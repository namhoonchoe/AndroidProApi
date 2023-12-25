package com.example.androidproapi.service;

import com.example.androidproapi.entitity.User;
import com.example.androidproapi.security.TokenProvider;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.Duration;

@RequiredArgsConstructor
@Service
public class TokenService {

    private TokenProvider tokenProvider;
    private RefreshTokenService refreshTokenService;
    private UserService userService;

    @Autowired
    public TokenService(TokenProvider tokenProvider, RefreshTokenService refreshTokenService, UserService userService) {
        this.refreshTokenService = refreshTokenService;
        this.userService = userService;
        this.tokenProvider = tokenProvider;
    }

    public String createNewAccessToken(String refreshToken) {
        // 토큰 유효성 검사에 실패하면 예외 발생
        if(!tokenProvider.validToken(refreshToken)) {
            throw new IllegalArgumentException("Unexpected token");
        }

        Long userId = refreshTokenService.findByRefreshToken(refreshToken).getUserId();
        User user = userService.findById(userId);

        return tokenProvider.generateToken(user, Duration.ofHours(2));
    }
}