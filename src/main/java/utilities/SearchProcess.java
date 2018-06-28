/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utilities;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import others_dto.LostFoundDataDto;
import others_dto.SearchDto;
import lost_found_dao.FoundDao;
import lost_found_dao.LostDao;
import persistence.pojo.Found;
import persistence.pojo.Lost;

/**
 *
 * @author eslam java
 */
@Component
@Scope(value = "prototype")
public class SearchProcess {

    @Autowired
    private ApplicationContext context;
    @Autowired
    private FaceRecognition faceRec;

    public LostFoundDataDto search(SearchDto searchData) {

        LostDao lostDao = context.getBean(LostDao.class);
        FoundDao foundDao = context.getBean(FoundDao.class);
        
        List<Lost> lostList = new ArrayList<>();
        List<Found> foundList = new ArrayList<>();
        LostFoundDataDto lostFoundDto = new LostFoundDataDto(lostList, foundList);

        if (searchData.getFirstName() != null && searchData.getLastName() != null) {

            lostFoundDto.getFoundList().addAll(foundDao.findByGenderFnameLname(searchData.getGender(), searchData.getFirstName(), searchData.getLastName()));
            lostFoundDto.getLostList().addAll(lostDao.findByGenderFnameLname(searchData.getGender(), searchData.getFirstName(), searchData.getLastName()));

        } else if (searchData.getFirstName() == null && searchData.getLastName() == null) {

            lostFoundDto.getFoundList().addAll(foundDao.findByGender(searchData.getGender()));
            lostFoundDto.getLostList().addAll(lostDao.findByGender(searchData.getGender()));

        } else if (searchData.getFirstName() == null && searchData.getLastName() != null) {

            lostFoundDto.getFoundList().addAll(foundDao.findByGenderLname(searchData.getGender(), searchData.getLastName()));
            lostFoundDto.getLostList().addAll(lostDao.findByGenderLname(searchData.getGender(), searchData.getLastName()));

        } else if (searchData.getFirstName() != null && searchData.getLastName() == null) {

            lostFoundDto.getFoundList().addAll(foundDao.findByGenderFname(searchData.getGender(), searchData.getFirstName()));
            lostFoundDto.getLostList().addAll(lostDao.findByGenderFname(searchData.getGender(), searchData.getFirstName()));
        }

        return lostFoundDto;
    }

    public ApplicationContext getContext() {
        return context;
    }

    public void setContext(ApplicationContext context) {
        this.context = context;
    }

    public FaceRecognition getFaceRec() {
        return faceRec;
    }

    public void setFaceRec(FaceRecognition faceRec) {
        this.faceRec = faceRec;
    }

}
