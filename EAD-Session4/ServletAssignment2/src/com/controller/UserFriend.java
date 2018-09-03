package com.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dao.UserDao;
import com.model.User;


public class UserFriend extends HttpServlet{
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException {
	
		System.out.println("hi");
		HttpSession session=req.getSession();
		User user=(User) session.getAttribute("userDetail");
	
	UserDao obj=new UserDao();
	List<User> listOfUser = obj.getAllFriend(user.getOrganization(),user.getEmail());
	System.out.println(listOfUser.size());

	res.setContentType("text/html");
	PrintWriter out = res.getWriter();
	out.println("<!DOCTYPE html>");
	out.println("<html>");
	out.println("<head>");
	out.println("<title>Friends list</title>");
	out.println("</head>");
	out.println("<body>");
	out.println("<h1 align='center'>Friends</h1>");
	out.println("<table align='center' cellspacing='30px'>");
	out.println("<tr>");
	out.println("<th>SNo</td>");
	out.println("<th>First Name</td>");
	out.println("<th>Last Name</td>");
	out.println("<th>Email</td>");
	//out.println("<th>Age</td>");
	out.println("</tr>");
	int rowCount = 1;
	for (User u : listOfUser) {
		out.println("<tr>");
		out.println("<td>" + rowCount + "</td>");
		// out.println("<td>"+employee.getId()+"</td>");
		out.println("<td>" + u.getFirstName() + "</td>");
		out.println("<td>" + u.getLastName() + "</td>");
		out.println("<td>" + u.getEmail() + "</td>");
		//out.println("<td>" + u.getAge() + "</td>");
		//out.println("<td><a href='UpdateHelper?id=" + u.getId() + "'>Update</a></td>");
		out.println("</tr>");
		rowCount++;
	}
	out.println("</table>");
	out.println("<a href='index.html'>Go to home page</a>");
	out.println("</body>");
	out.println("</html>");

}
}

