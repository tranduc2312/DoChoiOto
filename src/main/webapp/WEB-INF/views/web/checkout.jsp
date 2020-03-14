<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<div class="container">
	<div class="row">
		<div class="col">
		<form:form method="post" action="checkout" modelAttribute="customerModel">
			<div class="row">
			<div class="order-title col-12">
				<h3>Thông tin thanh toán</h3>
			</div>
			</div>
			<div class="order-detail row">
			<div class="col-6">
				<div class="form-group">
					<label for="ctmName">Họ tên *</label>
					<input type="text" class="form-control" name="ctmFullName"/>
				</div>
				<div class="form-group">
					<label for="ctmPhone">Số điện thoại *</label>
					<input type="text" class="form-control" name="ctmPhone"/>
				</div>
				</div>
				<div class="col-6">
				<div class="form-group">
					<label for="ctmAddress">Địa chỉ nhận hàng *</label>
					<input type="text" class="form-control" name="ctmAddress"/>
				</div>
				
				<div class="form-group">
					<label for="ctmEmail">Email *</label>
					<input type="text" class="form-control" name="ctmEmail"/>
				</div>
				</div>
				<div class="form-group col-12">
					<label for="ctmNotes">Ghi chú </label>
					<textarea type="text" row="20" class="form-control" name="ctmNotes"> </textarea>
				</div>
			</div>
			<div class="check-out">
				<button class="btn-success float-right">Thanh toán</button>
			</div>
			</form:form>
		</div>
	</div>
	<hr>
	<div class="row">
		<div class="col">
			<div class="order-title col-12">
				<h3>Đơn hàng của bạn!</h3>
			</div>
			<div class="order-detail">
				<table class="table table-hover table-stripped">
					<tr>
						<th>Sản phẩm</th>
						<th>Gía</th>
						<th>Số lượng</th>
						<th>Tổng</th>
					</tr>
					<c:forEach var="list" items="${myCart.listOrderDetails }">
						<tr>
							<td>${list.product.productName }</td>
							<td>${list.product.productPrice }</td>
							<td>${list.productAmount }</td>
							<td>${list.product.productPrice*list.productAmount }</td>
						</tr>
					</c:forEach>
				</table>
			</div>
			<%-- <div class="check-out">
				<a href="<c:url value="/checkout"/>" class="btn-primary">Thanh toán</a>
			</div> --%>
		</div>
	</div>
</div>