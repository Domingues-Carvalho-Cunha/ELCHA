    package pt.iade.elchadb.controllers;

    import org.slf4j.Logger;
    import org.slf4j.LoggerFactory;
    import org.springframework.beans.factory.annotation.Autowired;
    import org.springframework.http.MediaType;
    import org.springframework.web.bind.annotation.GetMapping;
    import org.springframework.web.bind.annotation.RequestMapping;
    import org.springframework.web.bind.annotation.RestController;
    
    import pt.iade.elchadb.models.repositories.PostalCodeRepository;
    import pt.iade.elchadb.models.PostalCode;
    
    
    @RestController
    @RequestMapping(path = "/api/PostalCode")
    public class PostalCodeController {
        private Logger logger = LoggerFactory.getLogger(PostalCode.class);
        @Autowired
        private PostalCodeRepository PostalCodeRepository;
        
        @GetMapping(path = "", produces = MediaType.APPLICATION_JSON_VALUE)
        public Iterable<PostalCode> getPostalCodes() {
            logger.info("Sending all PostalCode");
            return PersonalizationPostalCode.findAll();
        }
    
    }