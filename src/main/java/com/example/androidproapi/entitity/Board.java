package com.example.androidproapi.entitity;
import com.example.androidproapi.constants.Category;
import com.example.androidproapi.entitity.User;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Setter
@Getter
@NoArgsConstructor
@Entity(name = "board")

public class Board {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "board_name", nullable = false)
    private String board_name;

    @Enumerated(EnumType.STRING)
    @Column(name = "category", nullable = false, columnDefinition = "varchar(20) default 'DO'")
    private Category category = Category.DO;

    @Column(name = "description")
    private String description;

    @Column(name = "content")
    private String content;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", referencedColumnName = "id", insertable = false, updatable = false)
    private User user;


    @OneToMany(mappedBy = "board", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Task> tasks = new ArrayList<Task>();
}
