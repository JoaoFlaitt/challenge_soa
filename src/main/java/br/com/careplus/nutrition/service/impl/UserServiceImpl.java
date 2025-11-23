package br.com.careplus.nutrition.service.impl;

import br.com.careplus.nutrition.domain.entity.User;
import br.com.careplus.nutrition.domain.entity.UserProfile;
import br.com.careplus.nutrition.domain.repository.UserProfileRepository;
import br.com.careplus.nutrition.domain.repository.UserRepository;
import br.com.careplus.nutrition.dto.UserDTO;
import br.com.careplus.nutrition.exception.BusinessException;
import br.com.careplus.nutrition.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final UserProfileRepository userProfileRepository;

    @Override
    public UserDTO getProfile(UUID userId) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new BusinessException("Usuário não encontrado"));

        UserProfile profile = user.getProfile();
        UserDTO dto = new UserDTO();
        dto.setName(user.getName());
        dto.setEmail(user.getEmail());

        if (profile != null) {
            dto.setAge(profile.getAge());
            dto.setHeight(profile.getHeight());
            dto.setWeight(profile.getWeight());
            dto.setPreferences(profile.getPreferences());
            dto.setGoals(profile.getGoals());
        }

        return dto;
    }

    @Override
    @Transactional
    public UserDTO updateProfile(UUID userId, UserDTO dto) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new BusinessException("Usuário não encontrado"));

        user.setName(dto.getName());
        user.setEmail(dto.getEmail());

        UserProfile profile = user.getProfile();
        if (profile == null) {
            profile = new UserProfile();
            profile.setUser(user);
        }
        profile.setAge(dto.getAge());
        profile.setHeight(dto.getHeight());
        profile.setWeight(dto.getWeight());
        profile.setPreferences(dto.getPreferences());
        profile.setGoals(dto.getGoals());

        user.setProfile(profile);

        userRepository.save(user);
        userProfileRepository.save(profile);

        return getProfile(userId);
    }
}