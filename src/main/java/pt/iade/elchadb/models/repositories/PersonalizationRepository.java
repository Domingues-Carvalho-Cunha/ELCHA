package pt.iade.elchadb.models.repositories;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import pt.iade.elchadb.models.Personalization;


public interface PersonalizationRepository extends CrudRepository<Personalization,Integer> {

    // QUERIES
    @Query(value=
    "SELECT Per_ID AS id, "+
    "Per_name AS firstName, "+
    "Per_type AS lastName, "+
    "Per_gems AS gender, ",
    nativeQuery=true)
    Personalization FindUserId( int PersonalizationId);

}


