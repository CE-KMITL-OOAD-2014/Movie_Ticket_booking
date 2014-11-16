
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
    <head>
        <meta charset="UTF-8">
        <link href="${pageContext.request.contextPath}/resources/css/bootstrap.css" rel="stylesheet" >
        <script src="${pageContext.request.contextPath}/resources/js/jquery-2.1.1.min.js" />"></script>
    <script src="${pageContext.request.contextPath}/resources/js/bootstrap.js" />"></script>
<title>Add Movie</title>
</head>
<body bgcolor="#ffffff">
    <style type="text/css">
        div{
            word-wrap:break-word; 
            display:block;
        }
    </style>
    <div class="page-header">
        <span class="col-sm-1"></span><h1>Add & Delete Movie</h1>
    </div>

    <div class="wrap">
        <div class="well col-sm-8 col-sm-offset-2">
            <table class="table table-striped">
                <thead>
                <h3><b>Movie List</b></h3>
                </thead>
                <tbody>
                    <c:forEach var="movie" items="${movie}">
                        <tr class="mlist">
                            <td class="col-sm-8">
                                <br>
                                <div class="col-sm-offset-1">
                                    <p>Movie Title : <c:out value="${movie.getMname()}"/></p>
                                    <p>Release Date : <c:out value="${movie.getReleasedate()}"/></p>
                                </div>
                            </td>
                            <td class="col-sm-3">
                                <br>
                                <form role="form" name ="input" action="deletemovie" method="post">
                                    <input type="hidden" value="<c:out value="${movie.getMname()}"/>" name="mname">
                                    <center><button type="submit" class="btn btn-default">Delete</button></center>
                                </form>
                            </td>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>
        </div>
    </div>

    <div class="wrap col-sm-offset-2 col-sm-8">
        <form role="form" name = "input" action="addmovie" method="POST" enctype="multipart/form-data">
            <div class="form-group">
                <label for="InputtitleM">Title Movie</label>
                <input type="text" name="mname" class="form-control" id="InputtitleM" placeholder="Title Movie">
            </div>
            <div class="form-group">
                <label for="Inrelease">Release Date</label>
                <input type="text" name="releasedate" class="form-control" id="Inrelease" placeholder="dd-mm-yyyy">
            </div>
            <div class="form-group">
                <label for="Intype">Film Category</label>
                <input type="text" name="type" class="form-control" id="Intype" placeholder="Film Category">
            </div>
            <div class="form-group">
                <label for="Intime">Duration</label>
                <input type="text" name="duration" class="form-control" id="Intime" placeholder="xxx min">
            </div>
            <div class="form-group">
                <label for="Insynopsis">Synopsis</label>
                <input type="text" name="synopsis" class="form-control" id="InputtitleM" placeholder="Synopsis">
                <div class="form-group">
                    <label for="exampleInputFile">Movie Poster</label>
                    <input type="file" name="img">
                    <p class="help-block">Choose picture file.</p>
                </div>
                <span class="col-sm-10"></span><button type="submit" class="btn btn-default">Submit</button>
        </form>
    </div>