package dev.nnamdi.api_gateway.service;

import dev.nnamdi.api_gateway.external.AuthService;
import dev.nnamdi.api_gateway.external.RegisterDto;
//import dev.nnamdi.auth_service.model.entity.User;
//import dev.nnamdi.auth_service.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class UserInfoConfigManager implements UserDetailsService {
    @Autowired
    private AuthService authService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        ResponseEntity<RegisterDto> registerDto = authService.readUserByUserName(username);
        log.info("User: ", registerDto);

        if (registerDto != null) {
            log.info("Roles: ", registerDto.getBody().getRoles());
            return org.springframework.security.core.userdetails.User.builder()
                    .username(registerDto.getBody().getUsername())
                    .password(registerDto.getBody().getPassword())
                    .roles(String.valueOf(registerDto.getBody().getRoles()))
                    .build();
        }
        throw new UsernameNotFoundException("User not found with username: " + username);
    }
}
