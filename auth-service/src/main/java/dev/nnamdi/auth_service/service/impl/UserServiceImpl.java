package dev.nnamdi.auth_service.service.impl;

import dev.nnamdi.auth_service.model.dto.RegisterDto;
import dev.nnamdi.auth_service.model.entity.User;
import dev.nnamdi.auth_service.model.mapper.UserMapper;
import dev.nnamdi.auth_service.model.response.RegisterResponse;
import dev.nnamdi.auth_service.model.response.Response;
import dev.nnamdi.auth_service.repository.UserRepository;
import dev.nnamdi.auth_service.service.UserService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
@Transactional
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;

    private final UserMapper userMapper = new UserMapper();

    @Value("${spring.application.ok}")
    private String success;

    private static final PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    @Override
    public Response register(RegisterDto registerDto) {
        User user = userMapper.convertToEntity(registerDto);
        user.setPassword(passwordEncoder.encode(registerDto.getPassword()));
        user.setRoles(Arrays.asList("USER"));
        User save = userRepository.save(user);
        return Response.builder()
                .responseCode(success)
                .message(" User created successfully").build();
    }

    // using RegisterDto here cause of the name. It is the same as UserDto
    @Override
    public RegisterDto findUserByUsername(String username) {
        User user = userRepository.findByUsername(username);
        return userMapper.convertToDto(user);
    }
}
