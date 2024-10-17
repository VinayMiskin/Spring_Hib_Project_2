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
public class HomeController {
	
	@Autowired
	private EmployeeService employeeService;
	
	@RequestMapping({"/","/home"})
	public String showHome(Model model) {
		model.addAttribute("eList", employeeService.getAll());
		return "Home";
	}
	
	@RequestMapping("/toDeleteSuccess")
	public String showDeleteSuccess(Long id, Model model) {
		String data = employeeService.delete(id);
		model.addAttribute("successMessage", "success.delete.employee");
		return "Success";
	}
	
	
}
