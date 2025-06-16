package com.gitgud.business;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.UUID;

public class Task {

    private UUID id;
    private String description;
    private LocalDateTime createdAt;
    private LocalDate dueDate;
    private LocalDateTime completedAt;

    public Task(UUID id, String description, LocalDateTime createdAt, LocalDate dueDate, LocalDateTime completedAt) {
        this.id = id;
        this.description = description;
        this.createdAt = createdAt;
        this.dueDate = dueDate;
        this.completedAt = completedAt;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public LocalDate getDueDate() {
        return dueDate;
    }

    public void setDueDate(LocalDate dueDate) {
        this.dueDate = dueDate;
    }

    public LocalDateTime getCompletedAt() {
        return completedAt;
    }

    public void setCompletedAt(LocalDateTime completedAt) {
        this.completedAt = completedAt;
    }

    
}
