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
	<br> Full Name: <input type="text" name="fullName"/>
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
                             Users management <small></small>
                        </h1>
						<ol class="breadcrumb">
					  <li><a href="#">Admin</a></li>
					  <li><a href="#">User</a></li>
					  <li class="active">Add new</li>
					</ol> 
									
		</div>
		
        <div id="page-inner"> 
			<div class="row">
                        <div class="col-xs-12">
                            <div class="panel panel-default">
                                <div class="panel-heading">
                                    <div class="card-title">
                                        <div class="title">Add user</div>
                                    </div>
                                </div>
                                <div class="panel-body">
                                    <form:form class="form-horizontal" name="formAdd" action="addUser" method="post" modelAttribute="userModel">
                                        <div class="form-group">
                                            <label for="inputUserId" class="col-sm-2 control-label">Id User</label>
                                            <div class="col-sm-10">
                                                <input type="text" class="form-control" name="userId" value="${idUser }" id="inputUserId" placeholder="User Id" readonly="readonly">
                                            </div>
                                        </div>
                                        <div class="form-group">
                                            <label for="inputFullName" class="col-sm-2 control-label">Full Name</label>
                                            <div class="col-sm-10">
                                                <input type="text" class="form-control" name="fullName" id="inputFullName" placeholder="Fullname">
                                            </div>
                                        </div>
                                        <div class="form-group">
                                            <label for="inputUsername" class="col-sm-2 control-label">Username</label>
                                            <div class="col-sm-10">
                                                <input type="text" class="form-control" name="username" id="inputUsername" placeholder="Username">
                                            </div>
                                        </div>
                                        <div class="form-group">
                                            <label for="inputPassword3" class="col-sm-2 control-label">Password</label>
                                            <div class="col-sm-10">
                                                <input type="password" class="form-control" name="password" id="inputPassword" placeholder="Password">
                                            </div>
                                        </div>
                                        <div class="form-group">
                                            <label for="inputRole" class="col-sm-2 control-label">Role</label>
                                            <div class="col-sm-3">
                                            	<select name="userRole" id="inputRole" class="form-control">
                                            		<option value="1">Admin</option>
                                            		<option value="0">Employee</option>
                                            	</select>
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
              <c:forEach var="list" items="${listUser }">
              	<input type="hidden" value="${list.userId }" class="listUserId"/>
              	<input type="hidden" value="${list.username }" class="listUsername" />
              </c:forEach>
         <script type="text/javascript">
         	var listUserId = document.getElementsByClassName("listUserId");
         	var listUsername = document.getElementsByClassName("listUsername");
         	
         	function checkValidate(){
         		var userId = document.forms["formAdd"]["userId"].value;
         		var username = document.forms["formAdd"]["username"].value;
         		var form = document.forms["formAdd"];
         		var flag = 0;
         		for(var i = 0 ; i < listUsername.length; i++){
         			if(userId == listUserId[i].value){
         				show("",userId+' đã tồn tại!','User Id:','Error');
         				flag = 1;
         			}else if(username == listUsername[i].value){
         				show("",username+' đã tồn tại!','Username:','Error');
         				flag = 1;
         			}
         		}
         		if(flag != 1)
         		{
     				form.submit();
     			}
         		
         	}
         </script>
</body>
</html>