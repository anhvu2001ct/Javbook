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
    </head>
    <body>
        <div class="search-box">
            <h3>People</h3>
            <c:forEach items="${searchFriendList}" var="userItem">
                <div class="search-details">
                    <div class="search-img">
                        <img
                            src="${userItem.avatar}"
                            alt=""
                        />
                    </div>
                    <div class="search-information">
                        <a href="" class="title">${userItem.name}</a>
                        <div class="friend">
                            <p>Friend</p>
                            <p>1 mutual friend</p>
                        </div>
                        <p>Live in ${userItem.address}</p>
                    </div>
                    <div class="search-status">
                        <i class="fab fa-facebook-messenger fa-lg mess"></i>
                        <i class="fas fa-user-plus fa-1x add"></i>
                    </div>
                </div>
            </c:forEach>
        </div>

        <script src="/Javbook/assets/js/searchFriend/searchFriend.js"></script>
    </body>
</html>
