/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package found_rest_webservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import others_dto.StatusJson;
import persistence.pojo.Users;
import lost_found_dao.FoundDao;
import user.dto.UserImageUploadeDto;
import user_dao.UserDataRegisterDao;
import utilities.ImageUpload;

/**
 *
 * @author eslam java
 */
@RestController
public class FoundReturnedWebService {

    @Autowired
    ApplicationContext appContext;

    public @RequestMapping(value = "/updateFoundReturned.json", method = RequestMethod.GET)
    StatusJson updateFoundReturned(@RequestParam(value = "returned") String value, @RequestParam(value = "id") Integer id) {

        FoundDao foundDao = appContext.getBean(FoundDao.class);
        
        System.out.println(" value: "+value+" id: "+id);
        
        try {
            
            if (value != null && id > 0) {

            int updatedId = foundDao.updateFoundReturned(value, id);
            if (updatedId > 0) {
                
                return new StatusJson("SUCCESS");
            }
        }
            
        } catch (Exception e) {
            
            e.printStackTrace();
            return new StatusJson("FAILED");
        }

        
        return new StatusJson("FAILED");

    }

    public ApplicationContext getAppContext() {
        return appContext;
    }

    public void setAppContext(ApplicationContext appContext) {
        this.appContext = appContext;
    }

}
