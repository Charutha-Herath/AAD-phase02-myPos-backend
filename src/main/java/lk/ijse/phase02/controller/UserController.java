package lk.ijse.phase02.controller;


import lk.ijse.phase02.customStatusCodes.SelectedUserErrorStatus;
import lk.ijse.phase02.dto.UserStatus;
import lk.ijse.phase02.dto.impl.UserDTO;
import lk.ijse.phase02.exception.DataPersistException;
import lk.ijse.phase02.service.UserService;
import lk.ijse.phase02.util.AppUtil;
import lk.ijse.phase02.util.RegexProcess;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping(value = "/{email}", produces = MediaType.APPLICATION_JSON_VALUE)
    public UserStatus getSelectedUserByEmail(@PathVariable ("email") String email){
        if(!RegexProcess.userEmailMatcher(email)){
            return new SelectedUserErrorStatus(1,"User email not valid");
        }
        return userService.getUserByEmail(email);
    }

}
