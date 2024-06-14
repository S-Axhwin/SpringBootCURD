package com.example.curdapi.impl;

import com.example.curdapi.dto.EmpDto;
import com.example.curdapi.entity.Employee;
import com.example.curdapi.mapper.EmpMapper;
import com.example.curdapi.repository.EmployeeRepo;
import com.example.curdapi.service.EmpService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class EmpServiceImpl extends EmpService {

    private EmployeeRepo employeeRepo;

    @Override
    public EmpDto createEmp(EmpDto empDto) {
        Employee employee = EmpMapper.mapToEmp(empDto);
        Employee savedEmpDto = employeeRepo.save(employee);
        return EmpMapper.mapToEmpDto(savedEmpDto);
    }

    @Override
    public EmpDto updateEmp(EmpDto empDto) {
        Employee employee = employeeRepo.findByEmail(empDto.getEmail());
        EmpDto empDtoUpdated = new EmpDto(
                empDto.getEmail(),
                empDto.getFirstname(),
                empDto.getLastname()
        );
        employeeRepo.delete(employee);
        Employee employeeObj = EmpMapper.mapToEmp(empDtoUpdated);
        Employee employeeUpdated  = employeeRepo.save(employeeObj);
        return EmpMapper.mapToEmpDto(employeeRepo.save(employeeUpdated));
    }
}

