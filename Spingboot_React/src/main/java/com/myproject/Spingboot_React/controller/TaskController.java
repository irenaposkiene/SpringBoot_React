package com.myproject.Spingboot_React.controller;

import com.myproject.Spingboot_React.domain.Task;
import com.myproject.Spingboot_React.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/board")
@CrossOrigin

public class TaskController {

    @Autowired
    private TaskService taskService;


    @PostMapping("")
    public ResponseEntity<?> addToBoard(@Valid @RequestBody Task task, BindingResult result){

        if(result.hasErrors()){
            Map<String, String> errorMap = new HashMap<>();



            for(FieldError error: result.getFieldErrors()){
                errorMap.put(error.getField(), error.getDefaultMessage());
            }

            return new ResponseEntity<Map<String, String>>(errorMap, HttpStatus.BAD_REQUEST);
        }

        Task newT = taskService.saveOrUpdateTask(task);

        return new ResponseEntity<Task>(newT, HttpStatus.CREATED);
    }


}
