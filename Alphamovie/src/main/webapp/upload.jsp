<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
<head>
<title>Upload File Request Page</title>
</head>
<body>
 
    <h1>Spring MVC file upload example</h1>

    <h2>Add New File</h2>
    <form action="upload" method="post" enctype="multipart/form-data">
        <table width="60%" border="1" cellspacing="0">
            <tr>
                <td width="35%"><strong>File to upload</strong></td>
                <td width="65%"><input type="file" name="file" /></td>
            </tr>
            <tr>
                <td>&nbsp;</td>
                <td><input type="submit" name="submit" value="Add"/></td>
            </tr>
        </table>
    </form>
     
</body>
</html>