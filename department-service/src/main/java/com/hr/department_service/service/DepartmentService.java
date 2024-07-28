package com.hr.department_service.service;

import java.util.List;

import org.springframework.stereotype.Service;
import com.hr.department_service.client.EmployeeClient;
import com.hr.department_service.model.Department;
import com.hr.department_service.model.Employee;
import com.hr.department_service.repository.DepartmentRepository;

import jakarta.persistence.EntityNotFoundException;

@Service
public class DepartmentService {
	
	private final DepartmentRepository departmentRepository;
	private final EmployeeClient employeeClient;

	public DepartmentService(DepartmentRepository departmentRepository, EmployeeClient employeeClient) {
		this.departmentRepository = departmentRepository;
		this.employeeClient = employeeClient;
	}

	public Department createDepartment(Department department) {
		return departmentRepository.save(department);
	}

	public List<Department> findAllDepartments() {
		return departmentRepository.findAll();
	}

	public Department findDepartmentById(Long id) {
		Department department = departmentRepository.findById(id)
				.orElseThrow(() -> new EntityNotFoundException("Department not found with id: " + id));
		List<Employee> employees = employeeClient.findByDepartment(id);
		department.setEmployees(employees);

		return department;
	}

	public List<Department> findAllDepartmentsWithEmployees() {
		List<Department> departments = departmentRepository.findAll();
		departments.forEach(department -> {
			List<Employee> employees = employeeClient.findByDepartment(department.getId());
			department.setEmployees(employees);
		});
		return departments;
	}
	
    public Department updateDepartment(Long id, Department updatedDepartment) {
        if (!departmentRepository.existsById(id)) {
            throw new RuntimeException("Department not found");
        }
        updatedDepartment.setId(id);
        return departmentRepository.save(updatedDepartment);
    }

    public void deleteDepartment(Long id) {
        if (!departmentRepository.existsById(id)) {
            throw new RuntimeException("Department not found");
        }
        departmentRepository.deleteById(id);
    }
	
}
