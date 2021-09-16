<%-- 
    Document   : error.jsp
    Created on : Sep 14, 2021, 8:18:45 PM
    Author     : Anh Vu Nguyen {@literal <nganhvu>}
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <style>
        h1.servlet-error {
            color: red;
        }
        h2.servlet-error > pre {
            font-weight: normal;
            margin-left: 30px;
            display: block;
        }
    </style>
    <body>
        <h1 class="servlet-error">Servlet ERROR!!</h1>
        <h2 class="servlet-error">
            <p>Error Cause:</p>
            <pre><code>${requestScope.errorCause}</code></pre>
            
            <p>Error Message:</p>
            <pre><code>${requestScope.errorMessage}</code></pre>
            
            <p>Servlet Location:</p>
            <pre><code>${requestScope.errorLocation}</code></pre>
            
            <p>Error TraceStack:</p>
            <pre><code>${requestScope.errorTraceStack}</code></pre>
        </h2>
    </body>
</html>
