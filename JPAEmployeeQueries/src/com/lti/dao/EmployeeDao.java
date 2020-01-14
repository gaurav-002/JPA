package com.lti.dao;

import java.util.List;

import com.lti.model.Employee;

public interface EmployeeDao {
	
	
	public List<Employee> readAllEmployees();
	public List<Employee> readEmployeesBySalary(double sal);
	public List<Employee> readEmployeesByDepartmentId(int id);
	public List<Employee> readEmployeesByDepartmentName(String deptName);
	public List<Employee> readEmployeesBySalaryGreaterThan(String empname);

 }
