	package com.project;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LoginController extends HttpServlet {

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		String firstName = "", lastName = "";
		boolean recordExist = false;
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		String emailId = request.getParameter("email");
		String password = request.getParameter("password");
		String query = "select firstname,lastname from user where email='"+email+"' and password='" + password + "'";
		try {
			Connection con = UserDao.getConnection();
			Statement statement = con.createStatement();
			ResultSet resultSet = statement.executeQuery(query);
			recordExist = resultSet.isBeforeFirst();
			if (recordExist) {
				while (resultSet.next()) {
					firstName = resultSet.getString(1);
					lastName = resultSet.getString(2);
					}
				
				User user = new User();
				user.setFirstName(firstName);
				user.setLastName(lastName);
				user.setEmailId(emailId);
				HttpSession session = request.getSession();
				session.setAttribute("user", user);

				RequestDispatcher rd = request.getRequestDispatcher("view.jsp");
				rd.forward(request, response);

			} else {
				RequestDispatcher rd = request.getRequestDispatcher("home.jsp");
				request.setAttribute("email", emailId);
				out.print("<center><style>h2{color:red;}</style><h2>Enter Valid Email-Id And Password</h2></center>");
				rd.include(request, response);

			}

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		HttpSession session = request.getSession();
		session.invalidate();
		RequestDispatcher rd = request.getRequestDispatcher("home.jsp");
		out.print("<center><style>h2{color:green;}</style><h2>Sucessfully Logout<br></h2></center>");
		rd.include(request, response);
	}
}
