package com.project.homeautomation.interceptors;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.EmptyInterceptor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.AsyncHandlerInterceptor;

@Component
public class RequestStatisticsInterceptor extends EmptyInterceptor implements AsyncHandlerInterceptor {

    private static final long serialVersionUID = -3380192143080509111L;

    private ThreadLocal<Long> queryCount = new ThreadLocal<>();

    private ThreadLocal<Long> time = new ThreadLocal<>();

    private static final Logger logger = LoggerFactory.getLogger(RequestStatisticsInterceptor.class);

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
            throws Exception {

        logger.trace("starting request {}", request.getRequestURI());
        time.set(System.currentTimeMillis());
        startCounter();
        return true;
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
            throws Exception {

        logger.trace("ending request {}", request.getRequestURI());
        long duration = System.currentTimeMillis() - time.get();
        Long queryCount = getQueryCount();
        clearCounter();
        time.remove();
        logger.trace("api time: {} ms dbqueries: {} {} {}", duration, queryCount, request.getMethod(),
                request.getRequestURI());
    }

    @Override
    public String onPrepareStatement(String sql) {

        Long count = queryCount.get();
        if (count == null) {
            count = 0L;
        }
        queryCount.set(count + 1);
        logger.trace(sql);
        return super.onPrepareStatement(sql);
    }

    private void startCounter() {
        queryCount.set(0l);
    }

    private Long getQueryCount() {
        return queryCount.get();
    }

    private void clearCounter() {
        queryCount.remove();
    }
}
