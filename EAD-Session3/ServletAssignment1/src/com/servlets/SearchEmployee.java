package com.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.database.EmployeeOperation;
import com.model.Employee;

public class SearchEmployee extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String firstName = request.getParameter("firstName");
		String lastName = request.getParameter("lastName");
		EmployeeOperation obj=new EmployeeOperation();
		
		List<Employee> listOfEmployee =obj.searchEmployee(firstName, lastName); 

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.println("<!DOCTYPE html>");
		out.println("<html>");
		out.println("<head>");
		out.println("<title>Show Employees</title>");
		out.println("</head>");
		out.println("<body>");
		out.println("<h1 align='center'>Employee Details:</h1>");
		out.println("<table align='center' cellspacing='40px'>");
		out.println("<th>");
		out.println("<td><b>First Name</b></td>");
		out.println("<td><b>Last Name</b></td>");
		out.println("<td><b>Email</b></td>");
		out.println("<td><b>Age</b></td>");
		out.println("</th>");
		int rowCount = 1;
		for (Employee employee : listOfEmployee) {
			out.println("<tr>");
			out.println("<td>" + rowCount + "</td>");
			out.println("<td>" + employee.getFirstName() + "</td>");
			out.println("<td>" + employee.getLastName() + "</td>");
			out.println("<td>" + employee.getEmail() + "</td>");
			out.println("<td>" + employee.getAge() + "</td>");
			out.println("</tr>");
			rowCount++;
		}
		out.println("</table>");
		out.println("<a href='index.html'>Go to home page</a> ");
		out.println("</body>");
		out.println("</html>");

	}

}
