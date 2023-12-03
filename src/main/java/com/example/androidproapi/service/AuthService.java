package com.example.androidproapi.service;
import com.example.androidproapi.dto.SignInRequestDto;

public interface AuthService {
    boolean authenticate(SignInRequestDto SignInRequest);
}