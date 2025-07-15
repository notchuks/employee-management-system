package dev.nnamdi.auth_service.service;

import dev.nnamdi.auth_service.model.dto.RegisterDto;
import dev.nnamdi.auth_service.model.response.RegisterResponse;
import dev.nnamdi.auth_service.model.response.Response;

public interface UserService {
    Response register(RegisterDto registerDto);
}
