package com.sharzoid.services;

import java.util.List;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sharzoid.controller.Employee;
import com.sharzoid.dao.EmployeeDao;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	private EmployeeDao dao;
	
	@Override
	public String add(Employee employee) {
		
		return dao.add(employee);
	}

	@Override
	public Employee get(Long id) {
		
		return dao.get(id);
	}

	@Override
	public List<Employee> getAll() {
		
		return dao.getAll();
	}

	@Override
	public String update(Employee employee, Long id) {
		
		return dao.update(employee, id);
	}

	@Override
	public String delete(Long id) {
		
		return dao.delete(id);
	}

}
