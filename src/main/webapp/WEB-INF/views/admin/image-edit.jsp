<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<!-- /. NAV SIDE  -->
	<div id="page-wrapper">
		<div class="header">
			<h1 class="page-header">
				Images management <small></small>
			</h1>
			<ol class="breadcrumb">
				<li><a href="#">Admin</a></li>
				<li><a href="#">Images</a></li>
				<li class="active">Edit Images</li>
			</ol>

		</div>

		<div id="page-inner">
			<div class="row">
				<div class="col-xs-12">
					<div class="panel panel-default">
						<div class="panel-heading">
							<div class="card-title">
								<div class="title">Edit image</div>
							</div>
						</div>
						<div class="panel-body">
							<form:form class="form-horizontal" name="formImage" enctype="multipart/form-data"
								action="editImage" method="post"><!--  modelAttribute="model" -->
								<div class="form-group">
									<label for="inputImageId" class="col-sm-2 control-label">Id
										Image</label>
									<div class="col-sm-10">
										<input type="text" class="form-control" name="imageId"
											value="${image.imageId }" id="inputImageId"
											placeholder="Image Id" readonly="readonly">
									</div>
								</div>
								<div class="form-group">
                                            <label for="inputProductId" class="col-sm-2 control-label">Product Name</label>
                                            <div class="col-sm-10">
                                            	<select name="productId" id="" class="form-control">
                                            		<c:forEach var="list" items="${listProduct }">
                                            			<option value="${list.productId }">${list.productName }</option>
                                            		</c:forEach>
                                            	</select>
                                            </div>
                                        </div>
								<div class="form-group">
									<label for="inputImageTitle" class="col-sm-2 control-label">Image
										Title</label>
									<div class="col-sm-10">
										<input type="text" class="form-control" name="imageTitle"
											 id="inputImageTitle" value="${image.imageTitle }"
											placeholder="Image Title">
										<!-- <input type="hidden" class="form-control" name="imageUrl" id="inputImageUrl"/> -->
										
									</div>
								</div>
								<div class="form-group">
									<label for="inputImageUrl" class="col-sm-2 control-label">Upload Image</label>
									<div class="col-sm-10">
										<input type="file" class="form-control" name="file" value="${imageUrl }"
											id="inputImageUrl" placeholder="image Url"> 
																					
									</div>
								</div>
								<!-- <div class="form-inline">
									<label for="inputIsBanner" class="col-sm-2 control-label">Is Banner</label>
									<div class="col-sm-10">
										<input type="radio" class="form-control" name="isBanner"
											id="inputIsBanner" value="true"><label for="inputIsBanner">True</label>
										<input type="radio" class="form-control" name="isBanner"
											id="inputIsBannerfalse" value="false"><label for="inputIsBannerfalse">False</label>
																					
									</div>
								</div>
								<div class="form-inline">
									<label for="imageIsPrimary" class="col-sm-2 control-label">Is Present</label>
									<div class="col-sm-10">
										<input type="radio" class="form-control" name="isPrimary"
											id="inputIsPrimary" value="true"> True 
										<input type="radio" class="form-control" name="isPrimary"
											id="inputIsPrimary" value="false"> False											
									</div>
								</div> -->
								<div class="form-group">
									<div class="col-sm-offset-2 col-sm-10">
									<!-- onclick="checkValidate()" -->
										<input type="submit" 
											class="btn btn-default" value="Edit"> <input
											type="button" class="btn btn-default"
											onclick="window.history.back();" value="Cancel">
									</div>
								</div>
							</form:form>
						</div>
					</div>
				</div>
			</div>
		</div>
		</div>
		<c:forEach var="list" items="${listImage }">
			<input type="hidden" value="${list.ImageId }"
				class="listImageId" />
			<input type="hidden" value="${list.ImageName }"
				class="listImageName" />
		</c:forEach>
		<jsp:include page="popup.jsp" />
		<script type="text/javascript">
			var product = '${image.product.productId }';
	     	var selected = document.getElementById("inputProductId");
	     	
	     	for(var i = 0; i < selected.length; i++){
	     		if(product == selected[i].value){
	     			selected.selectedIndex = i;
	     		}
	     	}
				
		
			var listImageId = document
					.getElementsByClassName("listImageId");
			var listImageName = document
					.getElementsByClassName("listImageName");
			var form = document.forms["formImage"];
			function checkValidate() {
				if (checkUnique("ImageId", listImageId)) {
				} else if (checkLength("ImageName", 100, 0)) {
				} else {
					var ImageName = document.forms[0]["ImageName"].value;
					document.getElementById("inputImageCode").value = convertToNonUnicode(ImageName);
					form.submit();
				}

			}
		</script>
</body>
</html>