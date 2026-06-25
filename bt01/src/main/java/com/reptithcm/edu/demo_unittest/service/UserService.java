package com.reptithcm.edu.demo_unittest.service;

import com.reptithcm.edu.demo_unittest.entity.User;
import com.reptithcm.edu.demo_unittest.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    public String getUserName(Long id) {
        return userRepository.findById(id).orElseThrow().getUserName();
    }

    public List<User> getUsers(){
        return userRepository.findAll();
    }
}
