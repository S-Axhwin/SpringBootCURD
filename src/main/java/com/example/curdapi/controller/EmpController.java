package com.example.curdapi.controller;
import com.example.curdapi.dto.EmpDto;
import com.example.curdapi.service.EmpService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/emp")
@AllArgsConstructor
public class EmpController {

    private final EmpService empService;

    //Build add emp rest api
    @PostMapping("add")
    public ResponseEntity<EmpDto> createEmp(@RequestBody EmpDto empDto) {
        EmpDto savedEmp = empService.createEmp(empDto);
        return new ResponseEntity<>(savedEmp, HttpStatus.CREATED);
    }

    @PostMapping("update")
    public ResponseEntity<EmpDto> updateEmp(@RequestBody EmpDto empDto) {
        EmpDto savedEmp = empService.updateEmp(empDto);
        return new ResponseEntity<>(savedEmp, HttpStatus.CREATED);
    }
}
