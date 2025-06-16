package com.gitgud.business;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.stream.Collectors;

import org.jboss.logging.Logger;

import com.gitgud.api.dto.QuestDTO;
import com.gitgud.business.mappers.ApiMapper;
import com.gitgud.business.mappers.StorageMapper;
import com.gitgud.storage.QuestDAO;
import com.gitgud.storage.QuestStorage;

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

    public List<QuestDTO> listQuests() {
        updateLog();
        return log.values().stream()
        .map(ApiMapper::map)
        .collect(Collectors.toList());
    }

    private void updateLog() {
        log = storage.getAll().entrySet().stream()
            .collect(Collectors.toMap(
                Map.Entry::getKey,
                entry -> StorageMapper.map(entry.getValue())
            ));
    }
}
