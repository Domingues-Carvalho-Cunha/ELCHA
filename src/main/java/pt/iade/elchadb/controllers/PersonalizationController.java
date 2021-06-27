package pt.iade.elchadb.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import pt.iade.elchadb.models.repositories.PersonalizationRepository;
import pt.iade.elchadb.models.Personalization;


@RestController
@RequestMapping(path = "/api/Personalizations")
public class PersonalizationController {
    private Logger logger = LoggerFactory.getLogger(PersonalizationController.class);
    @Autowired
    private PersonalizationRepository PersonalizationRepository;
    
    // DEVOLVE TODAS AS PERSONALIZAÇÕES
    @GetMapping(path = "", produces = MediaType.APPLICATION_JSON_VALUE)
    public Iterable<Personalization> getPersonalizations() {
        logger.info("Sending all Personalizations");
        return PersonalizationRepository.findAll();
    }

}