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
@RequestMapping(path = "/api/Avatars")
public class AvatarController {
    private Logger logger = LoggerFactory.getLogger(AvatarController.class);
    @Autowired
    private AvatarRepository AvatarRepository;
    
    // DEVOLVE TODOS OS AVATARS
    @GetMapping(path = "", produces = MediaType.APPLICATION_JSON_VALUE)
    public Iterable<Avatar> getAvatars() {
        logger.info("Sending all Avatars");
        return AvatarRepository.findAll();
    }

} 