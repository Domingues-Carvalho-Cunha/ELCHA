package pt.iade.elchadb.controllers;

import java.util.Optional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestParam;
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
  
  // DEVOLVE TODOS OS UTILIZADORES
  @GetMapping(path = "", produces= MediaType.APPLICATION_JSON_VALUE)
  public Iterable<AppUser> getUsers() {
    logger.info("Sending all Users");
    return UserRepository.findAll();
  }

  // DEVOLVE UM UTILIZADOR PELO ID
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

  // SALVA UM ULTILIZADOR NOVO
  @PostMapping(path = "/saveUser", produces= MediaType.APPLICATION_JSON_VALUE)
  public AppUser saveUser(@RequestBody AppUser User) {
    AppUser savedUser = UserRepository.save(User);
    logger.info("Saving User with id "+((AppUser) savedUser).getId());
    return savedUser;
  }

  // APAGA UM UTILIZADOR POR ID
  @DeleteMapping(path = "/{id:[0-9]+}", produces= MediaType.APPLICATION_JSON_VALUE)
  public Response deleteU(@PathVariable int id){
    logger.info("Deleting unit with id "+id);
    UserRepository.deleteById(id);
    return new Response("Deleted User with id "+id, null);
  }
  public class Response {
    //private String message;
    //private Object object;
    public Response(String message, Object object) {}

  }


  // DEVOLVE UM UTILIZADOR PELA PESQUISA DO NOME
  @GetMapping(path = "/{text:[^0-9]+}", produces= MediaType.APPLICATION_JSON_VALUE)
  public Iterable<AppUser> getName(
    @PathVariable(value = "text") String text) {
    logger.info("User with name like "+text);
    return UserRepository.findByNameContaining(text);
  }

  @GetMapping(path = "/search", produces= MediaType.APPLICATION_JSON_VALUE)
  public Iterable<AppUser> searchUser(
    @RequestParam(value="name",defaultValue="") String name,
    @RequestParam(value="pointsMin",defaultValue="min")String pointsMin,
    @RequestParam(value="pointsMax",defaultValue="max")String pointsMax) {
      logger.info("Sending User with name like "+name+" and points between "+pointsMin+" and "+pointsMax);
      int _pointsMin = -1;
      int _pointsMax = Integer.MAX_VALUE;
      try { _pointsMin = Integer.parseInt(pointsMin);
      } catch (NumberFormatException e) {}
      try { _pointsMax = Integer.parseInt(pointsMax);
      } catch (NumberFormatException e) {}
    return UserRepository.findByNameContainingAndPointsBetween(name, _pointsMin, _pointsMax);
  } 

}