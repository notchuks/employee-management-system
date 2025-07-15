package dev.nnamdi.employee_service.service;

import dev.nnamdi.employee_service.model.dto.EmployeeDto;
import dev.nnamdi.employee_service.model.dto.EmployeeUpdate;
import dev.nnamdi.employee_service.model.response.EmployeeRequest;
import dev.nnamdi.employee_service.model.response.Response;

import java.util.List;

public interface EmployeeService {
    /**
     * Creates a new employee.
     *
     * @param employeeRequest the employee information to be created
     * @return the response containing the created employee
     */
    Response createEmployee(EmployeeRequest employeeRequest);

    /**
     * Retrieves a list of employees created.
     * @return a list of employee requests
     */
    List<EmployeeDto> getEmployees();

    /**
     * Retrieves an employee by its employeeID.
     *
     * @param employeeID The employee number to search for.
     * @return The employee DTO if found, or null if not found.
     */
    EmployeeDto getEmployeeById(Long employeeID);

    /**
     * Updates the employee with the specified employee number.
     *
     * @param employeeID The employee number of the employee to be updated.
     * @param employeeUpdate The employee data to update the employee with.
     * @return The response indicating the result of the update operation.
     */
    Response updateEmployee(Long employeeID, EmployeeUpdate employeeUpdate);

    /**
     * Delete the employee with the specified employee number.
     *
     * @param employeeID The employee number of the employee to be closed.
     * @return The response indicating the result of the employee closure.
     */
    Response deleteEmployee(Long employeeID);
}
