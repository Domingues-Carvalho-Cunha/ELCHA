package pt.iade.elchadb.models.repositories;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import pt.iade.elchadb.models.Message;


public interface MessageRepository extends CrudRepository<Message,Integer> {

    // QUERIES
    @Query(value=
        "SELECT Mess_ID AS id, "+
        "Mess_text AS text",
    nativeQuery=true)
    Message FindUserId( int MessageId);

}


