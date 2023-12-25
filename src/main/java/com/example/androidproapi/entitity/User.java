package com.example.androidproapi.entitity;

import jakarta.persistence.*;
import lombok.*;

import jakarta.persistence.CascadeType;
import java.util.ArrayList;
import java.util.List;

import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;


@Table(name = "user")
@NoArgsConstructor(access = AccessLevel.PROTECTED)

@Setter
@Getter
@Entity
public class User implements UserDetails {
    @Id
    @Column(name ="id")
    private Long id;

    @Column(name = "user_name ", nullable = false,  unique = true)
    private String username;

    @Getter
    @Column(name = "account", nullable = false, unique = true)
    private String account;

    @Column(name = "password", nullable = false)
    private String password;

    @Column(name = "profile_photo", nullable = true)
    private String profilePhoto ;

    @Column(name = "role", nullable = false)
    private String role = "user";

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Board> boards = new ArrayList<Board>();


    @Builder
    public User(String account, String password, String username) {
        this.account = account;
        this.password = password;
        this.username = username;
    }



    public User update(String username) {
        this.username = username;

        return this;
    }



    @Override
    public List<SimpleGrantedAuthority> getAuthorities() {
        return List.of(new SimpleGrantedAuthority("user"));
    }

    @Override
    public String getUsername() {
        return username;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }


}
