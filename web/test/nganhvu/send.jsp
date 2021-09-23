<%-- 
    Document   : send
    Created on : Sep 22, 2021, 9:24:25 PM
    Author     : Anh Vu Nguyen {@literal <nganhvu>}
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Hello World!</h1>
        <c:forEach begin="1" end="5">
            ${name}
        </c:forEach>
    </body>
</html>
