package pt.iade.elchadb.models.repositories;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import pt.iade.elchadb.models.PostalCode;


public interface PostalCodeRepository extends CrudRepository<PostalCode,Integer> {

    // QUERIES
    @Query(value=
    "SELECT Pc_ID AS id, "+
    "Pc_4D AS code4D, "+
    "Pc_3D AS code3D, "+
    "Pc_block AS block, "+
    "Pc_parish AS parish, "+
    "Pc_country AS country, ",
    nativeQuery=true)
    PostalCode FindUserId( int PostalCodeId);

}


