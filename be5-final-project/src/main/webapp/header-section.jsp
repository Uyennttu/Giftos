<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!-- header section starts -->
<header class="header_section">
	<nav class="navbar navbar-expand-lg custom_nav-container ">
		<a class="navbar-brand" href="index.html"> <span> Giftos </span>
		</a>
		<button class="navbar-toggler" type="button" data-toggle="collapse"
			data-target="#navbarSupportedContent"
			aria-controls="navbarSupportedContent" aria-expanded="false"
			aria-label="Toggle navigation">
			<span class=""></span>
		</button>

		<div class="collapse navbar-collapse" id="navbarSupportedContent">
			<ul class="navbar-nav  ">
				<li class="nav-item active"><a class="nav-link" href="Home">Home
						<span class="sr-only">(current)</span>
				</a></li>
				<c:forEach items="${categories}" var="category">
					<li class="nav-item"><a class="nav-link"
						href="Home?action=SHOW_PRODUCTS_BY_CATEGORY&categoryId=${category.id}">
							${category.name} </a></li>
				</c:forEach>



				<!-- search bar -->
				<form action="Home">
					<div class="col-md-6 col-lg-11 px-0 d-flex align-items-center">
						<input type="text" name="action" hidden value="SEARCH"> <input
							type="text" name="searchValue" class="form-control mr-2"
							placeholder="Search">
						<!-- <button class="btn nav_search-btn" type="submit">
										<i class="fa fa-search" aria-hidden="true"></i>
									</button> -->


						<div class="d-flex">
							<input type="submit" value="SEARCH">
						</div>
					</div>
				</form>
				<!-- end search bar -->
				<!-- login -->
				<div class="user_option">
					<c:if test="${empty sessionScope.user}">
						<a href="login.jsp"> <i class="fa fa-user" aria-hidden="true"></i>
							<span>Login</span></a>
						<a href="register.jsp"> <i class="fa fa-registered"
							aria-hidden="true"></i> <span>Register</span></a>
					</c:if>
					<c:if test="${not empty sessionScope.user}">

						<a href="#"> <i class="fa fa-user" aria-hidden="true"></i> <span>${sessionScope.user.username}</span>
						</a>
						<a href="Authentication?action=LOGOUT"> <span>Logout</span></a>
					</c:if>

					<!-- end login -->
					<a href="Cart?action=VIEW_CART"> <i class="fa fa-shopping-bag" aria-hidden="true"></i> (${sessionScope.cart.getItems().size()})
					</a>
				</div>

			</ul>
		</div>
	</nav>
</header>


<!-- end header section -->