package br.com.careplus.nutrition.domain.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "user_profiles")
@Data
@NoArgsConstructor
public class UserProfile {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Integer age;
    private Double height;
    private Double weight;

    private String preferences;
    private String goals;

    @OneToOne
    @JoinColumn(name = "user_id")
    private User user;
}