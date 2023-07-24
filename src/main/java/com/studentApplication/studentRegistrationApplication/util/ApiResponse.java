package com.studentApplication.studentRegistrationApplication.util;

import java.util.Date;

public class ApiResponse<T> {

    private T data;
    private Long timestamp = new Date().getTime();;
    private String message;


    public ApiResponse() {
    }

    public ApiResponse(String message) {
        this.message = message;
    }

    public ApiResponse(T data, String message) {
        this.data = data;
        this.message = message;
    }

    public Object getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public Long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Long timestamp) {
        this.timestamp = timestamp;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
