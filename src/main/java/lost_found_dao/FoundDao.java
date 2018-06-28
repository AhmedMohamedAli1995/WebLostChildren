/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lost_found_dao;

import java.util.List;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;
import persistence.pojo.Found;
import persistence.pojo.Users;

/**
 *
 * @author eslam java
 */
public interface FoundDao extends CrudRepository<Found, Integer> {

    List<Found> findByReturned(@Param("returned") String value);

    List<Found> findByImageUrl(@Param("imageUrl") String value);

    List<Found> findByGender(@Param("gender") String value);
    
     List<Found> findByGenderFnameLname(@Param("gender") String gender, @Param("firstName") String firstName, @Param("lastName") String lastName);

    List<Found> findByGenderFname(@Param("gender") String gender, @Param("firstName") String firstName);

    List<Found> findByGenderLname(@Param("gender") String gender, @Param("lastName") String lastName);

    @Transactional
    @Modifying
    int updateFoundReturned(@Param("returned") String value, @Param("id") int id);

}
