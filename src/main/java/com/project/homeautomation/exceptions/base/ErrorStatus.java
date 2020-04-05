package com.project.homeautomation.exceptions.base;

import org.springframework.http.HttpStatus;

public enum ErrorStatus {

    //1XXX series - server errors
    UNEXPECTED(HttpStatus.INTERNAL_SERVER_ERROR, 1000), //
    SOLR_UNREACHABLE(HttpStatus.SERVICE_UNAVAILABLE, 1001),
    MYSQL_CONNECTION_FAILURE(HttpStatus.SERVICE_UNAVAILABLE, 1002),
    INVALID_DATA_ENCOUNTERED(HttpStatus.INTERNAL_SERVER_ERROR, 1003),
    OBJECT_RETRIEVAL_FAILED(HttpStatus.INTERNAL_SERVER_ERROR, 1004),

    //11XX series - request errors
    INVALID_RESOURCE(HttpStatus.NOT_FOUND, 1100), //
    INVALID_INPUT(HttpStatus.BAD_REQUEST, 1101), //

    INVALID_DATE_FORMAT(HttpStatus.BAD_REQUEST, 1102), //
    INVALID_DAY_PASSED(HttpStatus.BAD_REQUEST, 1103), //
    INVALID_ID_PASSED(HttpStatus.BAD_REQUEST, 1104), //
    INVALID_LAT_LONG(HttpStatus.BAD_REQUEST, 1105),

    //12XX matching data not found
    ENTITY_NOT_FOUND(HttpStatus.NOT_FOUND, 1201), //
    ENTITY_COLLECTION_NOT_FOUND(HttpStatus.OK, 1202), //
    ENTITIES_EXHAUSTED(HttpStatus.OK, 1203), //Return when there are not more entities to be returned

    //TODO:remove API specific bug
    DELIVERY_MODE_INVALID(HttpStatus.BAD_REQUEST, 1230), //
    DELIVERY_MODE_NOT_FOUND(HttpStatus.NOT_FOUND, 1231), //
    DELIVERY_DAYS_UNTIL_NOT_IN_RANGE(HttpStatus.NOT_FOUND, 1232), //

    SALE_TYPE_INVALID(HttpStatus.BAD_REQUEST, 1233),
    PRODUCT_ENTITY_INVALID(HttpStatus.BAD_REQUEST, 1234),

    MERCHANT_ID_INVALID(HttpStatus.NOT_FOUND, 1210), //
    MERCHANT_CONFIGS_NOT_FOUND(HttpStatus.NOT_FOUND, 1211), //

    ENTITY_EXPIRED(HttpStatus.NOT_FOUND,1250),
    ENTITY_UNAVAILABLE(HttpStatus.NOT_FOUND,1251),
    ENTITY_INACTIVE(HttpStatus.NOT_FOUND,1252),
    ENTITY_ARCHIVED(HttpStatus.NOT_FOUND,1253),
    ENTITY_NULL_INVENTORY(HttpStatus.NOT_FOUND,1254),
    ENTITY_NULL_PRICE(HttpStatus.NOT_FOUND,1255),

    LANGUAGE_FIELD_INVALID(HttpStatus.NOT_FOUND, 1220), //
    LANGUAGE_FIELD_NOT_SUPPORTED(HttpStatus.NOT_FOUND, 1221), //
    LANGUAGE_FIELD_NOT_FOUND(HttpStatus.NOT_FOUND, 1222);

    private HttpStatus httpStatus;
    private int code;

    ErrorStatus(HttpStatus httpStatus, int code) {
        this.httpStatus = httpStatus;
        this.code = code;
    }

    public int getCode() {
        return code;
    }

    public HttpStatus getHttpStatus() {
        return httpStatus;
    }

    public static class ErrorCode {
        private String name;
        private int code;
        private int httpCode;
        private String httpStatus;

        public ErrorCode(ErrorStatus errorStatus) {
            this.name = errorStatus.name();
            this.code = errorStatus.getCode();
            this.httpCode = errorStatus.getHttpStatus().value();
            this.httpStatus = errorStatus.getHttpStatus().getReasonPhrase();
        }
    }
}
