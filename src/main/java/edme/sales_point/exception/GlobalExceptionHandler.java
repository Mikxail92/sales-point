package edme.sales_point.exception;

import edme.sales_point.dto.AppError;
import io.swagger.v3.oas.annotations.Hidden;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDate;
import java.util.Date;


@Hidden
@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity<String> handleException(EntityNotFoundException ex) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ex.getMessage());
    }

    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<String> handleException(IllegalArgumentException ex) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ex.getMessage());
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<?> handleException(Exception ex) throws Exception {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ex);
    }


    @ExceptionHandler(NotCreateNewUserException.class)
    public ResponseEntity<AppError> handleException(NotCreateNewUserException exception) {
        AppError errorResponse = AppError.builder()
                .status(HttpStatus.BAD_REQUEST.value())
                .name(exception.getClass().getSimpleName())
                .message(exception.getMessage())
                .timestamp(new Date())
                .build();
        return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
    }


}

