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
			<h3>Log in and get exploring</h3>
			<p>Log into your account or create one below.</p>


			<c:if test="${not empty errorMessage}">
				<p style="color: red;">${errorMessage}</p>
			</c:if>
		</div>
		<br>
	</div>
	<div class="container container-bg">
		<div class="heading_container heading_center">
			<div class="row">
				<div class="col-md-6 col-lg-5 px-0">


					<form action="Authentication">
						<label for="uname">Username:</label><br> <input type="text"
							id="uname" name="username" placeholder="Enter your username"><br>
						<br> <label for="pwd">Password:</label><br> <input
							type="text" id="pwd" name="password"
							placeholder="Enter your password"><br> <br> <input
							type="submit" value="Submit">
					</form>


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