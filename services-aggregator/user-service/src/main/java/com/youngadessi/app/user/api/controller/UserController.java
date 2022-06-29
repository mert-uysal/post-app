package com.youngadessi.app.user.api.controller;

import com.youngadessi.app.user.service.abstracts.UserService;
import com.youngadessi.app.user.model.User;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

@RestController
@RequestMapping("/api/user")
@RequiredArgsConstructor
public class UserController {
    private UserService userService;

    @PostMapping("/addUser")
    public User addUser(@RequestBody User user){
        Date date = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
        DateTimeFormatter formatter2 = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
        String tempDate = formatter.format(date);
//        String tempdate2 = formatter2.format((TemporalAccessor) date);
        user.setCreatedTime(LocalDateTime.parse(tempDate, formatter2));
//        user.g
        return this.userService.addUser(user);
    }


}
