<%-- 
    Document   : homePage
    Created on : 29 Oct 2021, 14:12:26
    Author     : NhatQuynh
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Javbook</title>
        <script src="https://kit.fontawesome.com/ff4d20b881.js" crossorigin="anonymous"></script>
        <link
            rel="stylesheet"
            href="/Javbook/assets/css/common/variables.css"
            />
        <link rel="stylesheet" href="/Javbook/assets/css/common/base.css" />
        <link
            rel="stylesheet"
            href="/Javbook/assets/css/home/leftpanel.css"
            />
        <link
            rel="stylesheet"
            href="/Javbook/assets/css/home/rightPanel.css"
            />

        <link
            rel="stylesheet"
            href="/Javbook/assets/css/common/header.css"
            />
        <link
            rel="stylesheet"
            href="/Javbook/assets/css/common/notification.css"
            />
        <link
            rel="stylesheet"
            href="/Javbook/assets/css/home/homeStatus.css"
            />
        <link
            rel="stylesheet"
            href="/Javbook/assets/css/home/homePost.css"
            />

    </head>
    <body>
        <%@include file="leftPanel.jsp" %>
        <%@include file="rightPanel.jsp" %>
        <%@include file="../common/header.jsp" %>
        <%@include file="../common/notification.jsp" %>
        <%@include file="homePost.jsp" %>
        <%@include file="homeStatus.jsp" %>


        <script src="/Javbook/assets/js/common/query.js"></script>
        <script src="https://code.jquery.com/jquery-3.6.0.js"></script>
        <script src="/Javbook/assets/js/home/LeftPanel/leftpanel.js"></script>
        <script src="/Javbook/assets/js/common/header.js"></script>
        <script src="/Javbook/assets/js/common/notification.js"></script>
        <script src="/Javbook/assets/js/home/HomePost/homePost.js"></script>
        <script src="/Javbook/assets/js/home/HomeStatus/homeStatus.js"></script>


    </body>
</html>
