<%@ page language="java" contentType="text/html; charset=UTF-8"  pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>List Orders</title>

</head>
<body>
	   <!-- /. NAV SIDE  -->
        <div id="page-wrapper" >
		  <div class="header"> 
                        <h1 class="page-header">
                            Orders Management<small></small>
                        </h1>
						<ol class="breadcrumb">
					  <li><a href="#">Admin</a></li>
					  <li><a href="#">Orders</a></li>
					  <li class="active">List Orders</li>
					</ol> 
									
		</div>
		
            <div id="page-inner"> 
               
            <div class="row">
                <div class="col-md-12">
                    <!-- Advanced Tables -->
                    <div class="panel panel-default">
                        <div class="panel-heading">
                             List Orders
                        </div>
                        <div class="panel-body">
                            <div class="table-responsive">
                                <table class="table table-striped table-bordered table-hover" id="dataTables-example">
                                    <thead>
                                        <tr>
                                            <th>Order ID</th>
                                            <th>Order Date</th>
                                            <th>Customer</th>
                                            <th>Cost</th>
                                            <th>Confirm</th>
                                        </tr>
                                    </thead>
                                    <tbody>
                          			<c:forEach items="${listOrder }" var="list">                
                                        <tr class="even">
                                            <td><a href="<c:url value="/admin/orders?op=edit&id=${list.orderId }"/>"><c:out value="${list.orderId }"/></a></td>
                                            <td><c:out value="${list.orderDate }"/></td>
                                            <td><c:out value="${list.customers.ctmFullName }"/></td>
                                            <td><c:out value="${list.orderCost }"/></td>
											<td><a onclick="show('${list.orderId }','${list.orderId }','Do you want to delete this Order?','Confirm')" >Confirm</a></td>
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