package br.com.careplus.nutrition.service;

import br.com.careplus.nutrition.dto.AuthRequestDTO;
import br.com.careplus.nutrition.dto.AuthResponseDTO;
import br.com.careplus.nutrition.dto.UserDTO;

public interface AuthService {

    AuthResponseDTO register(UserDTO userDTO);

    AuthResponseDTO login(AuthRequestDTO request);
}