package ru.unlimit;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet(urlPatterns="/ParametersServletUrl", loadOnStartup=0  ,description="servlet description", displayName="displayName")
public class ParametersServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	
       
    @Override
	public void init() throws ServletException {
		super.init();
		System.out.println("Initialization of servlet");
	}



	@Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    	String user = req.getParameter("user");
    	HttpSession session = req.getSession();
    	ServletContext context = req.getServletContext();
    	if (user != "" && user != null) {
    		session.setAttribute("user", user);
    		context.setAttribute("user", user);
    	}
    
    	//session.setMaxInactiveInterval(5);
//    	resp.setContentType("text/html");
//    	resp.setCharacterEncoding("UTF-8");
    	// or
    	
    	resp.setContentType("text/html;charset=utf-8");
    	
    	PrintWriter out = resp.getWriter();
    	out.println("Request parameter: " + user + "<br>");
    	out.println("Session parameter: " + session.getAttribute("user") + "<br>");
    	out.println("Context parameter: " + context.getAttribute("user") + "<br>");
    	out.println("<a href='http://localhost:8080/WebApp/Parameters.html'>Назад</a><br>");
    	out.close();
    	
    	System.out.println("session time in seconds: " + session.getMaxInactiveInterval());
    } 

}
