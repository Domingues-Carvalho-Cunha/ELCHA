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
import pt.iade.elchadb.models.repositories.BadgeRepository;
import pt.iade.elchadb.models.Badge;


@RestController
@RequestMapping(path = "/api/Badges")
public class BadgeController {
    private Logger logger = LoggerFactory.getLogger(BadgeController.class);
    @Autowired
    private BadgeRepository BadgeRepository;
    
    // DEVOLVE TODOS OS BADGES
    @GetMapping(path = "", produces = MediaType.APPLICATION_JSON_VALUE)
    public Iterable<Badge> getBadges() {
        logger.info("Sending all Badges");
        return BadgeRepository.findAll();
    }

    // DEVOLVE UM BADGE PELO ID
    @GetMapping(path = "/{BadgeId:[1-9]+}", produces= MediaType.APPLICATION_JSON_VALUE)
    public Badge getBadge(@PathVariable("BadgeId") Integer BadgeId) {
        logger.info("Sending Badge info with id "+ BadgeId);
        Optional<Badge> _Badge = BadgeRepository.findById(BadgeId);
        if (!_Badge.isPresent()) {
            try {
                throw new NotFoundException(""+BadgeId+"Badge" + "id");
            } catch (NotFoundException e){}
        }
        return _Badge.get();
    }

    // SALVA UM BADGE NOVO
    @PostMapping(path = "", produces= MediaType.APPLICATION_JSON_VALUE)
    public Badge saveBadge(@RequestBody Badge Badge) {
        Badge savedBadge = BadgeRepository.save(Badge);
        logger.info("Saving Badge with id "+((Badge) savedBadge).getId());
        return savedBadge;
    }
}