package lk.ijse.phase02.controller;


import lk.ijse.phase02.service.UserService;
import lk.ijse.phase02.util.AppUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("api/v1/user")
public class UserController {

    private UserService userService;

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> saveUser(
            @RequestPart("name") String name,
            @RequestPart("email") String mail,
            @RequestPart("password")String password
    ){
        String userId = AppUtil.generateUserId();
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

}
