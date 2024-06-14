package com.example.curdapi.controller;
import com.example.curdapi.dto.EmpDto;
import com.example.curdapi.entity.Employee;
import com.example.curdapi.impl.EmpServiceImpl;
import com.example.curdapi.service.EmpService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/emp")
@AllArgsConstructor
@CrossOrigin(origins = "http://localhost:5173")
public class EmpController {

    private final EmpService empService;
    private final EmpServiceImpl empServiceImpl;

    //Build add emp rest api
    @PostMapping("add")
    public ResponseEntity<EmpDto> createEmp(@RequestBody EmpDto empDto) {
        try{
            EmpDto savedEmp = empService.createEmp(empDto);
            return new ResponseEntity<>(savedEmp, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("update")
    public ResponseEntity<EmpDto> updateEmp(@RequestBody EmpDto empDto) {
        try{
            EmpDto savedEmp = empService.updateEmp(empDto);
            return new ResponseEntity<>(savedEmp, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

    @DeleteMapping("delete")
    public ResponseEntity<EmpDto> deleteEmp(@RequestBody EmpDto empDto) {
        try{
            EmpDto deletedEmp = empService.deleteEmp(empDto);
            return new ResponseEntity<>(deletedEmp, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

    @GetMapping("view")
    public List<Employee> viewEmp() {
        return empService.getAllEmps();
    }
}
