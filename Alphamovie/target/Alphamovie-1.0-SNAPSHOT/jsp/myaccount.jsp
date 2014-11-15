<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html>
    <head>
        <meta charset="UTF-8">
        <link href="${pageContext.request.contextPath}/resources/css/bootstrap.css" rel="stylesheet" >
        <link href="${pageContext.request.contextPath}/resources/css/bootstrap-theme.css" rel="stylesheet" >
        <script src="${pageContext.request.contextPath}/resources/js/jquery-2.1.1.min.js" />"></script>
    <script src="${pageContext.request.contextPath}/resources/js/bootstrap.js" />"></script>
<title>My Account</title>

</head>
<body>
    <jsp:include page="navbar.jsp" />
    <style type="text/css">
        body{
            background-attachment: fixed;
            background-image: url(${pageContext.request.contextPath}/resources/img/CinemaBackground.jpg);
            background-size: cover;
            background-position: center;
            background-repeat: no-repeat;
        }
        div{
            word-wrap:break-word; 
            display:block;
        }
        .panel {
            background:#D3D3D3;}
        .nav-tabs > li.active > a,
        .nav-tabs > li.active > a:hover,
        .nav-tabs > li.active > a:focus {
            color: #000000;
            cursor: white;
            background-color: #D3D3D3;

            border-bottom-color: transparent;
        } 
    </style>
    
    <script>
						function checkPassMatch() {
							var newpassword = $("#input-newpassword").val();
							var newconfirmPassword = $("#confirm-newpassword").val();
							if (newpassword != newconfirmPassword){
								  $("#confirm-newpassword").css( "background-color", "#d9534f" );
								  $("#send-newpass").prop("type", "button");	 
							}
							else{
								$("#confirm-newpassword").css( "background-color", "#5cb85c" );
								$("#send-newpass").prop("type", "submit");
							}
						}
						$(document).ready(function () {
						   $("#confirm-newpassword").keyup(checkPassMatch);					
						});
    </script>
    <div class="page-header">

    </div>
    <div class="wrap">
        <div class="container">
            <div class="page-header">
                <img src="${pageContext.request.contextPath}/resources/img/myacc2.png" class="img-responsive col-sm-offset-2" alt="Responsive image">
            </div>

            <div class="panel panel-default col-sm-8 col-sm-offset-2">
                <h3 class="panel-title">
                    <ul class="nav nav-tabs" role="tablist">
                        <li class="active"><a href="#profile" role="tab" data-toggle="tab"><b>Profile</b></a></li>
                        <li><a href="#editinfo" role="tab" data-toggle="tab"><b>Edit Profile</b></a></li>
                        <li><a href="#changepass" role="tab" data-toggle="tab"><b>Change Password</b></a></li>
                        <li><a href="#checkbooking" role="tab" data-toggle="tab"><b>Check Booking Status</b></a></li>
                    </ul>
                </h3>
                <div class="panel-body">
                    <div class="tab-content">

                        <!-- /.Profile form -->
                        <div class="tab-pane fade in active" id="profile">
                            <form class="form-horizontal" role="form">
                                <div class="form-group">
                                    <label class="control-label col-sm-3" for="show-username">Username :</label>
                                    <div class="col-sm-6">
                                        <p> <c:out value="${user.getUsername()}"/> </p>
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label class="control-label col-sm-3" for="show-email">Email :</label>
                                    <div class="col-sm-6">
                                        <p> <c:out value="${user.getEmail()}"/> </p>
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label class="control-label col-sm-3" for="show-tel">Phone Number :</label>
                                    <div class="col-sm-6">
                                        <p> <c:out value="${user.getPhonenumber()}"/> </p>
                                    </div>
                                </div>
                            </form>
                        </div>

                        <!-- /.Edit-Profile form -->
                        <div class="tab-pane fade" id="editinfo">
                            <form class="form-horizontal" role="form" name = "input" action="update" method="post">
                                <input type="hidden" name="username" class="form-control" id="input-username" value="<c:out value="${user.getUsername()}"/>">
                                <div class="form-group">
                                    <label class="control-label col-sm-3" for="show-username">Username :</label>
                                    <div class="col-sm-6">
                                        <input type="text" name="username" class="form-control" id="input-username" placeholder="<c:out value="${user.getUsername()}"/>" disabled="disabled">
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label class="control-label col-sm-3" for="show-email">Email :</label>
                                    <div class="col-sm-6">
                                        <input type="text" name="email" class="form-control" id="input-email" placeholder="<c:out value="${user.getEmail()}"/>">
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label class="control-label col-sm-3" for="show-tel">Phone Number :</label>
                                    <div class="col-sm-6">
                                        <input type="text" name="phonenumber" class="form-control" id="input-tel" placeholder="<c:out value="${user.getPhonenumber()}"/>">
                                    </div>
                                </div>
                                <p>  </p>
                                <button type="submit" class="btn btn-warning col-sm-2 col-sm-offset-5"><b>Submit</b></button>
                            </form>
                        </div>

                        <!-- /.Change-password form -->
                        <div class="tab-pane fade" id="changepass">
                            <form class="form-horizontal" role="form" name = "input" action="changepassword" method="post">
                                <input type="hidden" name="username" class="form-control" id="input-username" value="<c:out value="${user.getUsername()}"/>">
                                <p>  </p>
                                <div class="form-group">
                                    <label class="control-label col-sm-4" for="input-newpassword">New Password:</label>
                                    <div class="col-sm-6">
                                        <input type="password" name="newpassword" class="form-control" id="input-newpassword" placeholder="New Password" pattern=".{8,15}" required title="8 to 15 characters" autofocus>
                                    </div>
                                    <span class="col-sm-8"></span><p class="col-sm-7 col-sm-offset-4 help-block">At least 8 to 15 Alphabet. (A-z,a-z,0-9,No space)</p>
                                </div>
                                <div class="form-group">
                                    <label class="control-label col-sm-4" for="confirm-newpassword">Confirm New Password:</label>
                                    <div class="col-sm-6">
                                        <input type="password" name="confirmnewpassword" class="form-control" id="confirm-newpassword" placeholder="Confirm New Password" required autofocus title="Please use same password.">
                                    </div>
                                    <p class="col-sm-3 help-block">.</p>
                                </div>
                                <div class="form-group">
                                    <label class="control-label col-sm-4" for="input-newpassword">Password:</label>
                                    <div class="col-sm-6">
                                        <input type="password" name="oldpassword" class="form-control" id="input-password" placeholder="Password">
                                    </div>
                                </div>
                                <p>  </p>
                                <button type="submit" class="btn btn-warning col-sm-2 col-sm-offset-5" id="send-newpass"><b>Submit</b></button>
                            </form>
                        </div>



                        <!-- /.Check-booking form -->
                        <div class="tab-pane fade" id="checkbooking">
                            <c:choose>
                                <c:when test="${code == null}">
                                    <div class="jumbotron">
                                        <center><h1>None<br> Booking Status</h1></center>
                                    </div>
                                </c:when>
                                <c:when test="${code != null}">
                                    <table class="table table-striped">
                                        <tbody>
                                            <tr class="bookstatus" id="bs1">
                                                <td class="col-sm-2"><center><h2><c:out value="${code.getCinema()}"/></h2></center></td>
                                        <td class="col-sm-6">
                                            <br>
                                            <p><b><c:out value="${code.getMname()}"/></b></p>
                                            <p>Showtime : <c:out value="${code.getTime()}"/></p>
                                            <p>Seat : <c:out value="${code.getSeatname()}"/></p>
                                            <p>Booking Code : <c:out value="${code.getCode()}"/></p>
                                            <br>
                                        </td>
                                        <td>
                                        <center>
                                            <br>
                                            <form role="form" action="canclebooking" method="post" >
                                                <input type="hidden" name="code" value="<c:out value="${code.getCode()}"/>">>
                                                <input type="hidden" name="username" value="<c:out value="${user.getUsername()}"/>">
                                                <button type="submit" class="btn btn-danger"><b>Cancel Booking</b></button>
                                            </form>
                                        </center>
                                        </td>
                                        </tr>
                                        </tbody>
                                    </table>
                                </c:when>
                            </c:choose>
                        </div>


                    </div>
                </div>
            </div>
        </div>
</body>
</html>