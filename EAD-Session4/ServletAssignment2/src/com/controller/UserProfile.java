package com.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.model.User;


public class UserProfile extends HttpServlet{
	
	public void doPost(HttpServletRequest req,HttpServletResponse res)
	{   
		HttpSession session = req.getSession();

		User user=(User) session.getAttribute("userDetail");
		
		PrintWriter out;
		try {
			out = res.getWriter();
		
		res.setContentType("text/html");
		out.println("<!DOCTYPE html>");
		out.println("<html>");
		out.println("<head>");
		out.println("<title>Update</title>");
		out.println("</head>");
		
		out.println("<body>");
		out.println("<a href='UserFriend'>Friends</a>");
		
		out.println("<h1 align='center'>User Profile</h1>");
		
		
		out.println("<form action='UserProfile' method='get'>");
		out.println("<table align='left' cellspacing='30px' >");

		
		out.println("<tr><td>First Name</td>");
		out.println("<td>" + user.getFirstName()+ "</td></tr>");
		out.println("<tr><td>Last Name</td>");
		out.println("<td>" +user.getLastName() + "</td></tr>");
		out.println("<tr><td>DateOfBirth</td>");
		out.println("<td>" +user.getDob() + "</td></tr>");
		out.println("<tr><td>Contact</td>");
		out.println("<td>" +user.getContact() + "</td></tr>");
		out.println("<tr><td>Email</td>");
		out.println("<td>" + user.getEmail()+ "</td><br></tr>");
		out.println("<tr><td>Organization</td>");
		out.println("<td>" + user.getOrganization()+ "</td></tr>");
		out.println("<tr><td><input type='submit' value='Edit'/></td></tr>");
		out.println("</table>");
		out.println("</form><br>");
		
		

		out.println("</body>");
		out.println("</html>");
		out.close();
		}
		catch (IOException e) {
	
			e.printStackTrace();
		}
		
	}
	
	public void doGet(HttpServletRequest req,HttpServletResponse res)
	{   
		HttpSession session = req.getSession(false);

		User user=(User) session.getAttribute("userDetail");
		
		PrintWriter out;
		try {
			out = res.getWriter();
		
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
		out.println("<tr><td>First Name</td>");
		out.println("<td><input type='text' name = 'firstName' value='" + user.getFirstName()+ "'/></td></tr>");
		out.println("<tr><td>Last Name</td>");
		out.println("<td><input type='text' name = 'lastName' value='" +user.getLastName() + "'/></td></tr>");
		out.println("<tr><td>Email</td>");
		out.println("<td><input type='text' name = 'email' value='" +user.getEmail() + "' readonly/></td></tr>");
		out.println("<tr><td>Date Of Birth</td>");
		out.println("<td><input type='date' name = 'date' value='" + user.getDob()+ "'/></td><br></tr>");
		out.println("<tr><td>Contact</td>");
		out.println("<td><input type='text' name = 'contact' value='" + user.getContact()+ "'/></td></tr>");
		out.println("<tr><td>Organization</td>");
		out.println("<td><input type='text' name = 'organization' value='" + user.getOrganization()+ "'/></td></tr>");
		out.println("<tr><td><input type='submit' value='update'/></td></tr>");
		out.println("</table>");
		out.println("</form>");
		out.println("<a href='index.html'>Go to home page</a>");

		out.println("</body>");
		out.println("</html>");
		out.close();
		}
		catch (IOException e) {
	
			e.printStackTrace();
		}
		
	}


}
