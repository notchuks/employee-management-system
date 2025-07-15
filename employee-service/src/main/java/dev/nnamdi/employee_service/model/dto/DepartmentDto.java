package dev.nnamdi.employee_service.model.dto;

import dev.nnamdi.employee_service.model.entity.Employee;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class DepartmentDto {
    private Long departmentID;

    private String short_Name;

    private String department_Name;

    private Set<Employee> employees;
}
