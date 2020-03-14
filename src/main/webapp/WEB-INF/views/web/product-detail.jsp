<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
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
                <div class="row mb-4">
                    <div class="col col-6">
                        <div class="carousel slide" data-ride="carousel" id="carousel-1">
                            <div class="carousel-inner" role="listbox">
								<c:forEach var="list" items="${product.listImages }" varStatus="index">
								<c:if test="${index.index == 0}">
									<div class="carousel-item active">
									<img class="w-100 d-block"
										src="<c:url value="${list.imageUrl }"/>"
										id="img-carousel">
								</div>
								</c:if>
								<c:if test="${index.index > 0}">
								<div class="carousel-item">
									<img class="w-100 d-block"
										src="<c:url value="${list.imageUrl }"/>"
										id="img-carousel">
								</div>
								</c:if>
								</c:forEach>
						
							</div>
                    <div><a class="carousel-control-prev" href="#carousel-1" role="button" data-slide="prev"><span class="carousel-control-prev-icon"></span><span class="sr-only">Previous</span></a><a class="carousel-control-next" href="#carousel-1" role="button"
                            data-slide="next"><span class="carousel-control-next-icon"></span><span class="sr-only">Next</span></a></div>
                    <ol class="carousel-indicators">
                    <c:forEach var="list" items="${product.listImages }" varStatus="index">
                        <li data-target="#carousel-1" data-slide-to="${index }"></li>
                    </c:forEach>
                    </ol>
                </div>
                <div class="row p-2">
                <c:forEach var="list" items="${product.listImages }" varStatus="index">
                        <div class="col m-1 p-1"><img data-target="#carousel-1" data-slide-to="${index }" src="<c:url value="${list.imageUrl }"/>" class="w-100"></div>
                 </c:forEach>
                </div>
            </div>
            <div class="col">
            <form:form action="/dochoioto/carts" method="post" modelAttribute="orderDetail">
            	<div class="product-name">
            		<h3>${product.productName }</h3>
            	</div>
            	<div class="product-price">
            		<p>${product.productPrice }</p>
            	</div>
            	<div class="product-amount">
            		<input type="hidden" name="product.productPrice" value="${product.productPrice }"/>
            		<input type="hidden" name="product.productName" value="${product.productName }"/>
            		<input type="hidden" name="productId" value="${product.productId }"/>
            		<input type="number" value="1" min="1" max="10" name="productAmount"/>
            	</div>
            	
            	<div class="form-inline">
            		<button type="submit" class="btn btn-success" >Đặt mua</button>
            	</div>
            	</form:form>
            </div>
        </div>
        <div class="bg-light p-1 mb-2 shadow-sm rounded-2">
            <div class="w-25 bg-info pl-2 shadow-lg"><a href="#" class="text-light">Thông tin sản phẩm</a></div>
            <div class="row p-2">
            	${product.productInfo }
            </div>
        </div>
        <div class="bg-light p-1 mb-2 shadow-sm rounded-2">
            <div class="w-25 bg-info pl-2 shadow-lg"><a href="#" class="text-light">Sản phẩm liên quan</a></div>
            <div class="row p-2">
                <div class="col bg-white p-1 m-1"><img src="assets/img/duc.jpg" id="produc_img" produc_img="">
                    <h5>Tên sản phẩm</h5>
                    <p>Giá: 100$</p>
                    <div class="bg-success w-50 float-right text-center rounded-2"><a href="#" class="text-white">Xem tiếp</a></div>
                </div>
                <div class="col bg-white p-1 m-1"><img src="assets/img/duc.jpg" id="produc_img" produc_img="">
                    <h5>Heading</h5>
                    <p>Paragraph</p>
                    <div class="bg-success w-50 float-right text-center rounded-2"><a href="#" class="text-white">Xem tiếp</a></div>
                </div>
                <div class="col bg-white p-1 m-1"><img src="assets/img/duc.jpg" id="produc_img" produc_img="">
                    <h5>Heading</h5>
                    <p>Paragraph</p>
                    <div class="bg-success w-50 float-right text-center rounded-2"><a href="#" class="text-white">Xem tiếp</a></div>
                </div>
                <div class="col bg-white p-1 m-1"><img src="assets/img/duc.jpg" id="produc_img" produc_img="">
                    <h5>Heading</h5>
                    <p>Paragraph</p>
                    <div class="bg-success w-50 float-right text-center rounded-2"><a href="#" class="text-white">Xem tiếp</a></div>
                </div>
            </div>
        </div>
    </div>
    </div>
    </div>
   