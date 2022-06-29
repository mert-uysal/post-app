package com.youngadessi.app.user.service.concretes;

import com.youngadessi.app.user.service.abstracts.UserService;
import com.youngadessi.app.user.dataAccess.UserDao;
import com.youngadessi.app.user.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserManager implements UserService {
    @Autowired
    private UserDao userDao;

    @Override
    public User addUser(User user) {
        return this.userDao.save(user);
    }

    @Override
    public User updateUser(User user) {
        return this.userDao.save(user);
    }

    @Override
    public List<User> listAllUsers() {
        return this.userDao.findAll();
    }

    @Override
    public User findUserByUsernameOrEmail(String username, String email) {
        return this.userDao.findUserByUsernameOrEmail(username, email);
    }

    @Override
    public User findUserUsernameAndEmail(String userName, String eMail) {
        return this.userDao.findUserUsernameAndEmail(userName, eMail);
    }
}
