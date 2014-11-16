<html>
    <head>
        <meta charset="UTF-8">
        <link href="${pageContext.request.contextPath}/resources/css/bootstrap.css" rel="stylesheet" >
        <link href="${pageContext.request.contextPath}/resources/css/bootstrap-theme.css" rel="stylesheet" >
        <script src="${pageContext.request.contextPath}/resources/js/jquery-2.1.1.min.js" />"></script>
    <script src="${pageContext.request.contextPath}/resources/js/bootstrap.js" />"></script>
<title>ADMIN</title>

</head>
<jsp:include page="navbar.jsp" />
<body>
    <jsp:include page="navbar.jsp" />
    <div class="page-header">

    </div>
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
            background:#B5B5B5;
        }
        .well {
            background:#D3D3D3;
        }
    </style>
    <div class="wrap">
        <div class="container">
            <div class="page-header">
                <img src="${pageContext.request.contextPath}/resources/img/admin.png" class="img-responsive col-sm-offset-2" alt="Responsive image">
            </div>

            <div class="well col-sm-8 col-sm-offset-2">
                <div class="panel panel-default">
                    <div class="panel-body">
                        <br>
                        <p>
                            <a href=# id="movie"><button type="button" class="btn btn-danger col-sm-8 col-sm-offset-2"><br><b><h4>Add & Delete Movie</h4></b><br></button></a>
                        </p>
                        <br><br><br><br><br><br>
                        <p>
                            <a href=# id="showtime"><button type="button" class="btn btn-primary col-sm-3 col-sm-offset-2"><br><b><h4>Add Showtime</h4></b><br></button></a>
                            <a href=# id="cinema"><button type="button" class="btn btn-warning col-sm-3 col-sm-offset-2"><br><b><h4>Add Cinema</h4></b><br></button></a>
                        </p>
                        <br><br><br><br><br>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <form id="movieedit" role="form" name ="input" action="movieedit" method="post">
    </form>
    <form id="showtimeedit" role="form" name ="input" action="showtimeedit" method="post">
    </form>
    <form id="cinemaedit" role="form" name ="input" action="cinemaedit" method="post">
    </form>
    <script>
        $(document).ready(function () {
            $("#movie").click(function () {
                $("#movieedit").submit();
            });
        });
    </script>
    <script>
        $(document).ready(function () {
            $("#showtime").click(function () {
                $("#showtimeedit").submit();
            });
        });
    </script>
    <script>
        $(document).ready(function () {
            $("#cinema").click(function () {
                $("#cinemaedit").submit();
            });
        });
    </script>



</body>
</html>