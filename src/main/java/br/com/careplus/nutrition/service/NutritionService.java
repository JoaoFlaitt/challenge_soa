package br.com.careplus.nutrition.service;

import br.com.careplus.nutrition.dto.MealRequestDTO;
import br.com.careplus.nutrition.dto.MealResponseDTO;

import java.util.List;
import java.util.UUID;

public interface NutritionService {

    MealResponseDTO createMeal(UUID userId, MealRequestDTO dto);

    List<MealResponseDTO> listMeals(UUID userId);
}