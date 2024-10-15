package lk.ijse.phase02.entity.impl;

import jakarta.persistence.*;

import lk.ijse.phase02.entity.SuperEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "user")
public class UserEntity implements SuperEntity {
    @Id
    private String userId;
    private String name;
    private String email;
    private String password;

}
