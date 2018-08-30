package com.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.database.DBConnection;
import com.database.EmployeeOperation;
import com.model.Employee;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class AddEmployee extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String firstName = request.getParameter("firstName");
		String lastName = request.getParameter("lastName");
		String email = request.getParameter("email");
		int age = Integer.parseInt(request.getParameter("age"));
		// System.out.println(firstName+" "+lastName+" "+email+" "+age);

		Employee employee = new Employee(firstName, lastName, email, age);
		EmployeeOperation obj=new EmployeeOperation();
		obj.addEmployee(employee);

		PrintWriter out = response.getWriter();
		response.setContentType("index.html");

	}

}
