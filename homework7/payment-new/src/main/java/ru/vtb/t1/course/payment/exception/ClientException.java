package ru.vtb.t1.course.payment.exception;

import org.springframework.http.HttpStatusCode;

public class ClientException extends RuntimeException {

    private final HttpStatusCode code;

    private final String status;

    public ClientException(String message, HttpStatusCode code, String status) {
        super(message);
        this.code = code;
        this.status = status;
    }

    public HttpStatusCode getCode() {
        return code;
    }

    public String getStatus() {
        return status;
    }
}
