package dev.nnamdi.auth_service.model.dto;

import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserDto {
    private String firstName;

    private String lastName;

    private String email;

    private String username;

    private String password;

    private String gender;

    private List<String> roles;

    private String status;
}
