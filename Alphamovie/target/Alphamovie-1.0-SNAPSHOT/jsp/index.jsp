<%-- 
    Document   : test
    Created on : Oct 25, 2014, 11:23:09 PM
    Author     : Gift
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
    <head>
        <meta charset="UTF-8">
        <link href="${pageContext.request.contextPath}/resources/css/bootstrap.css" rel="stylesheet" >
        <link href="${pageContext.request.contextPath}/resources/css/bootstrap-theme.css" rel="stylesheet" >
        <script src="${pageContext.request.contextPath}/resources/js/jquery-2.1.1.min.js" />"></script>
    <script src="${pageContext.request.contextPath}/resources/js/bootstrap.js" />"></script>

<script>
    $(document).ready(function () {
        getdata();
        if (localStorage.getItem("session") != null) {
            $(".show-if-logout").hide();
            $("#logout").show();
            $("#memberbooking").show();
            if (localStorage.getItem("isadmin") == "true") {
                $("#admin-login").show();
                $("#user-login").hide();
            }
            else {
                $("#user-login").show();
                $("#admin-login").hide();
            }
        }
        else {
            $(".show-if-logout").show();
            $(".show-if-login").hide();
        }
    });
</script>

<script>
    $(document).ready(function () {
        $("#logout").click(function () {
            alert("logout");
            var username = localStorage.getItem("user");
            $.post("logout", {username: username});
            localStorage.clear();
            document.location = "/index";
        });
    });
</script>

<script>
    $(document).ready(function () {
        $("#user-login").click(function () {
            var username = localStorage.getItem("user");
            $('input:hidden').val(username);
            $("#myaccount").submit();
        });
    });
</script>

<script>
    $(document).ready(function () {
        $("#admin-login").click(function () {
            $("#adminmanage").submit();
        });
    });
</script>

<title> Alpha Movie Ticket Booking </title>
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
    <br><br>

    <div class="wrap">
        <center>
            <div id="carousel-example-generic" class="carousel slide col-sm-10 col-sm-offset-1" data-ride="carousel">
                <!-- Indicators -->
                <ol class="carousel-indicators">
                    <li data-target="#carousel-example-generic" data-slide-to="0" class="active"></li>
                    <li data-target="#carousel-example-generic" data-slide-to="1"></li>
                    <li data-target="#carousel-example-generic" data-slide-to="2"></li>
                    <li data-target="#carousel-example-generic" data-slide-to="3"></li>
                </ol>

                <!-- Wrapper for slides -->
                <div class="carousel-inner">
                    <div class="item active">
                        <img src="${pageContext.request.contextPath}/resources/img/the_hunger_games_mockingjay__part_1_title-2560x1600.jpg" class="image-responsive" alt="Responsive image" style="width: 100%; height: 70%;">
                        <div class="carousel-caption">

                        </div>
                    </div>
                    <div class="item">
                        <img src="${pageContext.request.contextPath}/resources/img/3_wideDraculaPoster3-1024x640-780x400.jpg" class="image-responsive" alt="Responsive image" style="width: 100%; height: 70%;">
                        <div class="carousel-caption">

                        </div>
                    </div>
                    <div class="item">
                        <img src="${pageContext.request.contextPath}/resources/img/slide2.jpg" class="image-responsive" alt="Responsive image" style="width: 100%; height: 70%;">
                        <div class="carousel-caption">

                        </div>
                    </div>
                    <div class="item">
                        <img src="${pageContext.request.contextPath}/resources/img/slide3.jpg" class="image-responsive" alt="Responsive image" style="width: 100%; height: 70%;">
                        <div class="carousel-caption">

                        </div>
                    </div>

                </div>

                <!-- Controls -->
                <a class="left carousel-control" href="#carousel-example-generic" role="button" data-slide="prev">
                    <span class="glyphicon glyphicon-chevron-left"></span>
                </a>
                <a class="right carousel-control" href="#carousel-example-generic" role="button" data-slide="next">
                    <span class="glyphicon glyphicon-chevron-right"></span>
                </a>
            </div>
        </center>
    </div>

    <footer>
        <br>
        <p class="text-center">Copyright © 2014 : Alpha Movie Ticket Booking. ||  CREDIT : © Bootstrap </p>
    </footer>

</body>
</html>