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
import com.pojo.Feedback;
import com.pojo.Patient;


@WebServlet("/Update")
public class Update extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   BLManager bl = new BLManager();
   Feedback f = new Feedback();
	Patient p = new Patient();
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String id1=request.getParameter("id");
		 int i=Integer.parseInt(id1);
		f=bl.searchbyFeedbackId(i);
		System.out.println(f.getQ1());
		HttpSession session=request.getSession();
		session.setAttribute("list",f);
		
		response.sendRedirect("update.jsp");

	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		PrintWriter out=response.getWriter();
		String feedid1 = request.getParameter("id");
		int feedid=Integer.parseInt(feedid1);
		String id = request.getParameter("pid");
		//String status=request.getParameter("status");
		String q1=request.getParameter("q1");
		String q2= request.getParameter("q2");
		String q3=request.getParameter("q3");
		String q4=request.getParameter("q4");
		String q5=request.getParameter("q5");
		String q6= request.getParameter("q6");
		String q7=request.getParameter("q7");
		String q8=request.getParameter("q8");
		String q9=request.getParameter("q9");
		String comments=request.getParameter("comments");
		String pname=request.getParameter("pname");
		
		
		
		p=bl.searchbyId(id);
		
		f.setAttendantname(pname);
		f.setFeedid(feedid);
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
		bl.updateFeedback(f);
		
		
		
		
		 out.println("<script type=\"text/javascript\">");
			out.println("alert('Feedback Updated Successfully');");
			out.println("location='ViewFeedback.jsp';");
			out.println("</script>");
	}

}
