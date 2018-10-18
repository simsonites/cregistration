<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ include file="../includes/taglibs.jsp"%>
 <%@ page import="com.softpager.cregistration.utils.ResourceMappings" %>
<html>
<head>
<title>CRP | student details</title>

<%@ include file="../includes/css-js-links.jsp"%>

</head>
<body>
	<%@ include file="../includes/header.jsp"%>

	<div class="container col-md-offset-2">
		<div class="row">
			<div class="col-md-10">

				<div class="widget-main">
					<div class="widget-main-title">
						<span class="input-group-btn">
								<button class="btn btn-default" type="button" 
								  onclick="window.location.href='list'; return false;">Back to list of students</button>
							</span>	
						<h3 class="text-center">Student Registration Details</h3>
						</div>					
					<div class="widget-inner">

						<c:url var="delete" value="${ResourceMappings.DELETE }">
							<c:param name="studentId" value="${student.id }" />
						</c:url>

						<c:url var="update" value="${ResourceMappings.UPDATE }">
							<c:param name="studentId" value="${student.id }" />
						</c:url>

						<c:url var="addCourse" value="${ResourceMappings.LIST }">
							<c:param name="studentId" value="${student.id }" />
						</c:url>
						
						<c:url var="instructorDetails" value="${ResourceMappings.DETAILS }">
						<c:param name="instructorId" value="${instructor.id }"></c:param>
						</c:url>

						<div class="prof-list-item clearfix">
							<div class="row">
								<div class="col-sm-2">
									<div class="prof-thumb">
										<img
											src="${pageContext.request.contextPath}/resources/images/rose.jpg" />
									</div>
								</div>

								<div class="col-sm-8">

									<div class="prof-details">

										<div class="row">
											<h5 class="col-md-4">First Name :</h5>
											<h5 class="col-md-6">${student.firstName }</h5>
										</div>

										<div class="row">
											<h5 class="col-md-4">Last Name :</h5>
											<h5 class="col-md-6">${student.lastName }</h5>
										</div>

										<div class="row">
											<h5 class="col-md-4">Email Address :</h5>
											<h5 class="col-md-6">${student.email }</h5>
										</div>

										<div class="row">
											<h5 class="col-md-4">Gender :</h5>
											<h5 class="col-md-6">${student.gender }</h5>
										</div>

										<div class="row">
											<a class="col-md-4" href="${update }">Edit information</a> <a
												class="col-md-4" href="${delete }"
												onclick=" if(!(confirm(' Your registration details will be deleted from the database '))) return false; ">Cancel
												registration</a>
										</div>
									</div>
								</div>
							</div>
							<!-- /.prof-details -->
							<h3 class=" text-center">Registered Courses</h3>
							
							<table class="table table-bordered">
								<tr class="prof-name-list event-title">
									<th>Course Title</th>
									<th>Number of Credits</th>
									<th>Instructor</th>
									<th>Course Content</th>
									<th>Action</th>
								</tr>
								<c:forEach var="course" items="${student.courses}">
									<tr>
										<td>${ course.title }</td>
										<td>${ course.numberOfCredits }</td>
										<td><a href="${instructorDetails}">${ course.instructor.title } ${ course.instructor.firstName }
												${ course.instructor.lastName }</a></td>
										<td>${ course.description }</td>
										<td><a href="${delete }"
											onclick=" if(!(confirm(' This course will be removed from your registered courses '))) return false; "><button
													class="btn btn-danger btn-xs">
													<span class="glyphicon glyphicon-trash"></span>
												</button></a></td>
									</tr>
								</c:forEach>
							</table>
							<h4>
								<a href="${addCourse }"> &nbsp; Register for courses</a>
							</h4>
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
	<%@ include file="../includes/footer.jsp"%>

</body>
</html>

