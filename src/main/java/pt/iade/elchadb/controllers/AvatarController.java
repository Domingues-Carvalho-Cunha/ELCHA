package pt.iade.elchadb.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import pt.iade.elchadb.models.repositories.AvatarRepository;
import pt.iade.elchadb.models.Avatar;


@RestController
@RequestMapping(path = "/api/avatar")
public class AvatarController {
    private Logger logger = LoggerFactory.getLogger(AvatarController.class);
    @Autowired
    private AvatarRepository AvatarRepository;
    
    @GetMapping(path = "", produces = MediaType.APPLICATION_JSON_VALUE)
    public Iterable<Avatar> getAvatars() {
        logger.info("Sending all Avatar");
        return AvatarRepository.findAll();
    }

}