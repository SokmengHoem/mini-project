package com.example.mini_pos.execption;

import org.springframework.http.HttpStatus;

public class ResourceNotFoundException extends ApiException {

    public ResourceNotFoundException(String resourceName, Long id) {
        super(HttpStatus.NOT_FOUND, resourceName + " with id = " + id + " not found.");
    }
}
