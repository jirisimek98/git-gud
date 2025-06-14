package com.jirikovo.business.mappers;

import com.jirikovo.business.Quest;
import com.jirikovo.storage.QuestDAO;

public class StorageMapper {

    public static Quest map(QuestDAO dao) {
        return new Quest(dao.getId(), dao.getName(), dao.getDescription(), dao.getReward(), dao.isCompleted());
    }

    public static QuestDAO map(Quest quest) {
        return new QuestDAO(quest.getId(), quest.getName(), quest.getDescription(), quest.getReward(), quest.isCompleted());
    }
}
