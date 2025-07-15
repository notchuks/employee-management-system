package dev.nnamdi.employee_service.controller;

import dev.nnamdi.employee_service.model.dto.DepartmentDto;
import dev.nnamdi.employee_service.model.dto.DepartmentUpdate;
import dev.nnamdi.employee_service.model.response.Response;
import dev.nnamdi.employee_service.service.DepartmentService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping("/api/departments")
public class DepartmentController {

    private final DepartmentService departmentService;

    /**
     * Create a department using the provided departmentDto
     *
     * @param departmentDto The department details
     * @return The response entity with the created department and HTTP status code
     */
    @PostMapping
    public ResponseEntity<Response> createAccount(@RequestBody DepartmentDto departmentDto) {
        return new ResponseEntity<>(departmentService.createDepartment(departmentDto), HttpStatus.CREATED);
    }

    /**
     * Retrieves a list of departments for a given department ID.
     * @return The list of transactions
     */
    @GetMapping
    public ResponseEntity<List<DepartmentDto>> getDepartments() {
        return new ResponseEntity<>(departmentService.getDepartments(), HttpStatus.OK);
    }

    /**
     * Retrieves a department by their ID.
     *
     * @param id The authentication ID of the department.
     * @return The response entity containing the department DTO.
     */
    @GetMapping("/{id}")
    public DepartmentDto getDepartment(@RequestBody Long id) {
        log.info("reading department by their id");
        return departmentService.getDepartment(id);
    }

    /**
     * Updates a department.
     *
     * @param id The ID of the department to update.
     * @param departmentUpdate The updated status of the department.
     * @return The response entity containing the updated department and HTTP status.
     */
    @PutMapping("/{id}")
    public ResponseEntity<Response> updateDepartment(@PathVariable Long id, @RequestBody DepartmentUpdate departmentUpdate) {
        log.info("updating the department with: {}", departmentUpdate.toString());
        return new ResponseEntity<>(departmentService.updateDepartment(id, departmentUpdate), HttpStatus.OK);
    }

    /**
     * Deletes a department.
     *
     * @param id The Id of the department to be deleted.
     * @return The response entity with the result of closing the department.
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<Response> deleteDepartment(@PathVariable Long id) {
        return ResponseEntity.ok(departmentService.deleteDepartment(id));
    }
}
