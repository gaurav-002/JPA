package com.lti.ui;

import java.util.List;
import java.util.Scanner;
import com.lti.model.Employee;
import com.lti.service.EmployeeService;
import com.lti.service.EmployeeServiceImpl;

public class Main {
	static EmployeeService service = new EmployeeServiceImpl();

	public static void displayEmployees(){
		List<Employee> emplist = service.viewAllEmployees();
		if(emplist.isEmpty()){
			System.out.println("Empty Table");
		}
		else
		{
			for(Employee e: emplist){
				System.out.println("Employee id: " + e.getEmployeeId());
				System.out.println("Employee Name: "+e.getEmployeeName());
				System.out.println("Employee Salary: "+e.getEmployeeSalary());
				if(e.getDepartment() != null){
					System.out.println("Department id: "+e.getDepartment().getDepartmentId());
					System.out.println("Department Name: "+e.getDepartment().getDepartmentName());
				}
			}
		}
	}

	
	public static void displayEmployeeBySalary(double sal){
		List<Employee> emplist = service.findEmployeesBySalary(sal);
		for(Employee e: emplist){
			System.out.println("Employee id: " + e.getEmployeeId());
			System.out.println("Employee Name: "+e.getEmployeeName());
			System.out.println("Employee Salary: "+e.getEmployeeSalary());
			System.out.println("Department id: "+e.getDepartment().getDepartmentId());
			System.out.println("Department Name: "+e.getDepartment().getDepartmentName());
		}
	}
	
	
	public static void displayEmployeeByDeptId(int id){
		List<Employee> emplist = service.findEmployeesByDepartmentId(id);
		for(Employee e: emplist){
			System.out.println("Employee id: " + e.getEmployeeId());
			System.out.println("Employee Name: "+e.getEmployeeName());
			System.out.println("Employee Salary: "+e.getEmployeeSalary());
			System.out.println("Department id: "+e.getDepartment().getDepartmentId());
			System.out.println("Department Name: "+e.getDepartment().getDepartmentName());
		}
	}
	
	public static void displayEmployeeByDeptName(String deptName){
		List<Employee> emplist = service.findEmployeesByDepartmentName(deptName);
		for(Employee e: emplist){
			System.out.println("Employee id: " + e.getEmployeeId());
			System.out.println("Employee Name: "+e.getEmployeeName());
			System.out.println("Employee Salary: "+e.getEmployeeSalary());
			System.out.println("Department id: "+e.getDepartment().getDepartmentId());
			System.out.println("Department Name: "+e.getDepartment().getDepartmentName());
		}
	}
	
	
	public static void displayEmployeeBySalaryGreaterThan(String empname){
		List<Employee> emplist = service.findEmployeesBySalaryGreaterThan(empname);
		for(Employee e: emplist){
			System.out.println("Employee id: " + e.getEmployeeId());
			System.out.println("Employee Name: "+e.getEmployeeName());
			System.out.println("Employee Salary: "+e.getEmployeeSalary());
			System.out.println("Department id: "+e.getDepartment().getDepartmentId());
			System.out.println("Department Name: "+e.getDepartment().getDepartmentName());
		}
	}
	
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		boolean flag=true;
		do{	
			System.out.println("1.Find All Employees");
			System.out.println("2.Find Employees by Salary Greater than");
			System.out.println("3.Find Employees based on department id");
			System.out.println("4.Find Employees based on department name");
			System.out.println("5.Find Employees whose salary is greater than someone else");
			System.out.println("0.Exit");

			int choice = sc.nextInt();
			switch(choice){
			
			case 1: displayEmployees();
			break;
			
			case 2:
				System.out.println("Enter Salary : ");
				double sal = sc.nextDouble();
				displayEmployeeBySalary(sal);
				break;
				
			case 3:
				System.out.println("Enter Department id: ");
				int deptId = sc.nextInt();
				displayEmployeeByDeptId(deptId);
				break;
				
			case 4:
				System.out.println("Enter Department Name: ");
				String deptName = sc.next();
				displayEmployeeByDeptName(deptName);
				break;
				
			case 5:
				System.out.println("Enter Employee Name: ");
				String empName = sc.next();
				displayEmployeeBySalaryGreaterThan(empName);
				break;				
				
			case 0 :
				flag = false;
				break;


			default: 
				System.out.println("Invalid choice");
				break;
			}
			
		}while(flag);
		System.out.println("<==========End of the application===========>");

	}


}
