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
import pt.iade.elchadb.models.repositories.PostalCodeRepository;
import pt.iade.elchadb.models.PostalCode;
    
    
@RestController
@RequestMapping(path = "/api/PostalCodes")
public class PostalCodeController {
    private Logger logger = LoggerFactory.getLogger(PostalCode.class);
    @Autowired
    private PostalCodeRepository PostalCodeRepository;
    
    // DEVOLVE TODOS OS CODIGOS POSTAIS
    @GetMapping(path = "", produces = MediaType.APPLICATION_JSON_VALUE)
    public Iterable<PostalCode> getPostalCodes() {
        logger.info("Sending all PostalCodes");
        return PostalCodeRepository.findAll();
    }

    // DEVOLVE UM CODIGO POSTAL PELO ID
    @GetMapping(path = "/{PostalCodeId:[1-9]+}", produces= MediaType.APPLICATION_JSON_VALUE)
    public PostalCode getPostalCode(@PathVariable("PostalCodeId") Integer PostalCodeId) {
        logger.info("Sending PostalCodes info with id "+ PostalCodeId);
        Optional<PostalCode> _PostalCode = PostalCodeRepository.findById(PostalCodeId);
        if (!_PostalCode.isPresent()) {
            try {
                throw new NotFoundException(""+PostalCodeId+"PostalCode" + "id");
            } catch (NotFoundException e){}
        }
        return _PostalCode.get();
    }

    // SALVA UM CODIGO POSTAL NOVO
    @PostMapping(path = "", produces= MediaType.APPLICATION_JSON_VALUE)
    public PostalCode savePostalCode(@RequestBody PostalCode PostalCode) {
        PostalCode savedPostalCode = PostalCodeRepository.save(PostalCode);
        logger.info("Saving PostalCode with id "+((PostalCode) savedPostalCode).getId());
        return savedPostalCode;
    }
}