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

    // DEVOLVE UMA PERSONALIZAÇÃO PELO ID
    @GetMapping(path = "/{PersonalizationId:[1-30]+}", produces= MediaType.APPLICATION_JSON_VALUE)
    public Personalization getPersonalization(@PathVariable("PersonalizationId") Integer PersonalizationId) {
        logger.info("Sending Personalization info with id "+ PersonalizationId);
        Optional<Personalization> _Personalization = PersonalizationRepository.findById(PersonalizationId);
        if (!_Personalization.isPresent()) {
            try {
                throw new NotFoundException(""+PersonalizationId+"Personalization" + "id");
            } catch (NotFoundException e){}
        }
        return _Personalization.get();
    }

    // SALVA UMA PERSONALIZAÇÃO NOVO
    @PostMapping(path = "/savePersonalization", produces= MediaType.APPLICATION_JSON_VALUE)
    public Personalization savePersonalization(@RequestBody Personalization Personalization) {
        Personalization savedPersonalization = PersonalizationRepository.save(Personalization);
        logger.info("Saving Personalization with id "+((Personalization) savedPersonalization).getId());
        return savedPersonalization;
    }
}