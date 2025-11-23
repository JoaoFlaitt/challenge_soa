package br.com.careplus.nutrition.service;

import br.com.careplus.nutrition.dto.UserDTO;

import java.util.UUID;

public interface UserService {

    UserDTO getProfile(UUID userId);

    UserDTO updateProfile(UUID userId, UserDTO dto);
}