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


@WebServlet("/Delete")
public class Delete extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
  BLManager bl = new BLManager();
  Feedback f = new Feedback();
	Patient p = new Patient();
    public Delete() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id1=request.getParameter("id");
		 int i=Integer.parseInt(id1);
		f=bl.searchbyFeedbackId(i);
		bl.deleteFeedback(f);
		PrintWriter out=response.getWriter();
		 out.println("<script type=\"text/javascript\">");
			out.println("alert('Feedback Deleted Successfully');");
			out.println("location='ViewFeedback.jsp';");
			out.println("</script>");
	
	}

	
}
