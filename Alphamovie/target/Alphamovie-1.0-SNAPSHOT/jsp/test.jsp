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
            <th>Time</th><th>Cinema</th><th>Seat</th><th>Type</th><th>isAvalible</th>
            </tr>
            
            <c:forEach var="seat" items="${seat}">
                <tr>
                    <td>
                        <c:out value="${seat.getId().getTime()}"></c:out>
                    </td>
                    <td>
                        <c:out value="${seat.getId().getCinema()}"></c:out>
                    </td>
                    <td>
                        <c:out value="${seat.getId().getSeat()}"></c:out>
                    </td>
                    <td>
                        <c:out value="${seat.getType()}"></c:out>
                    </td>
                    <td>
                        <c:out value="${seat.isAvalible()}"></c:out>
                    </td>
                </tr>
            </c:forEach>
        </table>
    </body>
</html>
