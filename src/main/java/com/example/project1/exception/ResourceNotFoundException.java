package com.example.project1.exception;

public class ResourceNotFoundException extends RuntimeException {
    public ResourceNotFoundException(String id) {
        super("Resource with resourceName = {" + id + "} not found");
    }
}
