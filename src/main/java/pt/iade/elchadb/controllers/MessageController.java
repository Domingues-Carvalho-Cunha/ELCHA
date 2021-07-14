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

    // DEVOLVE UMA MENSAGEM PELO ID
    @GetMapping(path = "/{MessageId:[1-9]+}", produces= MediaType.APPLICATION_JSON_VALUE)
    public Message getMessage(@PathVariable("MessageId") Integer MessageId) {
        logger.info("Sending Message info with id "+ MessageId);
        Optional<Message> _Message = MessageRepository.findById(MessageId);
        if (!_Message.isPresent()) {
            try {
                throw new NotFoundException(""+MessageId+"Message" + "id");
            } catch (NotFoundException e){}
        }
        return _Message.get();
    }

    // SALVA UMA MENSAGEM NOVA
    @PostMapping(path = "", produces= MediaType.APPLICATION_JSON_VALUE)
    public Message saveMessage(@RequestBody Message Message) {
        Message savedMessage = MessageRepository.save(Message);
        logger.info("Saving Message with id "+((Message) savedMessage).getId());
        return savedMessage;
    }
}