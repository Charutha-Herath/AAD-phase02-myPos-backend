package lk.ijse.phase02.service.impl;

import jakarta.transaction.Transactional;
import lk.ijse.phase02.customStatusCodes.SelectedUserErrorStatus;
import lk.ijse.phase02.dao.UserDao;
import lk.ijse.phase02.dto.UserStatus;
import lk.ijse.phase02.dto.impl.UserDTO;
import lk.ijse.phase02.entity.impl.UserEntity;
import lk.ijse.phase02.exception.DataPersistException;
import lk.ijse.phase02.service.UserService;
import lk.ijse.phase02.util.Mapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
@Transactional
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;
    @Autowired
    private Mapping mapping;
    @Override
    public void saveUser(UserDTO userDTO) {
        UserEntity savedUser = userDao.save(mapping.toUserEntity(userDTO));
        if (savedUser == null) {
            throw new DataPersistException("User not saved");
        }

    }

    @Override
    public UserStatus getUserByEmail(String email) {
        if(userDao.existsById(email)){
            UserEntity selectedUser = userDao.findByEmail(email);
            return mapping.toUserDTO(selectedUser);
        }else {
            return new SelectedUserErrorStatus(2, "User with email " + email + " not found");
        }
    }
}
