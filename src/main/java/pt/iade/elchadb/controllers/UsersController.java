package pt.iade.elchadb.controllers;

import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javassist.NotFoundException;
import pt.iade.elchadb.models.AppUser;
import pt.iade.elchadb.models.repositories.UserRepository;

@RestController
@RequestMapping(path="/api/Users")
public class UsersController {
    private Logger logger = LoggerFactory.getLogger(UsersController.class);
  @Autowired
  private UserRepository UserRepository;
  
  @GetMapping(path = "", produces= MediaType.APPLICATION_JSON_VALUE)
  public Iterable<AppUser> getUsers() {
    logger.info("Sending all Users");
    return UserRepository.findAll();
  }

  @GetMapping(path = "/{UserId:[1-30]+}", produces= MediaType.APPLICATION_JSON_VALUE)
  public AppUser getUser(@PathVariable("UserId") Integer UserId) {
    logger.info("Sending user info with id "+ UserId);
    Optional<AppUser> _User = UserRepository.findById(UserId);
    if (!_User.isPresent()) {
      try {
        throw new NotFoundException(""+UserId+"User" + "id");
    } catch (NotFoundException e){}
  }
  return _User.get();
  }
}