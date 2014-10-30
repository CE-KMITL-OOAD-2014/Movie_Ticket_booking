
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
	<meta charset="UTF-8">
	<link href="bootstrap/bootstrap-3.2.0-dist/css/bootstrap.css" rel="stylesheet">
	<script src="jquery-2.1.1.min.js"></script>
	<script src="bootstrap/bootstrap-3.2.0-dist/js/bootstrap.js"></script>
	<title>Movie Detail</title>
</head>
<body bgcolor="#ffffff">
    <style type="text/css">
    div{
        word-wrap:break-word; 
        display:block;
      }
    </style>
    <div class="page-header">
      <span class="col-sm-1"></span><h1>Add Movie</h1>
    </div>
          <div class="wrap col-sm-offset-2 col-sm-8">
              <form role="form" name = "input" action="addmovie" method="POST" enctype="multipart/form-data">
                <div class="form-group">
                  <label for="InputtitleM">Title Movie</label>
                  <input type="text" name="mname" class="form-control" id="InputtitleM" placeholder="Title Movie">
                </div>
                <div class="form-group">
                  <label for="Inrelease">Release Date</label>
                  <input type="text" name="realeasedate" class="form-control" id="Inrelease" placeholder="dd-mm-yyyy">
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
                  <!--input type="text" class="form-control" id="Insynopsis" placeholder="xxx min"-->
                  <input type="text" name="synopsis" class="form-control" id="InputtitleM" placeholder="Synopsis">
                <div class="form-group">
                  <label for="exampleInputFile">Movie Poster</label>
                  <input type="file" name="img">
                  <p class="help-block">Choose picture file.</p>
                </div>
                <span class="col-sm-10"></span><button type="submit" class="btn btn-default">Submit</button>
              </form>
          </div>

  <!--Review n Rating Modal -->
    <div class="modal fade" id="reviewModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
        <div class="modal-dialog">
          <div class="modal-content">
              <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal"><span aria-hidden="true">&times;</span><span class="sr-only">Close</span></button>
               <h1>Register Success!</h1>
        <c:out value="${mname}"></c:out>

	
</body>
</html>