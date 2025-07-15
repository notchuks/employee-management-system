package dev.nnamdi.employee_service.model.response;

import dev.nnamdi.employee_service.model.entity.Employee;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.Instant;
import java.time.LocalDateTime;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class DepartmentRequest {
    private String short_Name;

    private String department_Name;

    private Set<Employee> employees;

    private Instant createdAt;

    private Instant updatedAt;
}
