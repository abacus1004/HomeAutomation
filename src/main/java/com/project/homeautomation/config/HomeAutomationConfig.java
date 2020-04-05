package com.project.homeautomation.config;

import java.util.HashMap;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.orm.jpa.JpaProperties;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;


import com.project.homeautomation.interceptors.RequestStatisticsInterceptor;

@Configuration
public class HomeAutomationConfig implements WebMvcConfigurer {


    @Autowired
    private RequestStatisticsInterceptor requestStatisticsInterceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(requestStatisticsInterceptor).addPathPatterns("/**");
    }

    @Bean
    public LocalContainerEntityManagerFactoryBean entityManagerFactory(EntityManagerFactoryBuilder factory,
                                                                       DataSource dataSource, JpaProperties properties) {
        Map<String, Object> jpaProperties = new HashMap<String, Object>();
        jpaProperties.putAll(properties.getProperties());
        jpaProperties.put("hibernate.ejb.interceptor", requestStatisticsInterceptor);
        return factory
                .dataSource(dataSource)
                .packages("com.project.homeautomation.datamodel")
                .properties((Map<String, ?>) jpaProperties)
                .build();
    }
}
