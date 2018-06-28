/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package search_rest_webservices;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import others_dto.LostFoundDataDto;
import others_dto.SearchDto;
import utilities.SearchProcess;

/**
 *
 * @author eslam java
 */
@RestController
public class SearchWebService {

    @Autowired
    private ApplicationContext context;

    public @RequestMapping(value = "/search.json", method = RequestMethod.POST)
    LostFoundDataDto searchLostFound(@RequestParam("firstName")String firstName,@RequestParam("lastName")String lastName,@RequestParam("gender")String gender,@RequestParam(value = "userImage") MultipartFile image) {

        SearchProcess searchProcess = context.getBean(SearchProcess.class);
        
        SearchDto searchData = new SearchDto(firstName, lastName, gender, image);

        return searchProcess.search(searchData);
    }

    public ApplicationContext getContext() {
        return context;
    }

    public void setContext(ApplicationContext context) {
        this.context = context;
    }

}
