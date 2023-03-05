package com.example.CrudOperation.Controller;

import com.example.CrudOperation.Entity.Employee;
import com.example.CrudOperation.Repo.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class EmployeeController {
    @Autowired
    private EmployeeRepository employeeRepo;

    @PostMapping("/saveEmployee")
    public Employee saveEmployee(@RequestBody Employee employee){
        return employeeRepo.save(employee);


    }
    @GetMapping("/getEmployee/{id}")
    public Employee getEmployee(@PathVariable Long id){

        return employeeRepo.findById(id).get();
    }
    @DeleteMapping("/delete/{id}")
    public String deleteEmployee(@PathVariable Long id){
        employeeRepo.deleteById(id);
        return "Employee is deleted ";
    }
}

