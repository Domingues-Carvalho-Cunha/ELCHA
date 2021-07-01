package pt.iade.elchadb.models.repositories;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
//import org.springframework.data.repository.query.Param;

import pt.iade.elchadb.models.AppUser;


public interface UserRepository extends CrudRepository<AppUser,Integer> {

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


    //Infelizmente o que se encontra a comentado impede de iniciar o servidor :(

    //Query encontrar um user por nome mesmo que imcompleto
    Iterable<AppUser> findByFirstNameContaining(String text);

    //Query encontrar alguém através do nome e dos pontos

    //String findSomeone = "select * FROM AppUser WHERE AppUser.Us_firstName =: firstName and AppUser.Us_points =: points";
    //Iterable<AppUser> findByFirstName(@Param ("firstName") String name);


    Iterable<AppUser> findByPointsBetween (int min, int max);
    //Iterable<AppUser> findByNameContainingAndPointsBetween(String name, int _pointsMin, int _pointsMax);

}