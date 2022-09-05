
<html>
<head>
<title>Registration Page</title>
<link rel="stylesheet" href="design-registration.css">
</head>
<body>
<div class="registration-form">
<h1>Registration Form</h1>
<form action="registration" method="post">
<p>First Name: </p>
<input type="text" name="firstname" maxlength="30"placeholder="Enter First Name" required>
<p>Last Name:</p> 
<input type="text" name="lastname" maxlength="30"placeholder="Enter Last Name" required>
<p>Email ID:</p>
 <input type="email" name="email" pattern="[a-z0-9._%+-]+@[a-z0-9.-]+\.[a-z]{2,4}$" maxlength="256"  placeholder="Enter Email ID" required>
<p>Password:</p>
 <input type="password" name="password"  pattern="(?=.*\d)(?=.*[a-z])(?=.*[A-Z]).{8,}" placeholder="Enter Password"required>
<p> Confirm Password:</p>
 <input type="password"  name="confirmpassword" pattern="[0-9a-zA-Z]+{0,9}"  placeholder="Enter Confirm Password"required>
<button type="submit" value="Register">Register</button>
<a href="home.jsp">Click Here To Login</a>
</form>

</div>

</body>
</html>