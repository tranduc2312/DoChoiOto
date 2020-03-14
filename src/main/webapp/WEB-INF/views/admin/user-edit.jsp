<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%-- <form:form action="editUser" method="post" name="editForm" modelAttribute="userModel">
		User Id: <input type="text" name="userId" value="${user.userId }" readonly="readonly"/>
	<br> Full Name: <input type="text" name="fullName" value="${user.fullName }"/>
	<br> Username: <input type="text" name="username" value="${user.username }"/>
	<br> Password: <input type="password" name="password" value="${user.password }"/>
	<br> Role: <select name="userRole">
				<option value="1">Admin
				<option value="0">Employee
				</select>
	<br> Active: <select name="userStatus">
				<option value="1">On
				<option value="0">Off
				</select> 
	<button>Edit</button>
	</form:form>
	 --%>
	 <!-- /. NAV SIDE  -->
        <div id="page-wrapper" >
		  <div class="header"> 
                        <h1 class="page-header">
                             Users management <small></small>
                        </h1>
						<ol class="breadcrumb">
					  <li><a href="#">Admin</a></li>
					  <li><a href="#">User</a></li>
					  <li class="active">Edit User</li>
					</ol> 
									
		</div>
		
        <div id="page-inner"> 
			<div class="row">
                        <div class="col-xs-12">
                            <div class="panel panel-default">
                                <div class="panel-heading">
                                    <div class="card-title">
                                        <div class="title">Edit user</div>
                                    </div>
                                </div>
                                <div class="panel-body">
                                    <form:form class="form-horizontal" action="editUser" method="post" modelAttribute="userModel">
                                        <div class="form-group">
                                            <label for="inputUserId" class="col-sm-2 control-label">Id User</label>
                                            <div class="col-sm-10">
                                                <input type="text" class="form-control" name="userId" value="${user.userId }" id="inputUserId" placeholder="User Id" readonly="readonly">
                                            </div>
                                        </div>
                                        <div class="form-group">
                                            <label for="inputFullName" class="col-sm-2 control-label">Full Name</label>
                                            <div class="col-sm-10">
                                                <input type="text" class="form-control" name="fullName" value="${user.fullName }" id="inputFullName" placeholder="Fullname">
                                            </div>
                                        </div>
                                        <div class="form-group">
                                            <label for="inputUsername" class="col-sm-2 control-label">Username</label>
                                            <div class="col-sm-10">
                                                <input type="text" class="form-control" name="username"  value="${user.username }" id="inputUsername" placeholder="Username" readonly="readonly">
                                            </div>
                                        </div>
                                        <div class="form-group">
                                            <label for="inputPassword3" class="col-sm-2 control-label">Password</label>
                                            <div class="col-sm-10">
                                                <input type="password" class="form-control" name="password" value="${user.password }" id="inputPassword" placeholder="Password">
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
                                            <label for="inputStatus" class="col-sm-2 control-label">Active</label>
                                            <div class="col-sm-3">
                                            	<select name="userStatus" id="inputStatus" class="form-control">
													<option value="1">On</option>
													<option value="0">Off</option>
													</select>
                                            	
                                            </div>
                                        </div>
                                         
                                        <div class="form-group">
                                            <div class="col-sm-offset-2 col-sm-10">
                                                <input type="button" onclick="checkValidate()" class="btn btn-default" value="Edit">
                                                <input type="button" class="btn btn-default" onclick="show('','','Do you want to cancel this?','Confirm')" value="Cancel">
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
		        var status = '${user.userStatus}';
		     	var inputStatus = document.forms[0]["userStatus"];
		     	setIndexCombobox(status,inputStatus);
		     	//
		     	var form = document.forms[0];
         	function checkValidate(){
         		if(checkLength("username",30,0)){
     				
     			}
         		else if(checkLength("fullName",40,0)){
         			
         		}
         		else{
     				form.submit();
     			}
         		
         	}
		     	
         </script>
</body>
</html>