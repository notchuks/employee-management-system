package dev.nnamdi.employee_service.service.implementation;

import dev.nnamdi.employee_service.exception.ResourceNotFound;
import dev.nnamdi.employee_service.model.dto.DepartmentDto;
import dev.nnamdi.employee_service.model.dto.DepartmentUpdate;
import dev.nnamdi.employee_service.model.entity.Department;
import dev.nnamdi.employee_service.model.mapper.DepartmentMapper;
import dev.nnamdi.employee_service.model.response.Response;
import dev.nnamdi.employee_service.repository.DepartmentRepository;
import dev.nnamdi.employee_service.service.DepartmentService;
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
public class DepartmentServiceImpl implements DepartmentService {
    private final DepartmentRepository departmentRepository;

    private final DepartmentMapper departmentMapper =  new DepartmentMapper();

    @Value("${spring.application.ok}")
    private String success;

    /**
     * Creates a new department.
     *
     * @param departmentDto the department information to be created
     * @return the response containing the created department
     */
    @Override
    public Response createDepartment(DepartmentDto departmentDto) {
        Department department = departmentMapper.convertToEntity(departmentDto);
        departmentRepository.save(department);
        return Response.builder()
                .responseCode(success)
                .message(" Department created successfully").build();
    };

    /**
     * Retrieves a list of departments created.
     * @return a list of department requests
     */
    @Override
    public List<DepartmentDto> getDepartments() {
        List<Department> departments = departmentRepository.findAll();

        return departments.stream().map(department -> {
            DepartmentDto departmentDto = departmentMapper.convertToDto(department);
//            departmentDto.setDepartmentId(department.getDepartmentId());
//            departmentDto.setEmail(department.getEmail());
//            departmentDto.setBvn(department.getBvn());
            return departmentDto;
        }).collect(Collectors.toList());
    };

    /**
     * Retrieves a department by its departmentID.
     *
     * @param departmentID The department number to search for.
     * @return The department DTO if found, or null if not found.
     */
    @Override
    public DepartmentDto getDepartment(Long departmentID) {
        return departmentRepository.findById(departmentID)
                .map(department -> departmentMapper.convertToDto(department))
                .orElseThrow(() -> new ResourceNotFound("Department not found on the server"));
    };

    /**
     * Updates the department with the specified department number.
     *
     * @param departmentID The department number of the department to be updated.
     * @param departmentUpdate The department data to update the department with.
     * @return The response indicating the result of the update operation.
     */
    @Override
    public Response updateDepartment(Long departmentID, DepartmentUpdate departmentUpdate) {
        Department department = departmentRepository.findById(departmentID)
                .orElseThrow(() -> new ResourceNotFound("Department not found on the server"));

        BeanUtils.copyProperties(departmentUpdate, department);
        departmentRepository.save(department);

        return Response.builder()
                .responseCode(success)
                .message("department updated successfully").build();
    };

    /**
     * Delete the department with the specified department number.
     *
     * @param departmentID The department number of the department to be closed.
     * @return The response indicating the result of the department closure.
     */
    @Override
    public Response deleteDepartment(Long departmentID) {
        departmentRepository.deleteById(departmentID);
        return Response.builder()
                .responseCode(success)
                .message("department deleted successfully").build();
    };

}
