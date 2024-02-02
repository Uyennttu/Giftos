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
		<jsp:include page="/header-section.jsp" />

		<!-- shop section -->

		<section class="shop_section layout_padding">
			<div class="container">
				<div class="heading_container heading_center">
					<h2>Order Details</h2>
				</div>
				<div class="row">
					<div class="col-sm-6 col-lg-12"></div>
					  <c:if test="${empty orders}">
                <p>No orders available</p>
            </c:if>
            <c:forEach var="order" items="${orders}">
                <p>Order ID: ${order.orderId}</p>
                <p>User ID : ${order.userId}</p>
               
            </c:forEach>
				</div>

				<c:if test="${not empty searchResultMessage}">
					<div class="heading_container heading_center">
						<p style="color: red;">${searchResultMessage}</p>
					</div>
				</c:if>


				<div class="btn-box">
					<a href=""> Paging </a>
				</div>
			</div>

		</section>

		<!-- end shop section -->

		<jsp:include page="footer-section.jsp" />
</body>

</html>