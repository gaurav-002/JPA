package com.lti.service;

import java.util.List;

import com.lti.dao.EmployeeDao;
import com.lti.dao.EmployeeDaoImpl;
import com.lti.model.Employee;

public class EmployeeServiceImpl implements EmployeeService {
	EmployeeDao dao = new EmployeeDaoImpl();
	
	@Override
	public List<Employee> viewAllEmployees() {
		List<Employee> list = dao.readAllEmployees();
		return list;
	}

	@Override
	public List<Employee> findEmployeesBySalary(double sal) {
		List<Employee> list = dao.readEmployeesBySalary(sal);
		return list;
	}

	@Override
	public List<Employee> findEmployeesByDepartmentId(int id) {
		List<Employee> list = dao.readEmployeesByDepartmentId(id);
		return list;
	}

	@Override
	public List<Employee> findEmployeesByDepartmentName(String deptName) {
		List<Employee> list = dao.readEmployeesByDepartmentName(deptName);
		
		return list;
	}

	@Override
	public List<Employee> findEmployeesBySalaryGreaterThan(String empname) {
		List<Employee> list = dao.readEmployeesBySalaryGreaterThan(empname);
		return list;
	}

}
