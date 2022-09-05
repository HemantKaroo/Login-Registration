
<html>
<head>
<title>Home Page</title>
<link rel="stylesheet" href="design-home.css">
</head>
<body>

<%
 
String email=request.getAttribute("email")!=null?((String)request.getAttribute("email")):"";
%>
	<div class="center">
		<h1>Login Page</h1>
		<form action="login" method="post">
			<div class="text-field">
			
				<input type="text" name="email" value="<%=email%>"
					pattern="[a-z0-9._%+-]+@[a-z0-9.-]+\.[a-z]{2,4}$" maxlength="256"
					name="email" placeholder="Enter Email-ID" required> <span></span>

			</div>
			<div class="text-field">
				<input type="password" name="password" pattern="(?=.*\d)(?=.*[a-z])(?=.*[A-Z]).{8,}"
					placeholder="Enter Password" required> <span></span>


			</div>
			<input type="submit" value="Login">

		</form>
		<div class="reg-link">
			<a href="registration.jsp"> New Registration </a>
		</div>
	</div>
</body>
</html>