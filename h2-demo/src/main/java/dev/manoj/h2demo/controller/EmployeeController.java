package dev.manoj.h2demo.controller;

import dev.manoj.h2demo.model.Employee;
import dev.manoj.h2demo.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;


@CrossOrigin(origins = "http://localhost:8081")
@RestController
@RequestMapping("/api")
public class EmployeeController {

    @Autowired
    EmployeeRepository employeeRepository;

    @GetMapping("/employees/{id}")
    public ResponseEntity<Employee> getEmployeebyId(@PathVariable("id") long id){
        Optional<Employee> employeedata = employeeRepository.findById(id);

        if(employeedata.isPresent()){
            return new ResponseEntity<>(employeedata.get(), HttpStatus.OK);
        }
        else{
            return new ResponseEntity<>(employeedata.get(), HttpStatus.NOT_FOUND);
        }



    }

    @PostMapping("/employees")
    public ResponseEntity<Employee> createEmployeebyId(@RequestBody Employee employee){
        try{
            Employee _employee;
            _employee = employeeRepository.save(new Employee(employee.getId(),employee.getFirstname(),employee.getSecondname()));

            return new ResponseEntity<>(_employee,HttpStatus.CREATED);

        }
        catch(Exception e){
            return new ResponseEntity<>(null,HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/employees/{id}")
    public ResponseEntity<Employee> updateEmployee(@PathVariable("id") long id, @RequestBody Employee employee) {
        Optional<Employee> employeeData = employeeRepository.findById(id);

        if (employeeData.isPresent()) {
            Employee _employee = employeeData.get();
            _employee.setFirstname(employee.getFirstname());
            _employee.setSecondname(employee.getSecondname());

            return new ResponseEntity<>(employeeRepository.save(_employee), HttpStatus.OK);

        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);

        }

    }

    @DeleteMapping("/employees")
    public ResponseEntity<HttpStatus> deleteEmployees(){
        try{
            employeeRepository.deleteAll();
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }




    }

    @DeleteMapping("/employees/{id}")
    public ResponseEntity<Employee> deleteEmployee(@PathVariable("id") long id){
        try{
            employeeRepository.deleteById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }




    }






}
