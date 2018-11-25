package com.myproject.Spingboot_React.service;

import com.myproject.Spingboot_React.domain.Task;
import com.myproject.Spingboot_React.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TaskService {

    @Autowired
    private TaskRepository taskRepository;

    public Task saveOrUpdateTask(Task task){

        if(task.getStatus()==null || task.getStatus()==""){
            task.setStatus("TO_DO");
        }

        return taskRepository.save(task);
    }

}
