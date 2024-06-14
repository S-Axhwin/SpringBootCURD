package com.example.curdapi.service;

import com.example.curdapi.dto.EmpDto;

public abstract class EmpService {
    public abstract EmpDto createEmp(EmpDto empDto);

    public abstract EmpDto updateEmp(EmpDto empDto);

}
