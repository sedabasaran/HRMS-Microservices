package com.hr.department_service.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hr.department_service.model.Department;
import com.hr.department_service.service.DepartmentService;

@RestController
@RequestMapping("/department")
public class DepartmentController {
	private static final Logger Logger = LoggerFactory.getLogger(DepartmentController.class);

	private final DepartmentService departmentService;

	public DepartmentController(DepartmentService departmentService) {
		this.departmentService = departmentService;
	}

	@PostMapping
	public Department createDepartment(@RequestBody Department department) {
		Logger.info("Adding department: {}", department);
		return departmentService.createDepartment(department);
	}

	@GetMapping
	public List<Department> getAllDepartments() {
		Logger.info("Fetching all departments");
		return departmentService.findAllDepartments();
	}

	@GetMapping("/{id}")
	public Department getDepartmentById(@PathVariable Long id) {
		Logger.info("Fetching department with id: {}", id);
		return departmentService.findDepartmentById(id);
	}
	
	@GetMapping("/with-employees")
	public List<Department> getAllDepartmentsWithEmployees() {
		Logger.info("Fetching all departments with employees");
		return departmentService.findAllDepartmentsWithEmployees();
	}
	
    @PutMapping("/{id}")
    public Department updateDepartment(@PathVariable Long id, @RequestBody Department department) {
        Logger.info("Updating department with id: {}", id);
        return departmentService.updateDepartment(id, department);
    }

    @DeleteMapping("/{id}")
    public void deleteDepartment(@PathVariable Long id) {
        Logger.info("Deleting department with id: {}", id);
        departmentService.deleteDepartment(id);
    }
}
