/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package user.dto;

import javax.xml.bind.annotation.XmlRootElement;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import persistence.pojo.Users;

/**
 *
 * @author eslam java
 */
@Component(value = "userImageUploadeDto")
@Scope(value = "prototype")
@XmlRootElement

public class UserImageUploadeDto extends LogInDataDto{

    public UserImageUploadeDto() {
    }

    public UserImageUploadeDto(String status, Users user) {
        super(status, user);
    }

   
    
    
    
}
