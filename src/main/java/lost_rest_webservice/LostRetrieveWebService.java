/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lost_rest_webservice;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import persistence.pojo.Lost;
import lost_found_dao.LostDao;

/**
 *
 * @author eslam java
 */
@RestController
public class LostRetrieveWebService {

    @Autowired
    private ApplicationContext context;

    public @RequestMapping(value = "/lostRetrieve.json", method = RequestMethod.GET)
    List<Lost> retrievingLost() {

        LostDao lostDao = context.getBean(LostDao.class);

        return lostDao.findByReturned("no");
    }

    public ApplicationContext getContext() {
        return context;
    }

    public void setContext(ApplicationContext context) {
        this.context = context;
    }

}
