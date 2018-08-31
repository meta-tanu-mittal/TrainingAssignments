package com.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.database.EmployeeOperation;
import com.model.Employee;

public class UpdateEmployee extends HttpServlet {

	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

		PrintWriter out = res.getWriter();
		int id = Integer.parseInt(req.getParameter("id"));
		String firstName = req.getParameter("firstName");
		String lastName = req.getParameter("lastName");
		String email = req.getParameter("email");
		int age = Integer.parseInt(req.getParameter("age"));
		Employee employee = new Employee(firstName, lastName, email, age);
		employee.setId(id);

		EmployeeOperation obj=new EmployeeOperation();
		if(obj.updateEmployee(employee))
		{
			out.println("<script>alert('employee updated successfully!!')</script>");
		}
		else
		{
			out.println("<script>alert('error:')</script>");
		}
		RequestDispatcher rd=req.getRequestDispatcher("index.html");
		rd.include(req, res);

		out.close();
	}

}
