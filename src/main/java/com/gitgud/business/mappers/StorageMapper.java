package com.gitgud.business.mappers;

import com.gitgud.business.Quest;
import com.gitgud.storage.QuestDAO;

public class StorageMapper {

    public static Quest map(QuestDAO dao) {
        return new Quest(dao.getId(), dao.getName(), dao.getDescription(), dao.getReward(), dao.isCompleted());
    }

    public static QuestDAO map(Quest quest) {
        return new QuestDAO(quest.getId(), quest.getName(), quest.getDescription(), quest.getReward(), quest.isCompleted());
    }
}
