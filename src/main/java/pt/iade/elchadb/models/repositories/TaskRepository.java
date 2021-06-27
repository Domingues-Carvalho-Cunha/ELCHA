package pt.iade.elchadb.models.repositories;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import pt.iade.elchadb.models.Task;

public interface TaskRepository extends CrudRepository<Task,Integer> {
/*
    @GetMapping(path ="/", produces= MediaType.APPLICATION_JSON_VALUE)
    public Iterable<AppUser> getUtilizadoresPontos() {
        logger.info("A carregar a Leadearboard");
        return UserRepository.EcontraPonSuperior();
    }
*/

    @Query(value=
        "SELECT ut_id AS id, ut_nome AS Nome, "+
        "ut_surname AS Apelido, "+
        "ut_genero AS Genero, "+
        "ut_danasc AS Data Nascimento",
    nativeQuery=true)
    Task FindUserId( int TaskId);

    Task save(Task task);
}