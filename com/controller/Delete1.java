package com.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.model.BLManager;
import com.pojo.Feedback;
import com.pojo.Patient;

/**
 * Servlet implementation class DeletePatient
 */
@WebServlet("/Delete1")
public class Delete1 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	   
	  BLManager bl = new BLManager();
	  Feedback f = new Feedback();
		Patient p = new Patient();
    public Delete1() {
        super();
        
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		/*response.getWriter().append("Served at: ").append(request.getContextPath());*/
	
		/*String pid=request.getParameter("pid");
		
		p=bl.searchbyPatientId(pid);
		bl.deletePatient(p);
		PrintWriter out=response.getWriter();
		 out.println("<script type=\"text/javascript\">");
			out.println("alert('Patient Deleted Successfully');");
			out.println("location='ViewFeedback.jsp';");
			out.println("</script>");*/
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	
        String pid=request.getParameter("id");
		
		p=bl.searchbyPatientId(pid);
		bl.deletePatient(p);
		PrintWriter out=response.getWriter();
		    out.println("<script type=\"text/javascript\">");
			out.println("alert('Patient Deleted Successfully');");
			out.println("location='ViewFeedback.jsp';");
			out.println("</script>");
	
	}

}
