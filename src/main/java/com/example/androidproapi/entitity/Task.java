package com.example.androidproapi.entitity;
import com.example.androidproapi.constants.Category;
import com.example.androidproapi.constants.Progress;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;


@Setter
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity(name = "task")

public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "task_title", nullable = false)
    private String task_title;

    @Column(name = "task_description", nullable = false)
    private String task_description;

    @Column(name = "start_date", nullable = true)
    private Date start_date;

    @Column(name = "due_date", nullable = true)
    private Date due_date;

    @Enumerated(EnumType.STRING)
    private Progress progress;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "board_id")
    private Board board;
}
