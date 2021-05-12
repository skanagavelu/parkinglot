package com.example.parking.common.response.utils;

import org.springframework.http.HttpStatus;

public class Response<T> {

    T body;
    HttpStatus status;

    public Response(){}

    public Response(T body, HttpStatus status) {

        this.body = body;
        this.status = status;
    }

    public T getBody() {

        return body;
    }

    public void setBody(T body) {

        this.body = body;
    }

    public HttpStatus getStatus() {

        return status;
    }

    public void setStatus(HttpStatus status) {

        this.status = status;
    }

    static class FailureResponse{

        int code;
        String message;

        public FailureResponse(ResponseCode responseCode) {
            this.code = responseCode.getCode();
            this.message = responseCode.getCause();
        }

        public FailureResponse(int code, String message) {

            this.code = code;
            this.message = message;
        }
    }

//    static class SuccessfulResponse {
//
//        int code;
//        String message;
//
//        public SuccessfulResponse(ResponseCode responseCode) {
//            this.code = responseCode.getCode();
//            this.message = responseCode.getCause();
//        }
//
//        public SuccessfulResponse(int code, String message) {
//
//            this.code = code;
//            this.message = message;
//        }
//    }
}