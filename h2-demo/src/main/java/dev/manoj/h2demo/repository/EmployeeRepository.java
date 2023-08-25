package dev.manoj.h2demo.repository;

import dev.manoj.h2demo.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee,Long> {




}
