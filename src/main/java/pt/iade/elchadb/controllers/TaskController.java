package pt.iade.elchadb.controllers;

import java.util.Optional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import javassist.NotFoundException;

import pt.iade.elchadb.models.repositories.TaskRepository;
import pt.iade.elchadb.models.Task;


@RestController
@RequestMapping(path = "/api/Tasks")
public class TaskController {
    private Logger logger = LoggerFactory.getLogger(Task.class);
    @Autowired
    private TaskRepository TaskRepository;
    
    // DEVOLVE TODAS AS TASKS
    @GetMapping(path = "", produces = MediaType.APPLICATION_JSON_VALUE)
    public Iterable<Task> getTasks() {
        logger.info("Sending all Tasks");
        return TaskRepository.findAll();
    }

    // DEVOLVE UMA TASK PELO ID
    @GetMapping(path = "/{TaskId:[1-30]+}", produces= MediaType.APPLICATION_JSON_VALUE)
    public Task getTask(@PathVariable("TaskId") Integer TaskId) {
        logger.info("Sending Task info with id "+ TaskId);
        Optional<Task> _Task = TaskRepository.findById(TaskId);
        if (!_Task.isPresent()) {
            try {
                throw new NotFoundException(""+TaskId+"Task" + "id");
            } catch (NotFoundException e){}
        }
        return _Task.get();
    }

    // SALVA UMA TASK NOVA
    @PostMapping(path = "/saveTask", produces= MediaType.APPLICATION_JSON_VALUE)
    public Task saveTask(@RequestBody Task task) {
        Task savedTask = TaskRepository.save(task);
        logger.info("Saving Task with id "+((Task) savedTask).getId());
        return savedTask;
    }
}