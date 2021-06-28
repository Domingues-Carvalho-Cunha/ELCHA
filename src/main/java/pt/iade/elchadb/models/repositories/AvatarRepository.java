package pt.iade.elchadb.models.repositories;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import pt.iade.elchadb.models.Avatar;


public interface AvatarRepository extends CrudRepository<Avatar,Integer> {

    // QUERIES
    @Query(value=
        "SELECT Ava_ID AS id, "+
        "Ava_nickname AS name, ",
    nativeQuery=true)
    Avatar FindUserId( int AvatarId);

}


