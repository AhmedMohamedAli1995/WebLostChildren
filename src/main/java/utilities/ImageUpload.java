/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utilities;

import java.io.File;
import javax.servlet.ServletContext;
import org.apache.commons.io.FilenameUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.context.annotation.Scope;

/**
 *
 * @author eslam java
 */
@Component
@Scope(value = "prototype")

public class ImageUpload {

    public static final String FILE_IS_EMAPTY = "file is empaty";
    public static final String FILE_CAN_NOT_BE_SAVED = "file can not be saved";

    @Autowired
    ServletContext context;

    public String imageUploading(MultipartFile inputFile, String fileName, String fileLocation, String imgExtension) {

        if (!inputFile.isEmpty()) {
            try {
                String filePath = context.getRealPath("") + fileLocation + File.separator + fileName + "." + imgExtension ;
                System.out.println("file path: "+filePath);
                File destinationFile = new File(filePath);

                inputFile.transferTo(destinationFile);

                return fileLocation+File.separator+fileName+"."+imgExtension;
            } catch (Exception e) {

                e.printStackTrace();
                return FILE_CAN_NOT_BE_SAVED;
            }
        } else {
            return FILE_IS_EMAPTY;
        }
    }

    public static String getFileExtension(String fileName) {

        if (fileName != null) {
            
           return FilenameUtils.getExtension(fileName);
        }
        return null;
    }

}
