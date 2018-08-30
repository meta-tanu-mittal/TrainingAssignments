package com.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.database.EmployeeOperation;
import com.model.Employee;

public class ShowAllEmployee extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
		EmployeeOperation obj=new EmployeeOperation();
		List<Employee> listOfEmployee = obj.getAllEmployee();
		System.out.println(listOfEmployee.size());

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.println("<!DOCTYPE html>");
		out.println("<html>");
		out.println("<head>");
		out.println("<title>Show All Employee</title>");
		out.println("</head>");
		out.println("<body>");
		out.println("<h1 align='center'>Show All Employee</h1>");
		out.println("<table align='center' cellspacing='30px'>");
		out.println("<th>");
		out.println("<td>First Name</td>");
		out.println("<td>Last Name</td>");
		out.println("<td>Email</td>");
		out.println("<td>Age</td>");
		out.println("</th>");
		int rowCount = 1;
		for (Employee employee : listOfEmployee) {
			out.println("<tr>");
			out.println("<td>" + rowCount + "</td>");
			// out.println("<td>"+employee.getId()+"</td>");
			out.println("<td>" + employee.getFirstName() + "</td>");
			out.println("<td>" + employee.getLastName() + "</td>");
			out.println("<td>" + employee.getEmail() + "</td>");
			out.println("<td>" + employee.getAge() + "</td>");
			out.println("<td><a href='UpdateHelper?id=" + employee.getId() + "'>Update</a></td>");
			rowCount++;
		}
		out.println("</table>");
		out.println("<a href='index.html'>Go to home page</a>");
		out.println("</body>");
		out.println("</html>");

	}
}
