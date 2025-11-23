package br.com.careplus.nutrition.controller;

import br.com.careplus.nutrition.dto.FatSecretFoodDTO;
import br.com.careplus.nutrition.dto.MealRequestDTO;
import br.com.careplus.nutrition.dto.MealResponseDTO;
import br.com.careplus.nutrition.service.FatSecretService;
import br.com.careplus.nutrition.service.NutritionService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/nutrition")
@RequiredArgsConstructor
public class NutritionController {

    private final NutritionService nutritionService;
    private final FatSecretService fatSecretService;

    @PostMapping("/meals")
    public ResponseEntity<MealResponseDTO> createMeal(@RequestBody MealRequestDTO dto,
                                                      Principal principal) {
        UUID userId = UUID.fromString(principal.getName());
        return ResponseEntity.ok(nutritionService.createMeal(userId, dto));
    }

    @GetMapping("/meals")
    public ResponseEntity<List<MealResponseDTO>> listMeals(Principal principal) {
        UUID userId = UUID.fromString(principal.getName());
        return ResponseEntity.ok(nutritionService.listMeals(userId));
    }

    @GetMapping("/foods/search")
    public ResponseEntity<List<FatSecretFoodDTO>> searchFoods(@RequestParam String query) {
        return ResponseEntity.ok(fatSecretService.searchFoods(query));
    }
}