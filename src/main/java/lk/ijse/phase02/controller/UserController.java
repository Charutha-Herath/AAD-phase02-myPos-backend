package lk.ijse.phase02.controller;


import lk.ijse.phase02.dto.impl.UserDTO;
import lk.ijse.phase02.exception.DataPersistException;
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
            @RequestPart("email") String email,
            @RequestPart("password")String password
    ){
        try {

            UserDTO buildUserDTO = new UserDTO();

            String userId = AppUtil.generateUserId();

            buildUserDTO.setUserId(userId);
            buildUserDTO.setName(name);
            buildUserDTO.setEmail(email);
            buildUserDTO.setPassword(password);

            userService.saveUser(buildUserDTO);
            return new ResponseEntity<>(HttpStatus.CREATED);
        }catch (DataPersistException e){
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }catch (Exception e){
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
