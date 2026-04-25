package com.belfastdev.exception;

import java.time.LocalDateTime;
import java.util.List;

public class ApiError {
    private final int status;
    private final String message;
    private final LocalDateTime timestamp;
    private final List<String> details;

    public ApiError(int status, String message, LocalDateTime timestamp, List<String> details) {
        this.status = status;
        this.message = message;
        this.timestamp = timestamp;
        this.details = details;
    }

    public int getStatus() { return status; }
    public String getMessage() { return message; }
    public LocalDateTime getTimestamp() { return timestamp; }
    public List<String> getDetails() { return details; }
}
