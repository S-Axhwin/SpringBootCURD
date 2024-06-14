package com.example.curdapi.impl;

import com.example.curdapi.dto.EmpDto;
import com.example.curdapi.entity.Employee;
import com.example.curdapi.mapper.EmpMapper;
import com.example.curdapi.repository.EmployeeRepo;
import com.example.curdapi.service.EmpService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

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
        employee.setLastName(empDto.getLastname());
        employee.setFirstName(empDto.getFirstname());
        employeeRepo.save(employee);
        return EmpMapper.mapToEmpDto(employeeRepo.save(employee));
    }

    @Override
    public EmpDto deleteEmp (EmpDto empDto) {
        Employee employee = employeeRepo.findByEmail(empDto.getEmail());
        try{
            employeeRepo.delete(employee);
            return EmpMapper.mapToEmpDto(employee);
        } catch (Exception e){
            return EmpMapper.mapToEmpDto(null);
        }

    }

    public List<Employee> getAllEmps() {
        return employeeRepo.findAll();
    }
}

