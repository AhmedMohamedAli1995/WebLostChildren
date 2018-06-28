/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package user_dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import persistence.pojo.Users;

/**
 *
 * @author eslam java
 */
public interface UserLogInDao extends CrudRepository<Users, Integer> {
    
    Users findByEmailAndPassword(@Param("email")String email,@Param("password") String password);
    
}
