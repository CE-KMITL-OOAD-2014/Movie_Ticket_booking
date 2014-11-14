<html>
    <head>
        <meta charset="UTF-8">
        <link href="${pageContext.request.contextPath}/resources/css/bootstrap.css" rel="stylesheet" >
        <link href="${pageContext.request.contextPath}/resources/css/bootstrap-theme.css" rel="stylesheet" >
        <script src="${pageContext.request.contextPath}/resources/js/jquery-2.1.1.min.js" />"></script>
    <script src="${pageContext.request.contextPath}/resources/js/bootstrap.js" />"></script>
        <title> Booking </title>
    </head>
    <body>

        <style type="text/css">
            body{
                background-attachment: fixed;
                background-image: url(/resources/img/bg.jpg);
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
                                    <img src="${pageContext.request.contextPath}/resources/img/photodune-1625438-movies-film-blue-light-background-s.jpg" class="image-responsive" alt="Responsive image" style="width: 120px; height: 160px;">
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
                            <form role="form" name ="input" action="selectseat" method="get">
                                <p><h4><b>Select seat type</b></h4></p>
                                <p class="help-block">help comment</p><br><br>
                                <div class="normal-seat">
                                    <label class="col-sm-3 col-sm-offset-3"><b>Normal seat</b></label>
                                    <div class="col-sm-2">
                                        <select class="form-control" for="select-nseat" name="val">
                                            <option>-</option>
                                            <option value="1">1</option>
                                            <option value="2">2</option>
                                            <option value="3">3</option>
                                            <option value="4">4</option>
                                        </select>
                                    </div>
                                    <label class="col-sm-2"> 120 Baht</label>
                                </div>
                                <br><br><br>
                                <!--<div class="premium-seat">
                                    <label class="col-sm-3 col-sm-offset-3"><b>Premium seat</b></label>

                                    <div class="col-sm-2">
                                        <select class="form-control" for="select-nseat">
                                            <option>-</option>
                                            <option>1</option>
                                            <option>2</option>
                                            <option>3</option>
                                            <option>4</option>
                                        </select>
                                    </div>
                                    <label class="col-sm-2"> 150 Baht</label>
                                </div>-->
                                <br><br><br><br>
                                <button type="submit" class="btn btn-defualt col-sm-2 col-sm-offset-10"><b>Submit</b></button>
                                <br><br>
                            </form>
                        </div>
                    </div>           
                </div>
            </div>
        </div>           
    </body>
</html>