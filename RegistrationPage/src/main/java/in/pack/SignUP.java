package in.pack;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/regform")
public class SignUP extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		PrintWriter out = resp.getWriter();

		String name = req.getParameter("name1");
		String Email = req.getParameter("email");
		String Pass = req.getParameter("pass1");
		String Gender = req.getParameter("gender");
		String City = req.getParameter("city1");

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/std_1", "root", "1234");

			PreparedStatement ps = con.prepareStatement("insert into register values(?,?,?,?,?)");
			ps.setString(1, name);
			ps.setString(2, Email);
			ps.setString(3, Pass);
			ps.setString(4, Gender);
			ps.setString(5, City);

			int count = ps.executeUpdate();
			if (count > 0) {
				resp.setContentType("text/html");
				out.print("<h3 style= 'color:green'>user register successfully<h3/>");

				RequestDispatcher rd = req.getRequestDispatcher("/reg.jsp");
				rd.include(req, resp);
			} else {
				resp.setContentType("text/html");
				out.print("<h3 style= 'color:red'>user register failed<h3/>");

				RequestDispatcher rd = req.getRequestDispatcher("/reg.jsp");
				rd.include(req, resp);
			}
		} catch (Exception e) {
			System.out.println(e);

			resp.setContentType("text/html");
			out.print("<h3 style= 'color:red'>" + e.getMessage() + "<h3/>");

			RequestDispatcher rd = req.getRequestDispatcher("/reg.jsp");
			rd.include(req, resp);
		}
	}

}
