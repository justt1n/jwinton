package com.jwinton.auth.application.exceptions;

import com.jwinton.auth.application.constants.ErrorCode;
import com.jwinton.auth.presentation.dto.response.ApiResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.List;
import java.util.stream.Collectors;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(value = RuntimeException.class)
    ResponseEntity<ApiResponse> handleException(RuntimeException e) {
        ApiResponse response = new ApiResponse();
        response.setCode(ErrorCode.UNCATEGORIZED.getCode());
        response.setMessage(ErrorCode.UNCATEGORIZED.getMessage());
        response.setResult(e.getMessage());
        return ResponseEntity.badRequest().body(response);
    }

    @ExceptionHandler(value = MethodArgumentNotValidException.class)
    public ResponseEntity<ApiResponse> handleMethodArgumentNotValid(MethodArgumentNotValidException e) {
        ApiResponse response = null;
        try {
            List<ErrorCode> errors = e.getBindingResult()
                    .getFieldErrors()
                    .stream()
                    .map(error -> error.getDefaultMessage())
                    .map(error -> ErrorCode.valueOf(error))
                    .toList();

            response = new ApiResponse();
            response.setCode(errors.get(0).getCode());
            response.setMessage(errors.stream().map(error -> error.getMessage()).collect(Collectors.joining(",\n")));
        } catch (IllegalArgumentException ex) {

        }
        return ResponseEntity.badRequest().body(response);
    }


    @ExceptionHandler(value = AppException.class)
    public ResponseEntity<ApiResponse> handleAppException(AppException e) {
        ApiResponse response = new ApiResponse();
        response.setCode(e.getErrorCode().getCode());
        response.setMessage(e.getErrorCode().getMessage());
        return ResponseEntity.badRequest().body(response);
    }
}
