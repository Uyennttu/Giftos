<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>

<head>
<!-- Basic -->
<meta charset="utf-8" />
<meta http-equiv="X-UA-Compatible" content="IE=edge" />
<!-- Mobile Metas -->
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no" />
<!-- Site Metas -->
<meta name="keywords" content="" />
<meta name="description" content="" />
<meta name="author" content="" />
<link rel="shortcut icon" href="images/favicon.png" type="image/x-icon">

<title>Giftos</title>

<!-- slider stylesheet -->
<link rel="stylesheet" type="text/css"
	href="https://cdnjs.cloudflare.com/ajax/libs/OwlCarousel2/2.3.4/assets/owl.carousel.min.css" />

<!-- bootstrap core css -->
<link rel="stylesheet" type="text/css" href="css/bootstrap.css" />

<!-- Custom styles for this template -->
<link href="css/style.css" rel="stylesheet" />
<!-- responsive style -->
<link href="css/responsive.css" rel="stylesheet" />

</head>

<body>
	<div class="hero_area">
		<!-- header section starts -->
		<header class="header_section">
			<nav class="navbar navbar-expand-lg custom_nav-container ">
				<a class="navbar-brand" href="index.html"> <span> Giftos
				</span>
				</a>
			</nav>
		</header>
	</div>


	<!-- login session -->
	<div class="container">
		<div class="heading_container heading_center">
			<h3>Create a new account</h3>

		
		<br>
	</div>
	<div class="container container-bg">
		
				<div class="col-md-6 col-lg-5 px-4">
				<c:if test="${not empty errorMessage}">
				<p style="color: red;">${errorMessage}</p>
			</c:if>

					<!-- Form -->
					<form action="Register" method="post">
						<label for="email">Email:</label><br> 
						<input type="text" id="email" name="email" placeholder="Enter your email"><br><br>
						
						<label for="username">Username:</label><br> 
						<input type="text" id="uname" name="username" placeholder="Enter your username"><br><br> 
						
						<label for="password">Password:</label><br> 
						<input type="text" id="pwd" name="password" placeholder="Enter your password"><br><br>
						
						<label for="firstname">Firstname:</label><br> 
						<input type="text" id="fname" name="firstname" placeholder="Enter your firstname"><br><br> 
						
						<label for="lastname">Lastname:</label><br> 
						<input type="text" id="lname" name="lastname" placeholder="Enter your lastname"><br><br>
						
						<label for="gender">Gender:</label> 
						<select name="gender" id="gender">
							<option value="male">Male</option>
							<option value="female">Female</option>
							<option value="others">Others</option>
						</select> <br><br> 
						
						<label for="interest">Interest?</label><br> 
						<input type="checkbox" id="luxury" name="interest" value="luxury">
						<label for="luxury">Luxury Brand</label><br>
						
						<input type="checkbox" id="medium" name="interest" value="medium">
						<label for="medium">Medium Brand</label><br>
						
						<input type="checkbox" id="budget" name="interest" value="budget">
						<label for="budget">Budget</label><br>
						
						<input type="checkbox" id="local" name="interest" value="local">
						<label for="local">Local</label><br>
						
						<input type="checkbox" id="national" name="interest" value="national">
						<label for="national">National</label><br>
						
						<input type="checkbox" id="international" name="interest" value="international">
						<label for="international">International</label><br><br>

						<input type="submit" value="Register">
					</form>
					<!-- Form -->

				</div>
			</div>
		</div>
	</div>
	<br>

	<!-- end login session -->


	<!-- info section -->

	<section class="info_section  layout_padding2-top">
		<div class="social_container">
			<div class="social_box">
				<a href=""> <i class="fa fa-facebook" aria-hidden="true"></i>
				</a> <a href=""> <i class="fa fa-twitter" aria-hidden="true"></i>
				</a> <a href=""> <i class="fa fa-instagram" aria-hidden="true"></i>
				</a> <a href=""> <i class="fa fa-youtube" aria-hidden="true"></i>
				</a>
			</div>
		</div>
		<div class="info_container ">
			<div class="container">
				<div class="row">
					<div class="col-md-6 col-lg-3">
						<h6>ABOUT US</h6>
						<p>Lorem ipsum dolor sit amet, consectetur adipiscing elit,
							sed doLorem ipsum dolor sit amet, consectetur adipiscing elit,
							sed doLorem ipsum dolor sit amet,</p>
					</div>
					<div class="col-md-6 col-lg-3">
						<div class="info_form ">
							<h5>Newsletter</h5>
							<form action="#">
								<input type="email" placeholder="Enter your email">
								<button>Subscribe</button>
							</form>
						</div>
					</div>
					<div class="col-md-6 col-lg-3">
						<h6>NEED HELP</h6>
						<p>Lorem ipsum dolor sit amet, consectetur adipiscing elit,
							sed doLorem ipsum dolor sit amet, consectetur adipiscing elit,
							sed doLorem ipsum dolor sit amet,</p>
					</div>
					<div class="col-md-6 col-lg-3">
						<h6>CONTACT US</h6>
						<div class="info_link-box">
							<a href=""> <i class="fa fa-map-marker" aria-hidden="true"></i>
								<span> Gb road 123 london Uk </span>
							</a> <a href=""> <i class="fa fa-phone" aria-hidden="true"></i> <span>+01
									12345678901</span>
							</a> <a href=""> <i class="fa fa-envelope" aria-hidden="true"></i>
								<span> demo@gmail.com</span>
							</a>
						</div>
					</div>
				</div>
			</div>
		</div>
		<!-- footer section -->
		<footer class=" footer_section">
			<div class="container">
				<p>
					&copy; <span id="displayYear"></span> All Rights Reserved By <a
						href="https://html.design/">Free Html Templates</a>
				</p>
			</div>
		</footer>
		<!-- footer section -->

	</section>

	<!-- end info section -->


	<script src="js/jquery-3.4.1.min.js"></script>
	<script src="js/bootstrap.js"></script>
	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/OwlCarousel2/2.3.4/owl.carousel.min.js">
		
	</script>
	<script src="js/custom.js"></script>

</body>

</html>