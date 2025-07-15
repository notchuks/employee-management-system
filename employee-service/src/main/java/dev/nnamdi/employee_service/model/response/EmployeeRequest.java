package dev.nnamdi.employee_service.model.response;

import dev.nnamdi.employee_service.model.entity.Department;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class EmployeeRequest {
    private String firstName;

    private String lastName;

    private String email;

    private String gender;

    private String status;

    private Long departmentId;

    private List<String> roles;

//    private LocalDateTime createdAt;
//
//    private LocalDateTime updatedAt;
}
