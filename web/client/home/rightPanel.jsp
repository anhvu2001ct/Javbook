<%-- 
    Document   : rightPanel
    Created on : 29 Oct 2021, 14:16:01
    Author     : ASUS
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!--rightPanel-->
<div class="right-side">
    <div class="header-right">
        <div class="right-title">
            <h3>Friends</h3>
        </div>
    </div>

    <div class="friendList">

        <c:if test="${!friendlist.isEmpty()}">
            <c:forEach items="${friendlist}" var="friend">
                
                <a href="/Javbook/profile/${friend.getEncodeID()}/">
                    <div class="friendList-item">
                        <div class="user-img">
                            <img
                                src="${friend.avatar}"
                                alt="avatar"
                                class="avatar-img"
                                />
                        </div>
                        <div class="user-name">
                            <h5>${friend.name}</h5>
                        </div>
                        <div class="friend-status online"></div>
                    </div>
                </a>
            </c:forEach>
        </c:if>

    </div>

    <div class="search-friend">
        <div class="search">
            <label for="search_friendList" class="btn-search-friendList"
                   ><i class="fas fa-search"></i
                ></label>

            <input
                type="text"
                name="search_friendList"
                id="search_friendList"
                placeholder="Search"
                />
        </div>
        <p></p>
    </div>
</div>