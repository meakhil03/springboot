package com.learn.springboot.controller;

import com.learn.springboot.domain.EmployeeEntity;
import com.learn.springboot.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employees")
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;

    @GetMapping("/getdetails")
    public List<EmployeeEntity> getDetails() {
        return employeeService.getAllDetails();
    }
    @PostMapping("/postdetails")
    public EmployeeEntity postDetails(@RequestBody EmployeeEntity employeeEntity) {
        return employeeService.saveDetails(employeeEntity);
    }

    @PutMapping("/updatedetails")
    public EmployeeEntity updateEmpDetails(@RequestBody EmployeeEntity employeeEntity) {
        return employeeService.updateDetails(employeeEntity);
    }

    @DeleteMapping("/deleteEmployee/{id}")
    public String deleteEmp(@PathVariable int id) {
        return employeeService.deleteEmployee(id);
    }
}
