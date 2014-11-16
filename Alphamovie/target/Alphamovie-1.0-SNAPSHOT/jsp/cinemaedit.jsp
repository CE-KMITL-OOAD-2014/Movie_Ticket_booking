<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
    <head>
        <meta charset="UTF-8">
        <link href="${pageContext.request.contextPath}/resources/css/bootstrap.css" rel="stylesheet">
        <script src="${pageContext.request.contextPath}/resources/js/jquery-2.1.1.min.js"></script>
        <script src="${pageContext.request.contextPath}/resources/js/bootstrap.js"></script>
        <title>Add Cinema</title>
    </head>
    <body>
        <style type="text/css">
            div{
                word-wrap:break-word; 
                display:block;
            }
            body{
                background-color:#CFCFCF;
            }
        </style>
        <div class="page-header">
            <span class="col-sm-1"></span><h1>Add Cinema</h1>
        </div>
        <div class="wrap col-sm-offset-1 col-sm-10">
            <div class="col-sm-6">

                <c:forEach var="cinema" items="${cinema}">
                    <div class="well col-sm-5">
                        <center><p><b>Cinema <c:out value=" ${cinema.getCinema()}"/></b></p></center>
                        <p>Seat</p>
                        <p><c:out value=" ${cinema.getSeatmax()}"/></p>
                    </div>
                    <span class="col-sm-1"></span>
                </c:forEach>

            </div>
            <div class="col-sm-6">
                <form role="form" action="addcinema" method="post">
                    <center><img src="${pageContext.request.contextPath}/resources/img/seatplan.jpg"></center>
                    <br>
                    <div class="form-group">
                        <label for="innumseatprow">Number of Seat Row</label>
                        <input type="text" name="seat" class="form-control" id="innumseatprow" placeholder="Number of Seat Row">
                    </div>
                    <span class="col-sm-5"></span><button type="submit" class="btn btn-default col-sm-2"><b>Submit</b></button>
                    <br><br>
                </form>
            </div>
        </div>
    </body>
</html>