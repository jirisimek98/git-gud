package com.gitgud.business;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.stream.Collectors;

import com.gitgud.api.dto.TaskDTO;
import com.gitgud.business.mappers.ApiMapper;

import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class TaskManager {
    private Map<UUID, Task> tasks = new HashMap<>();

    public void create(TaskDTO dto) {
        UUID id = UUID.randomUUID();
        Task task = new Task(id, dto.getDescription(), LocalDateTime.now(), dto.getDueDate(), null);
        tasks.put(id, task);
    }

    public List<TaskDTO> listTasks() {
        return tasks.values().stream()
        .map(ApiMapper::map).collect(Collectors.toList());
    }

    public TaskDTO getTask(UUID id) {
        return ApiMapper.map(tasks.get(id));
    }

}
