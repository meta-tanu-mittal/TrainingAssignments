package com.metacube.training.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;

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
import com.metacube.training.model.Employee;
import com.metacube.training.model.Job;
import com.metacube.training.model.Project;
import com.metacube.training.model.Skill;
import com.metacube.training.service.EmployeeService;
import com.metacube.training.service.JobService;
import com.metacube.training.service.ProjectService;
import com.metacube.training.service.SkillService;

@Controller
@RequestMapping("/admin")
public class AdminController {

	@Autowired
	private ProjectService projectService;
	@Autowired
	private SkillService skillService;
	@Autowired
	private JobService jobService;
	@Autowired
	private EmployeeService employeeService;

	@GetMapping("/login")
	public String login() {
		return "admin/login";
	}

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public ModelAndView login(@RequestParam(name = "username") String username,
			@RequestParam(name = "password") String password) {

		return new ModelAndView("admin/dashboard", "username", username);
	}

	/** Methods For projects **/

	@RequestMapping(path = "/projects/add", method = RequestMethod.GET)
	public String createproject(Model model) {
		model.addAttribute("project", new Project());
		return "admin/editProject";
	}

	@RequestMapping(path = "projects", method = RequestMethod.POST)
	public String saveproject(@ModelAttribute("project") Project project) {
		if (project != null && project.getProjectId() == 0) {
			projectService.createProject(project);
		} else {
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

	/** Methods for skill **/

	@RequestMapping(path = "skills/add", method = RequestMethod.GET)
	public String createSkill(Model model) {
		model.addAttribute("skill", new Skill());
		return "admin/editSkill";
	}

	@RequestMapping(path = "/skills", method = RequestMethod.GET)
	public String getAllSkills(Model model) {
		model.addAttribute("skills", skillService.getAllSkills());
		return "admin/skills";
	}

	@RequestMapping(path = "/skills/edit", method = RequestMethod.GET)
	public String editSkill(Model model, @RequestParam("id") int id) {
		model.addAttribute("skill", skillService.getSkillById(id));
		return "admin/editSkill";
	}

	@RequestMapping(path = "skills", method = RequestMethod.POST)
	public String saveSkill(@ModelAttribute("skill") Skill skill) {
		if (skill != null && skill.getSkillId() == 0) {
			skillService.createSkill(skill);
		} else {
			skillService.updateSkill(skill);
		}
		return "redirect:/admin/skills";
	}

	/** Methods for employee */

	@RequestMapping(value = "/employee", method = RequestMethod.GET)
	public ModelAndView getAllEmployee(Model model) {
		model.addAttribute("employees", employeeService.getAllEmployee());
		return new ModelAndView("admin/employee");
	}

	@RequestMapping(value = "/addEmployee", method = RequestMethod.GET)
	public ModelAndView getEmployeeForm(Model model) {
		model.addAttribute("employee", new Employee());
		model.addAttribute("employees", employeeService.getAllEmployee());
		model.addAttribute("projects", projectService.getAllProjects());
		return new ModelAndView("admin/addEmployee");
	}

	@RequestMapping(value = "/addEmployee", method = RequestMethod.POST)
	public String submitEmployeeForm(@ModelAttribute("employee") Employee employee) {
		employeeService.insertEmployee(employee);
		return "redirect:/admin/employee";

	}

	@RequestMapping(value = "/editEmployee", method = RequestMethod.GET)
	public String editEmployee(Model model, @RequestParam("id") int id) {
		model.addAttribute("employee", employeeService.getEmployeeById(id));
		return "admin/editEmployee";

	}

	@RequestMapping(value = "/editEmployee", method = RequestMethod.POST)
	public String editEmployee(@ModelAttribute("employee") Employee employee, Model model) {
		employeeService.updateEmployee(employee);
		model.addAttribute("employee", employeeService.getEmployeeById(employee.getEmpCode()));
		return "redirect:/admin/employee";
	}

	/** Method for jobs **/

	@RequestMapping(value = "/job", method = RequestMethod.GET)
	public String getAllJobs(Model model) {
		model.addAttribute("jobs", jobService.getAllJobTitle());
		return "admin/job";
	}

	@RequestMapping(value = "/job/add", method = RequestMethod.GET)
	public String createJob(Model model) {
		model.addAttribute("job", new Job());
		return "admin/editJob";
	}

	@RequestMapping(value = "/job", method = RequestMethod.POST)
	public String saveJob(@ModelAttribute("job") Job job) {
		if (job.getJobCode() == 0 && job != null) {
			jobService.insertJobTitle(job);
		} else {
			jobService.updateJobTitle(job);
		}
		return "redirect:/admin/job";
	}

	@RequestMapping(value = "/job/edit", method = RequestMethod.GET)
	public String editJob(Model model, @RequestParam("id") int id) {
		model.addAttribute("job", jobService.getJobTitleById(id));
		return "admin/editJob";
	}
}
