package br.com.careplus.nutrition.dto;

import java.time.LocalDateTime;
import java.util.List;

public class MealRequestDTO {

    private LocalDateTime dateTime;
    private String type;
    private List<MealItemDTO> items;

    public MealRequestDTO() {
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public void setDateTime(LocalDateTime dateTime) {
        this.dateTime = dateTime;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public List<MealItemDTO> getItems() {
        return items;
    }

    public void setItems(List<MealItemDTO> items) {
        this.items = items;
    }
}