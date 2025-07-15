package dev.nnamdi.auth_service.model.mapper;

import dev.nnamdi.auth_service.model.dto.RegisterDto;
import dev.nnamdi.auth_service.model.dto.UserDto;
import dev.nnamdi.auth_service.model.entity.User;
import org.springframework.beans.BeanUtils;

import java.util.Objects;

public class UserMapper extends BaseMapper<User, RegisterDto> {

    @Override
    public User convertToEntity(RegisterDto dto, Object... args) {

        User employee = new User();
        if(!Objects.isNull(dto)){
            BeanUtils.copyProperties(dto, employee);
        }
        return employee;
    }

    @Override
    public RegisterDto convertToDto(User entity, Object... args) {

        RegisterDto transactionDto = new RegisterDto();
        if(!Objects.isNull(entity)) {
            BeanUtils.copyProperties(entity, transactionDto);
        }
        return transactionDto;
    }
}
