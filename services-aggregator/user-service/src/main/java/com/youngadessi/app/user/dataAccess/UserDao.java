package com.youngadessi.app.user.dataAccess;

import com.youngadessi.app.user.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface UserDao extends JpaRepository<User, Long> {
    User findUserByUsernameOrEmail (String username, String email);
    @Query("From User where username=:userName and email=:eMail")
    User findUserUsernameAndEmail (String userName, String eMail);
}
