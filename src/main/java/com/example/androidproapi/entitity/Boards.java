package com.example.androidproapi.entitity;
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
@NoArgsConstructor(access = AccessLevel.PROTECTED)

@Entity(name = "Boards")
public class Boards {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", referencedColumnName = "member_id", insertable = false, updatable = false)
    private User user;

    @OneToMany(mappedBy = "Boards", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Board> boards = new ArrayList<Board>();

}