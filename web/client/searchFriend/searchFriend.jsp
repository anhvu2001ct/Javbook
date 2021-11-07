<%@page contentType="text/html" pageEncoding="UTF-8"%> 
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

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
            <c:if test="${searchFriendList == null}">
                <div class="search-details">
                    <span>Nobody here! Looking for other names!</span>
                </div>
            </c:if>
            <c:forEach items="${searchFriendList}" var="userItem">
                <div
                    class="search-details"
                    data-id="${userItem.first.getEncodeID()}"
                    data-index="${userItem.second}"
                >
                    <div class="search-img">
                        <img src="${userItem.first.avatar}" alt="" />
                    </div>
                    <div class="search-information">
                        <a
                            href="/Javbook/profile/${userItem.first.getEncodeID()}/"
                            class="title"
                            >${userItem.first.name}</a
                        >

                        <c:if test="${userItem.second == 2}">
                            <div>
                                <p>Friend</p>
                            </div>
                        </c:if>

                        <p>Live in ${userItem.first.address}</p>
                    </div>

                    <c:choose>
                        <c:when test="${userItem.second == -2}">
                            <div
                                class="search-status js-add-friend-btn"
                                title="Add friend"
                            >
                                <i class="fas fa-user-plus fa-lg"></i>
                            </div>
                        </c:when>
                        <c:when test="${userItem.second == -1}">
                            <div
                                class="search-status js-add-friend-btn"
                                title="Accept friend request"
                            >
                                <i class="fas fa-user-clock fa-lg"></i>
                            </div>
                        </c:when>
                        <c:when test="${userItem.second == 1}">
                            <div
                                class="search-status js-add-friend-btn"
                                title="Unsend friend request"
                            >
                                <i class="fas fa-user-times fa-lg"></i>
                            </div>
                        </c:when>
                        <c:when test="${userItem.second == 2}">
                            <div
                                class="search-status js-add-friend-btn"
                                title="Go chat!"
                            >
                                <i class="fab fa-facebook-messenger fa-lg"></i>
                            </div>
                        </c:when>
                        <c:otherwise> </c:otherwise>
                    </c:choose>
                </div>
            </c:forEach>
        </div>

        <script src="https://code.jquery.com/jquery-3.6.0.js"></script>
        <script src="/Javbook/assets/js/common/ws.js"></script>
        <script src="/Javbook/assets/js/common/header.js"></script>
        <script src="/Javbook/assets/js/common/query.js"></script>
        <script src="/Javbook/assets/js/searchFriend/searchFriend.js"></script>
    </body>
</html>
