<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Wel-Come</title>
<link rel="icon" href="images/resitration_ion.png">
<link rel="stylesheet" href="welcome.css">
<script defer src="welcome.js"></script>
<link rel="stylesheet"href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.1.1/css/all.min.css" integrity="sha512-KfkfwYDsLkIlwQp6LFnl8zNdLGxu9YAA1QvwINks4PhcElQSvqcyVLLD9aMhXd13uQjoXtEKNosOWaZqXgel0g=="crossorigin="anonymous" referrerpolicy="no-referrer" />


<style>
video {
	position: fixed;
	top: 50%;
	left: 50%;
	min-width: 100%;
	min-height: 100%;
	width: auto;
	height: auto;
	z-index: -1;
	transform: translateX(-50%) translateY(-50%);
	background: cover;
	object-fit: cover;
}
</style>
</head>
<body>
	<video autoplay muted loop id="myVideo">
		<source src="images/ground.mp4" type="video/mp4">
	</video>

	<div class="container" id="container">
		<div class="form-container sign-up-container">
			<form action="signup" method="post">
				<h1>Create Account</h1>
				<input type="text" placeholder="First Name" name="first_name" required/> 
				<input type="text" placeholder="Last Name" name="last_name" required/> 
				<input type="email" placeholder="Email" name="email" required/>
				<input type="text" placeholder="Phone Number" name="phone" required/> 
				<input type="text" placeholder="Address" name="address" required/> 
				<input type="password" placeholder="Password" name="password" required/>
				<input type="password" placeholder="Confirm  Password" name="password_1" required/>
				<label for="user_type" style="color: black; font-size:16; margin-left: -220px; display: block; margin-bottom: 10px;">Select User Role:</label>
				<select id="user_type" name="role" style="margin-top: -25px">
					<option value="buyer">Buyer</option>
    				<option value="seller">Farmer</option>
				</select>
				<button>Sign Up</button>
			</form>
		</div>
		<div class="form-container sign-in-container">
				
			<form action="login" method="post">
				<h1>Login</h1>
				<div class="social-container">
					<a href="#" class="social"><i class="fab fa-facebook-f"></i></a> 
					<a href="#" class="social"><i class="fab fa-google-plus-g"></i></a> 
					<a	href="#" class="social"><i class="fab fa-linkedin-in"></i></a>
				</div>
				
				<input type="email" placeholder="Email" name="email" required/>
				<input type="password" placeholder="Password" name="password" required/>
				<a href="forgotpassword.jsp">Forgot your password?</a>
				<button>Login</button>
			</form>
		</div>
		<div class="overlay-container">
			<div class="overlay">
				<div class="overlay-panel overlay-left">
					<h1>Welcome Back!</h1>
					<p>
						To keep connected with us<br> please login with your personal
						info
					</p>
					<button class="ghost" id="signIn">Login</button>
				</div>
				<div class="overlay-panel overlay-right">
				<%
				String message = (String)request.getAttribute("message");
				if(message != null){
				%>
				<h2><%= message %></h2>
				<%
				}
				%>
					<h1>Hello, Friend!</h1>
					<p>
						Enter your personal details and <br>start journey with us
					</p>
					<button class="ghost" id="signUp">Sign Up</button>
				</div>
			</div>
		</div>
	</div>
	<script>
 		 document.addEventListener('DOMContentLoaded', function () {
  		 document.querySelector('form[action="signup"]').addEventListener('submit', function (event) {
      // Validate password
  		    var password = document.querySelector('input[name="password"]').value;
  		    var confirmPassword = document.querySelector('input[name="password_1"]').value;
  		    var passwordField = document.querySelector('input[name="password"]');
  		    var confirmPasswordField = document.querySelector('input[name="password_1"]');

      // Remove any previous visual indications
  		    passwordField.classList.remove('password-mismatch');
  		    confirmPasswordField.classList.remove('password-mismatch');

  		    if (password.trim() === '' || password !== confirmPassword) {
   		     alert("Passwords do not match Pless enter valid Password");
   		     passwordField.classList.add('password-mismatch');
   		     confirmPasswordField.classList.add('password-mismatch');
        
        // Clear password and confirm password fields
   		     passwordField.value = '';
   		     confirmPasswordField.value = '';

    	    event.preventDefault();
     		   return;
      }
    });
  });
</script>


</body>
</html>