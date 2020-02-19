package com.gift.evoucher.controller;

import com.gift.evoucher.model.LoginDao;
import com.gift.evoucher.model.User;
import com.gift.evoucher.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
public class UserController {

    @Autowired
    UserService userService;

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody LoginDao loginDao){
        System.out.println(loginDao.getId());
        Optional<User> user = userService.findById(loginDao.getId());
        if(user.isPresent())
        {
            return new ResponseEntity<>(user.get().getRole(), HttpStatus.OK);
        }
        return new ResponseEntity<>("User not valid",HttpStatus.FORBIDDEN);
    }

}
