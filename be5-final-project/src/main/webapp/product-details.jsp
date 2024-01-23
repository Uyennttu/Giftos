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
		<jsp:include page="/header-section.jsp"/>
		
		<!-- shop section -->

		<section class="shop_section layout_padding">
			<div class="container">
				<div class="heading_container heading_center">
					<h2>Product Description</h2>
				</div>
				<div class="row">
					
						<div class="col-sm-6 col-md-4 col-lg-3">
							<div class="box">
								<a href="Product?productId=${product.id}">
									<div class="img-box">
										<img src="images/${product.imgName}" alt="">
									</div>
									<div class="detail-box">
										<h6>${product.name}</h6>
										<h6>
											Price <span> $${product.price} </span>
										</h6>
									</div> <c:if test="${product.isNew}">
										<div class="new">
											<span> New </span>

										</div>
									</c:if>
								</a>
							</div>

						</div>
						<div class="col-sm-6 col-md-4 col-lg-9">
					<div class="box">
						Quantity : ${product.quantity} <br> Description :
						${product.description}
					</div>
					<br>
					<div>
					<!-- Shopping cart -->
					<form action="Cart">
					<input type="text" value="ADD_TO_CART" name="action" hidden="true">
						<input type="text" value="${product.id}" name="productId" hidden="true">
					<input type="submit" value="ADD TO CART">
					</form>
					
					<!-- End shopping cart -->
					</div>
				</div>
					
				</div>
			</div>
			<c:if test="${not empty searchResultMessage}">
				<div class="heading_container heading_center">
					<p style="color: red;">${searchResultMessage}</p>
				</div>
			</c:if>


			<div class="btn-box">
				<a href="Home?action=SHOW_ALL_PRODUCTS"> View All Products </a>
			</div>
			
	</div>
	
	</section>

	<!-- end shop section -->
	
<jsp:include page="footer-section.jsp"/>

</body>

</html>