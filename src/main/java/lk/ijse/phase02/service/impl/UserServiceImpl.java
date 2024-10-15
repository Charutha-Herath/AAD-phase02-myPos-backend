package lk.ijse.phase02.service.impl;

import jakarta.transaction.Transactional;
import lk.ijse.phase02.dao.UserDao;
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
}
