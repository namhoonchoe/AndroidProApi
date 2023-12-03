package com.example.androidproapi.service.impl;

import com.example.androidproapi.dto.SignInRequestDto;
import com.example.androidproapi.entitity.User;
import com.example.androidproapi.repository.UserRepository;
import com.example.androidproapi.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service
public class AuthServiceImpl implements AuthService {
    private final UserRepository userRepository;

    @Autowired
    public AuthServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public boolean authenticate(SignInRequest singinRequest) {
        User  user = userRepository.findByUsername(loginRequest.getUsername());
        return user != null && user.getPassword().equals(loginRequest.getPassword());
    }
}