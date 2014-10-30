<%-- 
    Document   : newjsp
    Created on : Oct 25, 2014, 9:11:19 PM
    Author     : B_MW (Wai & May)
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<body>
	<h1>Spring MVC Hello World Example</h1>
        <table>
            <tr>
                <th>Username</th><th>Password</th><th>Email</th><th>Phonenumber</th>
            </tr>
            
            
                <tr>
                    <td>
                        <c:out value="${msg.getUsername()}"></c:out>
                    </td>
                    <td>
                        <c:out value="${msg.getPassword()}"></c:out>
                    </td>
                    <td>
                        <c:out value="${msg.getEmail()}"></c:out>
                    </td>
                    <td>
                        <c:out value="${msg.getPhonenumber()}"></c:out>
                    </td>
                </tr>
        </table>
 
</body>
</html>