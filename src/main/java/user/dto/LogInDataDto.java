/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package user.dto;

import java.io.Serializable;
import javax.xml.bind.annotation.XmlRootElement;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import persistence.pojo.Users;

/**
 *
 * @author eslam java
 */

@Component(value = "logInDataDto")
@Scope(value = "prototype")
@XmlRootElement
@Qualifier

public class LogInDataDto {
    
    private String status;
    private Users user;

    public LogInDataDto() {
    }
    
    

    public LogInDataDto(String status, Users user) {
        this.status = status;
        this.user = user;
    }
    
    
    

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Users getUser() {
        return user;
    }

    public void setUser(Users user) {
        this.user = user;
    }
    
    
    
}
