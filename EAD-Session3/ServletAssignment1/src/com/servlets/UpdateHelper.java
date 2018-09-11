package com.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.database.EmployeeOperation;
import com.model.Employee;

public class UpdateHelper extends HttpServlet {

	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		EmployeeOperation obj=new EmployeeOperation();
		Employee emp =obj.searchById(Integer.parseInt(req.getParameter("id")));
		//System.out.println(emp.toString());
		PrintWriter out = res.getWriter();

		res.setContentType("text/html");
		out.println("<!DOCTYPE html>");
		out.println("<html>");
		out.println("<head>");
		out.println("<title>Update</title>");
		out.println("</head>");
		out.println("<body>");
		out.println("<h1 align='center'>Update</h1>");
		out.println("<form action='UpdateEmployee'>");
		out.println("<table align='center' cellspacing='30px' >");

		out.println("<tr><td>Id</td>");
		out.println("<td><input type='text' name = 'id' value='" + emp.getId() + "' readonly/></td></tr>");
		out.println("<tr><td>First Name</td>");
		out.println("<td><input type='text' name = 'firstName' value='" + emp.getFirstName() + "'/></td></tr>");
		out.println("<tr><td>Last Name</td>");
		out.println("<td><input type='text' name = 'lastName' value='" + emp.getLastName() + "'/></td></tr>");
		out.println("<tr><td>Email</td>");
		out.println("<td><input type='text' name = 'email' value='" + emp.getEmail() + "' readonly/></td><br></tr>");
		out.println("<tr><td>First Name</td>");
		out.println("<td><input type='text' name = 'age' value='" + emp.getAge() + "'/></td></tr>");
		out.println("<tr><td><input type='submit' value='update'/></td></tr>");
		out.println("</table>");
		out.println("</form>");
		out.println("<a href='index.html'>Go to home page</a>");

		out.println("</body>");
		out.println("</html>");
		out.close();
	}

}
