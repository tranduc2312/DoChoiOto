<%@ page language="java" contentType="text/html; charset=UTF-8"  pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>List Categories</title>

</head>
<body>
	   <!-- /. NAV SIDE  -->
        <div id="page-wrapper" >
		  <div class="header"> 
                        <h1 class="page-header">
                            Categories Management<small></small>
                        </h1>
						<ol class="breadcrumb">
					  <li><a href="#">Admin</a></li>
					  <li><a href="#">Categories</a></li>
					  <li class="active">List categories</li>
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
                                            <th>Category ID</th>
                                            <th>Category Name</th>
                                            <th>Status</th>
                                            <th>Delete</th>
                                        </tr>
                                    </thead>
                                    <tbody>
                          			<c:forEach items="${listCategory }" var="list">                
                                        <tr class="even">
                                            <td><a href="<c:url value="/admin/categories?op=edit&id=${list.categoryId }"/>"><c:out value="${list.categoryId }"/></a></td>
                                            <td><c:out value="${list.categoryName }"/></td>
                                            <td><c:out value="${list.categoryStatus }"/></td>
											<td><a onclick="show('${list.categoryId }','${list.categoryName }','Do you want to delete this?','Confirm')" ><i class="fas fa-trash"></i></a></td>
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
       <script type="text/javascript">
	       function execute(){
	    	   var id = document.getElementById("idHidden").value;
	    		window.location.href = "categories?op=del&id="+id;
	       }
       </script>
</body>
</html>