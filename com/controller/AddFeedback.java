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


@WebServlet("/AddFeedback")
public class AddFeedback extends HttpServlet {
	private static final long serialVersionUID = 1L;
       Feedback f=new Feedback();
       BLManager bl=new BLManager();
       Patient p=new Patient();
    
    public AddFeedback() {
        super();
       
    }

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    String id=request.getParameter("pid");
		p=bl.searchbyId(id);
		
		String pname=request.getParameter("pname");
		String q1=request.getParameter("q1");
		String q2= request.getParameter("q2");
		String q3=request.getParameter("q3");
		String q4=request.getParameter("q4");
		String q5=request.getParameter("q5");
		String q6= request.getParameter("q6");
		String q7=request.getParameter("q7");
		String q8=request.getParameter("q8");
		String q9=request.getParameter("q8");

		String comments=request.getParameter("comments");
f.setAttendantname(pname);
		f.setQ1(q1);
		f.setQ2(q2);
		f.setQ3(q3);
		f.setQ4(q4);
		f.setQ5(q5);
		f.setQ6(q6);
		f.setQ7(q7);
		f.setQ8(q8);
		f.setQ9(q9);
		f.setQ10(comments);
		f.setStatus("Completed");
		
		f.setPatient(p);
		
		bl.saveFeedback(f);
		PrintWriter out=response.getWriter();
		 out.println("<script type=\"text/javascript\">");
			out.println("alert('Feedback Added Successfully');");
			out.println("location='Feedback.jsp';");
			out.println("</script>");
	

	}

}
