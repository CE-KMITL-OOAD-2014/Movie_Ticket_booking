<%-- 
    Document   : register
    Created on : Nov 12, 2014, 1:40:16 PM
    Author     : Art
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
<title>Register</title>
</head>
<body>
    <style type="text/css">
        html {
            position: relative;
            min-height: 100%;
        }
        body{
            background-attachment: fixed;
            background-image: url(${pageContext.request.contextPath}/resources/img/bg.jpg);
            background-size: cover;
            background-position: center;
            background-repeat: no-repeat;

            margin: 0 0 100px; /* bottom = footer height */
        }
        div{
            word-wrap:break-word; 
            display:block;
        }
        footer {
            background-color: #101010;
            position: absolute;
            left: 0;
            bottom: 0;
            height: 50px;
            width: 100%;
        }



    </style>

    <jsp:include page="navbar.jsp" />


    <!--Content -->

    <div class="page-header">

    </div>

    <h2><center><font color="white"><c:out value="${user.getUsername()}"/></font></center></h2>
    <h1><center><font color="white">Thank you for Register Alphamovie!</font></center></h1>
</body>
</html>
