package com.example.curdapi.service;

import com.example.curdapi.dto.EmpDto;
import com.example.curdapi.entity.Employee;

import java.util.List;

public abstract class EmpService {
    public abstract EmpDto createEmp(EmpDto empDto);

    public abstract EmpDto updateEmp(EmpDto empDto);

    public abstract EmpDto deleteEmp(EmpDto empDto);

    public abstract List<Employee> getAllEmps();
}

