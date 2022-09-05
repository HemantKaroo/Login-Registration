package com.project;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class RegistrationController extends HttpServlet {

	public void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {

		res.setContentType("text/html");
		PrintWriter out = res.getWriter();
		String firstName = req.getParameter("firstname");
		String lastName = req.getParameter("lastname");
		String emailId = req.getParameter("email");
		String userPass = req.getParameter("password");
		String confirmPass = req.getParameter("confirmpassword");

		if (userPass.equals(confirmPass)) {
			User user = new User();
			user.setFirstName(firstName);
			user.setLastName(lastName);
			user.setEmailId(emailId);
			user.setPassword(userPass);

			boolean check = UserDao.checkUserData(emailId);
			if (check) {
				RequestDispatcher rd = req.getRequestDispatcher("registration.jsp");
				out.print(
						"<center><style>h2{color:red;}</style><h2>Email ID Already Exists Please Check</h2></center>");
				rd.include(req, res);

			} else {

				int status = UserDao.insertData(user);
				if (status > 0) {
					RequestDispatcher rd = req.getRequestDispatcher("home.jsp");
					out.print(
							"<center><style>h1{color:green;}</style><h1>You Are Sucessfully Register....</h1></center>");
					rd.include(req, res);
				}
			}
		} else {
			RequestDispatcher rd = req.getRequestDispatcher("registration.jsp");
			out.print(
					"<center><style>h1{color:red;}</style><h2>Both Password Are Not Match Please Check</h1></center>");
			rd.include(req, res);
		}

	}
}
