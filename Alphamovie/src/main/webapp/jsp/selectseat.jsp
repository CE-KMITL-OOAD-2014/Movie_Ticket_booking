
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
                                <img src="img/photodune-1625438-movies-film-blue-light-background-s.jpg" class="image-responsive" alt="Responsive image" style="width: 120px; height: 160px;">
                                <br>
                            </center>
                        </div>
                        <div class="col-sm-8">
                            <br>
                            <div><p><h4><b>Movie Title</b></h4></p></div><br>
                            <div class="date-release">
                                <label class="col-sm-3"><b>Cinema</b></label>
                                <p>__________</p>
                            </div>
                            <div class="type-movie">
                                <label class="col-sm-3"><b>Date</b></label>
                                <p>__________</p>
                            </div>
                            <div class="time-movie">
                                <label class="col-sm-3"><b>Time</b></label>
                                <p>__________</p>
                            </div>
                        </div>
                    </div>

                    <div class="col-sm-8 col-sm-offset-2">
                        <form role="form" action="hello" method="get">
                            <br><br>
                            <center><label class="label label-warning col-sm-12"><h3><b>SCREEN</b></h3></label></center><br><br><br>

                            <div class="wrap" id="seatshow">
                                <!--row 1 normal-->
                                <br><br><br><br>
                                <span class="col-sm-1"></span>
                                <label class="label label-danger col-sm-1"><h5> A1 <br><input type="checkbox" name="seat" value="A1" disabled></h5></label>
                                <label class="label label-danger col-sm-1"><h5> A2 <br><input type="checkbox" name="seat" value="A2" disabled></h5></label>
                                <label class="label label-danger col-sm-1"><h5> A3 <br><input type="checkbox" name="seat" value="A3"></h5></label>
                                <label class="label label-danger col-sm-1"><h5> A4 <br><input type="checkbox" name="seat" value="A4"></h5></label>
                                <label class="label label-danger col-sm-1"><h5> A5 <br><input type="checkbox" name="seat" value="A5"></h5></label>
                                <label class="label label-danger col-sm-1"><h5> A6 <br><input type="checkbox" name="seat" value="A6"></h5></label>
                                <label class="label label-danger col-sm-1"><h5> A7 <br><input type="checkbox" name="seat" value="A7"></h5></label>
                                <label class="label label-danger col-sm-1"><h5> A8 <br><input type="checkbox" name="seat" value="A8"></h5></label>
                                <label class="label label-danger col-sm-1"><h5> A9 <br><input type="checkbox" name="seat" value="A9"></h5></label>
                                <label class="label label-danger col-sm-1"><h5> A10 <br><input type="checkbox" name="seat" value="A10"></h5></label>

                                <!--row 2 normal-->
                                <br><br><br><br>
                                <span class="col-sm-1"></span>
                                <label class="label label-danger col-sm-1"><h5> B1 <br><input type="checkbox"></h5></label>
                                <label class="label label-danger col-sm-1"><h5> B2 <br><input type="checkbox"></h5></label>
                                <label class="label label-danger col-sm-1"><h5> B3 <br><input type="checkbox"></h5></label>
                                <label class="label label-danger col-sm-1"><h5> B4 <br><input type="checkbox"></h5></label>
                                <label class="label label-danger col-sm-1"><h5> B5 <br><input type="checkbox"></h5></label>
                                <label class="label label-danger col-sm-1"><h5> B6 <br><input type="checkbox"></h5></label>
                                <label class="label label-danger col-sm-1"><h5> B7 <br><input type="checkbox"></h5></label>
                                <label class="label label-danger col-sm-1"><h5> B8 <br><input type="checkbox"></h5></label>
                                <label class="label label-danger col-sm-1"><h5> B9 <br><input type="checkbox"></h5></label>
                                <label class="label label-danger col-sm-1"><h5> B10 <br><input type="checkbox"></h5></label>

                                <!--row 3 normal-->
                                <br><br><br><br>
                                <span class="col-sm-1"></span>
                                <label class="label label-danger col-sm-1"><h5> C1 <br><input type="checkbox"></h5></label>
                                <label class="label label-danger col-sm-1"><h5> C2 <br><input type="checkbox"></h5></label>
                                <label class="label label-danger col-sm-1"><h5> C3 <br><input type="checkbox"></h5></label>
                                <label class="label label-danger col-sm-1"><h5> C4 <br><input type="checkbox"></h5></label>
                                <label class="label label-danger col-sm-1"><h5> C5 <br><input type="checkbox"></h5></label>
                                <label class="label label-danger col-sm-1"><h5> C6 <br><input type="checkbox"></h5></label>
                                <label class="label label-danger col-sm-1"><h5> C7 <br><input type="checkbox"></h5></label>
                                <label class="label label-danger col-sm-1"><h5> C8 <br><input type="checkbox"></h5></label>
                                <label class="label label-danger col-sm-1"><h5> C9 <br><input type="checkbox"></h5></label>
                                <label class="label label-danger col-sm-1"><h5> C10 <br><input type="checkbox"></h5></label>

                                <!--row 1 premium-->
                                <br><br><br><br>
                                <span class="col-sm-1"></span>
                                <label class="label label-primary col-sm-1"><h5> D1 <br><input type="checkbox"></h5></label>
                                <label class="label label-primary col-sm-1"><h5> D2 <br><input type="checkbox"></h5></label>
                                <label class="label label-primary col-sm-1"><h5> D3 <br><input type="checkbox"></h5></label>
                                <label class="label label-primary col-sm-1"><h5> D4 <br><input type="checkbox"></h5></label>
                                <label class="label label-primary col-sm-1"><h5> D5 <br><input type="checkbox"></h5></label>
                                <label class="label label-primary col-sm-1"><h5> D6 <br><input type="checkbox"></h5></label>
                                <label class="label label-primary col-sm-1"><h5> D7 <br><input type="checkbox"></h5></label>
                                <label class="label label-primary col-sm-1"><h5> D8 <br><input type="checkbox"></h5></label>
                                <label class="label label-primary col-sm-1"><h5> D9 <br><input type="checkbox"></h5></label>
                                <label class="label label-primary col-sm-1"><h5> D10 <br><input type="checkbox"></h5></label>

                                <!--row 2 premium-->
                                <br><br><br><br>
                                <span class="col-sm-1"></span>
                                <label class="label label-primary col-sm-1"><h5> E1 <br><input type="checkbox"></h5></label>
                                <label class="label label-primary col-sm-1"><h5> E2 <br><input type="checkbox"></h5></label>
                                <label class="label label-primary col-sm-1"><h5> E3 <br><input type="checkbox"></h5></label>
                                <label class="label label-primary col-sm-1"><h5> E4 <br><input type="checkbox"></h5></label>
                                <label class="label label-primary col-sm-1"><h5> E5 <br><input type="checkbox"></h5></label>
                                <label class="label label-primary col-sm-1"><h5> E6 <br><input type="checkbox"></h5></label>
                                <label class="label label-primary col-sm-1"><h5> E7 <br><input type="checkbox"></h5></label>
                                <label class="label label-primary col-sm-1"><h5> E8 <br><input type="checkbox"></h5></label>
                                <label class="label label-primary col-sm-1"><h5> E9 <br><input type="checkbox"></h5></label>
                                <label class="label label-primary col-sm-1"><h5> E10 <br><input type="checkbox"></h5></label>

                            </div>

                            <div id="seatcheck">
                            </div>

                            <br><br><br><br>
                            <center><p>_________________________________________________________________________</p></center>
                            <br>
                            <span class="col-sm-1"></span>
                            <label class="col-sm-3"><b>Normal Seat</b></label>
                            <label class="label label-danger col-sm-1"><h5> x </h5></label>
                            <span class="col-sm-1"></span>
                            <label class="col-sm-3"><b>Premium Seat</b></label>
                            <label class="label label-primary col-sm-1"><h5> x </h5></label>
                            <br><br>
                            <center><p>_________________________________________________________________________</p></center>
                            <br>

                            <!--<div class="wrap">
                                    <form class="form-horizontal" role="form">
                                            <div class="form-group">
                                                    <div id="selectseat">
                                          <label class="control-label col-sm-3" for="input-name">Seat 1 :</label>
                                          <div class="col-sm-3">
                                        <select class="form-control" for="select-rowseat">
                                          <option>-row-</option>
                                          <option>A</option>
                                          <option>B</option>
                                          <option>C</option>
                                          <option>D</option>
                                          <option>E</option>
                                          <option>F</option>
                                          <option>G</option>
                                        </select>
                                      </div>
                                      <div class="col-sm-3">
                                        <select class="form-control" for="select-numseat">
                                          <option>-No.-</option>
                                          <option>1</option>
                                          <option>2</option>
                                          <option>3</option>
                                          <option>4</option>
                                          <option>5</option>
                                          <option>6</option>
                                          <option>7</option>
                                          <option>8</option>
                                          <option>9</option>
                                          <option>10</option>
                                        </select>
                                      </div>
                                      <br><br>
                                        </div>
                                        <div id="selectseat">
                                          <label class="control-label col-sm-3" for="input-name">Seat 2 :</label>
                                          <div class="col-sm-3">
                                        <select class="form-control" for="select-rowseat">
                                          <option>-row-</option>
                                          <option>A</option>
                                          <option>B</option>
                                          <option>C</option>
                                          <option>D</option>
                                          <option>E</option>
                                          <option>F</option>
                                          <option>G</option>
                                        </select>
                                      </div>
                                      <div class="col-sm-3">
                                        <select class="form-control" for="select-numseat">
                                          <option>-No.-</option>
                                          <option>1</option>
                                          <option>2</option>
                                          <option>3</option>
                                          <option>4</option>
                                          <option>5</option>
                                          <option>6</option>
                                          <option>7</option>
                                          <option>8</option>
                                          <option>9</option>
                                          <option>10</option>
                                        </select>
                                      </div>
                                      <br><br>
                                        </div>
                                </div>-->
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
            console.log((n + (n === 1 ? " is" : " are") + " checked!"));
            console.log(<c:out value="${seatnum}"/>);

            if (n == <c:out value="${seatnum}"/>) {
                $("button[type=submit]").removeAttr('disabled');
            }
        };
        countChecked();

        $("input[type=checkbox]").on("click", countChecked);
    </script>

</body>
</html>

