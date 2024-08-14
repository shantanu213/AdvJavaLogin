package in.pack;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import org.apache.jasper.tagplugins.jstl.core.Out;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/loginform")
public class login extends HttpServlet
{
 @Override
protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException 
 {
	 PrintWriter out=resp.getWriter();
	 String name1 =req.getParameter("name");
	 String mypass=req.getParameter("pass2");
	 
	 try
	 {
		 resp.setContentType("text/html");
		 	 
		 Class.forName("com.mysql.cj.jdbc.Driver");
		 Connection con =DriverManager.getConnection("jdbc:mysql://localhost:3306/std_1","root","1234");
		   
		   PreparedStatement ps=con.prepareStatement("Select * from register where name=? and password=? ");
		   ps.setString(1,name1);
		   ps.setString(2,mypass);
		   
		 ResultSet rs=  ps.executeQuery();
		 if(rs.next())
		 {
			 RequestDispatcher rd =req.getRequestDispatcher("/profile.jsp");
			 rd.include(req, resp);
			 
		 }
		 else
		 {		 
			 out.print("<h3 style='color:red'>Email id and password didnt match</h3>");
			 
			 RequestDispatcher rd =req.getRequestDispatcher("/login.jsp");
			 rd.include(req, resp);
		 }
	 }
	 catch(Exception e) 
	 {
		 System.out.println(e);
		 
		
		out.print("<h3 style='color:red'>"+e.getMessage()+"</h3>");
		 
		 RequestDispatcher rd =req.getRequestDispatcher("/login.jsp");
		 rd.include(req, resp);	
	 }
 }
}
