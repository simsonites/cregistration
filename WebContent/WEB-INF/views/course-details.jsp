<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
 <%@ include file = "../includes/taglibs.jsp" %>
  <%@ page import="com.softpager.cregistration.utils.ResourceMappings" %>
<html>
<head>
<title>CRP | Course detail</title>
    <%@ include file = "../includes/css-js-links.jsp" %>  
</head>
<body>
    <%@ include file = "../includes/header.jsp" %> 

	<div class="container col-md-offset-2">
		<div class="row">
			<div class="col-md-10">

				<div class="widget-main">
					<div class="widget-main-title">
						<h3 class="text-center">${course.title}</h3>
					</div>					
					
                <div class="main-slideshow">
                    <div class="flexslider">
           <img alt="" src="${pageContext.request.contextPath}/resources/images/slide2.jpg">  
                    </div> <!-- /.flexslider -->
                </div> <!-- /.main-slideshow -->
                
           			<c:set var="temStudent" value="${student}"/>   
           			        					
					<div class="widget-inner">		
						
						<c:url var="courseList" value="${ResourceMappings.LIST}">
							<c:param name="studentId" value="${temStudent.id }" />
							</c:url>	
										
							<c:url var="registerCourse" value="${ResourceMappings.REG_FOR_COURSE}">
							 <c:param name="studentId" value="${temStudent.id }" /> 
							<c:param name="courseId" value="${course.id }" />
						</c:url>
												
						<c:url var="instructorDetails" value="${ResourceMappings.DETAILS}">							 
						</c:url>
		
						<div class="prof-list-item clearfix">
							<div class="row">					
							<!-- /.prof-details -->
							<h3 class=" text-center">	Course  Overview	</h3>							
								<span class="input-group-btn">
								<button class="btn btn-default" type="button" 
								  onclick="window.location.href='list'; return false;">Back to list of courses</button>
							</span>		<br>											
							<table class="table table-bordered">
								<tr class="prof-name-list">
								  <th>Course Id</th>
									<th>Course Title</th>
									<th>Number of Credits</th>
									<th>Instructor</th>
									<th>Description</th>
									<th colspan="2">Actions</th>
								</tr>								
								<tr>
								<td>${course.id}</td>
									<td nowrap>${course.title}</td>
									<td>${course.numberOfCredits}</td>
									
									<td nowrap><a href="${instructorDetails}">${ course.instructor.title } ${ course.instructor.firstName }
												${ course.instructor.lastName }</a></td>
									
									<td >${course.description}</td>
									
									<td nowrap ><a href="${registerCourse}">Register for course</a></td>
								</tr>					
							</table>
						</div>
						<!-- /.prof-list-item -->
					</div>
					<!-- /.widget-inner -->
				</div>
				<!-- /.widget-main -->
			</div>
			<!-- /.col-md-12 -->
			<!-- /.col-md-4 -->
		</div>
	</div>
	</div>
	   <%@ include file = "../includes/footer.jsp" %> 
</body>
</html>

