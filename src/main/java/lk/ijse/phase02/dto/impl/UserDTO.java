package lk.ijse.phase02.dto.impl;

import lk.ijse.phase02.dto.UserStatus;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class UserDTO implements UserStatus {
    private String userId;
    private String name;
    private String email;
    private String password;
}
