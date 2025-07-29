package com.example.PracticeDemo.controller;

import com.example.PracticeDemo.entity.UserEntity;
import com.example.PracticeDemo.service.UserService;
import jakarta.persistence.EntityNotFoundException;
import org.apache.catalina.User;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    UserService userService;

    @PostMapping
    public UserEntity createUser(@RequestBody UserEntity user){
        return userService.createUser(user);
    }

    @PutMapping("/{id}")
    public ResponseEntity<UserEntity> updateUser(@PathVariable Long id, @RequestBody UserEntity updateUser){
        try{
            UserEntity user = userService.updateUser(id,updateUser);
            return ResponseEntity.ok(user);
        }catch (EntityNotFoundException ex){
            return ResponseEntity.notFound().build();
        }catch (Exception ex){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteUser(@PathVariable Long id){
       userService.deleteUser(id);
       return ResponseEntity.ok("user deleted succesfully with ID: "+id);
    }

    @GetMapping
    public ResponseEntity<List<UserEntity>> getAllUser(){
        List<UserEntity> user = userService.getAllUsers();
        return ResponseEntity.ok(user);
    }

    // this endpoint is for getting user by id
    @GetMapping("/{id}")
    public ResponseEntity<UserEntity> getUserById(@PathVariable Long id){
        UserEntity user = userService.getUserById(id);
        return ResponseEntity.ok(user);
    }


}













