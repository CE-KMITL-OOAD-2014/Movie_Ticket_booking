<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <link href="${pageContext.request.contextPath}/resources/css/bootstrap.css" rel="stylesheet" >
        <link href="${pageContext.request.contextPath}/resources/css/bootstrap-theme.css" rel="stylesheet" >
        <script src="${pageContext.request.contextPath}/resources/js/jquery-2.1.1.min.js" />"></script>
    <script src="${pageContext.request.contextPath}/resources/js/bootstrap.js" />"></script>

<script>
    $(document).ready(function () {
        if ((localStorage.getItem("session")) != null)
        {
            $("#baddreviewnrate").show();
        }
        else
        {
            $("#baddreviewnrate").hide();
        }
    });
</script>

<script>
    $(document).ready(function () {
        $("#reviewrating").click(function () {
            var username = localStorage.getItem("user");
            $('#username').val(username);
        });
    });
</script>



<title>Movie Detail</title>
</head>
<body>
    <jsp:include page="navbar.jsp" />
    <style type="text/css">
        body{
            background-color: black;
        }
        div{
            word-wrap:break-word; 
            display:block;
        }
    </style>
    <div class="page-header">

    </div>

    <div class="wrap">
        <div class="well col-sm-10 col-sm-offset-1">
            <div class="panel panel-default">

                <div class="panel-body">

                    <!--left table-->  
                    <div class="col-sm-8">
                        <div><p><h2><span class="glyphicon glyphicon-film"></span>  <b> <c:out value="${movie.getMname()}"/></b></h2></p></div><br>
                        <div class="date-release">
                            <label class="col-sm-3"><b>Release Date</b></label>
                            <p> <c:out value="${movie.getReleasedate()}"/> </p>
                        </div>
                        <div class="type-movie">
                            <label class="col-sm-3"><b>Film Categories</b></label>
                            <p><c:out value="${movie.getType()}"/></p>
                        </div>
                        <div class="time-movie">
                            <label class="col-sm-2"><b>Duration</b></label>
                            <p><c:out value="${movie.getDuration()}"/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<b>min</b></p>
                        </div>
                        <br>
                        <div class="m-synopsis">
                            <label class="col-sm-2"><b>Synopsis</b></label><br>
                            <p class="col-sm-offset-1"><c:out value="${movie.getSynopsis()}"/></p>
                        </div>
                        <br><br><br>
                        <div class="review-rate">

                            <label class="col-sm-2"><b>Review</b></label>
                            <c:forEach var="review" items="${review}">
                                <br><br>
                                <div class="review-show col-sm-offset-1">
                                    <p><b><c:out value="${review.getUsername()} : "/></b></p>
                                    <p>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<c:out value="${review.getReview()}"/></p>
                                    <p>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<c:out value="Rating = ${review.getRating()}"/></p>
                                </div>
                            </c:forEach>
                        </div>

                        <!--right table-->
                    </div>
                    <div class="col-sm-4">
                        <center>
                            <br><br>
                            <img src="data:image/jpg;base64,<c:out value="${movie.getB64str()}"/>" class="image-responsive" alt="Responsive image" style="width: 240px; height: 320px;"/>
                            <br><br>
                            <button class="btn btn-danger" data-toggle="modal" data-target="#reviewModal" id="baddreviewnrate">Add Review & Rating</button>
                        </center>
                    </div>

                </div>
            </div>
        </div>
    </div>

    <!--Review n Rating Modal -->
    <div class="modal fade" id="reviewModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
        <div class="modal-dialog">
            <div class="modal-content">
                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal"><span aria-hidden="true">&times;</span><span class="sr-only">Close</span></button>
                    <h3 class="modal-title" id="myModalLabel"><span class="glyphicon glyphicon-file"></span>  Add Review & Rating</h3>
                </div>
                <div class="modal-body">
                    <div class="wrap">
                        <form class="form-horizontal" role="form" name ="input" action="reviewrating" method="post" id="reviewrating" >
                            <input type="hidden"  name="username" id="username" >
                            <input type="hidden" name="mname" value="<c:out value="${movie.getMname()}"/>">
                            <div class="form-group">
                                <label class="control-label col-sm-4">Choose Score </label>
                                <div class="col-sm-3">
                                    <select class="form-control" name="rating">
                                        <option>-</option>
                                        <option value="0">0</option>
                                        <option value="1">1</option>
                                        <option value="2">2</option>
                                        <option value="3">3</option>
                                        <option value="4">4</option>
                                        <option value="5">5</option>
                                    </select>
                                </div>
                            </div>  
                            <div class="form-group">
                                <div class="col-sm-8 col-sm-offset-2">
                                    <label class="control-label" for="add-review">Add Review </label><br><br>
                                    <textarea class="form-control" rows="5" name="review"></textarea>
                                </div>
                            </div>
                            <div class="modal-footer">
                                <button type="submit" class="btn btn-default">Submit</button>
                            </div>
                        </form>
                    </div>
                </div>
            </div>
        </div>
    </div>
</body>
</html>