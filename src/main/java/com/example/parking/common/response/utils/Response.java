package com.example.parking.common.response.utils;

import org.springframework.http.HttpStatus;

public class Response<T> {

    public int code = 0; //Successful
    public HttpStatus status = HttpStatus.OK; //Successful
    public T body;

    public Response() {}

    public Response(T body) {

        this.body = body;
    }

    public Response(T body, HttpStatus status) {

        this.body = body;
        this.status = status;
    }

    public ErrorResponse getFailureResponse() {

        throw new UnsupportedOperationException();
    }

    public T getSuccessfulResponse() {

        throw new UnsupportedOperationException();
    }

    public HttpStatus getStatus() {

        return this.status;
    }

    public static class SuccessfulResponse<T> extends Response<T> {

        public SuccessfulResponse(T body) {

            this.body = body;
        }

        public SuccessfulResponse(HttpStatus status, T body) {

            this.status = status;
            this.body = body;
        }

        public T getSuccessfulResponse() {

            return body;
        }
    }

    public static class FailureResponse<T> extends Response<T> {

        private ErrorResponse errorResponse;

        public FailureResponse(ResponseCode responseCode) {

            this.code = responseCode.getCode();
            this.status = responseCode.getStatus();
            this.errorResponse = new ErrorResponse(responseCode.getCode(), responseCode.getCause());
        }

        public ErrorResponse getFailureResponse() {

            return errorResponse;
        }
    }
}

class ErrorResponse {

    public int code;
    public String cause;

    public ErrorResponse(int code, String cause) {

        this.code = code;
        this.cause = cause;
    }
}