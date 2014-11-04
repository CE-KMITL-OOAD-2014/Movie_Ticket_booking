<%-- 
    Document   : userss
    Created on : Oct 25, 2014, 12:05:22 PM
    Author     : TRathC
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>User List!</h1>
        
        <table>
            <tr>
            <th>Username</th><th>Password</th><th>Email</th><th>Phonenumber</th><th>isAdmin</th>
            </tr>
            
            <c:forEach var="user" items="${users}">
                <tr>
                    <td>
                        <c:out value="${user.getUsername()}"></c:out>
                    </td>
                    <td>
                        <c:out value="${user.getPassword()}"></c:out>
                    </td>
                    <td>
                        <c:out value="${user.getEmail()}"></c:out>
                    </td>
                    <td>
                        <c:out value="${user.getPhonenumber()}"></c:out>
                    </td>
                    <td>
                        <c:out value="${user.isIsadmin()}"></c:out>
                    </td>
                </tr>
            </c:forEach>
        </table>
    </body>
</html>
