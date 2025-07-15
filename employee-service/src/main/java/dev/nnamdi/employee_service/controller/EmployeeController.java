package dev.nnamdi.employee_service.controller;

import dev.nnamdi.employee_service.model.dto.EmployeeDto;
import dev.nnamdi.employee_service.model.dto.EmployeeUpdate;
import dev.nnamdi.employee_service.model.response.EmployeeRequest;
import dev.nnamdi.employee_service.model.response.Response;
import dev.nnamdi.employee_service.service.EmployeeService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping("/api/employees")
public class EmployeeController {

    private final EmployeeService employeeService;

    /**
     * Create an employee using the provided employeeDto
     *
     * @param employeeRequest The employee details
     * @return The response entity with the created employee and HTTP status code
     */
    @PostMapping
    public ResponseEntity<Response> createAccount(@RequestBody EmployeeRequest employeeRequest) {
        return new ResponseEntity<>(employeeService.createEmployee(employeeRequest), HttpStatus.CREATED);
    }

    /**
     * Retrieves a list of employees for a given employee ID.
     * @return The list of transactions
     */
    @GetMapping
    public ResponseEntity<List<EmployeeDto>> getEmployees() {
        return new ResponseEntity<>(employeeService.getEmployees(), HttpStatus.OK);
    }

    @GetMapping("/hello")
    public ResponseEntity<String> hello() {
        return new ResponseEntity<>("Go on. I am working.", HttpStatus.OK);
    }

    /**
     * Retrieves an employee by their ID.
     *
     * @param id The authentication ID of the employee.
     * @return The response entity containing the employee DTO.
     */
    @GetMapping("/{id}")
    public EmployeeDto getEmployee(@PathVariable Long id) {
        log.info("reading employee by their id: " + id);
        return employeeService.getEmployeeById(id);
    }

    /**
     * Updates a employee.
     *
     * @param id The ID of the employee to update.
     * @param employeeUpdate The updated status of the employee.
     * @return The response entity containing the updated employee and HTTP status.
     */
    @PutMapping("/{id}")
    public ResponseEntity<Response> updateEmployee(@PathVariable Long id, @RequestBody EmployeeUpdate employeeUpdate) {
        log.info("updating the employee with: {}", employeeUpdate.toString());
        return new ResponseEntity<>(employeeService.updateEmployee(id, employeeUpdate), HttpStatus.OK);
    }

    /**
     * Deletes a employee.
     *
     * @param id The id of the employee to be deleted.
     * @return The response entity with the result of closing the employee.
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<Response> deleteEmployee(@PathVariable Long id) {
        return ResponseEntity.ok(employeeService.deleteEmployee(id));
    }
}
