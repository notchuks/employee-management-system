package dev.nnamdi.employee_service.model.mapper;

import dev.nnamdi.employee_service.model.dto.DepartmentDto;
import dev.nnamdi.employee_service.model.entity.Department;
import org.springframework.beans.BeanUtils;

import java.util.Objects;

public class DepartmentMapper extends BaseMapper<Department, DepartmentDto> {

    @Override
    public Department convertToEntity(DepartmentDto dto, Object... args) {

        Department employee = new Department();
        if(!Objects.isNull(dto)){
            BeanUtils.copyProperties(dto, employee);
        }
        return employee;
    }

    @Override
    public DepartmentDto convertToDto(Department entity, Object... args) {

        DepartmentDto transactionDto = new DepartmentDto();
        if(!Objects.isNull(entity)) {
            BeanUtils.copyProperties(entity, transactionDto);
        }
        return transactionDto;
    }
}