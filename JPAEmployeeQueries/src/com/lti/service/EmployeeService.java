package com.lti.service;

import java.util.List;

import com.lti.model.Employee;

public interface EmployeeService {

	public List<Employee> viewAllEmployees();
	public List<Employee> findEmployeesBySalary(double sal);
	public List<Employee> findEmployeesByDepartmentId(int id);
	public List<Employee> findEmployeesByDepartmentName(String deptName);
	public List<Employee> findEmployeesBySalaryGreaterThan(String empname);
}
