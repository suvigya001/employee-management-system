package com.ems.employeemanagement.service;

import com.ems.employeemanagement.dto.EmployeeUpdateDetails;
import com.ems.employeemanagement.model.Employee;
import com.ems.employeemanagement.repository.DepartmentRepository;
import com.ems.employeemanagement.repository.EmployeeRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService {

    private final EmployeeRepository employeeRepository;
    private final DepartmentRepository departmentRepository;

    public EmployeeService(EmployeeRepository employeeRepository, DepartmentRepository departmentRepository) {
        this.employeeRepository = employeeRepository;
        this.departmentRepository = departmentRepository;
    }

    public Employee saveEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }

    public Optional<Employee> getEmployeeById(Long id) {
        return employeeRepository.findById(id);
    }

    public List<Employee> listAll(){
        return employeeRepository.findAll();
    }

    public Optional<Employee> updateEmployee(Long id, EmployeeUpdateDetails employeeUpdateDetails) {
        return employeeRepository.findById(id)
                .map(employee -> {
                    employee.setName(employeeUpdateDetails.getName());
                    employee.setSalary(employeeUpdateDetails.getSalary());
                    return employeeRepository.save(employee);
                });
    }

    public void deleteEmployeeById(Long id) {

    }

}
