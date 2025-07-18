package dev.nnamdi.api_gateway.external;

import dev.nnamdi.api_gateway.config.FeignConfiguration;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "AUTH-SERVICE", configuration = FeignConfiguration.class)
public interface AuthService {

    /**
     * Retrieves a user by their Username.
     *
     * @param username the Username of the user to retrieve
     * @return a ResponseEntity containing the user DTO if found, or an empty body with a not found status code
     */
    @GetMapping("/api/auth/users/{username}")
    ResponseEntity<RegisterDto> readUserByUserName(@PathVariable String username);
}