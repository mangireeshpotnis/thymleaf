package com.thymleaf.controllers;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.thymleaf.models.Employee;



@Controller
@RequestMapping("/employee") //this will be the base URL.. thats the use of request mapping+
public class EmployeeController {
	String firstName="Mangireesh";
	String lastName="Potnis";
	
	@GetMapping("")
	public String show_home(Model model) {
		
		model.addAttribute("first_Name",firstName);
		model.addAttribute("last_Name",lastName);		
		return "home";
	}
	
	@GetMapping("/login")
	public String show_login(Model model) {
		model.addAttribute("emp_object",new Employee());
		return "form";
	}
	
	@PostMapping("/login")
	public String show_login(@ModelAttribute Employee employee,Model model) {
		
		String emp_name = employee.getEmp_name();
		int emp_salary = employee.getEmp_salary();
		model.addAttribute("emp_name",emp_name);
		model.addAttribute("emp_salary",emp_salary);
		
		return "result";
	}

}
	



