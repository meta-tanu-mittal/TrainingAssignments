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

import com.metacube.training.model.Project;
import com.metacube.training.model.Skill;
import com.metacube.training.service.ProjectService;
import com.metacube.training.service.SkillService;


@Controller
@RequestMapping("/admin")
public class AdminController {
	
	@Autowired
	private ProjectService projectService;

	@GetMapping("/login")
	public String login() {
		return "admin/login";
	}

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public ModelAndView login(@RequestParam(name = "username") String username,
			@RequestParam(name = "password") String password) {

		return new ModelAndView("admin/dashboard", "username", username);
	}
	
	
	@RequestMapping(path = "/projects/add", method = RequestMethod.GET)
	public String createproject(Model model) {
		model.addAttribute("project", new Project());
		return "admin/editProject";
	}

	@RequestMapping(path = "projects", method = RequestMethod.POST)
	public String saveproject(@ModelAttribute("project") Project project) {
		if(project!= null && project.getProjectId() == 0) {
			projectService.createProject(project);	
		}else {
			projectService.updateProject(project);
		}
		return "redirect:/admin/projects";
	}

	@RequestMapping(path = "/projects", method = RequestMethod.GET)
	public String getAllprojects(Model model) {
		model.addAttribute("projects", projectService.getAllProjects());
		return "admin/projects";
	}

	@RequestMapping(path = "/projects/edit", method = RequestMethod.GET)
	public String editproject(Model model, @RequestParam("id") int id) {
		model.addAttribute("project", projectService.getProjectById(id));
		return "admin/editProject";
	}


	@Autowired
	private SkillService skillService;
	
	@RequestMapping(path="skills/add",method=RequestMethod.GET)
	public String createSkill(Model model)
	{
		model.addAttribute("skill", new Skill());
		return "admin/editSkill";
	}

	@RequestMapping(path="/skills",method=RequestMethod.GET)
	public String getAllSkills(Model model)
	{
		model.addAttribute("skills",skillService.getAllSkills() );
		return "admin/skills";
	}
	
	@RequestMapping(path="/skills/edit" ,method=RequestMethod.GET)
	public String editSkill(Model model,@RequestParam("id") int id)
	{
		model.addAttribute("skill", skillService.getSkillById(id));
		return "admin/editSkill";
	}
	
	@RequestMapping(path="skills",method=RequestMethod.POST)
	public String saveSkill(@ModelAttribute("skill") Skill skill) {
		if(skill!= null && skill.getSkillId() == 0) {
			skillService.createSkill(skill);
		}else {
			skillService.updateSkill(skill);
		}
		return "redirect:/admin/skills";
	}
}
