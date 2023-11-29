package com.example.androidproapi.entitity;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.MapsId;
import jakarta.persistence.OneToOne;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Setter
@Getter
@Entity(name = "user")
public class User {
    @Id
    @Column(name ="id")
    private Long id;

    @Column(name = "user_name ", nullable = false)
    private String user_name;

    @Column(name = "account", nullable = false)
    private String account;

    @Column(name = "profile_photo", nullable = true)
    private String profile_photo ;

    @OneToOne(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
    private Boards boards;

}
