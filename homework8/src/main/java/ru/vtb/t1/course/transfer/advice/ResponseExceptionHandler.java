package ru.vtb.t1.course.transfer.advice;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import ru.vtb.t1.course.transfer.exception.TransferException;
import ru.vtb.t1.course.transfer.model.dto.ErrorResponse;

@ControllerAdvice
public class ResponseExceptionHandler {

    @ExceptionHandler(value = TransferException.class)
    protected ResponseEntity<ErrorResponse> handleConflict(TransferException ex) {
        var respone = new ErrorResponse(422, "UNPROCESSABLE_ENTITY", ex.getMessage());
        return new ResponseEntity<>(respone, HttpStatus.UNPROCESSABLE_ENTITY);
    }
}
