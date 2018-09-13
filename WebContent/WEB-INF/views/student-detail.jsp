<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
 <%@ include file = "../includes/taglibs.jsp" %>
<html>
<head>
<title>CRP | student details</title>

 <%@ include file = "../includes/css-js-links.jsp" %>  

</head>
<body>
   <%@ include file = "../includes/header.jsp" %>

	<div class="container col-md-offset-2">
		<div class="row">
			<div class="col-md-10">

				<div class="widget-main">
					<div class="widget-main-title">
						<h3 class="text-center">Student Registration Details</h3>
					</div>
					<div class="widget-inner">

						<c:url var="delete" value="/students/delete">
							<c:param name="studentId" value="${student.id }" />
						</c:url>

						<c:url var="update" value="/students/update">
							<c:param name="studentId" value="${student.id }" />
						</c:url>

						<c:url var="addCourse" value="/courses/list">
							<c:param name="studentId" value="${student.id }" />
						</c:url>

						<div class="prof-list-item clearfix">
							<div class="row">
								<div class="col-sm-2">
									<div class="prof-thumb">
										<img
											src="${pageContext.request.contextPath}/resources/images/rose.jpg"
										/>
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
												onclick=" if(!(confirm(' Are you sure you want to delete registration ? '))) return false; "
											>Delete registration</a>
										</div>
									</div>
								</div>
							</div>
							<!-- /.prof-details -->

							<h3 class=" text-center">
								Registered Courses <small><a href="${addCourse }"> &nbsp; register for
										courses</a></small>
							</h3>
							<table class="table table-bordered">
								<tr class="prof-name-list">
									<th>Course Title</th>
									<th>Number of Credits</th>
									<th>Instructor</th>
									<th>Action</th>
								</tr>
								<tr>
									<td>Advance Java Programming by Examples</td>
									<td>30</td>
									<td><a href="#">Prof. Sam Jefferson</a></td>
									<td><a href="${delete }"
										onclick=" if(!(confirm(' Are you sure you want to delete this student from the database ? '))) return false; "
									>remove course</a></td>
								</tr>
								<tr>
									<td>The Basics of Computing Programming</td>
									<td>15</td>
									<td><a href="#">Dr. Mary Public</a></td>
									<td><a href="${delete }"
										onclick=" if(!(confirm(' Are you sure you want to delete this student from the database ? '))) return false; "
									><span class="glyphicon glyphicon-trash"></span></a></td>
								</tr>
								<tr>
									<td>The Basics of Computing Science</td>
									<td>30</td>
									<td><a href="#">Prof. Moore Alvin</a></td>
									<td><a href="${delete }"
										onclick=" if(!(confirm(' Are you sure you want to delete this student from the database ? '))) return false; "
									><span class="glyphicon glyphicon-trash"></span></a></td>
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
    <%@ include file = "../includes/footer.jsp" %> 
</body>
</html>

