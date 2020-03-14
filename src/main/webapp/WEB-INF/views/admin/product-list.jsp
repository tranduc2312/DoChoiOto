<%@ page language="java" contentType="text/html; charset=UTF-8"  pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>List products</title>

</head>
<body>
	   <!-- /. NAV SIDE  -->
        <div id="page-wrapper" >
		  <div class="header"> 
                        <h1 class="page-header">
                            Products Management<small></small>
                        </h1>
						<ol class="breadcrumb">
					  <li><a href="#">Admin</a></li>
					  <li><a href="#">Products</a></li>
					  <li class="active">List Products</li>
					</ol> 
									
		</div>
		
            <div id="page-inner"> 
               
            <div class="row">
                <div class="col-md-12">
                    <!-- Advanced Tables -->
                    <div class="panel panel-default">
                        <div class="panel-heading">
                             List Products
                        </div>
                        <div class="panel-body">
                            <div class="table-responsive">
                                <table class="table table-striped table-bordered table-hover" id="dataTables-example">
                                    <thead>
                                        <tr>
                                            <th>Product ID</th>
                                            <th>Product Name</th>
                                            <th>Code</th>
                                            <th>Info</th>
                                            <th>Price</th>
                                            <th>Status</th>
                                            <th>Delete</th>
                                        </tr>
                                    </thead>
                                    <tbody>
                          			<c:forEach items="${listProduct }" var="list">                
                                        <tr class="even">
                                            <td><a href="<c:url value="/admin/products?op=edit&id=${list.productId }"/>"><c:out value="${list.productId }"/></a></td>
                                            <td><c:out value="${list.productName }"/></td>
                                            <td><c:out value="${list.productCode }"/></td>
                                            <td><c:out value="${list.productInfo }"/></td>
                                            <td><c:out value="${list.productPrice }"/></td>
                                            <td><c:out value="${list.productStatus }"/></td>
											<td><a onclick="show('${list.productId }','${list.productName }','Do you want to delete this product?','Confirm')" ><i class="fas fa-trash"></i></a></td>
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
	    		window.location.href = "products?op=del&id="+id;
	       }
       </script>
</body>
</html>