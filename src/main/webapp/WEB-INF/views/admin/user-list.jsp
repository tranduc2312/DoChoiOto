<%@ page language="java" contentType="text/html; charset=UTF-8"  pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>List Users</title>

</head>
<body>
	<%-- <a href="<c:url value="/admin/users?op=add"/>">Add new</a>
	<table>
		<thead>
			<tr>
				<td>ID</td>
				<td>Name</td>
				<td>username</td>
				<td>Password</td>
				<td>status</td>
				<td>role</td>
				<td>Del</td>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${listUser }" var="list"> 
				<tr>
					<td>
					<a href="<c:url value="/admin/users?op=edit&userId=${list.userId }"/>"><c:out value="${list.userId }"/></a>
					</td>
					<td><c:out value="${list.fullName }"/></td>
					<td><c:out value="${list.username }"/></td>
					<td><c:out value="${list.password }"/></td>
					<td><c:out value="${list.userStatus }"/></td>
					<td><c:out value="${list.userRole }"/></td>
					<td><a href="<c:url value="/admin/users?op=del&id=${list.userId }"/>">Del</a></td>
				</tr>
			</c:forEach>
			
		</tbody>
	</table> --%>
	
	
	   <!-- /. NAV SIDE  -->
        <div id="page-wrapper" >
		  <div class="header"> 
                        <h1 class="page-header">
                            List Users <small></small>
                        </h1>
						<ol class="breadcrumb">
					  <li><a href="#">Admin</a></li>
					  <li><a href="#">Users</a></li>
					  <li class="active">List Users</li>
					</ol> 
									
		</div>
		
            <div id="page-inner"> 
               
            <div class="row">
                <div class="col-md-12">
                    <!-- Advanced Tables -->
                    <div class="panel panel-default">
                        <div class="panel-heading">
                             List Users
                        </div>
                        <div class="panel-body">
                            <div class="table-responsive">
                                <table class="table table-striped table-bordered table-hover" id="dataTables-example">
                                    <thead>
                                        <tr>
                                            <th>User ID</th>
                                            <th>Full Name</th>
                                            <th>Username</th>
                                            <th>Password</th>
                                            <th>Status</th>
                                            <th>Role</th>
                                            <th>Delete</th>
                                        </tr>
                                    </thead>
                                    <tbody>
                                       <!--  <tr class="odd gradeX">
                                            <td>Trident</td>
                                            <td>Internet Explorer 4.0</td>
                                            <td>Win 95+</td>
                                            <td class="center">4</td>
                                            <td class="center">X</td>
                                        </tr>
                                        <tr class="even gradeC">
                                            <td>Trident</td>
                                            <td>Internet Explorer 5.0</td>
                                            <td>Win 95+</td>
                                            <td class="center">5</td>
                                            <td class="center">C</td>
                                        </tr>
                                        <tr class="odd gradeA">
                                            <td>Trident</td>
                                            <td>Internet Explorer 5.5</td>
                                            <td>Win 95+</td>
                                            <td class="center">5.5</td>
                                            <td class="center">A</td>
                                        </tr> -->
                          			<c:forEach items="${listUser }" var="list">                
                                        <tr class="even">
                                            <td><a href="<c:url value="/admin/users?op=edit&userId=${list.userId }"/>"><c:out value="${list.userId }"/></a></td>
                                            <td><c:out value="${list.fullName }"/></td>
                                            <td><c:out value="${list.username }"/></td>
											<td><c:out value="${list.password }"/></td>
											<td><c:out value="${list.userStatus }"/></td>
											<td><a href="#"><c:out value="${list.userRole }"/></a></td>
											<td><a onclick="show('${list.userId }','${list.fullName }','Do you want to delete this user?','Confirm')" href="#"><i class="fas fa-trash"></i></a></td>
                                        </tr>
                                     </c:forEach>  
                                    </tbody>
                                </table>
                            </div>
                            
                        </div>
                    </div>
                    <!--End Advanced Tables -->
                </div>
            </div>
           </div>
           </div>
       <jsp:include page="popup.jsp"/>
</body>
</html>