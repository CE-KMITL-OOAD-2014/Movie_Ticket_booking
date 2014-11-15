
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
    <head>
        <meta charset="UTF-8">
        <link href="${pageContext.request.contextPath}/resources/css/bootstrap.css" rel="stylesheet" >
        <link href="${pageContext.request.contextPath}/resources/css/bootstrap-theme.css" rel="stylesheet" >
        <script src="${pageContext.request.contextPath}/resources/js/jquery-2.1.1.min.js" />"></script>
    <script src="${pageContext.request.contextPath}/resources/js/bootstrap.js" />"></script>
<title> Select Seat </title>

</head>
<body>

    <style type="text/css">
        body{
            background-attachment: fixed;
            background-image: url(img/bg.jpg);
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
                    <div class="well col-sm-8 col-sm-offset-2">
                        <div class="col-sm-4">
                            <center>
                                <img src="data:image/jpg;base64,<c:out value="${movie.getB64str()}"/>" class="image-responsive" class="image-responsive" alt="Responsive image" style="width: 120px; height: 160px;">
                                <br>
                            </center>
                        </div>
                        <div class="col-sm-8">
                                <br>
                                <div><p><h4><b><c:out value="${showtime.getMname()}"/></b></h4></p></div><br>
                                <div class="date-release">
                                    <label class="col-sm-3"><b>Cinema</b></label>
                                    <p><c:out value="${showtime.getId().getCinema()}"/></p>
                                </div>  
                                <div class="time-movie">
                                    <label class="col-sm-3"><b>Time</b></label>
                                    <p><c:out value="${showtime.getId().getTime()}"/></p>
                                </div>
                            </div>
                        </div>

                    <div class="col-sm-8 col-sm-offset-2">
                        <form role="form" action="code" method="get" id="submit">
                            <br><br>
                            <center><label class="label label-warning col-sm-12"><h3><b>SCREEN</b></h3></label></center><br><br><br>

                            <div class="wrap" id="seatshow">
                                <!--row 1 normal-->
                                <br><br><br><br>
                                <span class="col-sm-1"></span>
                                <c:forEach var="seat" items="${seat}">

                                    <c:choose>
                                        <c:when test="${seat.isAvalible() == true}">
                                            <label class="label label-danger col-sm-1"><h5> <c:out value="${seat.getId().getSeat()}"/> <br><input type="checkbox" name="seat" value="<c:out value="${seat.getId().getSeat()}"/>"></h5></label>
                                                </c:when>
                                                <c:when test="${seat.isAvalible() == false}">
                                            <label class="label label-danger col-sm-1"><h5> <c:out value="${seat.getId().getSeat()}"/> <br><input type="checkbox" name="seat" value="<c:out value="${seat.getId().getSeat()}"/>" disabled></h5></label>
                                                </c:when>
                                            </c:choose>
                                            <c:if test="${seat.getId().getSeat().substring(1) ==  '10'}">
                                        <br><br><br><br>
                                        <span class="col-sm-1"></span>
                                    </c:if>
                                </c:forEach>

                                <div id="seatcheck">
                                </div>

                                <br><br><br><br>
                                <center><p>_________________________________________________________________________</p></center>
                                <br>
                                <span class="col-sm-1"></span>
                                <center>
                                    <label class="col-sm-3"><b>Normal Seat</b></label>
                                    <label class="label label-danger col-sm-1"><h5> x </h5></label>
                                </center>
                                <br><br>
                                <center><p>_________________________________________________________________________</p></center>
                                <br>
                                 <input type="hidden" name="username" value="" id="username">
                                <input type="hidden" name="mname" value="<c:out value="${showtime.getMname()}"/>">
                                <input type="hidden" name="cinema" value="<c:out value="${showtime.getId().getCinema()}"/>">
                                <input type="hidden" name="time" value="<c:out value="${showtime.getId().getTime()}"/>">
                                <button type="submit" class="btn btn-defualt col-sm-2 col-sm-offset-5"><b>Submit</b></button>
                                <br><br>
                                </form>
                                <!--</div>-->

                            </div>
                    </div>


                </div>
            </div>
        </div>
        <script>
            var countChecked = function () {
                $("button[type=submit]").attr('disabled', 'disabled');
                var n = $("input:checked").length;

                if (n == <c:out value="${seatnum}"/>) {
                    $("button[type=submit]").removeAttr('disabled');
                }
            };
            countChecked();

            $("input[type=checkbox]").on("click", countChecked);
        </script>
 <script>
    $(document).ready(function () {
        $("#submit").click(function () {
            var username = localStorage.getItem("user");
            $('#username').val(username);
        });
    });
</script>
        

</body>
</html>

