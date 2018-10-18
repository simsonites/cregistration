<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ include file="../includes/taglibs.jsp"%>
<html>
<head>
<title>iCourses | Instructor details</title>
<%@ include file="../includes/css-js-links.jsp"%>
</head>
<body>
	<%@ include file="../includes/header.jsp"%>

	<div class="container col-md-offset-2">
		<div class="row">
			<div class="col-md-10">

				<div class="widget-main">
					<div class="widget-main-title">
						<h3 class="text-center">Instructor Details</h3>
						<h4><a href="${pageContext.request.contextPath}/instructors/list">Back to instructor list</a></h4>
					</div>
					<div class="widget-inner">

						<c:url var="delete" value="/instructors/admin/delete">
							<c:param name="instructorId" value="${instructor.id }" />
						</c:url>

						<c:url var="update" value="/instructors/admin/update">
							<c:param name="instructorId" value="${instructor.id }" />
						</c:url>

						<c:url var="addCourse" value="/courses/list">
							<c:param name="instructorId" value="${instructor.id }" />
						</c:url>

						<div class="prof-list-item clearfix">
							<div class="row">
								<div class="col-sm-2">
									<div class="prof-thumb">
										<img
											src="${pageContext.request.contextPath}/resources/images/placeholder.jpg"
										/>
									</div>
								</div>

								<div class="col-sm-8">
									<div class="prof-details">

										<div class="row">
										<h5 class="col-md-4">Academic title :</h5>
											<h5 class="col-md-6">${instructor.title }</h5>
										</div>
											<h5 class="col-md-4">First Name :</h5>
											<h5 class="col-md-6">${instructor.firstName }</h5>
										</div>

										<div class="row">
											<h5 class="col-md-4">Last Name :</h5>
											<h5 class="col-md-6">${instructor.lastName }</h5>
										</div>

										<div class="row">
											<h5 class="col-md-4">Email Address :</h5>
											<h5 class="col-md-6">${instructor.email }</h5>
										</div>
										<div class="row">
											<h5 class="col-md-4">Mobile Contact :</h5>
											<h5 class="col-md-6">${instructor.mobileContact }</h5>
										</div>

										<div class="row">
											<a class="col-md-4" href="${update }">Edit information</a> <a
												class="col-md-4" href="${delete }"
												onclick=" if(!(confirm(' Are you sure you want to delete registration ? '))) return false; "
											>Delete this instructor</a>
										</div>
									</div>
								</div>
							</div>
							<!-- /.prof-details -->
							<h3 class=" text-center">
								Assigned  Courses <small><a href="${addCourse }">assign more
										Courses</a></small>
							</h3>
							<table class="table table-bordered table-striped">
								<tr class="prof-name-list">
									<th>Course Title</th>
									<th>Number of Credits</th>									
									<th>Action</th>
								</tr>
								<tr>
									<td>Advance Java Programming by Examples</td>
									<td>30</td>									
									<td><a href="${delete }"
										onclick=" if(!(confirm(' Are you sure you want to delete this student from the database ? '))) return false; "
									>remove course</a></td>
								</tr>
								<tr>
									<td>The Basics of Computing Programming</td>
									<td>15</td>								
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
   	<%@ include file="../includes/footer.jsp"%>
</body>
</html>

