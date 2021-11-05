<%@page contentType="text/html" pageEncoding="UTF-8"%> <%@taglib
uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
        <title>Search Friend</title>
        <link
            rel="icon"
            href="/Javbook/assets/img/icon/Javbook.ico"
            type="image/x-icon"
        />
        <link
            rel="stylesheet"
            href="/Javbook/assets/fonts/fontawesome-5.15.4/css/all.min.css"
        />
        <link
            rel="stylesheet"
            href="/Javbook/assets/css/common/variables.css"
        />
        <link rel="stylesheet" href="/Javbook/assets/css/common/base.css" />
        <link
            rel="stylesheet"
            href="/Javbook/assets/css/searchFriend/searchFriend.css"
        />
        <link rel="stylesheet" href="/Javbook/assets/css/common/header.css" />
    </head>
    <body>
        <%@include file="../common/header.jsp" %>
        <div class="search-friend">
            <h3>People</h3>
            <c:forEach items="${searchFriendList}" var="userItem">
                <div class="search-details">
                    <div class="search-img">
                        <img src="${userItem.first.avatar}" alt="" />
                    </div>
                    <div class="search-information">
                        <a href="" class="title">${userItem.first.name}</a>

                        <c:if test="${userItem.second}">
                            <div class="friend">
                                <p>Friend</p>
                                <p>1 mutual friend</p>
                            </div>
                        </c:if>

                        <p>Live in ${userItem.first.address}</p>
                    </div>
                    <div class="search-status">
                        <c:choose>
                            <c:when test="${userItem.second}">
                                <i
                                    class="fab fa-facebook-messenger fa-lg mess"
                                ></i>
                            </c:when>
                            <c:otherwise>
                                <i class="fas fa-user-plus fa-1x add"></i>
                            </c:otherwise>
                        </c:choose>
                    </div>
                </div>
            </c:forEach>
        </div>
        
        <script src="https://code.jquery.com/jquery-3.6.0.js"></script>
        <script src="/Javbook/assets/js/searchFriend/searchFriend.js"></script>
        <script src="/Javbook/assets/js/common/header.js"></script>
    </body>
</html>
