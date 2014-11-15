<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
    <head>
        <meta charset="UTF-8">
        <link href="${pageContext.request.contextPath}/resources/css/bootstrap.css" rel="stylesheet">
        <script src="${pageContext.request.contextPath}/resources/jquery-2.1.1.min.js"></script>
        <script src="${pageContext.request.contextPath}/resources/js/bootstrap.js"></script>

        <title>Add Showtime</title>
    </head>
    <body>
        <style type="text/css">
            body{
                background-color:#CFCFCF;
            }
        </style>

        <div class="page-header">
            <span class="col-sm-1"></span><h1>Add Showtime</h1>
        </div>
        <div class="wrap">
        <div class="well col-sm-8 col-sm-offset-2">
        <span class="col-sm-1"></span><h3>Showtime List</h3>
        <table class="table table-striped">
                        <thead>
                            <tr>
                                <th class="col-sm-2 text-center"><h4><b>Cinema</b></h4></th>
                        <th class="col-sm-4"><h4><b>MovieTitle</b></h4></th>
                        <th><h4><b>Time</b></h4></th>
                        </tr>
                        </thead>
                        <tbody>
                            <c:forEach var="showtime" items="${showtime}">
                            <tr class="mshowtime" id="mst1">
                                <td><center><c:out value="${showtime.getId().getCinema()}"/></center></td>
                            <td>
                                <p><c:out value="${showtime.getMname()}"/></p>
                            </td>
                            <td>
                                <p><c:out value="${showtime.getId().getTime()}"/></p>
                            </td>
                            </tr>
                            </c:forEach>
                        </tbody>
                    </table>
        </div>
        </div>

        <div class="wrap col-sm-offset-2 col-sm-8">
            <form class="form-horizontal" role="form" name ="input" action="addshowtime" method="post">
                <br><br>
                <div class="form-group">
                    <label for="InputtitleM">Title Movie</label>
                    <select class="form-control" for="select-mname" name="mname">
                        <c:forEach var="movie" items="${movie}">
                            <option value="<c:out value="${movie.getMname()}"/>"><c:out value="${movie.getMname()}"/></option>
                        </c:forEach>
                    </select>
                </div>
                <div class="form-group">
                    <label for="Inrelease">Cinema</label>
                    <br>
                    <div class="col-sm-3">
                        <select class="form-control" for="select-cinema" name="cinema">
                            <c:forEach var="cinema" items="${cinema}">
                                <option value="<c:out value="${cinema.getCinema()}"/>"><c:out value="${cinema.getCinema()}"/></option>
                            </c:forEach>
                        </select>
                    </div>
                    <br><br>
                </div>
                <div class="form-group">
                    <label for="Intype">Showtime</label>
                    <br>
                    <div class="col-sm-3">
                        <select class="form-control" for="select-showtime" name="time">
                            <option value="10:00"> 10.00 - 12.00</option>
                            <option value="12:00"> 12.00 - 14.00</option>
                            <option value="14:00"> 14.00 - 16.00</option>
                            <option value="16:00"> 16.00 - 18.00</option>
                            <option value="18:00"> 18.00 - 20.00</option>
                            <option value="20:00"> 20.00 - 22.00</option>
                        </select>
                    </div>
                </div>
                <p>_________________________________________________________________________________________________________</p>
                <br>
                <span class="col-sm-5"></span><button type="submit" class="btn btn-default"><b>Submit</b></button>
            </form>
        </div>

        
    </body>
</html>