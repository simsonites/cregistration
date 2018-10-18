
<%@ include file="../includes/taglibs.jsp"%>
<html>
<head>
<title>CRP | instructors</title>
<%@ include file="../includes/css-js-links.jsp"%>
<!-- 	<script src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.1/jquery.min.js"></script> -->
</head>
<body>
	<%@ include file="../includes/header.jsp"%>

	<div class="container col-md-offset-2">
		<div class="row">
			<div class="col-md-10">
				<div class="row">
					<div class="col-md-12">
						<h3 class="text-center">List of Instructors</h3>
						<!-- /.col-md-12 -->
					</div>
					<br>

					<div class="row">
						<div class="search-form col-md-8 col-md-offset-2">
							<form:form name="search_form" method="post" action="search"
								class="search_form">

								<div class="input-group">
									 <input type="text" name="searchString"
										placeholder=" Enter instructor name to search ..."
										title="Search the site..." class="form-control"> <span
										class="input-group-btn">
										<button class="btn btn-default" type="button">Search
											Instructor</button>
									</span>
								</div>
							</form:form>
						</div>
					</div>

					<div class="row">
						<c:url var="details" value="/instructors/details">
							<c:param name="instructorId" value="${temInstructor.id }" />
						</c:url>

						<c:url var="delete" value="/instructors/delete">
							<c:param name="instructorId" value="${temInstructor.id }" />
						</c:url>
						<h3><a href="#">Add new Instructor</a></h3>
						
						
							<div class="prof-list-item clearfix" id="checkBoxForm">
						<div id='checkboxes'>
						<form:form action="${pageContext.request.contextPath}/courses/admin/delete-checked" method="post">
						
						<table class="table table-bordered table-hover">
							<tr class="prof-name-list event-title">
								<th><input type='checkbox' id='checkall'> delete  all	</th>
								<th>Title</th>
								<th>First Name</th>
								<th>Last Name</th>
								<th>Email</th>
								<th>Mobile</th>
								<th>Assigned Courses</th>
								<th colspan=2>Action </th>
							</tr>
							<c:forEach var="temInstructor" items="${instructors}">
								<tr>
								<td><input  class="checkbox" type="checkbox"  name="checkeds" value="${temInstructor.id }"/></td>
									<td>${ temInstructor.title }</td>
									<td>${ temInstructor.firstName }</td>
									<td>${ temInstructor.lastName }</td>
									<td>${ temInstructor.email }</td>
									<td>${ temInstructor.mobile }</td>
									<td><a href="${details}">Assigned Courses</a></td>
									<td><a href="#"><i class="glyphicon glyphicon-edit"></i></a></td>
									<td><a href="#"><i class="glyphicon glyphicon-trash"></i></a></td>
								</tr>
							</c:forEach>
						</table>
							<button class="btn btn-danger"><span><i class="glyphicon glyphicon-trash"> delete selected instructors</i></span></button>
						<button class="btn btn-danger"><span><i class="glyphicon glyphicon-trash"> delete all instructors</i></span></button>
						</form:form>
						</div>
						</div>

						<ul class="pagination">
							<li><a href="#">1</a></li>
							<li><a href="#">2</a></li>
							<li><a href="#">3</a></li>
							<li><a href="#">4</a></li>
							<li><a href="#">5</a></li>
						</ul>
					</div>			
					<!-- /.row -->
				</div>
				<!-- /.col-md-8 -->
			</div>
		</div>
	</div>
	<%@ include file="../includes/footer.jsp"%>
	  <%@ include file = "../includes/delete-checked.jsp" %> 
</body>
</html>


