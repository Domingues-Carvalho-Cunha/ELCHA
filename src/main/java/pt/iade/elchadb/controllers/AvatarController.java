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

    // DEVOLVE UM AVATAR PELO ID
    @GetMapping(path = "/{AvatarId:[1-9]+}", produces= MediaType.APPLICATION_JSON_VALUE)
    public Avatar getAvatar(@PathVariable("AvatarId") Integer AvatarId) {
        logger.info("Sending Avatar info with id "+ AvatarId);
        Optional<Avatar> _Avatar = AvatarRepository.findById(AvatarId);
        if (!_Avatar.isPresent()) {
            try {
                throw new NotFoundException(""+AvatarId+"Avatar" + "id");
            } catch (NotFoundException e){}
        }
        return _Avatar.get();
    }

    // SALVA UM AVATAR NOVO
    @PostMapping(path = "", produces= MediaType.APPLICATION_JSON_VALUE)
    public Avatar saveAvatar(@RequestBody Avatar Avatar) {
        Avatar savedAvatar = AvatarRepository.save(Avatar);
        logger.info("Saving Avatar with id "+((Avatar) savedAvatar).getId());
        return savedAvatar;
    }
} 