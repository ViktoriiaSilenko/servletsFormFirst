package ru.unlimit;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet(urlPatterns="/MyServletUrl", description="servlet description", displayName="displayName")
public class MyServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /*@Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    	System.out.println("info");
    	String firstName = req.getParameter("firstName");
    	String secondName = req.getParameter("secondName");
    	
//    	resp.setContentType("text/html");
//    	resp.setCharacterEncoding("UTF-8");
    	// or
    	
    	resp.setContentType("text/html;charset=utf-8");
    	
    	PrintWriter out = resp.getWriter();
    	out.println("<h3>MyServlet.doGet " + firstName + " " + secondName + "</h3><br>Again");
    	out.close();
    }*/
    
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    	req.setCharacterEncoding("UTF-8");
    	
    	System.out.println("info");
    	String firstName = req.getParameter("firstName"); // "" if user enter nothing
    	String secondName = req.getParameter("secondName");
    	
    	//String job = req.getParameter("job"); // if not multiple selection
    	String [] jobs = req.getParameterValues("job");
    	
    	String gender = req.getParameter("gender"); // null if user enter nothing
    	if (gender == null) {
    		gender = "-";
    	}
    	String age18 = req.getParameter("age18"); // null if user enter nothing
    	if (age18 == null) {
    		age18 = "-";
    	}
    	
    	
//    	resp.setContentType("text/html");
//    	resp.setCharacterEncoding("UTF-8");
    	// or
    	
    	resp.setContentType("text/html;charset=utf-8");
    	
    	PrintWriter out = resp.getWriter();
    	out.println("<h3>Профиль сотрудника</h3>");
    	out.println("Имя: " + firstName + "<br>" );
    	out.println("Фамилия: " + secondName + "<br>" );
    	out.println("Профессия: " + Arrays.deepToString(jobs) + "<br>" );
    	out.println("Пол: " + gender + "<br>" );
    	out.println("Старше 18: " + age18 + "<br>" );
    	out.close();
    }

}
