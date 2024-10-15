package lk.ijse.phase02.dao;

import lk.ijse.phase02.entity.impl.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserDao extends JpaRepository<UserEntity,String> {
    UserEntity findByEmail(String email);
}
