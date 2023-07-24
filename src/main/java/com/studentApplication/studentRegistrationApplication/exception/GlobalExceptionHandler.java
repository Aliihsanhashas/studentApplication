package com.studentApplication.studentRegistrationApplication.exception;

import com.studentApplication.studentRegistrationApplication.util.ApiResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {
    /**
     * handleException fonksiyonları ogrenciyi ararken olmayan id yada long yerine
     * baska bir degisken girdigimizde dondurecegimiz hata kodlarını ve mesajlarını
     * ayarladık.
     */

    @ExceptionHandler(Exception.class)
    public ResponseEntity<Object> handleException(Exception e) {
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new ApiResponse<>("unexpected error " + e.getMessage()));
    }

    @ExceptionHandler(StudentNotFoundException.class)
    public ResponseEntity<Object> handleException(StudentNotFoundException e) {
        return ResponseEntity.ok(new ApiResponse<>(e.getMessage()));
    }


}
