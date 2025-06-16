package com.gitgud.business.mappers;

import com.gitgud.api.dto.QuestDTO;
import com.gitgud.api.dto.TaskDTO;
import com.gitgud.business.Quest;
import com.gitgud.business.Task;

public class ApiMapper {

    public static Quest map(QuestDTO dto) {
        return new Quest(dto.getId(), dto.getName(), dto.getDescription(), dto.getReward(), dto.isCompleted());
    }

    public static QuestDTO map(Quest quest) {
        return new QuestDTO(quest.getId(), quest.getName(), quest.getDescription(), quest.getReward(), quest.isCompleted());
    }

    public static Task map(TaskDTO dto) {
        return new Task(dto.getId(), dto.getDescription(), dto.getCreatedAt(), dto.getDueDate(), dto.getCompletedAt());
    }

    public static TaskDTO map(Task task) {
        return new TaskDTO(task.getId(), task.getDescription(), task.getCreatedAt(), task.getDueDate(), task.getCompletedAt());
    }
}
