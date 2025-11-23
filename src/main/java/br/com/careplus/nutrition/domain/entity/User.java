package br.com.careplus.nutrition.domain.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Entity
@Table(name = "users")
@Data
@NoArgsConstructor
public class User {

    @Id
    @GeneratedValue
    private UUID id;

    private String name;

    @Column(unique = true)
    private String email;

    private String passwordHash;

    @OneToOne(mappedBy = "user", cascade = CascadeType.ALL)
    private UserProfile profile;
}