<%@ page language="java" contentType="text/html; charset=UTF-8"  pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>List Images</title>

</head>
<body>
	   <!-- /. NAV SIDE  -->
        <div id="page-wrapper" >
		  <div class="header"> 
                        <h1 class="page-header">
                            Images Management<small></small>
                        </h1>
						<ol class="breadcrumb">
					  <li><a href="#">Admin</a></li>
					  <li><a href="#">Images</a></li>
					  <li class="active">List Images</li>
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
                                            <th>Image ID</th>
                                            <th>Image Name</th>
                                            <th>Image</th>
                                            <th>Status</th>
                                            <th>Delete</th>
                                        </tr>
                                    </thead>
                                    <tbody>
                          			<c:forEach items="${listImage }" var="list">                
                                        <tr class="even">
                                            <td><a href="<c:url value="/admin/images?op=edit&id=${list.imageId }"/>"><c:out value="${list.imageId }"/></a></td>
                                            <td><c:out value="${list.imageTitle }"/></td>
                                            <td><img alt="${list.imageTitle }" src="<c:url value="${list.imageUrl }"/>" width="100px"></td>
                                            <td><c:out value="${list.imageStatus }"/></td>
											<td><a onclick="show('${list.imageId }','${list.imageTitle }','Do you want to delete this Image?','Confirm')" ><i class="fas fa-trash"></i></a></td>
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
	      
       </script>
</body>
</html>