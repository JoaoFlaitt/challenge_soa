package br.com.careplus.nutrition.dto;

import br.com.careplus.nutrition.domain.entity.Meal;

import java.util.List;
import java.util.stream.Collectors;

public class MealResponseDTO {

    private String id;
    private String type;
    private String dateTime;
    private Integer wellnessScore;
    private List<MealItemDTO> items;

    public MealResponseDTO() {
    }

    public MealResponseDTO(Meal meal) {
        this.id = meal.getId().toString();
        this.type = meal.getType();
        this.dateTime = meal.getDateTime().toString();
        this.wellnessScore = meal.getWellnessScore();
        this.items = meal.getItems().stream().map(i -> {
            MealItemDTO dto = new MealItemDTO();
            dto.setFoodId(i.getFoodId());
            dto.setFoodName(i.getFoodName());
            dto.setUnit(i.getUnit());
            dto.setQuantity(i.getQuantity());
            return dto;
        }).collect(Collectors.toList());
    }

    public String getId() {
        return id;
    }

    public String getType() {
        return type;
    }

    public String getDateTime() {
        return dateTime;
    }

    public Integer getWellnessScore() {
        return wellnessScore;
    }

    public List<MealItemDTO> getItems() {
        return items;
    }
}