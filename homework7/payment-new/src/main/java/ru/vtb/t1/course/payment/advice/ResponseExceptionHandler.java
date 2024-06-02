package ru.vtb.t1.course.payment.advice;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import ru.vtb.t1.course.payment.exception.ClientException;
import ru.vtb.t1.course.payment.exception.IntegrationException;
import ru.vtb.t1.course.payment.model.ErrorResponse;

@ControllerAdvice
public class ResponseExceptionHandler {

    @ExceptionHandler(value = IntegrationException.class)
    protected ResponseEntity<ErrorResponse> handleConflict(IntegrationException ex) {
        var respone = new ErrorResponse(422, "UNPROCESSABLE_ENTITY", ex.getMessage());
        return new ResponseEntity<>(respone, HttpStatus.UNPROCESSABLE_ENTITY);
    }

    @ExceptionHandler(value = ClientException.class)
    protected ResponseEntity<ErrorResponse> handleConflict(ClientException ex) {
        var code = ex.getCode();
        var respone = new ErrorResponse(code.value(), ex.getStatus(), ex.getMessage());
        return new ResponseEntity<>(respone, code);
    }
}
