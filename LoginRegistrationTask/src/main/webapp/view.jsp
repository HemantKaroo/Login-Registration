
<%@page import="com.project.User"%>
<html>
<head>
</head>
<body>


	<%
	
	response.setHeader("Cache-Control", "no-cache,no-store,must-revalidate");
	User user = (User) session.getAttribute("user");
	if (user != null) {
		String firstName = user.getFirstName();
		String lastName = user.getLastName();
	%>
	<h1>
		Hello
		<%=firstName%></h1>
	<a href="logout">Logout</a>
	<%
	} else {
	out.print("Please Login First");
	request.getRequestDispatcher("home.jsp");

	}
	%>
</body>
</html>