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
	<%-- <form:form action="addUser" method="post" modelAttribute="userModel">
		User Id: <input type="text" name="userId" value="${idUser }" disable="true"/>
	<br> Full Name: <input type="text" name="CategoryName"/>
	<br> Username: <input type="text" name="username"/>
	<br> Password: <input type="password" name="password"/>
	<br> Role: <select name="userRole">
					<option value="1">Admin
					<option value="0">Employee
				</select>
	<button>Add</button>
	</form:form> --%>
	 <!-- /. NAV SIDE  -->
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
                                        <div class="title">Add category</div>
                                    </div>
                                </div>
                                <div class="panel-body">
                                    <form:form class="form-horizontal" name="formCategory" action="addCategory" method="post" modelAttribute="model">
                                        <div class="form-group">
                                            <label for="inputCategoryId" class="col-sm-2 control-label">Id Category</label>
                                            <div class="col-sm-10">
                                                <input type="text" class="form-control" name="categoryId" value="${idCategory }" id="inputCategoryId" placeholder="Category Id" readonly="readonly">
                                            </div>
                                        </div>
                                        <div class="form-group">
                                            <label for="inputCategoryName" class="col-sm-2 control-label">Category Name</label>
                                            <div class="col-sm-10">
                                                <input type="text" class="form-control" name="categoryName" id="inputCategoryName" placeholder="CategoryName">
                                            	<input type="hidden" name="categoryCode" id="inputCategoryCode">
                                            </div>
                                        </div>
                                       
                                        <div class="form-group">
                                            <div class="col-sm-offset-2 col-sm-10">
                                                <input type="button" onclick="checkValidate()" class="btn btn-default" value="Add">
                                                <input type="button" class="btn btn-default" onclick="window.history.back();" value="Cancel">
                                            </div>
                                        </div>
                                    </form:form>
                                </div>
                            </div>
                        </div>
                    </div>
              </div>
              <jsp:include page="popup.jsp" />
              <c:forEach var="list" items="${listCategory }">
              	<input type="hidden" value="${list.categoryId }" class="listCategoryId"/>
              	<input type="hidden" value="${list.categoryName }" class="listCategoryName" />
              </c:forEach>
         <script type="text/javascript">
         	var listCategoryId = document.getElementsByClassName("listCategoryId");
         	var listCategoryName = document.getElementsByClassName("listCategoryName");
         	var form = document.forms["formCategory"];
         	function checkValidate(){
         		if(checkUnique("categoryId",listCategoryId))
         		{
         			
     			}else if(checkLength("categoryName",100,0)){
     				
     			}else{
     				var categoryName = document.forms[0]["categoryName"].value;
     				document.getElementById("inputCategoryCode").value = convertToNonUnicode(categoryName);
     				form.submit();
     			}
         		
         	}
         </script>
</body>
</html>