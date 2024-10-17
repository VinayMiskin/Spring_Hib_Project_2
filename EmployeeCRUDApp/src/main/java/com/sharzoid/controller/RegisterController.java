package com.sharzoid.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.sharzoid.services.EmployeeService;

@Controller
public class RegisterController {

	@Autowired
	private EmployeeService service;

	@RequestMapping("/toRegisterView")
	public String toRegisterView(@ModelAttribute("bean") Employee employee, Model model) {
		model.addAttribute("submit", "Add Employee");
		model.addAttribute("action", "toRegisterSuccessView");
		return "Register";
	}

	@RequestMapping("/toRegisterSuccessView")
	public String toSuccessView(@Valid @ModelAttribute("bean") Employee employee, BindingResult result, Model model, Long id) {
		
		model.addAttribute("submit", "Add Employee");
		model.addAttribute("action", "toRegisterSuccessView");
		
		if (result.hasErrors()) {
			System.out.println("Errors.....................");
			List<ObjectError> errors = result.getAllErrors();
			for (ObjectError objectError : errors) {
				System.out.println(objectError);
			}
			return "Register";
		}
		
		System.out.println("Adding-----------------");
		model.addAttribute("successMessage", "success.register.employee");
		service.add(employee);
		
		return "Success";
	}

	@InitBinder
	public void init(WebDataBinder dataBinder) {
		System.out.println("init binder.................");

		SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		CustomDateEditor editor2 = new CustomDateEditor(dateFormat, true);
		dataBinder.registerCustomEditor(Date.class, "dob", editor2);

	}
}
