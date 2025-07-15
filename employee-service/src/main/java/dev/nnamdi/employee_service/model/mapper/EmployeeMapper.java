package dev.nnamdi.employee_service.model.mapper;

import dev.nnamdi.employee_service.model.dto.EmployeeDto;
import dev.nnamdi.employee_service.model.entity.Employee;
import org.springframework.beans.BeanUtils;

import java.util.Objects;

public class EmployeeMapper extends BaseMapper<Employee, EmployeeDto> {

    @Override
    public Employee convertToEntity(EmployeeDto dto, Object... args) {

        Employee employee = new Employee();
        if(!Objects.isNull(dto)){
            BeanUtils.copyProperties(dto, employee);
        }
        return employee;
    }

    @Override
    public EmployeeDto convertToDto(Employee entity, Object... args) {

        EmployeeDto transactionDto = new EmployeeDto();
        if(!Objects.isNull(entity)) {
            BeanUtils.copyProperties(entity, transactionDto);
        }
        return transactionDto;
    }
}
