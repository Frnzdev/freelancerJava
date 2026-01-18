package com.codify.labor.worker.exceptions;

public class WorkerNotFoundException extends RuntimeException {
    public WorkerNotFoundException(String message) {
        super(message);
    }
}
