<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
    <head>
        <meta charset="UTF-8">
        <link href="${pageContext.request.contextPath}/resources/css/bootstrap.css" rel="stylesheet" >
        <link href="${pageContext.request.contextPath}/resources/css/bootstrap-theme.css" rel="stylesheet" >
        <script src="${pageContext.request.contextPath}/resources/js/jquery-2.1.1.min.js" />"></script>
    <script src="${pageContext.request.contextPath}/resources/js/bootstrap.js" />"></script>
<title> Booking Ticket </title>
</head>
<body>

    <style type="text/css">
        body{
            background-attachment: fixed;
            background-image: url(${pageContext.request.contextPath}/resources/img/bg.jpg);
            background-size: cover;
            background-position: center;
            background-repeat: no-repeat;
        }
        div{
            word-wrap:break-word; 
            display:block;
        }
    </style>


    <!--Content -->
    <div class="page-header">

    </div>

    <div class="wrap">
        <div class="well col-sm-10 col-sm-offset-1">
            <div class="panel panel-default">
                <div class="panel-body">
                    <div><p><h2><span class="glyphicon glyphicon-bookmark"></span>  <b>Booking</b></h2></p></div><br>
                    <p class="help-block">Choose movie and select showtime by click on time button.</p>
                    <table class="table table-striped">
                        <thead>
                            <tr>
                                <th class="col-sm-2 text-center"><h4><b>Cinema</b></h4></th>
                        <th><h4><b>Detail</b></h4></th>
                        </tr>
                        </thead>
                        <tbody>
                            <c:forEach var="cinema" items="${cinema}">
                            <c:forEach var="movie" items="${cinema.getMovieList()}">
                            <tr class="mshowtime" id="mst1">
                                <td><center><h2><c:out value="${cinema.getCinema()}"/></h2></center></td>
                                
                            <td class="col-sm-3"><img src="data:image/jpg;base64,<c:out value="${movie.getB64str()}"/>" class="image-responsive" alt="Responsive image" style="width: 90px; height: 120px;"></td>
                            <td>
                                <p style="strong"><b><a href ="moviedetail?mname=<c:out value="${movie.getMname()}"/>"> <c:out value="${movie.getMname()}"/></a></b></p>
                                <p>showtime</p>
                                <c:forEach var="showtime" items="${movie.getShowtimeList()}">
                                    
                                    <form role="form" name ="input" action="booking" method="get">
                                        <input type="hidden" name="cinema" value="<c:out value="${cinema.getCinema()}"/>">
                                               <input type="hidden" name="mname" value="<c:out value="${movie.getMname()}"/>">
                                               <input type="hidden" name="time" value="<c:out value="${showtime.getId().getTime()}"/>">
                                        <button type="submit" class="btn btn-default"><c:out value="${showtime.getId().getTime()}"/></button>
                                    </form>
                                    
                                </c:forEach>
                            </td>
                            
                            </tr>
                            </c:forEach>
                        </c:forEach>
                        </tbody>
                    </table>
                </div>
            </div>
        </div>
    </div>
</body>
</html>