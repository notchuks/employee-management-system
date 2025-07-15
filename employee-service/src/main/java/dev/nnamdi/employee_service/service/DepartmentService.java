package dev.nnamdi.employee_service.service;

import dev.nnamdi.employee_service.model.dto.DepartmentDto;
import dev.nnamdi.employee_service.model.dto.DepartmentUpdate;
import dev.nnamdi.employee_service.model.response.DepartmentRequest;
import dev.nnamdi.employee_service.model.response.Response;

import java.util.List;

public interface DepartmentService {

    /**
     * Creates a new department.
     *
     * @param departmentDto the department information to be created
     * @return the response containing the created department
     */
    Response createDepartment(DepartmentDto departmentDto);

    /**
     * Retrieves a list of departments created.
     * @return a list of department requests
     */
    List<DepartmentDto> getDepartments();

    /**
     * Retrieves a department by its departmentID.
     *
     * @param departmentID The department number to search for.
     * @return The department DTO if found, or null if not found.
     */
    DepartmentDto getDepartment(Long departmentID);

    /**
     * Updates the department with the specified department number.
     *
     * @param departmentID The department number of the department to be updated.
     * @param departmentUpdate The department data to update the department with.
     * @return The response indicating the result of the update operation.
     */
    Response updateDepartment(Long departmentID, DepartmentUpdate departmentUpdate);

    /**
     * Delete the department with the specified department number.
     *
     * @param departmentID The department number of the department to be closed.
     * @return The response indicating the result of the department closure.
     */
    Response deleteDepartment(Long departmentID);
}
