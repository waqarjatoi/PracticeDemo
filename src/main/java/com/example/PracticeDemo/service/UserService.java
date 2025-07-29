package com.example.PracticeDemo.service;



import com.example.PracticeDemo.entity.UserEntity;

import java.util.List;
import java.util.Optional;

public interface UserService {

    UserEntity createUser(UserEntity user);

    UserEntity getUserById(Long id);

    List<UserEntity> getAllUsers();

    UserEntity updateUser(Long id, UserEntity user);

    void deleteUser(Long id);



}
