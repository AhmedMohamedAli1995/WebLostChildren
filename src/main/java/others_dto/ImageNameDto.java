/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package others_dto;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/**
 *
 * @author eslam java
 */

@Component
@Scope(value = "prototype")
public class ImageNameDto {
    
    private String imageName;
    private String LostFound;

    public ImageNameDto() {
    }
    
    

    public ImageNameDto(String imageName, String LostFound) {
        this.imageName = imageName;
        this.LostFound = LostFound;
    }
    
    

    public String getImageName() {
        return imageName;
    }

    public void setImageName(String imageName) {
        this.imageName = imageName;
    }

    public String getLostFound() {
        return LostFound;
    }

    public void setLostFound(String LostFound) {
        this.LostFound = LostFound;
    }
    
    
    
}
