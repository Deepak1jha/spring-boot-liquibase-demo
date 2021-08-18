package com.liquibase.demo.controller.user;

import com.liquibase.demo.model.user.User;
import com.liquibase.demo.repository.user.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @PostMapping("/")
    public String save(@RequestParam String name) {
        userRepository.save(new User(name, "someone@gmail.com", "1231313"));
        return userRepository.findByName(name) + "Saved successfully";
    }

    @GetMapping("/")
    public List<User> getAll(){
        return (List<User>) userRepository.findAll();
    }
}
