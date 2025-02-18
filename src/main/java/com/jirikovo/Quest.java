package com.jirikovo;

public class Quest {
    private String name;
    private String description;
    private long reward;
    private boolean completed;


    public Quest(String name, String description, long reward, boolean completed) {
        this.name = name;
        this.description = description;
        this.reward = reward;
        this.completed = completed;
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

    public long getReward() {
        return reward;
    }

    public void setReward(long reward) {
        this.reward = reward;
    }

    public boolean isCompleted() {
        return completed;
    }

    public void setCompleted(boolean completed) {
        this.completed = completed;
    }
}
