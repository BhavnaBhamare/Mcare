package com.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.model.BLManager;
import com.pojo.User;

/**
 * Servlet implementation class UserServlet
 */
@WebServlet("/UserServlet")
public class UserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	User u=new User(); 
	BLManager bl=new BLManager();
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name=request.getParameter("name");
		String password=request.getParameter("password");
		String email= request.getParameter("email");
		String contact=request.getParameter("contact");
		String address=request.getParameter("address");
		
		u.setAddress(address);
		u.setContact(contact);
		u.setEmail(email);
		u.setName(name);
		u.setPassword(password);
		PrintWriter out = response.getWriter();
		bl.saveUser(u);
		out.println("<script type=\"text/javascript\">");
		out.println("alert('User Added Successfully');");
		out.println("location='AdminPanel.jsp';");
		out.println("</script>");
		
	}

}
