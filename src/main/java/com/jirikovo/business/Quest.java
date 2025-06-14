package com.jirikovo.business;

import java.util.UUID;

public class Quest {
    private UUID id;
    private String name;
    private String description;
    private int reward;
    private boolean completed;


    public Quest(UUID id, String name, String description, int reward, boolean completed) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.reward = reward;
        this.completed = completed;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public UUID getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getReward() {
        return reward;
    }

    public void setReward(int reward) {
        this.reward = reward;
    }

    public boolean isCompleted() {
        return completed;
    }

    public void setCompleted(boolean completed) {
        this.completed = completed;
    }
}
