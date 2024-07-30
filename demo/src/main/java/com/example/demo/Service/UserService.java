package com.example.demo.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Model.User;
import com.example.demo.Repo.UserRepo;

@Service
public class UserService {
    @Autowired
    private UserRepo userRepo;
    public boolean addUser(User user)
    {
        userRepo.save(user);
        return true;
    }
    public boolean loginUsingPhoneNumber(String phoneString,String passString)
    {
        User user = userRepo.findByPhoneNumber(phoneString).orElse(null);
        if(user == null)
        {
            return false;
        }
        if(user.getPassword()!=passString)
        {
            return false;
        }
        return true;
    }
    public boolean loginUsingEmail(String emailString,String passString)
    {
        User user = userRepo.findByEmail(emailString).orElse(null);
        if(user == null)
        {
            return false;
        }
        if(user.getPassword()!=passString)
        {
            return false;
        }
        return true;
    }
}
