package com.jirikovo.business;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.stream.Collectors;

import org.jboss.logging.Logger;

import com.jirikovo.api.QuestDTO;
import com.jirikovo.business.mappers.ApiMapper;
import com.jirikovo.business.mappers.StorageMapper;
import com.jirikovo.storage.QuestDAO;
import com.jirikovo.storage.QuestStorage;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

@ApplicationScoped
public class QuestLog {

    @Inject
    QuestStorage storage;

    private static final Logger LOG = Logger.getLogger(QuestLog.class);

    private Map<UUID, Quest> log = new HashMap<>();

    public void addQuest(QuestDTO dto) {
        Quest quest = ApiMapper.map(dto);
        QuestDAO dao = StorageMapper.map(quest);
        storage.store(dao);
        updateLog();
    }

    public List<Quest> listQuests() {
        return new ArrayList<>(log.values());
    }

    private void updateLog() {
        log = storage.getAll().entrySet().stream()
            .collect(Collectors.toMap(
                Map.Entry::getKey,
                entry -> StorageMapper.map(entry.getValue())
            ));
    }
}
