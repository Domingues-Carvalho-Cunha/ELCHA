package pt.iade.elchadb.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import pt.iade.elchadb.models.repositories.TaskRepository;
import pt.iade.elchadb.models.Task;


@RestController
@RequestMapping(path = "/api/Task")
public class TaskController {
    private Logger logger = LoggerFactory.getLogger(Task.class);
    @Autowired
    private TaskRepository TaskRepository;
    
    @GetMapping(path = "", produces = MediaType.APPLICATION_JSON_VALUE)
    public Iterable<Task> getTasks() {
        logger.info("Sending all Task");
        return PersonalizationTask.findAll();
    }

}