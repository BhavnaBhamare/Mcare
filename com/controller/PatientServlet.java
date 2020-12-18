package com.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.model.BLManager;
import com.pojo.Patient;


@WebServlet("/PatientServlet")
public class PatientServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       Patient p= new Patient();
       
       BLManager bl=new BLManager();
    
    public PatientServlet() {
        super();
        
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//doGet(request, response);
		 String pid=request.getParameter("pid");
		 String pname=request.getParameter("pname");
		 String email=request.getParameter("email");
		 String address=request.getParameter("address");
		 String mobileno=request.getParameter("mobileno");
		 String ptype=request.getParameter("ptype");
		 String bedno=request.getParameter("bedno");
		 String doctor=request.getParameter("doctor");
		
		p.setAddress(address);
		p.setBedno(bedno);
		p.setDoctor(doctor);
		p.setEmail(email);
		p.setMobileno(mobileno);
		p.setPname(pname);
		p.setPtype(ptype);
		p.setPid(pid);
	
		 
		 bl.savePatient(p);
		 PrintWriter out=response.getWriter();
		 out.println("<script type=\"text/javascript\">");
			out.println("alert('Patient Added Successfully');");
			out.println("location='PatientDetails.jsp';");
			out.println("</script>");
	}

}
