package com.sharzoid.services;

import java.util.List;

import com.sharzoid.controller.Employee;

public interface EmployeeService {
	public String add(Employee employee);
	public Employee get(Long id);
	public List<Employee> getAll();
	public String update(Employee employee, Long id);
	public String delete(Long id);
}
