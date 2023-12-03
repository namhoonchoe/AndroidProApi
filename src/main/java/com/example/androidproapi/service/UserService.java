package com.example.androidproapi.service;

import com.example.androidproapi.dto.SignUpRequestDto;
import com.example.androidproapi.entitity.User;

public interface UserService {
    User registerUser(SignUpRequestDto  registrationRequest);
}
