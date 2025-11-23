package br.com.careplus.nutrition.service.impl;

import br.com.careplus.nutrition.config.FatSecretProperties;
import br.com.careplus.nutrition.dto.FatSecretFoodDTO;
import br.com.careplus.nutrition.service.FatSecretService;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.Collections;
import java.util.List;

@Service
@RequiredArgsConstructor
public class FatSecretServiceImpl implements FatSecretService {

    private final WebClient fatSecretWebClient;
    private final FatSecretProperties properties;

    private String getAccessToken() {
        String basicAuth = properties.getClientId() + ":" + properties.getClientSecret();
        String encoded = java.util.Base64.getEncoder().encodeToString(basicAuth.getBytes());

        TokenResponse response = fatSecretWebClient.post()
                .uri("/connect/token")
                .contentType(MediaType.APPLICATION_FORM_URLENCODED)
                .header("Authorization", "Basic " + encoded)
                .bodyValue("grant_type=client_credentials&scope=basic")
                .retrieve()
                .bodyToMono(TokenResponse.class)
                .block();

        if (response == null) {
            throw new RuntimeException("Não foi possível obter token do FatSecret");
        }

        return response.getAccess_token();
    }

    @Override
    public List<FatSecretFoodDTO> searchFoods(String query) {
        String token = getAccessToken();

        FoodSearchResponse response = fatSecretWebClient.get()
                .uri(uriBuilder -> uriBuilder
                        .path("/rest/foods/search/v3")
                        .queryParam("search_expression", query)
                        .build())
                .accept(MediaType.APPLICATION_JSON)
                .header("Authorization", "Bearer " + token)
                .retrieve()
                .bodyToMono(FoodSearchResponse.class)
                .block();

        if (response == null || response.getFoods() == null) {
            return Collections.emptyList();
        }

        return response.getFoods().stream().map(f -> {
            FatSecretFoodDTO dto = new FatSecretFoodDTO();
            dto.setId(f.getFood_id());
            dto.setName(f.getFood_name());
            dto.setDescription(f.getFood_description());
            return dto;
        }).toList();
    }

    @Data
    private static class TokenResponse {
        private String access_token;
        private String token_type;
        private Long expires_in;
    }

    @Data
    private static class FoodSearchResponse {
        private List<Food> foods;
    }

    @Data
    private static class Food {
        private String food_id;
        private String food_name;
        private String food_description;
    }
}