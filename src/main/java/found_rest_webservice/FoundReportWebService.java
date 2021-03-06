/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package found_rest_webservice;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;
import java.util.Date;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import others_dto.StatusJson;
import persistence.pojo.Found;
import persistence.pojo.Users;
import lost_found_dao.FoundDao;
import user_dao.UserDataRegisterDao;
import utilities.ImageUpload;

/**
 *
 * @author eslam java
 */
@RestController
public class FoundReportWebService {

    @Autowired
    private ApplicationContext context;
    @Autowired
    ImageUpload imageUpload;

    public @RequestMapping(value = "/foundReport.json", headers = ("content-type=multipart/*"),method = RequestMethod.POST)
    StatusJson reportingFound(@RequestParam(value = "found") String foundJson, @RequestParam(value = "email") String email, @RequestParam(value = "image") MultipartFile image, @RequestParam(value = "extension") String imgExtension) {

        ObjectMapper mapper = new ObjectMapper();
        Found found = new Found();
        try {
            found = mapper.readValue(foundJson, Found.class);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        UserDataRegisterDao userDao = context.getBean(UserDataRegisterDao.class);
        FoundDao foundDao = context.getBean(FoundDao.class);
        Users userData = userDao.findByEmail(email);

        if (userData != null) {

            Date date = new Date();
            found.setFoundUserId(userData);
            if (image != null) {
                String[] extensionSplits = imgExtension.split("/");
                String imageUrl = imageUpload.imageUploading(image, email + "-" + date.toString().replace(" ", "-").replace(":", "-") + System.nanoTime(), "found_images", extensionSplits[1]);
                if (!imageUrl.equals(ImageUpload.FILE_CAN_NOT_BE_SAVED) && !imageUrl.equals(ImageUpload.FILE_IS_EMAPTY)) {
                    found.setImageUrl(imageUrl);
                    foundDao.save(found);
                    return new StatusJson("SUCCESS");

                }
            }
        }

        return new StatusJson("FAILED");
    }

    public ApplicationContext getContext() {
        return context;
    }

    public void setContext(ApplicationContext context) {
        this.context = context;
    }

    public ImageUpload getImageUpload() {
        return imageUpload;
    }

    public void setImageUpload(ImageUpload imageUpload) {
        this.imageUpload = imageUpload;
    }
}
