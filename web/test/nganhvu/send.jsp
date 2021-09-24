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
        
    </body>
    <script src="/Javbook/assets/js/common/query.js"></script>
    <script>
        let query = new QueryData("test/sendGET")
        query.addParam("key", "value");
        query.addParam("key2", "value2");
        query.send("GET")
        
        let query2 = new QueryData("test/sendPOST")
        query2.addParam("keyPOST", "value1");
        query2.send("POST")
    </script>
</html>
