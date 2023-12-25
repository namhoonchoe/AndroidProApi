package com.example.androidproapi.controllers;


import com.example.androidproapi.dto.AuthRequestDto;
import com.example.androidproapi.dto.CreateAccessTokenRequestDto;
import com.example.androidproapi.dto.CreateAccessTokenResponseDto;
import com.example.androidproapi.service.TokenService;
import com.example.androidproapi.service.UserService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.context.SecurityContextHolder;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
public class AuthController {
    private AuthenticationManager authenticationManager;
    private PasswordEncoder passwordEncoder;

    private UserService userService;
    private TokenService tokenService;

    @PostMapping("/signin")
    public ResponseEntity<String> authenticateUser(@RequestBody  AuthRequestDto loginRequest) {
        return ResponseEntity.status(HttpStatus.OK).body("login successful");
    }

    /**
     *회원가입 컨트롤러
     * */
    @PostMapping("/signup")
    public ResponseEntity<CreateAccessTokenResponseDto> createNewAccessToken(@RequestBody CreateAccessTokenRequestDto createAccessTokenRequest) {
        String newAccessToken = tokenService.createNewAccessToken(createAccessTokenRequest.getRefreshToken());
        return ResponseEntity.status(HttpStatus.CREATED).body(new CreateAccessTokenResponseDto(newAccessToken));
     }

    /**
     * 로그아웃 컨트롤러
     * */
    @DeleteMapping("/signout")
    public ResponseEntity<String> logoutUser(HttpServletRequest request, HttpServletResponse response){
        new SecurityContextLogoutHandler().logout(request, response, SecurityContextHolder.getContext().getAuthentication());
        return ResponseEntity.status(HttpStatus.OK).body("Logout successful");
    }
}
