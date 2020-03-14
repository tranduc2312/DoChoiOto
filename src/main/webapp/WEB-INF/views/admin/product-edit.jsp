<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

</head>
<body>
	 <!-- /. NAV SIDE  -->
        <div id="page-wrapper" >
		  <div class="header"> 
                        <h1 class="page-header">
                             Products management <small></small>
                        </h1>
						<ol class="breadcrumb">
					  <li><a href="#">Admin</a></li>
					  <li><a href="#">Products</a></li>
					  <li class="active">Edit Product</li>
					</ol> 
									
		</div>
		
        <div id="page-inner"> 
			<div class="row">
                        <div class="col-xs-12">
                            <div class="panel panel-default">
                                <div class="panel-heading">
                                    <div class="card-title">
                                        <div class="title">Edit Product</div>
                                    </div>
                                </div>
                                <div class="panel-body">
                                    <form:form class="form-horizontal" name="formProduct" action="editProduct" method="post" modelAttribute="model">
                                        <div class="form-group">
                                            <label for="inputProductId" class="col-sm-2 control-label">Id Product</label>
                                            <div class="col-sm-10">
                                                <input type="text" class="form-control" name="productId" value="${product.productId }" id="inputProductId" placeholder="Product Id" readonly="readonly">
                                            </div>
                                        </div>
                                        <div class="form-group">
                                            <label for="inputCategoryId" class="col-sm-2 control-label">Category Name</label>
                                            <div class="col-sm-5">
                                            	<select id="inputCategoryId" name="category.categoryId" class="form-control">
                                            		<c:forEach var="list" items="${listCategory }">
                                            			<option value="${list.categoryId }">${list.categoryName }</option>
                                            		</c:forEach>
                                            	</select>
                                            </div>
                                        </div>
                                        <div class="form-group">
                                            <label for="inputProductName" class="col-sm-2 control-label">Product Name</label>
                                            <div class="col-sm-10">
                                                <input type="text" class="form-control" name="productName" value="${product.productName }" id="inputProductName" placeholder="Product Name">
                                            	<input type="hidden" name="productCode" id="inputProductCode">
                                            </div>
                                        </div>
                                       <div class="form-group">
                                            <label for="inputProductInfo" class="col-sm-2 control-label">Product Information</label>
                                            <div class="col-sm-10">
                                                <textarea class="form-control" name="productInfo" cols="30" rows="10" id="inputProductInfo">"${product.productInfo }"</textarea>
                                            </div>
                                        </div>
                                       	<div class="form-group">
                                            <label for="inputProductPrice" class="col-sm-2 control-label">Product Price</label>
                                            <div class="col-sm-10">
                                                <input type="text" class="form-control" name="productPrice" id="inputProductPrice" value="${product.productPrice }" placeholder="Product Price">
                                            </div>
                                        </div>
                                        <div class="form-group">
                                            <label for="inputStatus" class="col-sm-2 control-label">Active</label>
                                            <div class="col-sm-3">
                                            	<select name="productStatus" id="inputStatus" class="form-control">
													<option value="1">On</option>
													<option value="0">Off</option>
												</select>
                                            </div>
                                        </div>
                                        <div class="form-group">
                                            <div class="col-sm-offset-2 col-sm-10">
                                                <input type="button" onclick="checkValidate()" class="btn btn-default" value="Edit">
                                                <input type="button" class="btn btn-default"  onclick="show('','','Do you want to cancel this?','Confirm')" value="Cancel">
                                            </div>
                                        </div>
                                    </form:form>
                                </div>
                            </div>
                        </div>
                    </div>
              </div>
         <jsp:include page="popup.jsp" />
         <script type="text/javascript">
         
         	var category = '${product.category.categoryId }';
         	var selected = document.getElementById("inputCategoryId");
         	
         	for(var i = 0; i < selected.length; i++){
         		if(category == selected[i].value){
         			selected.selectedIndex = i;
         		}
         	}
         	var status = '${product.productStatus}';
        	var inputStatus = document.forms[0]["productStatus"];
        	setIndexCombobox(status,inputStatus);

         	var form = document.forms["formProduct"];
         	function checkValidate(){
         		if(false)
         		{
         			
     			}else if(false){
     				
     			}else{
     				var categoryName = document.forms[0]["productName"].value;
     				document.getElementById("inputProductCode").value = convertToNonUnicode(categoryName);
     				form.submit();
     			}
         		
         	}
        
         </script>
          
</body>
</html>