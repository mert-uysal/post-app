package com.youngadessi.app.user.repository;

import java.util.List;

import com.youngadessi.app.user.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    User findUserByUsernameOrEmail (String username, String email);
    @Query("From User where username=:userName and email=:eMail")
    User findUserUsernameAndEmail (String userName, String eMail);

    List<User> findByFullnameContainsIgnoreCase(String searchKeyword);
}
