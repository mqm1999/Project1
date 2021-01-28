package com.example.project1.exception;

public class ResourceAlreadyExistException extends RuntimeException {
    public ResourceAlreadyExistException(String message) {
        super("Resource with resourceName = {" + message + "} already existed");
    }
}
