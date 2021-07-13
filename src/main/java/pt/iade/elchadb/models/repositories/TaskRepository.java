package pt.iade.elchadb.models.repositories;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import pt.iade.elchadb.models.Task;


public interface TaskRepository extends CrudRepository<Task,Integer> {

    // QUERIES
    @Query(value=
        "SELECT Task_ID AS id, "+
        "Task_name AS name, "+
        "Task_description AS description, "+
        "Task_points AS points, "+
        "Task_category AS category",
    nativeQuery=true)
    Task FindUserId( int TaskId);

    //Query encontrar task por categoria
    Iterable<Task> findByCategoryContaining(String text);
}


