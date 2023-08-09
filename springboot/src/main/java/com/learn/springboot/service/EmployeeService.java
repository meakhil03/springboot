package com.learn.springboot.service;

import com.learn.springboot.domain.EmployeeEntity;
import com.learn.springboot.repository.EmployeeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepo employeeRepo;

    public List<EmployeeEntity> getAllDetails() {
        return employeeRepo.findAll();
    }

    public EmployeeEntity saveDetails(EmployeeEntity employeeEntity) {
        return employeeRepo.save(employeeEntity);
    }

    public EmployeeEntity updateDetails(EmployeeEntity employeeEntity) {
        EmployeeEntity updateEmployee=employeeRepo.findById(employeeEntity.getId()).orElse(null);
        if(updateEmployee!=null)
        {
            updateEmployee.setAge(employeeEntity.getAge());
            employeeRepo.save(updateEmployee);
        }
        return null;
    }

    public String deleteEmployee(int id){
        employeeRepo.deleteById(id);
        return "deleted "+id;
    }
}
