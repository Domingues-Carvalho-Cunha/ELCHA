package pt.iade.elchadb.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

}