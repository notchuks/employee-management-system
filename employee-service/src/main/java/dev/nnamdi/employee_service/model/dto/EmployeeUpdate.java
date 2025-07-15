package dev.nnamdi.employee_service.model.dto;

import dev.nnamdi.employee_service.model.entity.Department;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeUpdate {
    private String firstName;

    private String lastName;

    private String email;

    private String gender;

    private String status;

    private Long departmentId;

    private List<String> roles;
}
