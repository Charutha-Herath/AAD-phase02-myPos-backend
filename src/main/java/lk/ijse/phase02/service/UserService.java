package lk.ijse.phase02.service;

import lk.ijse.phase02.dto.UserStatus;
import lk.ijse.phase02.dto.impl.UserDTO;

public interface UserService {

    void saveUser(UserDTO userDTO);

    UserStatus getUserByEmail(String email);
}
