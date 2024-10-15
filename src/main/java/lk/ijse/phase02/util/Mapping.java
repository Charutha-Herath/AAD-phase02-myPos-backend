package lk.ijse.phase02.util;


import lk.ijse.phase02.dto.impl.UserDTO;
import lk.ijse.phase02.entity.impl.UserEntity;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class Mapping {
    @Autowired
    private ModelMapper modelMapper;

    public UserEntity toUserEntity(UserDTO userDTO) {
        return modelMapper.map(userDTO, UserEntity.class);
    }



}
