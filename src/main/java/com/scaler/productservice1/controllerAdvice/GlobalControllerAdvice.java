package com.scaler.productservice1.controllerAdvice;

import com.scaler.productservice1.dto.ErrorResponseDTO;
import com.scaler.productservice1.exceptions.ProductIdCannotBeNegative;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.client.HttpClientErrorException;

import java.time.LocalDateTime;


@RestControllerAdvice
public class GlobalControllerAdvice {
    @ExceptionHandler(ProductIdCannotBeNegative.class)
    public ResponseEntity<ErrorResponseDTO> handleProductIdCannotBeNegative(ProductIdCannotBeNegative exception) {
        return new ResponseEntity<>(new ErrorResponseDTO("INVALID ID", exception.getMessage()), HttpStatus.BAD_REQUEST);

    }

    @ExceptionHandler(HttpClientErrorException.class)
    public ResponseEntity<ErrorResponseDTO> handleHttpClientErrorException(HttpClientErrorException exception) {

        ErrorResponseDTO error = new ErrorResponseDTO();
        error.setErrorCode("EXTERNAL_API_NOT_FOUND");
        error.setErrorMessage(exception.getMessage());
        error.setTimestamp(LocalDateTime.now());
        return ResponseEntity.status(HttpStatus.BAD_GATEWAY).body(error);



    }

    @ExceptionHandler(Exception.class)
        public ResponseEntity<ErrorResponseDTO> handleGeneralExceptions(Exception e){
            return new ResponseEntity<>(new ErrorResponseDTO("Failure ", e.getMessage()), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }



