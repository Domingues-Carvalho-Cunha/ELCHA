package pt.iade.elchadb.models.repositories;

import org.springframework.data.repository.CrudRepository;
import pt.iade.elchadb.models.Message;

public interface MessageRepository extends CrudRepository<Message,Integer> {

}