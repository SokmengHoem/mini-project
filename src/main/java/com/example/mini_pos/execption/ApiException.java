package com.example.mini_pos.execption;

import lombok.EqualsAndHashCode;
import org.springframework.http.HttpStatus;
import lombok.Data;
import lombok.RequiredArgsConstructor;
@Data
@EqualsAndHashCode(callSuper = false)
@RequiredArgsConstructor
public class ApiException extends RuntimeException {
    private final HttpStatus status;
    private final String message;
}