package com.project.homeautomation;

import java.net.URI;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

public class BasicRestTest {

    private static final Logger logger = LoggerFactory.getLogger(BasicRestTest.class);

    @LocalServerPort
    protected int port;

    protected final String getBaseUrl() {
        try {
            return "http://localhost:" + port + "/v1/";
        } catch (Exception e) {
            logger.error("could not get base url due to error :{}", e.getMessage());
            throw new RuntimeException(e);
        }
    }

    protected <T> ResponseEntity<T> getCall(String url, Class<T> clazz) {
        RestTemplate restTemplate = new RestTemplate();

        try {
            URI uri = new URI(getBaseUrl() + url);
            logger.info("trying get call to: {}", uri);
            ResponseEntity<T> forEntity = restTemplate.getForEntity(uri, clazz);
            logger.info("call response: {}", forEntity);
            return forEntity;
        } catch (RestClientException e) {
            logger.error("error while making rest call", e);
            throw new RuntimeException(e);
        } catch (Throwable e) {
            logger.error("unexpected error while making rest call", e);
            throw new RuntimeException(e);
        }
    }

    protected <T> ResponseEntity<T> postCall(String url, Class<T> clazz) {
        RestTemplate restTemplate = new RestTemplate();
        try {
            URI uri = new URI(getBaseUrl() + url);
            logger.info("trying post call to: {}", uri);
            ResponseEntity<T> forEntity = restTemplate.exchange(uri, HttpMethod.POST, null, clazz);
            logger.info("call response: {}", forEntity);
            return forEntity;

        } catch (HttpClientErrorException e) {
            logger.error("error while making rest call" + e.getResponseBodyAsString(), e);
            throw e;
        } catch (RestClientException e) {
            logger.error("error while making rest call", e);
            throw new RuntimeException(e);
        } catch (Throwable e) {
            logger.error("unexpected error while making rest call", e);
            throw new RuntimeException(e);
        }
    }

    @SuppressWarnings({ "rawtypes" })
    private HttpEntity setHeaders(Object object) {
        return setHeaders(object, MediaType.APPLICATION_JSON);
    }

    @SuppressWarnings({ "unchecked", "rawtypes" })
    private HttpEntity setHeaders(Object object, MediaType contentType) {
        HttpHeaders header = new HttpHeaders();
        header.set("ObjectType", "Order");
        header.set("Action", "Update");
        header.set("Object_Id", "123");
        header.setContentType(contentType);
        return new HttpEntity(object, header);
    }

    protected void deleteCall(String url) {
        RestTemplate restTemplate = new RestTemplate();
        try {
            URI uri = new URI(getBaseUrl() + url);
            logger.info("trying delete call to: {}", uri);
            restTemplate.delete(uri);
            logger.info("delete complete");
        } catch (RestClientException e) {
            logger.error("error while making rest call", e);
            throw new RuntimeException(e);
        } catch (Throwable e) {
            logger.error("unexpected error while making rest call", e);
            throw new RuntimeException(e);
        }
    }

    @SuppressWarnings({ "unchecked", "rawtypes" })
    protected void putCall(String url, Object object) {
        RestTemplate restTemplate = new RestTemplate();
        try {
            URI uri = new URI(getBaseUrl() + url);
            logger.info("trying put call to: {}", uri);
            restTemplate.exchange(uri, HttpMethod.PUT, setHeaders(object), (Class) null);
            logger.info("put complete");
        } catch (RestClientException e) {
            logger.error("error while making rest call", e);
            throw new RuntimeException(e);
        } catch (Throwable e) {
            logger.error("unexpected error while making rest call", e);
            throw new RuntimeException(e);
        }
    }

}
