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
    <nav class="navbar navbar-fixed-top navbar-inverse" role="navigation">
        <div class="container-fluid">
            <!-- Brand and toggle get grouped for better mobile display -->
            <div class="navbar-header">
                <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse">
                    <span class="sr-only">Toggle navigation</span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                </button>
                <a class="navbar-brand" href="index"><img alt="Brand Responsive image" src="${pageContext.request.contextPath}/resources/img/logobrand.png" class="img-responsive"></a>
            </div>
            <!-- Collect the nav links, forms, and other content for toggling -->
            <div class="collapse navbar-collapse" id="bs-example-navbar-collapse">
                <ul class="nav navbar-nav">
                    <li><a href="movie"> Movie </a></li>
                    <li><a href="showtime"> Showtime </a></li>
                    <li><a href="#"> Booking Ticket </a></li>
                </ul>

                <!--ul class="nav navbar-nav">
                                <div class="input-group">
                                <form class="navbar-form  col-sm-4" role="search">
                                        <div class="form-group">
                                                <input type="text" class="form-control" placeholder="Search movie by title.">
                                                <span class="input-group-btn">
                                                        <button class="btn btn-default" type="button" onClick="location.href='#"><span class="glyphicon glyphicon-search"></span> Search </button>
                                                </span>
                                        </div>
                                </form>
                        </div>
                        </ul-->

                <ul class="nav navbar-nav navbar-right">     
                    <li class="show-if-logout" style="display: list-item;" data-toggle="modal" data-target="#signinModal">
                        <a href="#"> Sign In </a>

                    </li>
                    <li class="show-if-logout" style="display: list-item;" data-toggle="modal" data-target="#signupModal"><a href=" # "> Sign Up </a></li> 
                    <li class="show-if-login" id="user-menu" style="display: none;">
                        <a href="#" class="dropdown-toggle" data-toggle="dropdown">
                            <span class="user-name"><span class="glyphicon glyphicon-user"></span> Your Account</span>
                            <b class="caret"></b>
                        </a>
                        <ul class="dropdown-menu">
                            <li><a href=" # ">View Your Profile</a></li>
                            <li><a href=" # ">Manage Booking</a></li>
                            <li class="divider"></li>
                            <li><a href=" # ">Sign Out</a></li>
                        </ul>
                    </li> 
                </ul>
            </div><!-- /.navbar-collapse -->
        </div><!-- /.container-fluid -->
    </nav>

    <!--Sign Up Modal -->
    <div class="modal fade" id="signupModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
        <div class="modal-dialog">
            <div class="modal-content">
                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal"><span aria-hidden="true">&times;</span><span class="sr-only">Close</span></button>
                    <h1 class="modal-title" id="myModalLabel">Member Registeration</h4>
                </div>
                <div class="modal-body">
                    <div class="wrap">
                        <div class="container">

                            <form class="form-horizontal" role="form" name = "input" action="adduser" method="get">

                                <div class="form-group">
                                    <label class="control-label col-sm-2" for="input-username">Username :</label>
                                    <div class="col-sm-3">
                                        <input type="text" name="username" class="form-control" id="input-username" placeholder="Username" required autofocus>
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label class="control-label col-sm-2" for="input-password">Password :</label>
                                    <div class="col-sm-3">
                                        <input type="password" name="password" class="form-control" id="input-password" placeholder="Password" > <!--required autofocus onchange="form.repass.pattern = this.value; -->
                                    </div>
                                    <div class="col-sm-9"><p class="help-block col-sm-offset-3">At least 8-12 Alphabet. (A-z,a-z,0-9,No space)</p></div>
                                </div>
                                <div class="form-group">
                                    <label class="control-label col-sm-2" for="confirm-password">Confirm Password :</label>
                                    <div class="col-sm-3">
                                        <input type="password" name="confirmpassword" class="form-control" id="confirm-password" placeholder="Confirm Password" ><!--required autofocus title="Please use same password."-->
                                    </div>
                                    <ul><p class="col-sm-3 help-block">.</p></ul>
                                </div>
                                <div class="form-group">
                                    <label class="control-label col-sm-2" for="input-email">Email address :</label>
                                    <div class="col-sm-3">
                                        <input type="text" name="email" class="form-control" id="input-email" placeholder="Enter email" required autofocus>
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label class="control-label col-sm-2" for="input-tel">Phone Number :</label>
                                    <div class="col-sm-3">
                                        <input type="text" name="phonenumber" class="form-control" id="input-tel" placeholder="(xxx)-xxx-xxxx" required autofocus>
                                    </div>
                                </div>
                                <div class="modal-footer">
                                    <button type="submit" class="btn btn-default" >Submit</button> <!--data-dismiss="modal" -->
                                </div>
                            </form>
                        </div>
                    </div>
                </div>
                <div>
                    <input type="hidden" name="username" value=<%out.print(request.getParameter("username")); %>>
                    <input type="hidden" name="email" value=<%out.print(request.getParameter("email")); %>>
                    <input type="hidden" name="password" value=<%out.print(request.getParameter("password")); %>>
                    <input type="hidden" name="phonenumber" value=<%out.print(request.getParameter("phonenumber"));%>>
                </div>

            </div>
        </div>
    </div>

    <!--Sign In Modal -->


    <div class="modal fade" id="signinModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
        <div class="modal-dialog">
            <div class="modal-content">
                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal"><span aria-hidden="true">&times;</span><span class="sr-only">Close</span></button>
                    <h1 class="modal-title" id="myModalLabel">Sign In</h4>
                </div>
                <div class="modal-body">
                    <div class="signin">
                        <center>
                            <div class="input-group col-sm-7">
                                <span class="input-group-addon"><span class="glyphicon glyphicon-user"></span></span>
                                <input type="username" class="form-control" placeholder="Username">
                            </div>
                            <br>
                            <div class="input-group col-sm-7">
                                <span class="input-group-addon"><span class="glyphicon glyphicon-lock"></span></span>
                                <input type="password" class="form-control" placeholder="Password">
                            </div>
                            <br>
                            <p><input type="checkbox"> Remember Me </p>
                        </center>
                    </div>
                </div>
                <div class="modal-footer">
                    <button type="submit" class="btn btn-default" data-dismiss="modal">Sign In</button>
                </div>
            </div>
        </div>
    </div>


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
                        <div class="tab-pane fade in active" id="nowshow" style="display:block;">
                            <c:forEach var="movie" items="${movie}">
                                <div class="well col-sm-3">
                                    <a href ="moviedetail?mname=<c:out value="${movie.getMname()}"></c:out>">
                                    <img src="${pageContext.request.contextPath}/resources/img/photodune-1625438-movies-film-blue-light-background-s.jpg" class="image-responsive" alt="Responsive image" style="width: 150px; height: 200px;">
                                    <p><c:out value="${movie.getMname()}"></c:out></p>
                                        </a>
                                    </div>
                            </c:forEach>
                        </div>

                    <!--Coming Tab -->
                    <div class="tab-pane fade in active" id="coming">

                        <p>________________</p>
                        <p>________________</p>
                        <p>________________</p>
                        <p>________________</p>
                        <p>________________</p>
                        <p>________________</p>
                        <p>________________</p>
                    </div>
                </div>
            </div>
        </div>
    </div>
</center>
</body>
</html>
