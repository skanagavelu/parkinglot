package com.example.parking.common.response.utils;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;

public enum ResponseCode {


    //Input Validation
    UNKNOWN_ERROR(-1, "Unknown Error", HttpStatus.BAD_REQUEST), //TODO when ever we face this needs to correct it by adding OP-DMI correlation
    SUCCESS(0, "SUCCESS", HttpStatus.OK),
    INVALID_PDU(1, "Invalid PDU", HttpStatus.BAD_REQUEST), //Invalid Request Content
    INVALID_REQUEST(2, "Invalid Request", HttpStatus.BAD_REQUEST),
    INVALID_BATCH_SIZE(3, "Invalid batch size used", HttpStatus.BAD_REQUEST),
    ACCESS_DENIED(103,"Access denied", HttpStatus.FORBIDDEN),

    INVALID_DATA(4, "Invalid Data", HttpStatus.BAD_REQUEST),
    NOT_FOUND(6, "Not Found", HttpStatus.NOT_FOUND);

    private int code;
    private String cause;
    private HttpStatus status;

    private ResponseCode(int code, String msg) {
        this.setCode(code);
        this.setCause(msg);
    }

    private ResponseCode(int code, String msg, HttpStatus hStatus) {
        this.setCode(code);
        this.setCause(msg);
        this.setStatus(hStatus);
    }


    private static final Map<Integer, ResponseCode> HTTPDMIcorrelation = new HashMap<>();

    static {
        for (ResponseCode error : ResponseCode.values()) {
            if(error.code >= 400 && error.code < 600) {
                HTTPDMIcorrelation.put(error.code, error);
            }
        }
    }

    public HttpStatus getStatus() {

        return status;
    }

    public void setStatus(HttpStatus status) {

        this.status = status;
    }

    public int getCode() {
        return code;
    }

    private void setCode(int code) {
        this.code = code;
    }

    public String getCause() {
        return cause;
    }

    private void setCause(String msg) {
        this.cause = msg;
    }
}
