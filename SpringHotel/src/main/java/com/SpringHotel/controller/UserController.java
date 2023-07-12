package com.SpringHotel.controller;

import com.SpringHotel.entity.User;
import com.SpringHotel.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin
@RestController
@RequestMapping("/api/user")
public class UserController {
     @Autowired
     UserService userS;

     @GetMapping("/getByid/{id}")
     public Optional<User>GetUserByid(@PathVariable Integer id){
         return userS.GetUserByid(id);
     }

     @GetMapping("/getAll")
     public List<User> GetAllUser(){
         return userS.GetAll();
     }
    @Transactional

    @PostMapping("/add")
     public User addUser(@RequestBody User u){
         return userS.addUser(u);
     }

    @Transactional
    @DeleteMapping("/delete/{id}")
     public String deleteUser(@PathVariable Integer id,User u){
         return userS.deleteByUserId(id);
     }
    @Transactional
    @PutMapping("/update/{id}")
    public User updateUser(@PathVariable Integer id,@RequestBody User u){
         return userS.updateUser(id,u);
     }
}
