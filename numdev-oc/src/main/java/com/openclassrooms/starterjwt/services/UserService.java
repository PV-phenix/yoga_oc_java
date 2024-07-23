package com.openclassrooms.starterjwt.services;

import com.openclassrooms.starterjwt.models.User;
import com.openclassrooms.starterjwt.repository.UserRepository;

import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class UserService {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
    
    public List<User> findAll() {
        return this.userRepository.findAll();
    }

    public void delete(Long id) {
        this.userRepository.deleteById(id);
    }

    public User findById(Long id) {
        return this.userRepository.findById(id).orElse(null);
    }
}
