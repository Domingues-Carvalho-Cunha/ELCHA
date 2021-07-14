package pt.iade.elchadb.models.repositories;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import pt.iade.elchadb.models.AppUser;

public interface UserRepository extends CrudRepository<AppUser,Integer> {

    String findbypoints = "SELECT Us_ID, Us_firstName, Us_lastName, Us_gender, Us_email, Us_dob, Us_points, Us_level, Us_gems, Us_status FROM appuser order by Us_points desc";
    @Query (value = findbypoints, nativeQuery = true)
    Iterable<AppUser> findbypoints ();

    // QUERIES
    @Query(value=
        "SELECT Us_ID AS id, "+
        "Us_firstName AS firstName, "+
        "Us_lastName AS lastName, "+
        "Us_gender AS gender, "+
        "Us_email AS email, "+
        "Us_dob AS dateOfBirth, "+
        "Us_points AS points, "+
        "Us_level AS level, "+
        "Us_gems AS gems, "+
        "Us_status AS status",
    nativeQuery=true)
    AppUser FindUserId( int UserId);

    //Query encontrar um user por nome mesmo que imcompleto
    Iterable<AppUser> findByFirstNameContaining(String text);

    //Query encontrar um user por range de pontos
    Iterable<AppUser> findByPointsBetween (int min, int max);

    
}