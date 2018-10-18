 <%@ include file = "../includes/taglibs.jsp" %>
 <%@ page import="com.softpager.cregistration.utils.ResourceMappings" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title> CRP  | courses </title>
 <%@ include file = "../includes/css-js-links.jsp" %>  
</head>
<body>
 <%@ include file = "../includes/header.jsp" %>

   <div class="container">   
   <div class="row">
   
     <div class="col-md-4">

                <div class="widget-main">
                    <div class="widget-main-title">
                        <h3 class="widget-title">List of available courses</h3>
                    </div> <!-- /.widget-main-title -->
                    <div class="widget-inner">
                        <div class="event-small-list clearfix">                       
                    		<ul>
								<c:forEach var="temCourse" items="${courses}">
								
									<c:url var="courseDetails" value="${ResourceMappings.DETAILS}">
										<c:param name="courseId" value="${temCourse.id }" />
									</c:url>								
									
								<li> <a href="${courseDetails}"> ${temCourse.title} </a></li> 	
								</c:forEach>
							</ul>  						                     
                        </div>                                 
                    </div> <!-- /.widget-inner -->
                </div> <!-- /.widget-main -->
            </div> <!-- /.col-md-4 -->      
            
            
            
            <!-- Here begin Main Content -->
            <div class="col-md-8 ">
                <div class="row">

                    <div class="col-md-12">
                        <div class="list-event-item">
                            <div class="box-content-inner clearfix">         
                            
                                <h5 class="event-title"><a href="event-single.html">January Career Centre Events for Grad Students</a></h5>
                                <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit. Quis, cum, quidem aut natus odit deleniti placeat quia est quibusdam hic. Quod, minima, excepturi eum repellat tempora...</p>
                            </div> <!-- /.box-content-inner -->
                        </div> <!-- /.list-event-item -->  
                 
                    </div> <!-- /.col-md-12 -->
                </div> <!-- /.row -->
                <div class="row">
                    <div class="col-md-12">
                        <div class="load-more-btn">
                            <a href="#">Click here to load more events</a>
                        </div>
                    </div> <!-- /.col-md-12 -->
                </div> <!-- /.row -->
            </div> <!-- /.col-md-8 -->             
    
        </div>
    </div> <!-- /.container -->      
  
 <%@ include file = "../includes/footer.jsp" %> 
</body>
</html>