package pt.iade.elchadb.models.repositories;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import pt.iade.elchadb.models.AppUser;


public interface UserRepository extends CrudRepository<AppUser,Integer> {
/*
    String QueryFindUnitPlans =
        "SELECT u.dis_id AS id, u.dis_nome AS name, "+
        "u.dis_creditos AS credits, "+
        "p.pla_semestre AS semester, "+
        "c.cur_nome AS courseName, c.cur_id AS courseId "+
        "FROM disciplinas u "+
        "INNER JOIN planoestudos p ON u.dis_id=p.pla_dis_id "+
        "INNER JOIN cursos c ON p.pla_cur_id=c.cur_id";
        
*/

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


/*
    String findName = ("select Us_firstName from AppUser where Us_firstName =: firstName");
    Iterable<AppUser> findByNameContaining(String text);


    String findSomeone = ("select * from AppUser where Us_firstName, Us_points =: firstName, points");
    Iterable<AppUser> findByName(String name);
    Iterable<AppUser> findByPointsBetween(int min,int max);
    Iterable<AppUser> findByNameContainingAndPointsBetween(String name, int _pointsMin, int _pointsMax);
*/
}


