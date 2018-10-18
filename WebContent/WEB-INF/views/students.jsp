
 <%@ include file = "../includes/taglibs.jsp" %>
  <%@ page import="com.softpager.cregistration.utils.ResourceMappings" %>
<html>
<head>
<title>CRP  | Students</title>
 <%@ include file = "../includes/css-js-links.jsp" %>  
</head>
<body>
  <%@ include file = "../includes/header.jsp" %>
	<div class="container col-md-offset-2">	
	
		<div class="row">
			<div class="col-md-10">
			
			<div class="row">
					<div class="col-md-12 text-center">					
						<h2>Current Registered Students</h2>					
					</div>
					<!-- /.col-md-12 -->
				</div>
				
						
				<br>	
				<div class="row">				
						<div class="search-form col-md-10 col-md-offset-1">
					<form:form name="search_form" method="post" action="search"	class="search_form"	>					
						<div class="input-group">						
							<input type="text" name="searchString" placeholder=" Enter student name to search ..."
								 class="form-control"> 								
								<span class="input-group-btn">
								<button class="btn btn-default" type="button">Search</button>
							</span>							
						</div>
					</form:form>
				</div>	
				</div>		
				
				<div class="row">
					<c:forEach var="temStudent" items="${student}">
						<c:url var="regDetails" value="${ResourceMappings.DETAILS}">
							<c:param name="studentId" value="${temStudent.id }" />
						</c:url>
						<div class="col-md-12">
							<div class="list-event-item">
								<div class="box-content-inner clearfix">
									<div class="list-event-thumb">
										<a href="${regDetails }"> <img
											src="${pageContext.request.contextPath}/resources/images/rose.jpg"
											alt="">
										</a>
									</div>
									<div class="list-event-header">									
										<div class="view-details">										
											<a  class="btn btn-view" href="${regDetails }">View  details</a>
										</div>
									</div>
									<h3 class="event-title">${temStudent.firstName}			${temStudent.lastName}</h3>
									<p>Lorem ipsum dolor sit amet, consectetur adipisicing elit. Quis,
										cum, quidem aut natus odit deleniti placeat quia est quibusdam hic.
										Quod, minima, excepturi eum repellat tempora...</p>
								</div>
								<!-- /.box-content-inner -->
							</div>
							<!-- /.list-event-item -->
						</div>
						<!-- /.col-md-12 -->
					</c:forEach>
				</div>
				<!-- /.row -->
				
				
				<div class="row">
					<div class="col-md-12">
						<div class="load-more-btn">
							<a href="#">Click here to load more students  (Ooops! not connected  :-) )</a>
						</div>
					</div>
					<!-- /.col-md-12 -->
				</div>
				<!-- /.row -->
			</div>
			<!-- /.col-md-8 -->
		</div>
	</div>
	   <%@ include file = "../includes/footer.jsp" %> 
</body>
</html>
