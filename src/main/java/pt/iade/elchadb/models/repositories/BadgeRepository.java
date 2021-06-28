package pt.iade.elchadb.models.repositories;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import pt.iade.elchadb.models.Badge;


public interface BadgeRepository extends CrudRepository<Badge,Integer> {

    // QUERIES
    @Query(value=
        "SELECT Bad_ID AS id, "+
        "Bad_name AS name, "+
        "Bad_description AS description, "+
        "Bad_type AS type, ",
    nativeQuery=true)
    Badge FindUserId( int BadgeId);

}


