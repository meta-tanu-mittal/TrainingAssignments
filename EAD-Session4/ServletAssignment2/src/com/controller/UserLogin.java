package com.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dao.UserDao;
import com.model.User;

public class UserLogin extends HttpServlet{
	
	
	public void doPost(HttpServletRequest req,HttpServletResponse res) throws ServletException, IOException
	{
	  String email=req.getParameter("email");
	  String password=req.getParameter("password");
	  UserDao obj=new UserDao();
	  
	  User user=obj.isValidUser(email, password);
	  if(user!=null)
	  {
		    HttpSession session = req.getSession();
			session.setAttribute("userDetail", user);
			RequestDispatcher requestDispatcher = req.getRequestDispatcher("/UserProfile");
			requestDispatcher.forward(req, res);  
	  }
	  else
	  {
		  
	  }
	}
}
