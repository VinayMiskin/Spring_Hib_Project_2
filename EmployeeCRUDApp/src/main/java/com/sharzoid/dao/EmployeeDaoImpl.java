package com.sharzoid.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sharzoid.controller.Employee;

@Repository
public class EmployeeDaoImpl implements EmployeeDao {
	
	@Autowired
	private SessionFactory factory;
	
	@Override
	public String add(Employee employee) {
		System.out.println("The Employee Datails as follows.......");
		Session session = factory.openSession();
		session.beginTransaction();
		
		session.save(employee);
		
		session.getTransaction().commit();
		session.close();
		System.out.println(employee);
		
		return "success";
	}

	@Override
	public Employee get(Long id) {
		Session s1 = factory.openSession();
		s1.beginTransaction();
		Employee employee = s1.get(Employee.class, id);
		s1.getTransaction().commit();
		return employee;
	}

	@Override
	public List<Employee> getAll() {
		Session s1 = factory.openSession();
		s1.beginTransaction();
		List<Employee> employees = s1.createQuery("from Employee").getResultList();
		s1.getTransaction().commit();
		return employees;
	}

	@Override
	public String update(Employee employee, Long id) {
		Session s1 = factory.openSession();
		s1.beginTransaction();
		Employee e = s1.get(Employee.class, id);
		e.copyEmployee(employee);
		//s1.update(e);
		s1.getTransaction().commit();
		return "updated";
	}

	@Override
	public String delete(Long id) {
		Session s1 = factory.openSession();
		s1.beginTransaction();
		Employee employee = s1.get(Employee.class, id);
		s1.delete(employee);
		s1.getTransaction().commit();
		return "Delete";
	}

}
