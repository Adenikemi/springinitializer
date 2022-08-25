package com.example.springinitializer.userInfo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class UserService {
    @Autowired
    private UserRepository repo;

    public List<Users> listAll(){
        return (List<Users>) repo.findAll();
    }

    public Users save(Users user) {
        return repo.save(user);
    }


}
