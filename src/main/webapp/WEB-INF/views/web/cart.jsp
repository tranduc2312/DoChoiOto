<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<div class="container bg-light border-5 p-3 shadow-sm">
	<div class="row">
		<div class="col">
			<div class="order-title col-12">
				<h3>Sản phẩm đã chọn</h3>
			</div>
			<div class="order-detail">
				<table class="table table-hover table-stripped">
					<tr>
						<th>Sản phẩm</th>
						<th>Gía</th>
						<th>Số lượng</th>
						<th>Tổng</th>
					</tr>
					<c:set var="tong" value="0"></c:set>
					<c:forEach var="list" items="${myCart.listOrderDetails }">
						<tr>
							<td>${list.product.productName }</td>
							<td>${list.product.productPrice }</td>
							<td><input type="number" min="1" max="10"  value="${list.productAmount }" style="background: transparent;"/></td>
							<td>${list.product.productPrice*list.productAmount }</td>
							<c:set var="tong" value="${tong+ list.product.productPrice*list.productAmount}"/>
						</tr>
					</c:forEach>
				</table>
				
			</div>
			<div class="row">
				<div class="col">
					<h4 style="float:right">Tổng: ${tong }</h4>
				</div>
			</div>
			<div class="check-out form-group">
				
				<a class="btn btn-success float-right" href="<c:url value="/checkout"/>" class="btn-primary">Thanh toán</a>
				<button class="btn btn-danger float-right mr-2"  >Cập nhật giỏ hàng</button>
			</div>
		</div>
	</div>
	
</div>