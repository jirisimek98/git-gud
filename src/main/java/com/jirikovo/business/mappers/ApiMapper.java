package com.jirikovo.business.mappers;

import com.jirikovo.api.QuestDTO;
import com.jirikovo.business.Quest;

public class ApiMapper {

    public static Quest map(QuestDTO dto) {
        return new Quest(dto.getId(), dto.getName(), dto.getDescription(), dto.getReward(), dto.isCompleted());
    }

    public static QuestDTO map(Quest quest) {
        return new QuestDTO(quest.getId(), quest.getName(), quest.getDescription(), quest.getReward(), quest.isCompleted());
    }
}
