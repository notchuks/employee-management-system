package dev.nnamdi.employee_service.service.implementation;

import dev.nnamdi.employee_service.exception.ResourceNotFound;
import dev.nnamdi.employee_service.model.dto.DepartmentDto;
import dev.nnamdi.employee_service.model.dto.EmployeeDto;
import dev.nnamdi.employee_service.model.dto.EmployeeUpdate;
import dev.nnamdi.employee_service.model.entity.Department;
import dev.nnamdi.employee_service.model.entity.Employee;
import dev.nnamdi.employee_service.model.mapper.DepartmentMapper;
import dev.nnamdi.employee_service.model.mapper.EmployeeMapper;
import dev.nnamdi.employee_service.model.response.EmployeeRequest;
import dev.nnamdi.employee_service.model.response.Response;
import dev.nnamdi.employee_service.repository.EmployeeRepository;
import dev.nnamdi.employee_service.service.DepartmentService;
import dev.nnamdi.employee_service.service.EmployeeService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Service
@RequiredArgsConstructor
@Transactional
public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeRepository employeeRepository;

    private final DepartmentService departmentService;

    private final DepartmentMapper departmentMapper =  new DepartmentMapper();

    private final EmployeeMapper employeeMapper = new EmployeeMapper();

    @Value("${spring.application.ok}")
    private String success;

    /**
     * Creates a new employee.
     *
     * @param employeeRequest the employee information to be created
     * @return the response containing the created employee
     */
    @Override
    public Response createEmployee(EmployeeRequest employeeRequest) {
        // Employee employee = employeeMapper.convertToEntity(employeeDto);
        DepartmentDto deptDto = departmentService.getDepartment(employeeRequest.getDepartmentId());
        Department dept = departmentMapper.convertToEntity(deptDto);
        Employee employee = Employee.builder()
                        .firstName(employeeRequest.getFirstName())
                .lastName(employeeRequest.getLastName())
                .email(employeeRequest.getEmail())
                .status(employeeRequest.getStatus())
                .gender(employeeRequest.getGender())
                .roles(employeeRequest.getRoles())
                .department(dept)
                .build();
        employeeRepository.save(employee);
        return Response.builder()
                .responseCode(success)
                .message(" Employee created successfully").build();
    };

    /**
     * Retrieves a list of employees created.
     * @return a list of employee requests
     */
    @Override
    public List<EmployeeDto> getEmployees() {
        List<Employee> employees = employeeRepository.findAll();

        return employees.stream().map(employee -> {
            EmployeeDto employeeDto = employeeMapper.convertToDto(employee);
//            employeeDto.setEmployeeId(employee.getEmployeeId());
//            employeeDto.setEmail(employee.getEmail());
//            employeeDto.setBvn(employee.getBvn());
            return employeeDto;
        }).collect(Collectors.toList());
    };

    /**
     * Retrieves an employee by its employeeID.
     *
     * @param employeeID The employee number to search for.
     * @return The employee DTO if found, or null if not found.
     */
    @Override
    public EmployeeDto getEmployeeById(Long employeeID) {
        return employeeRepository.findById(employeeID)
                .map(employee -> employeeMapper.convertToDto(employee))
                .orElseThrow(() -> new ResourceNotFound("Employee not found on the server"));
    };

    /**
     * Updates the employee with the specified employee number.
     *
     * @param employeeID The employee number of the employee to be updated.
     * @param employeeUpdate The employee data to update the employee with.
     * @return The response indicating the result of the update operation.
     */
    @Override
    public Response updateEmployee(Long employeeID, EmployeeUpdate employeeUpdate) {
        Employee employee = employeeRepository.findById(employeeID)
                .orElseThrow(() -> new ResourceNotFound("Employee not found on the server"));

        BeanUtils.copyProperties(employeeUpdate, employee);
        employeeRepository.save(employee);

        return Response.builder()
                .responseCode(success)
                .message("employee updated successfully").build();
    };

    /**
     * Delete the employee with the specified employee number.
     *
     * @param employeeID The employee number of the employee to be closed.
     * @return The response indicating the result of the employee closure.
     */
    @Override
    public Response deleteEmployee(Long employeeID) {
        employeeRepository.deleteById(employeeID);
        return Response.builder()
                .responseCode(success)
                .message("employee deleted successfully").build();
    };
}
