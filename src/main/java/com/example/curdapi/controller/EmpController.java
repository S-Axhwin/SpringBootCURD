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
@CrossOrigin(origins = "http://localhost:5173")
public class EmpController {

    private final EmpService empService;

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
        EmpDto savedEmp = empService.updateEmp(empDto);
        return new ResponseEntity<>(savedEmp, HttpStatus.CREATED);
    }
}
