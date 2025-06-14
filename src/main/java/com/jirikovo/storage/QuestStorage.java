package com.jirikovo.storage;

import jakarta.annotation.PostConstruct;
import jakarta.enterprise.context.ApplicationScoped;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import org.jboss.logging.Logger;

@ApplicationScoped
public class QuestStorage {
    private Map<UUID, QuestDAO> quests = new HashMap<>();
    private static final Logger LOG = Logger.getLogger(QuestStorage.class);

    @PostConstruct
    void init() {
        QuestDAO q1 = new QuestDAO(null, "First quest", "My first ever quest, this is gonna be so much fun", 15, false);
        QuestDAO q2 = new QuestDAO(null, "Another quest", "Another one, I have so much to do", 25, false);
        store(q1);
        store(q2);
    }

    public void store(QuestDAO dao) {
        UUID id = UUID.randomUUID();
        dao.setId(id);
        quests.put(id, dao);
    }

    public QuestDAO get(UUID id) {
        return quests.get(id);
    }

    public Map<UUID, QuestDAO> getAll() {
        return quests;
    }

}
