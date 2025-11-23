package br.com.careplus.nutrition.domain.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "meals")
@Data
@NoArgsConstructor
public class Meal {

    @Id
    @GeneratedValue
    private UUID id;

    private LocalDateTime dateTime;

    private String type;

    private Integer wellnessScore;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @OneToMany(mappedBy = "meal", cascade = CascadeType.ALL)
    private List<MealItem> items;
}