<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Edit Categories</title>
</head>
<body>
        <div id="page-wrapper" >
		  <div class="header"> 
                        <h1 class="page-header">
                             Categories management <small></small>
                        </h1>
						<ol class="breadcrumb">
					  <li><a href="#">Admin</a></li>
					  <li><a href="#">Categories</a></li>
					  <li class="active">Edit Category</li>
					</ol> 
									
		</div>
		
        <div id="page-inner"> 
			<div class="row">
                        <div class="col-xs-12">
                            <div class="panel panel-default">
                                <div class="panel-heading">
                                    <div class="card-title">
                                        <div class="title">Edit Category</div>
                                    </div>
                                </div>
                                <div class="panel-body">
                                    <form:form class="form-horizontal" name="formCategory" action="editCategory" method="post" modelAttribute="model">
                                        <div class="form-group">
                                            <label for="inputCategoryId" class="col-sm-2 control-label">Id Category</label>
                                            <div class="col-sm-10">
                                                <input type="text" class="form-control" name="categoryId" value="${category.categoryId }" id="inputCategoryId" placeholder="Category Id" readonly="readonly">
                                            </div>
                                        </div>
                                        <div class="form-group">
                                            <label for="inputCategoryParent" class="col-sm-2 control-label">Category Parent</label>
                                            <div class="col-sm-5">
                                            	<select name="categoryParentId" class="form-control">
                                            		<c:forEach var="list" items="${listCategory }">
                                            			<option value="${list.categoryId }">${list.categoryName }</option>
                                            		</c:forEach>
                                            	</select>
                                            </div>
                                        </div>
                                        <div class="form-group">
                                            <label for="inputCategoryName" class="col-sm-2 control-label">Category Name</label>
                                            <div class="col-sm-10">
                                                <input type="text" class="form-control" name="categoryName" id="inputCategoryName" value="${category.categoryName }" placeholder="CategoryName">
                                            	<input type="hidden" name="categoryCode" id="inputCategoryCode">
                                            </div>
                                        </div>
                                        <div class="form-group">
                                            <label for="inputStatus" class="col-sm-2 control-label">Active</label>
                                            <div class="col-sm-3">
                                            	<select name="categoryStatus" id="inputStatus" class="form-control">
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
        	var status = '${category.categoryStatus}';
        	var inputStatus = document.forms["formCategory"]["categoryStatus"];
        	setIndexCombobox(status,inputStatus);
        	var parentId = '${category.categoryParentId}';
        	var inputSelect = document.forms[0]["categoryParentId"];
        //
         	var form = document.forms[0];
         	function checkValidate(){
         		if(checkLength("categoryName",100,0)){
     				
     			}else{
     				var categoryName = document.forms["formCategory"]["categoryName"].value;
     				document.getElementById("inputCategoryCode").value = convertToNonUnicode(categoryName);
     				form.submit();
     			}
         		
         	}
         </script>
</body>
</html>