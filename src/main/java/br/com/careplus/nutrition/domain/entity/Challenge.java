package br.com.careplus.nutrition.domain.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "challenges")
@Data
@NoArgsConstructor
public class Challenge {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;
    private String description;
    private Integer durationDays;
    private Integer pointsReward;
    private String type;
}