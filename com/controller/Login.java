package com.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.model.BLManager;
import com.pojo.User;


@WebServlet("/Login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
    User u=new User();
  BLManager bl=new BLManager();
    public Login() {
        super();
       
    }

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		PrintWriter out = response.getWriter();
		HttpSession session = request.getSession();

		String email = request.getParameter("email");
		String password = request.getParameter("password");

	         u=bl.search(email, password);
	       
	       
              if(email.equals("admin")&& password.equals("admin"))
              {
            	  
            		out.println("<script type=\"text/javascript\">");
    				out.println("alert('Welcome to Admin Panel');");
    				out.println("location='AdminPanel.jsp';");
    				out.println("</script>");
              }	
              if(u!=null)
    				{
    				 
    				 
    				 
    			      out.println("<script type=\"text/javascript\">");
    	    				out.println("alert('Welcome to User Panel');");
    	    				out.println("location='UserPanel.jsp';");
    	    				out.println("</script>");
    						
    				
    				}
    				  else {
    						out.println("<script type=\"text/javascript\">");
    						out.println("alert('Please Provide Correct Email Id & Password');");
    						out.println("location='Login.jsp';");
    						out.println("</script>");
    					}
    				
	}

}
