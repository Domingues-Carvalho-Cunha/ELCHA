package pt.iade.elchadb.models.repositories;

import org.springframework.data.repository.CrudRepository;
import pt.iade.elchadb.models.Task;

public interface TaskRepository extends CrudRepository<Task,Integer> {

}