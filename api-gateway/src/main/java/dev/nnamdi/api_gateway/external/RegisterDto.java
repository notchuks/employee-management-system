package dev.nnamdi.api_gateway.external;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class RegisterDto {
    @NotBlank(message = "firstName is required")
    @Size(min = 3, max = 20, message = "firstName must be between 3 and 20 characters")
    private String firstName;

    @NotBlank(message = "lastName is required")
    @Size(min = 3, max = 20, message = "lastName must be between 3 and 20 characters")
    private String lastName;

    @NotBlank(message = "Email is required")
    @Email(message = "Email should be valid")
    private String email;

    @NotBlank(message = "Username is required")
    @Size(min = 3, max = 20, message = "Username must be between 3 and 20 characters")
    private String username;

    @NotBlank(message = "Password is required")
    @Size(min = 8, message = "Password must be at least 8 characters")
    private String password;

    private String gender;

    private String status;

    private List<String> roles;

}
