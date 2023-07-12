package com.SpringHotel.service;

import com.SpringHotel.entity.User;
import com.SpringHotel.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    @Autowired
    UserRepository userR;

    public Optional<User> GetUserByid(Integer id){ return userR.getUserByid(id);}
    public List<User> GetAll(){
        return userR.findAll();
    }
    public User addUser(User u){
        return userR.save(u);
    }
    public String deleteByUserId(Integer id){
        userR.deleteByid(id);
        return "User Eliminato!";
    }
    public User updateUser(Integer id,User u){
        User utente= userR.findById(id).orElse(null);
        if(utente!=null){
           return userR.save(u);
        }
        else {
            return null;
        }
    }
}
