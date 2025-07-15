package dev.nnamdi.employee_service.repository;

import dev.nnamdi.employee_service.model.entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DepartmentRepository extends JpaRepository<Department, Long> {
}
