package com.lti.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import com.lti.model.Employee;
import com.lti.utils.JpaUtils;

public class EmployeeDaoImpl implements EmployeeDao{
	private EntityManager entityManager;
	private final static String GET_ALL_EMPLOYEES ="select e from Employee e"; 
	private final static String GET_EMPLOYEES_BY_SALARY ="select e from Employee e where e.employeeSalary > :salary"; 
	private final static String GET_EMPLOYEES_BY_DEPARTMENT_ID ="select e from Employee e join e.department d where d.departmentId = :deptId"; 
	private final static String GET_EMPLOYEES_BY_DEPARTMENT_NAME ="select e from Employee e join e.department d where d.departmentName = :deptName";
	private final static String GET_EMPLOYEES_BY_SALARY_GREATER_THAN ="select e from Employee e where e.employeeSalary >ALL (select e.employeeSalary from Employee e where e.employeeName IN :empName)";
	

	public EmployeeDaoImpl() {
		entityManager = JpaUtils.getEntityManager();
	}
		
	@Override
	public List<Employee> readAllEmployees() {
		TypedQuery<Employee> tQuery = entityManager.createQuery(GET_ALL_EMPLOYEES, Employee.class);
		List<Employee> result=tQuery.getResultList();
		return result;
	}

	@Override
	public List<Employee> readEmployeesBySalary(double sal) {
		TypedQuery<Employee> tQuery = entityManager.createQuery(GET_EMPLOYEES_BY_SALARY, Employee.class);
		tQuery.setParameter("salary", sal);
		List<Employee> result = tQuery.getResultList();
		
		return result;
	}

	@Override
	public List<Employee> readEmployeesByDepartmentId(int id) {
		TypedQuery<Employee> tQuery = entityManager.createQuery(GET_EMPLOYEES_BY_DEPARTMENT_ID, Employee.class);
		tQuery.setParameter("deptId", id);
		List<Employee> list =tQuery.getResultList();
		
		return list;
	}

	@Override
	public List<Employee> readEmployeesByDepartmentName(String deptName) {
		TypedQuery<Employee> tQuery = entityManager.createQuery(GET_EMPLOYEES_BY_DEPARTMENT_NAME, Employee.class);
		tQuery.setParameter("deptName", deptName);
		List<Employee> list = tQuery.getResultList();
		return list;
	}

	@Override
	public List<Employee> readEmployeesBySalaryGreaterThan(String empname) {
		
		TypedQuery<Employee> tQuery = entityManager.createQuery(GET_EMPLOYEES_BY_SALARY_GREATER_THAN, Employee.class);
		tQuery.setParameter("empName", empname);
		List<Employee> list = tQuery.getResultList();
		return list;
	}

}
