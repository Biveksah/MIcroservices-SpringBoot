package com.example.hotelservices.Exception;

public class ResourceNotFoundException extends RuntimeException {
    public ResourceNotFoundException() {
        super("Resource not found on Server");
    }
    public ResourceNotFoundException(String message) {
        super(message);
    }
}
