/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import java.util.List;
import lost_found_dao.FoundDao;
import lost_found_dao.LostDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import persistence.pojo.Found;
import persistence.pojo.Lost;
import persistence.pojo.Users;
import user_dao.UserDataRegisterDao;

/**
 *
 * @author eslam java
 */
@Controller
public class MainController {
    
    @Autowired
    ApplicationContext context;
    
    
      @RequestMapping(value = "/users.htm", method = RequestMethod.GET)
    public String retrieveUsersData(Model usersData) {
        
          UserDataRegisterDao userDao = context.getBean(UserDataRegisterDao.class);
          
          List<Users> usersDataList = (List<Users>) userDao.findAll(); 
        usersData.addAttribute("users",usersDataList);

        return "users";
    }

        @RequestMapping(value = "/lost.htm", method = RequestMethod.GET)
    public String retrieveLostData(Model lostData) {
        
          LostDao lostDao = context.getBean(LostDao.class);
          
          List<Lost> lostDataList = (List<Lost>) lostDao.findAll(); 
        lostData.addAttribute("lostChildren",lostDataList);
        
        return "lostchildren";
    }
    
           @RequestMapping(value = "/found.htm", method = RequestMethod.GET)
    public String retrieveFoundData(Model foundData) {
        
          FoundDao foundDao = context.getBean(FoundDao.class);
          
          List<Found> foundDataList = (List<Found>) foundDao.findAll(); 
               System.out.println("data: "+foundDataList.get(0).getReturned());
        foundData.addAttribute("foundChildren",foundDataList);

        return "foundchildren";
    }
    
             @RequestMapping(value = "/index.htm", method = RequestMethod.GET)
    public String retrieveHome() {
        

        return "index";
    }
    
    public ApplicationContext getContext() {
        return context;
    }

    public void setContext(ApplicationContext context) {
        this.context = context;
    }
    
    
}
