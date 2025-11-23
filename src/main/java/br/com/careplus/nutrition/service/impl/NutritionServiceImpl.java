package br.com.careplus.nutrition.service.impl;

import br.com.careplus.nutrition.domain.entity.Meal;
import br.com.careplus.nutrition.domain.entity.MealItem;
import br.com.careplus.nutrition.domain.entity.User;
import br.com.careplus.nutrition.domain.repository.MealRepository;
import br.com.careplus.nutrition.domain.repository.UserRepository;
import br.com.careplus.nutrition.dto.MealRequestDTO;
import br.com.careplus.nutrition.dto.MealResponseDTO;
import br.com.careplus.nutrition.exception.BusinessException;
import br.com.careplus.nutrition.service.NutritionService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class NutritionServiceImpl implements NutritionService {

    private final MealRepository mealRepository;
    private final UserRepository userRepository;

    @Override
    @Transactional
    public MealResponseDTO createMeal(UUID userId, MealRequestDTO dto) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new BusinessException("Usuário não encontrado"));

        Meal meal = new Meal();
        meal.setUser(user);
        meal.setType(dto.getType());
        meal.setDateTime(dto.getDateTime());

        List<MealItem> items = dto.getItems().stream().map(i -> {
            MealItem item = new MealItem();
            item.setMeal(meal);
            item.setFoodId(i.getFoodId());
            item.setFoodName(i.getFoodName());
            item.setUnit(i.getUnit());
            item.setQuantity(i.getQuantity());
            // regra simples: 50 kcal por unidade/porção, só pra exemplo
            item.setCalories(50);
            return item;
        }).toList();

        meal.setItems(items);

        // Score simples: número de itens * 10 até no máximo 100
        int score = Math.min(100, items.size() * 10);
        meal.setWellnessScore(score);

        Meal saved = mealRepository.save(meal);
        return new MealResponseDTO(saved);
    }

    @Override
    public List<MealResponseDTO> listMeals(UUID userId) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new BusinessException("Usuário não encontrado"));

        return mealRepository.findByUser(user).stream()
                .map(MealResponseDTO::new)
                .toList();
    }
}