package com.example.PracticeDemo.serviceImpl;

import com.example.PracticeDemo.entity.UserEntity;
import com.example.PracticeDemo.repository.UserRepository;
import com.example.PracticeDemo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepository userRepository;

    @Override
    public UserEntity createUser(UserEntity user) {
        return userRepository.save(user);
    }

    @Override
    public UserEntity getUserById(Long id) {
        return userRepository.findById(id).orElseThrow(() -> new RuntimeException("User not found"));
    }

    @Override
    public List<UserEntity> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public UserEntity updateUser(Long id, UserEntity updateUser) {
        UserEntity user = getUserById(id);
        user.setName(updateUser.getName());
        user.setEmail(updateUser.getEmail());
       return userRepository.save(user);
    }

    @Override
    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }
}
