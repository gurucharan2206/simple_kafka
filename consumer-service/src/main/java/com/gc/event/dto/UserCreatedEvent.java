package com.gc.event.dto;

public class UserCreatedEvent {
    private String userId;
    private String email;

    // Getters and setters
    public String getUserId() { return userId; }
    public void setUserId(String userId) { this.userId = userId; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }
}
