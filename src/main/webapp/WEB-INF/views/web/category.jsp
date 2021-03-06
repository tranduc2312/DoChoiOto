<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ page session="false"%>

	<div class="container bg-light border-5 p-3 shadow-sm">
		<div class="row">
			<div class="col-lg-3">
				<ul class="list-group">
					<c:forEach var="listCate" items="${listCategory }">
						<li class="list-group-item bg-light" id="list-category"><a
							href="<c:url value="/${listCate.categoryCode }"/>"
							class="text-success">${listCate.categoryName }</a></li>
					</c:forEach>
				</ul>
			</div>
			<div class="col">
				<%-- <div class="row mb-4">
					<div class="col">
						<div class="carousel slide" data-ride="carousel" id="carousel-1">
							<div class="carousel-inner" role="listbox">
								<div class="carousel-item">
									<img class="w-100 d-block"
										src="<c:url value="/resources/img/DSC08346.jpg"/>"
										id="img-carousel">
								</div>
								<div class="carousel-item active">
									<img class="w-100 d-block"
										src="<c:url value="/resources/img/duc.jpg"/>"
										id="img-carousel">
								</div>
								<div class="carousel-item">
									<img class="w-100 d-block"
										src="<c:url value="/resources/img/doThoa1.jpg"/>"
										id="img-carousel">
								</div>
							</div>
							<div>
								<a class="carousel-control-prev" href="#carousel-1"
									role="button" data-slide="prev"><span
									class="carousel-control-prev-icon"></span><span class="sr-only">Previous</span></a><a
									class="carousel-control-next" href="#carousel-1" role="button"
									data-slide="next"><span class="carousel-control-next-icon"></span><span
									class="sr-only">Next</span></a>
							</div>
							<ol class="carousel-indicators">
								<li data-target="#carousel-1" data-slide-to="0"></li>
								<li data-target="#carousel-1" data-slide-to="1" class="active"></li>
								<li data-target="#carousel-1" data-slide-to="2"></li>
							</ol>
						</div>
					</div>
				</div> --%>

				<div class="row p-2">
					<c:forEach var="lsProduct" items="${listProduct}">
						<div class="col bg-white p-1 m-1">
							<a
								href="<c:url value="/${lsProduct.category.categoryCode }/${lsProduct.productCode }"/>">
								<img src="<c:url value="${lsProduct.imageUrl }"/>"
								id="produc_img">
							</a>
							<div class="product-name">
								<h6>
									<a
										href="<c:url value="/${lsProduct.category.categoryCode }/${lsProduct.productCode }"/>">${lsProduct.productName }</a>
								</h6>
							</div>
							<div class="product-price">
							<p>${lsProduct.productPrice }</p>
							</div>
							<div
								class="bg-success w-50 float-right text-center rounded-2 btnDetail">
								<a
									href="<c:url value="/${lsProduct.category.categoryCode }/${lsProduct.productCode }"/>"
									class="text-white">Xem tiếp</a>
							</div>
						</div>
					</c:forEach>
				</div>

			</div>
		</div>
	</div>
	