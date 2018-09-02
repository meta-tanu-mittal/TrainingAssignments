package com.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dao.UserDao;
import com.model.User;

public class AddUser extends HttpServlet{
	
	public void doPost(HttpServletRequest req,HttpServletResponse res) throws IOException, ServletException
	{  System.out.println("hi");
		String firstName=req.getParameter("firstName");
		String lastName=req.getParameter("lastName");
		
		java.util.Date dob = null;
		try {
			dob = new SimpleDateFormat("yyyy-MM-dd").parse(req.getParameter("dob"));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		String contact=req.getParameter("contact");
		String email=req.getParameter("email");
		String password=req.getParameter("password");
		String organization=req.getParameter("organization");
		

		PrintWriter out=res.getWriter();
		System.out.println(firstName+" "+lastName);
		
		User user=new User(firstName,lastName,dob,contact,email,password,organization);
		UserDao obj=new UserDao();
		if(obj.addUser(user))
		{   out.println("<script>alert('user registered successfully!!')</script>");
			HttpSession session = req.getSession();
			session.setAttribute("userDetail", user);
			RequestDispatcher requestDispatcher = req.getRequestDispatcher("UserProfile");
			requestDispatcher.forward(req, res);
			
		}
		else
		{
			out.println("<script>alert('user not registered!!')</script>");
		}
		
		
	}
	
	

	
	
	
}
