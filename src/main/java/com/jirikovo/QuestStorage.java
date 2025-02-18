package com.jirikovo;

import jakarta.annotation.PostConstruct;
import jakarta.enterprise.context.ApplicationScoped;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@ApplicationScoped
public class QuestStorage {
    private List<Quest> quests = new ArrayList<>();

    @PostConstruct
    void init() {
        quests.add(new Quest("First quest", "The first quest ever made", 1, true));
    }

    public Quest create(String name, String description, long reward) {
        Quest quest = new Quest(name, description, reward, false);
        quests.add(quest);
        return quest;
    }

    public Quest read(int id) {
        return quests.get(id);
    }

    public Quest complete(int id) {
        quests.get(id).setCompleted(true);
        return quests.get(id);
    }

    public List<Quest> list() {
        return quests;
    }

}
