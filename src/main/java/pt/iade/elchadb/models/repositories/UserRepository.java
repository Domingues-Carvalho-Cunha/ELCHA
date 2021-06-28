package pt.iade.elchadb.models.repositories;

import org.springframework.data.jpa.repository.Query;

//import javax.sql.rowset.spi.TransactionalWriter;

import org.apache.catalina.User;
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
        "SELECT ut_id AS id, "+
        "ut_nome AS Nome, "+
        "ut_surname AS Apelido, "+
        "ut_genero AS Genero, "+
        "ut_danasc AS Data Nascimento",
    nativeQuery=true)
    AppUser FindUserId( int UserId);   
    
    AppUser save(User user);

/*
    String findName = ("select Us_firstName from AppUser where Us_firstName =: firstName");

    @Modifying @Transactional
    @Query(value=findName,nativeQuery = true)
    Iterable<AppUser> findByNameContaining();


    String findSomeone = ("select * from AppUser where Us_firstName, Us_points =: firstName, points");
    Iterable<AppUser> findByName(String name);
    Iterable<AppUser> findByPointsBetween(int min,int max);
    Iterable<AppUser> findByNameContainingAndPointsBetween(String name, int _pointsMin, int _pointsMax);
*/
}


