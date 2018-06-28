/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package user_rest_webservice;

import javax.servlet.ServletContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import persistence.pojo.Users;
import user.dto.LogInDataDto;
import user.dto.UserImageUploadeDto;
import user_dao.UserDataRegisterDao;
import utilities.ImageUpload;

/**
 *
 * @author eslam java
 */
@RestController
public class UserImageUploadeService {

    @Autowired
    ApplicationContext appContext;
    @Autowired
    ImageUpload imageUpload;

    public @RequestMapping(value = "/imageUploade.json", headers = ("content-type=multipart/*"), method = RequestMethod.POST)
    UserImageUploadeDto imageUpload(
            @RequestParam(value = "userImage") MultipartFile inputFile,
            @RequestParam(value = "email") String email,
            @RequestParam(value = "extension") String imgExtension) {

        UserDataRegisterDao userDataRegDao = appContext.getBean(UserDataRegisterDao.class);
        UserImageUploadeDto userImageUploadeDto = (UserImageUploadeDto) appContext.getBean("userImageUploadeDto");

        String[] extensionSplits = imgExtension.split("/");
        String imageUrl = imageUpload.imageUploading(inputFile, email, "users_images", extensionSplits[1]);

        if (!imageUrl.equals(ImageUpload.FILE_CAN_NOT_BE_SAVED) && !imageUrl.equals(ImageUpload.FILE_IS_EMAPTY)) {
            userDataRegDao.updateUserImageUrl(imageUrl, email);
            Users userData = userDataRegDao.findByEmail(email);

            userImageUploadeDto.setStatus("SUCCESS");
            userImageUploadeDto.setUser(userData);
            return userImageUploadeDto;
        }
        userImageUploadeDto.setStatus("FAILED");

        return userImageUploadeDto;
    }

    public ApplicationContext getAppContext() {
        return appContext;
    }

    public void setAppContext(ApplicationContext appContext) {
        this.appContext = appContext;
    }

    public ImageUpload getImageUpload() {
        return imageUpload;
    }

    public void setImageUpload(ImageUpload imageUpload) {
        this.imageUpload = imageUpload;
    }

}
