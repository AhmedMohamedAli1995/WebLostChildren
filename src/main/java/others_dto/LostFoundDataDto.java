/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package others_dto;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import persistence.pojo.Found;
import persistence.pojo.Lost;

/**
 *
 * @author eslam java
 */
@Component
@Scope(value = "prototype")
public class LostFoundDataDto {

    @Autowired
    List<Lost> lostList;
    @Autowired
    List<Found> foundList;

    public LostFoundDataDto() {
    }

    public LostFoundDataDto(List<Lost> lostList, List<Found> foundList) {
        this.lostList = lostList;
        this.foundList = foundList;
    }
    
    

    public List<Lost> getLostList() {
        return lostList;
    }

    public void setLostList(List<Lost> lostList) {
        this.lostList = lostList;
    }

    public List<Found> getFoundList() {
        return foundList;
    }

    public void setFoundList(List<Found> foundList) {
        this.foundList = foundList;
    }

}
