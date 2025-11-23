package br.com.careplus.nutrition.service;

import br.com.careplus.nutrition.dto.FatSecretFoodDTO;

import java.util.List;

public interface FatSecretService {

    List<FatSecretFoodDTO> searchFoods(String query);
}