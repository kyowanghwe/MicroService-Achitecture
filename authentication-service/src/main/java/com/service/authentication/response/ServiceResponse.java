package com.service.authentication.response;

import lombok.AllArgsConstructor;
import lombok.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public class ServiceResponse extends ResponseEntity<ServiceResponse.Payload> {

    /**
     * Create a new {@code ApiResponse} with the given code, message, http status.
     * @param status status code
     * @param message status code message
     */
    public ServiceResponse(HttpStatus status, String message) {
        super(new Payload(status.value(), message, null), status);
    }

    /**
     * Create a new {@code ApiResponse} with the given code, message, data, http status.
     * @param status status code
     * @param message status code message
     * @param data data response
     */
    public ServiceResponse(HttpStatus status, String message, Object data) {
        super(new Payload(status.value(), message, data), status);
    }

    @Value
    @AllArgsConstructor
    public static class Payload {
        private Integer status;
        private String message;
        private Object data;
    }
}