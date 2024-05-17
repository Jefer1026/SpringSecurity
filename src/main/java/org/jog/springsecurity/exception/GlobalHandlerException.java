package org.jog.springsecurity.exception;

import jakarta.servlet.http.HttpServletRequest;
import org.jog.springsecurity.dto.ApiErrorDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;

@RestControllerAdvice
public class GlobalHandlerException {

    @ExceptionHandler(Exception.class)
    public ResponseEntity<?> genericHandlerException(Exception exception, HttpServletRequest request) {

        ApiErrorDTO apiErrorDTO = new ApiErrorDTO();
        apiErrorDTO.setBackendMessage(exception.getLocalizedMessage());
        apiErrorDTO.setURL(request.getRequestURL().toString());
        apiErrorDTO.setMethod(request.getMethod());
        apiErrorDTO.setMessage("Internal Server Error");
        apiErrorDTO.setTimestamp(LocalDateTime.now());

        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(apiErrorDTO);

    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<?> methodArgumentNotValidException(MethodArgumentNotValidException exception, HttpServletRequest request) {
        ApiErrorDTO apiErrorDTO = new ApiErrorDTO();
        apiErrorDTO.setBackendMessage(exception.getLocalizedMessage());
        apiErrorDTO.setURL(request.getRequestURL().toString());
        apiErrorDTO.setMethod(request.getMethod());
        apiErrorDTO.setTimestamp(LocalDateTime.now());
        apiErrorDTO.setMessage("Bad request, try later");

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(apiErrorDTO);

    }

}
