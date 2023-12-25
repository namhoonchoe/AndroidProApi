package com.example.androidproapi.service;


import com.example.androidproapi.dto.AuthRequestDto;
import com.example.androidproapi.dto.SignUpDto;
import com.example.androidproapi.entitity.User;
import com.example.androidproapi.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

    @RequiredArgsConstructor
    @Service
    public class UserService {

        private UserRepository userRepository;
        @Autowired
        public UserService(UserRepository userRepository) {
            this.userRepository = userRepository;
        }


        public Long save(SignUpDto dto) {
            BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

            return userRepository.save(User.builder()
                    .account(dto.getAccount())
                    .password(encoder.encode(dto.getPassword()))
                    .build()).getId();
        }

        public User findById(Long userId) {
            return userRepository.findById(userId)
                    .orElseThrow(() -> new IllegalArgumentException("Unexpected user"));
        }

        public User findByAccount(String account) {
            return userRepository.findByAccount(account)
                    .orElseThrow(() -> new IllegalArgumentException("Unexpected user"));
        }
    }


