package com.youngadessi.app.user.service.abstracts;

import com.youngadessi.app.user.model.User;

import java.util.List;

public interface UserService {
    User addUser(User user);
    User updateUser(User user);
    List<User> listAllUsers();
    User findUserByUsernameOrEmail (String username, String email);
    User findUserUsernameAndEmail (String userName, String eMail);
}
