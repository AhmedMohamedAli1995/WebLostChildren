/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utilities;

import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;
import others_dto.ImageNameDto;

/**
 *
 * @author eslam java
 */
@Component
@Scope(value = "prototype")
public class FaceRecognition {

    @Autowired
    private ServletContext context;
    
    
    
    public List<ImageNameDto> recognizingFace(MultipartFile inputFile){
    
        return new ArrayList<>();
    } 

    public ServletContext getContext() {
        return context;
    }

    public void setContext(ServletContext context) {
        this.context = context;
    }

}
