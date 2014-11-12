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
            $(document).ready(function(){
                if ($(localStorage.getItem("session")).val() != ''){
                    $(".show-if-logout").hide();
                    $("#logout").show();
                    if ($(localStorage.getItem("isadmin")).val() === 'true'){
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
            $(document).ready(function(){
              $("#logout").click(function(){
                    localStorage.clear();
                    location.reload(true);
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
                    <li><a href="movie"><b> Movie </b></a></li>
                    <li><a href="showtime"><b> Showtime </b></a></li>
                    <li><a href="#"><b> Booking Ticket </b></a></li>
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
		        		<li class="show-if-logout">
		         			<a href="signin.html"><b> Sign In </b></a>
		        		</li>
		        		<li class="show-if-logout" data-toggle="modal" data-target="#signupModal"><a href="#"><b> Sign Up </b></a></li> 
		        		
		        		<li class="show-if-login" id="user-login">
        					<a href="myaccount.html"><span class="user-name"><span class="glyphicon glyphicon-user"></span><b> Your Account </b></span></a>
        				</li>
        				<li class="show-if-login" id="admin-login">
        					<a href="adminmanage.html"><span class="user-name"><span class="glyphicon glyphicon-user"></span><b> Admin </b></span></a>
        				</li>
        				<li class="show-if-login" id="logout">
		         			<a href="#"><b> Sign Out </b></a>
		        		</li>
		</ul>
            </div><!-- /.navbar-collapse -->
        </div><!-- /.container-fluid -->
    </nav>
                
                <script>
                    if(typeof(Storage)!=="undefined")
                        {
                        // Code for localStorage/sessionStorage.
                        localStorage.setItem("user",'<c:out value="${user.getUsername()}"></c:out>');
                        localStorage.setItem("session",'xx');  
                        localStorage.setItem("isadmin",'false');  
                        //fetch object
                        console.log(localStorage.getItem("user")); // will return "[object Object]"
                        console.log(localStorage.getItem("session"));
                        console.log(localStorage.getItem("isadmin"));
                        }
                    else
                        {
                        // Sorry! No Web Storage support..
                        }
                </script>

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

                            <form class="form-horizontal" role="form" name = "input" action="myaccount" method="post">

                                <div class="form-group">
                                    <label class="control-label col-sm-2" for="input-username">Username :</label>
                                    <div class="col-sm-3">
                                        <input type="text" name="username" class="form-control" id="input-username" placeholder="Username" required autofocus>
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label class="control-label col-sm-2" for="input-password">Password :</label>
                                    <div class="col-sm-3">
                                        <input type="password" name="password" class="form-control" id="input-password" placeholder="Password" required autofocus onchange="form.repass.pattern = this.value;" > <!-- -->
                                    </div>
                                    <div class="col-sm-9"><p class="help-block col-sm-offset-3">At least 8-12 Alphabet. (A-z,a-z,0-9,No space)</p></div>
                                </div>
                                <div class="form-group">
                                    <label class="control-label col-sm-2" for="confirm-password">Confirm Password :</label>
                                    <div class="col-sm-3">
                                        <input type="password" name="confirmpassword" class="form-control" id="confirm-password" placeholder="Confirm Password" required autofocus title="Please use same password."><!---->
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
                        <img src="${pageContext.request.contextPath}/resources/img/the_hunger_games_mockingjay__part_1_title-2560x1600.jpg" class="image-responsive" alt="Responsive image" style="width: 100%; height: 500px;">
                        <div class="carousel-caption">

                        </div>
                    </div>
                    <div class="item">
                        <img src="${pageContext.request.contextPath}/resources/img/3_wideDraculaPoster3-1024x640-780x400.jpg" class="image-responsive" alt="Responsive image" style="width: 100%; height: 500px;">
                        <div class="carousel-caption">

                        </div>
                    </div>
                    <div class="item">
                        <img src="${pageContext.request.contextPath}/resources/img/slide2.jpg" class="image-responsive" alt="Responsive image" style="width: 100%; height: 500px;">
                        <div class="carousel-caption">

                        </div>
                    </div>
                    <div class="item">
                        <img src="${pageContext.request.contextPath}/resources/img/slide3.jpg" class="image-responsive" alt="Responsive image" style="width: 100%; height: 500px;">
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
        <p class="col-sm-offset-9">Copyright © 2014 : Alpha Movie Ticket Booking.</p>
    </footer>

</body>
</html>