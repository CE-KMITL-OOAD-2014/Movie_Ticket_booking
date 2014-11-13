<%-- 
    Document   : test
    Created on : Oct 25, 2014, 11:23:09 PM
    Author     : Gift
--%>

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
<title> </title>
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
<center>
    <div class="well col-sm-10 col-sm-offset-1">
        <div class="panel panel-default">
            <h3 class="panel-title">
                <ul class="nav nav-tabs" role="tablist">
                    <li class="active"><a href="#nowshow" role="tab" data-toggle="tab">Now Showing</a></li>
                    <li><a href="#coming" role="tab" data-toggle="tab">Coming Soon</a></li>
                    <!--li><a href="#toprank" role="tab" data-toggle="tab">Top Ranking</a></li-->
                </ul>
            </h3>
            <div class="panel-body">
                <div class="tab-content">

                    <!--Now Show Tab -->
                    <div class="tab-pane fade in active" id="nowshow">
                        <c:forEach var="movie" items="${movie}">
                            <div class="well col-sm-3">
                                <a href ="moviedetail?mname=<c:out value="${movie.getMname()}"></c:out>">
                                    <img src="data:image/jpg;base64,<c:out value="${movie.getB64str()}"></c:out>" class="image-responsive" alt="Responsive image" style="width: 150px; height: 200px;">
                                    <p><c:out value="${movie.getMname()}"></c:out></p>
                                    </a>
                                </div>
                        </c:forEach>
                    </div>

                    <!--Coming Tab -->
                    <div class="tab-pane fade" id="coming">
                        <center><p><H1>Coming Soon!!</H1></p></center>
                    </div>
                </div>
            </div>
        </div>
    </div>
</center>
</body>
</html>
