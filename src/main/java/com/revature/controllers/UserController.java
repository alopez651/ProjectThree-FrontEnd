package com.revature.controllers;

import com.revature.models.User;
import com.revature.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
//@CrossOrigin(origins = "http://localhost:4200", allowCredentials = "true")
@CrossOrigin(origins = "http://p3-front-bucket.s3-website-us-east-1.amazonaws.com", allowCredentials = "true")
//@CrossOrigin(origins = "*")
public class UserController {
    @Autowired
    UserService userService;

    //    @GetMapping("/search")
//    public List<User> findByFirstNameAndLastNameAndEmail(@RequestBody UserInfor userInfor) {
//        System.out.println(userInfor);
//        return userService.findByFirstNameAndLastNameAndEmail(userInfor);
//    }
    @GetMapping("/search")
    public List<User> findByString(@RequestParam(value = "word", required = true) String word){
        return userService.findByString(word);
    }
}
