package br.com.careplus.nutrition.domain.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "meal_items")
@Data
@NoArgsConstructor
public class MealItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String foodId;
    private String foodName;
    private Double quantity;
    private String unit;

    private Integer calories;

    @ManyToOne
    @JoinColumn(name = "meal_id")
    private Meal meal;
}