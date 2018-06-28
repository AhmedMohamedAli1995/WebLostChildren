/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lost_rest_webservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import others_dto.StatusJson;
import lost_found_dao.LostDao;

/**
 *
 * @author eslam java
 */
@RestController
public class LostReturnedWebService {

    @Autowired
    ApplicationContext appContext;

    public @RequestMapping(value = "/updateLostReturned.json", method = RequestMethod.GET)
    StatusJson updateLostReturned(@RequestParam(value = "returned") String value, @RequestParam(value = "id") int id) {

        LostDao lostDao = appContext.getBean(LostDao.class);

        try {
            if (value != null && id > 0) {

                int updatedId = lostDao.updateLostReturned(value, id);
                if (updatedId > 0) {

                    return new StatusJson("SUCCESS");
                }
            }
        } catch (Exception e) {
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
