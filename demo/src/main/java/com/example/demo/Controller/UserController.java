package com.example.demo.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Model.User;
import com.example.demo.Service.UserService;
@CrossOrigin("http://localhost:3000")
@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;


    @PostMapping("/add")
    boolean addUser(@RequestBody User user)
    {
        return userService.addUser(user);
    }

    @GetMapping("/login/phone")
    boolean loginUsingPhoneNumber(@RequestParam String phoneString,@RequestParam String passString)
    {
        return userService.loginUsingPhoneNumber(phoneString, passString);
    }

    @GetMapping("/login/email")
    boolean loginUsingEmail(@RequestParam String emailString,@RequestParam String passString)
    {
        return userService.loginUsingEmail(emailString, passString);
    }
}
