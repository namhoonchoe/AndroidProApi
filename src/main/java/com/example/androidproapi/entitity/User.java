package com.example.androidproapi.entitity;

import  com.example.androidproapi.entitity.Board;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;


@Setter
@Getter
@Entity(name = "user")
public class User {
    @Id
    @Column(name ="id")
    private Long id;

    @Column(name = "user_name ", nullable = false)
    private String username;

    @Column(name = "account", nullable = false)
    private String account;

    @Column(name = "profile_photo", nullable = true)
    private String profilePhoto ;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Board> boards = new ArrayList<Board>();


}
