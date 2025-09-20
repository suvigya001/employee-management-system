package com.ems.employeemanagement.service;

import com.ems.employeemanagement.model.Department;
import com.ems.employeemanagement.repository.DepartmentRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class DeparmentService {

    private DepartmentRepository departmentRepository;

    public Optional<Department> getDeptById(Long id){
        return departmentRepository.findById(id);
    }

    public DepartmentRepository getDepartmentRepository() {
        return departmentRepository;
    }

    public void setDepartmentRepository(DepartmentRepository departmentRepository) {
        this.departmentRepository = departmentRepository;
    }
}
