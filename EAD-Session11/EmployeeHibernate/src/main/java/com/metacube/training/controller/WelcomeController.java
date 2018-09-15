package com.metacube.training.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.metacube.training.model.Employee;
import com.metacube.training.model.Skill;
import com.metacube.training.service.EmployeeService;
import com.metacube.training.service.EmployeeSkillService;
import com.metacube.training.service.SkillService;

@Controller

public class WelcomeController {
   @Autowired
	private EmployeeService employeeService;
   @Autowired
   private SkillService SkillService;
   @Autowired
   private EmployeeSkillService employeeSkillService;
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String welcome(ModelMap model) {
		model.addAttribute("greeting", "Hello World from Spring 4 MVC");
		return "welcome";
	}
	
	@RequestMapping(value="/searchResult",method=RequestMethod.GET)
	public String searchResult(@RequestParam("searchBy") String searchBy,
			@RequestParam("input") String input,Model model)
	{   
		if("name".equals(searchBy))
		{
			model.addAttribute("employees", employeeService.getEmployeeByName(input));
		}
		else
		{
			if("skills".equals(searchBy))
			{
			Skill skill=SkillService.getSkillByName(input);
			List<Integer> empCodeList=employeeSkillService.getAllEmployeeCode(skill.getSkillId());
			List<Employee> employeeList=new ArrayList<Employee>();
			for(int empCode:empCodeList)
			{
				Employee emp=employeeService.getEmployeeById(empCode);
				employeeList.add(emp);
			}
			model.addAttribute("employees",employeeList);
			}
		}
		return "searchResult";
	}

}