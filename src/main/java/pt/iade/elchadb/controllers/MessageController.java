package pt.iade.elchadb.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import pt.iade.elchadb.models.repositories.MessageRepository;
import pt.iade.elchadb.models.Message;


@RestController
@RequestMapping(path = "/api/Messages")
public class MessageController {
    private Logger logger = LoggerFactory.getLogger(MessageController.class);
    @Autowired
    private MessageRepository MessageRepository;
    
    // DEVOLVE TODAS AS MENSAGENS
    @GetMapping(path = "", produces = MediaType.APPLICATION_JSON_VALUE)
    public Iterable<Message> getMessages() {
        logger.info("Sending all Messages");
        return MessageRepository.findAll();
    }

}