package com.example.curdapi.mapper;

import com.example.curdapi.dto.EmpDto;
import com.example.curdapi.entity.Employee;

public class EmpMapper {

        public static EmpDto mapToEmpDto( Employee emp ) {
            return new EmpDto(
                    emp.getId(),
                    emp.getFirstName(),
                    emp.getLastName(),
                    emp.getEmail()
            );
        }

    public static Employee mapToEmp( EmpDto empDto ) {
        return new Employee(
                empDto.getId(),
                empDto.getFirstname(),
                empDto.getLastname(),
                empDto.getEmail()
        );
    }
}
