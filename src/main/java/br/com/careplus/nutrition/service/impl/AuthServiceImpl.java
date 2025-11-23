package br.com.careplus.nutrition.service.impl;

import br.com.careplus.nutrition.domain.entity.User;
import br.com.careplus.nutrition.domain.entity.UserProfile;
import br.com.careplus.nutrition.domain.repository.UserRepository;
import br.com.careplus.nutrition.dto.AuthRequestDTO;
import br.com.careplus.nutrition.dto.AuthResponseDTO;
import br.com.careplus.nutrition.dto.UserDTO;
import br.com.careplus.nutrition.exception.BusinessException;
import br.com.careplus.nutrition.security.JwtTokenProvider;
import br.com.careplus.nutrition.service.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService {

    private final UserRepository userRepository;
    private final JwtTokenProvider jwtTokenProvider;

    private final BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

    @Override
    @Transactional
    public AuthResponseDTO register(UserDTO userDTO) {
        userRepository.findByEmail(userDTO.getEmail())
                .ifPresent(u -> {
                    throw new BusinessException("E-mail já cadastrado");
                });

        User user = new User();
        user.setName(userDTO.getName());
        user.setEmail(userDTO.getEmail());
        user.setPasswordHash(encoder.encode(userDTO.getPassword()));

        UserProfile profile = new UserProfile();
        profile.setUser(user);
        profile.setAge(userDTO.getAge());
        profile.setHeight(userDTO.getHeight());
        profile.setWeight(userDTO.getWeight());
        profile.setPreferences(userDTO.getPreferences());
        profile.setGoals(userDTO.getGoals());

        user.setProfile(profile);

        User saved = userRepository.save(user);

        String token = jwtTokenProvider.generateToken(saved.getId());
        return new AuthResponseDTO(token);
    }

    @Override
    public AuthResponseDTO login(AuthRequestDTO request) {
        User user = userRepository.findByEmail(request.getEmail())
                .orElseThrow(() -> new BusinessException("Credenciais inválidas"));

        if (!encoder.matches(request.getPassword(), user.getPasswordHash())) {
            throw new BusinessException("Credenciais inválidas");
        }

        String token = jwtTokenProvider.generateToken(user.getId());
        return new AuthResponseDTO(token);
    }
}