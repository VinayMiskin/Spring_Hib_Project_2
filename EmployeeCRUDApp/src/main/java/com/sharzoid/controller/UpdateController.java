package com.sharzoid.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.sharzoid.services.EmployeeService;

@Controller
public class UpdateController {
	
	@Autowired
	private EmployeeService employeeService;
	
	@RequestMapping("/toUpdateView")
	public String toUpdateView(Long id, Model model) {
		model.addAttribute("bean", employeeService.get(id));
		model.addAttribute("beanId", id);
		model.addAttribute("submit", "Update Employee");
		model.addAttribute("action", "toUpdateSuccessView");
		return "Register";
	}
	
	@RequestMapping("/toUpdateSuccessView")
	public String toSuccessView(@Valid @ModelAttribute("bean") Employee employee, BindingResult result, Model model, Long id) {
		System.out.println(employee);
		
		model.addAttribute("submit", "Add Employee");
		model.addAttribute("action", "toUpdateSuccessView");
		model.addAttribute("beanId", id);
		
		if (result.hasErrors()) {
			System.out.println("Errors.....................");
			List<ObjectError> errors = result.getAllErrors();
			for (ObjectError objectError : errors) {
				System.out.println(objectError);
			}
			return "Register";
		}
		
		System.out.println("Updating-----------------");
		model.addAttribute("successMessage", "success.update.employee");
		employeeService.update(employee, id);
		
		
		return "Success";
	}

}
