<%-- 
    Document   : profileFriends
    Created on : Oct 26, 2021, 3:16:26 PM
    Author     : Mr Khang
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<c:if test="${friends==null}">
    <div class="none-friend">
        <h1>This person doesn't have any friends</h1>
    </div>
</c:if>
<div class="main-friends">
    <c:forEach items="${friends}" var="friend">
        <div class="friends-item"> 
            <div class="friend-item-img">
                <a href="/Javbook/profile/${friend.getEncodeID()}/">
                    <img src="${friend.avatar}">
                </a>
            </div>
            <div class="friend-item-info">
                <div class="friend-item-name">
                    <a href="/Javbook/profile/${friend.getEncodeID()}/">
                        ${friend.name}
                    </a>
                </div>
                <div class="friend-item-mutual">
                    <a href="#">
                        <!--                        6 mutual friends-->
                    </a>
                </div>
            </div>	
        </div>
    </c:forEach>
</div>
