package com.metacube.training.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.metacube.training.model.Employee;
import com.metacube.training.service.EmployeeService;

@Controller
@RequestMapping("/employee")
public class EmployeeController {

	@Autowired
	EmployeeService employeeService;

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String login() {
		return "employee/login";
	}

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public ModelAndView login(Model model, @RequestParam(name = "emailId") String emailId,
			@RequestParam(name = "password") String password) {
		Employee employee = employeeService.checkValidLogin(emailId, password);
		if (employee != null) {
			model.addAttribute("employee", employee);
			return new ModelAndView("employee/dashboard");
		} else {

			return new ModelAndView("employee/login");
		}
	}

	@RequestMapping(value = "/editProfile", method = RequestMethod.GET)
	public String editProfile(Model model, @RequestParam("empCode") int empCode) {
		model.addAttribute("employee", employeeService.getEmployeeById(empCode));
		return "employee/editProfile";

	}

	@RequestMapping(value = "/editProfile", method = RequestMethod.POST)
	public String editProfile(@ModelAttribute("employee") Employee employee, Model model)

	{
		System.out.println(employee);
		System.out.println("hi");
		System.out.print(employeeService.updateEmployee(employee));
		model.addAttribute("employee", employeeService.getEmployeeById(employee.getEmpCode()));
		return "employee/dashboard";
	}

}
