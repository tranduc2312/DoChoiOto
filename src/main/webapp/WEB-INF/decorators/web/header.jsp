<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<header>
		<nav
			class="navbar navbar-light navbar-expand-md navigation-clean-search shadow-sm">
			<div class="container">
				<a class="navbar-brand" href="<c:url value="/"/>">Đồ chơi ô tô</a>
				<button class="navbar-toggler" data-toggle="collapse"
					data-target="#navcol-1">
					<span class="sr-only">Toggle navigation</span><span
						class="navbar-toggler-icon"></span>
				</button>
				<div class="collapse navbar-collapse float-right" id="navcol-1">
					<!-- <ul class="nav navbar-nav">
						<li class="nav-item" role="presentation"><a
							class="nav-link active" href="#">Link 1</a></li>
						<li class="nav-item" role="presentation"><a class="nav-link"
							href="#">Link 2</a></li>
						<li class="nav-item" role="presentation"><a class="nav-link"
							href="#">Link 3</a></li>
					</ul> -->
					<form class="form-inline mr-auto" target="_self">
						<div class="form-group">
							<label for="search-field"><i class="fa fa-search"></i></label><input
								class="form-control search-field" type="search" name="search"
								id="search-field">
						</div>
					</form>
					<a class="btn btn-light action-button" role="button" href="#">Tìm
						kiếm</a><a class="btn btn-light action-button" role="button" href="#">Giỏ
						hàng</a>
				</div>
			</div>
		</nav>
	</header>