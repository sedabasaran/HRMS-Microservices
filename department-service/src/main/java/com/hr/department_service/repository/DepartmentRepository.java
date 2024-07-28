package com.hr.department_service.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hr.department_service.model.Department;

@Repository
public interface DepartmentRepository extends JpaRepository<Department, Long> {

}
