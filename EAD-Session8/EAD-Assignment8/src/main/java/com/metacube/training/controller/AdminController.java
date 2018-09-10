package com.metacube.training.controller;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.metacube.training.dao.EmployeeDAOImpl;
import com.metacube.training.dao.ProjectDAOImpl;
import com.metacube.training.dao.SkillDAOImpl;
import com.metacube.training.model.Employee;
import com.metacube.training.model.Project;
import com.metacube.training.model.Skill;
import com.metacube.training.service.EmployeeService;

@Controller
@RequestMapping("/admin")
public class AdminController {

	@GetMapping("/login")
	public String login() {
		return "admin/login";
	}

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public ModelAndView login(@RequestParam(name = "username") String username,
			@RequestParam(name = "password") String password) {

		return new ModelAndView("admin/dashboard", "username", username);
	}
	
	@RequestMapping(value="/addProject" ,method=RequestMethod.GET)
	public ModelAndView getProjectForm()
	{
		return new ModelAndView("admin/addProject");
	}
	
	@RequestMapping(value="/addProject",method=RequestMethod.POST)
	public ModelAndView submitProjectForm(@ModelAttribute("project") Project project)
	{
		ProjectDAOImpl obj=new ProjectDAOImpl();
		System.out.println(project.getDescription());
		obj.insertProject(project);
		return  new ModelAndView("admin/addProject");
		
	}
	
	
	
	
	@RequestMapping(value="/skills" ,method=RequestMethod.GET)
	public ModelAndView getAllSkills(Model model)
	{  
		SkillDAOImpl obj=new SkillDAOImpl();
		model.addAttribute("skills",obj.getAllSkill());
		return new ModelAndView("admin/skills");
	}
	
	@RequestMapping(value="/addSkill" ,method=RequestMethod.GET)
	public ModelAndView getSkillForm()
	{  
		return new ModelAndView("admin/addSkill");
	}
	
	@RequestMapping(value="/addSkill" ,method=RequestMethod.POST)
	public String submitSkillForm(@ModelAttribute("skill") Skill skill)
	{
		SkillDAOImpl obj=new SkillDAOImpl();
		obj.insertSkill(skill);
		return "redirect:/admin/skills";
		
	}
	
	
	
	@RequestMapping(value="/employee" ,method=RequestMethod.GET)
	public ModelAndView getAllEmployee(Model model)
	{  
		EmployeeDAOImpl  obj=new EmployeeDAOImpl();
		model.addAttribute("employees",obj.getAllEmployee());
		return new ModelAndView("admin/employee");
	}
	
	@RequestMapping(value="/addEmployee" , method=RequestMethod.GET)
	public ModelAndView getEmployeeForm()
	{
		return new ModelAndView ("admin/addEmployee");
	}
	
	@RequestMapping(value="/addEmployee" , method=RequestMethod.POST)
	public String submitEmployeeForm(@ModelAttribute("employee") Employee employee, HttpServletRequest req)throws ParseException,ServletException
	{   
		try {
			employee.setDob( new SimpleDateFormat("yyyy-MM-dd").parse(req.getParameter("dob")));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		EmployeeService obj=new EmployeeService();
		obj.insertEmployee(employee);
		return "redirect:/admin/employee";
		
	}
	
	@RequestMapping(value="/editEmployee" , method=RequestMethod.GET)
	public ModelAndView getEmployeeEditForm(Model model,@RequestParam("empCode") int empCode)
	{
		EmployeeService obj=new EmployeeService();
		model.addAttribute("employee", obj.getEmployeeById(empCode));
		return new ModelAndView ("admin/editEmployee");
	}
	

}
