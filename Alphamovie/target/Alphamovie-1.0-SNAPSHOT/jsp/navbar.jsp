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

<title> </title>
</head>
<body>

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
                <li><a href="showtime" ><b> Showtime </b></a></li>
                <li class="show-if-login" id="memberbooking"><a href="selectshowtime"><b> Booking Ticket </b></a></li>
                <li class="show-if-logout" id="disablebooking" data-toggle="modal" data-target="#alertModal"><a href="#"><b> Booking Ticket </b></a></li>
            </ul>

            <ul class="nav navbar-nav navbar-right">     
                <li class="show-if-logout" data-toggle="modal" data-target="#signinModal">
                    <a href="#"><b> Sign In </b></a>
                </li>
                <li class="show-if-logout" data-toggle="modal" data-target="#signupModal"><a href="#"><b> Sign Up </b></a></li> 

                <li class="show-if-login" id="user-login">
                    <a href="#"><span class="user-name"><span class="glyphicon glyphicon-user"></span><b> Your Account </b></span></a>
                </li>
                <li class="show-if-login" id="admin-login">
                    <a href="#"><span class="user-name"><span class="glyphicon glyphicon-user"></span><b> Admin </b></span></a>
                </li>
                <li class="show-if-login" id="logout">
                    <a href="#" onclick="logout"><b> Sign Out </b></a>
                </li>
            </ul>
        </div><!-- /.navbar-collapse -->
    </div><!-- /.container-fluid -->
</nav>

<form id="myaccount" role="form" name ="input" action="myaccount" method="post">
    <input type="hidden" name="username">
</form>
<form id="adminmanage" role="form" name ="input" action="adminmanage" method="post">
</form>

<script>
    function getdata() {
        if ("<c:out value="${user.getSession()}"/>".length !== 0)
        {
            // Code for localStorage/sessionStorage.
            localStorage.setItem("user", '<c:out value="${user.getUsername()}"/>');
            localStorage.setItem("session", '<c:out value="${user.getSession()}"/>');
            localStorage.setItem("isadmin", '<c:out value="${user.isIsadmin()}"/>');
            //fetch object
            console.log(localStorage.getItem("user"));
            console.log(localStorage.getItem("session"));
            console.log(localStorage.getItem("isadmin"));
        }
        else
        {
            // Sorry! No Web Storage support..
        }
    }
</script>

<script>
    function checkPasswordMatch() {
        var password = $("#input-password").val();
        var confirmPassword = $("#confirm-password").val();
        if (password != confirmPassword) {
            $("#confirm-password").css("background-color", "#d9534f");
            $("#regis-submit").prop("type", "button");
        }
        else {
            $("#confirm-password").css("background-color", "#5cb85c");
            $("#regis-submit").prop("type", "submit");
        }
    }
    $(document).ready(function () {
        $("#confirm-password").keyup(checkPasswordMatch);
    });
</script>
<!--alert booking Modal -->
<div class="modal fade" id="alertModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal"><span aria-hidden="true">&times;</span><span class="sr-only">Close</span></button><br>
            </div>
            <div class="modal-body">
                <div class="wrap">
                    <h3><center><b>Please sign in before use this function.</b></center></h3>
                </div>
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
                <div class="wrap">
                    <form class="form-horizontal" role="form" name ="input" action="login" method="post">
                        <center>
                            <div class="form-group">
                                <div class="input-group col-sm-7">
                                    <span class="input-group-addon"><span class="glyphicon glyphicon-user"></span></span>
                                    <input type="username" name="username" class="form-control" placeholder="Username">
                                </div>
                            </div>
                            <br>
                            <div class="form-group">
                                <div class="input-group col-sm-7">
                                    <span class="input-group-addon"><span class="glyphicon glyphicon-lock"></span></span>
                                    <input type="password" name="password" class="form-control" placeholder="Password">
                                </div>
                            </div>
                            <!--<p><input type="checkbox"> Remember Me </p>-->
                        </center>
                        <div class="modal-footer">
                            <button type="submit" class="btn btn-default"><b>Sign In</b></button>
                        </div>
                    </form>
                </div>
            </div>
        </div>
    </div>
</div>            


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
                    <form class="form-horizontal" role="form" name = "input" action="register" method="post">
                        <div class="form-group">

                            <label class="control-label col-sm-4" for="input-username">Username :</label>
                            <div class="col-sm-6">
                                <input type="text" name="username" class="form-control" pattern=".{5,15}" required title="5 to 10 characters" id="input-username" placeholder="Username" autofocus>
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="control-label col-sm-4" for="input-password">Password :</label>
                            <div class="col-sm-6">
                                <input type="password" name="password" class="form-control" id="input-password" placeholder="Password" pattern=".{8,15}" required title="8 to 15 characters" autofocus onchange="form.repass.pattern = this.value;" > <!-- -->
                            </div>
                            <div class="col-sm-9"><p class="help-block col-sm-offset-3">At least 8 to 15 Alphabet. (A-z,a-z,0-9,No space)</p></div>
                        </div>
                        <div class="form-group">
                            <label class="control-label col-sm-4" for="confirm-password">Confirm Password :</label>
                            <div class="col-sm-6">
                                <input type="password" name="confirmpassword" class="form-control" id="confirm-password" placeholder="Confirm Password" required autofocus title="Please use same password."><!---->
                            </div>
                            <ul><p class="col-sm-6 help-block">.</p></ul>
                        </div>
                        <div class="form-group">
                            <label class="control-label col-sm-4" for="input-email">Email address :</label>
                            <div class="col-sm-6">
                                <input type="email" name="email" class="form-control" id="input-email" placeholder="Enter email" required autofocus>
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="control-label col-sm-4" for="input-tel">Phone Number :</label>
                            <div class="col-sm-6">
                                <input type="tel" name="phonenumber" class="form-control" id="input-tel" placeholder="(xxx)-xxx-xxxx" required autofocus>
                            </div>
                        </div>
                        <div class="modal-footer">
                            <button type="submit" class="btn btn-default" id="regis-submit">Submit</button> <!--data-dismiss="modal" -->
                        </div>
                    </form>
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

</body>
</html>