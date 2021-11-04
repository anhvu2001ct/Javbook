<%-- 
    Document   : popupEmoji
    Created on : Oct 29, 2021, 10:07:08 PM
    Author     : Mr Khang
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<div class="popup-emoji">
    <div class="main-emoji-popup">
        <div class="emoji-popup">
            <nav class="nav-header-emoji">
                <ul class="main-dropdown-emoji">
                    <li class="active-emoji">All</li>
                    <li>
                        <img src="/Javbook/assets/img/emoji/like.svg" alt="" />
                        <p>${countEmoji.like}</p>
                    </li>

                    <li>
                        <img src="/Javbook/assets/img/emoji/love.svg" alt="" />
                        <p>${countEmoji.love}</p>
                    </li>
                    <li>
                        <img src="/Javbook/assets/img/emoji/care.svg" alt="" />
                        <p>${countEmoji.care}</p>
                    </li>
                    <li>
                        <img src="/Javbook/assets/img/emoji/haha.svg" alt="" />
                        <p>${countEmoji.haha}</p>
                    </li>

                    <li>
                        <img src="/Javbook/assets/img/emoji/sad.svg" alt="" />
                        <p>${countEmoji.sad}</p>
                    </li>

                    <li>
                        <img src="/Javbook/assets/img/emoji/angry.svg" alt="" />
                        <p>${countEmoji.angry}</p>
                    </li>
                    <li class="last-emoji">
                        <div class="dropdown-emoji-exit">
                            <i class="fas fa-times"></i>
                        </div>
                    </li>
                </ul>
            </nav>
            <div class="list-friend-emoji">
                <div class="emoji-all active-display-quantity-emoji">
                    <c:forEach items="${listEmoji}" var="all">
                        <div class="friend-emoji-detail">
                            <div class="left-emoji-detail">
                                <div class="friend-emoji-avatar">
                                    <img src="${all.userImage}" alt="" />
                                </div>
                                <div class="type-emoji-popup">
                                    <c:choose>
                                        <c:when test="${all.emojiID==1}">
                                            <img src="/Javbook/assets/img/emoji/like.svg" alt="" />
                                        </c:when>
                                        <c:when test="${all.emojiID==2}">
                                            <img src="/Javbook/assets/img/emoji/love.svg" alt="" />
                                        </c:when>
                                        <c:when test="${all.emojiID==3}">
                                            <img src="/Javbook/assets/img/emoji/care.svg" alt="" />
                                        </c:when>
                                        <c:when test="${all.emojiID==4}">
                                            <img src="/Javbook/assets/img/emoji/haha.svg" alt="" />
                                        </c:when>
                                        <c:when test="${all.emojiID==5}">
                                            <img src="/Javbook/assets/img/emoji/sad.svg" alt="" />
                                        </c:when>
                                        <c:otherwise>
                                            <img src="/Javbook/assets/img/emoji/angry.svg" alt="" />
                                        </c:otherwise>
                                    </c:choose>
                                    
                                </div>
                            </div>
                            <div class="right-emoji-detail">
                                <a href="#" class="friend-name-detail">${all.userName}</a>
                                <div class="friend-status-detail">
                                    <div class="chat-friend-emoji">
                                        <i class="fab fa-facebook-messenger"></i>
                                        Messenger
                                    </div>
                                    <div class="add-friend-emoji">
                                        <i class="fas fa-user-plus fa-1x"></i>
                                        Add Friend
                                    </div>
                                </div>
                            </div>
                        </div>
                    </c:forEach>
                </div>
                <div class="emoji-like">
                    <c:forEach items="${listLike}" var="like">
                        <div class="friend-emoji-detail">
                            <div class="left-emoji-detail">
                                <div class="friend-emoji-avatar">
                                    <img src="${like.userImage}" alt="" />
                                </div>
                                <div class="type-emoji-popup">
                                    <img src="/Javbook/assets/img/emoji/like.svg" alt="" />
                                </div>
                            </div>
                            <div class="right-emoji-detail">
                                <a href="#" class="friend-name-detail">${like.userName}</a>
                                <div class="friend-status-detail">
                                    <div class="chat-friend-emoji">
                                        <i class="fab fa-facebook-messenger"></i>
                                        Messenger
                                    </div>
                                    <div class="add-friend-emoji">
                                        <i class="fas fa-user-plus fa-1x"></i>
                                        Add Friend
                                    </div>
                                </div>
                            </div>
                        </div>
                    </c:forEach>
                </div>
                <div class="emoji-love">
                    <c:forEach items="${listLove}" var="love">
                        <div class="friend-emoji-detail">
                            <div class="left-emoji-detail">
                                <div class="friend-emoji-avatar">
                                    <img src="${love.userImage}" alt="" />
                                </div>
                                <div class="type-emoji-popup">
                                    <img src="/Javbook/assets/img/emoji/love.svg" alt="" />
                                </div>
                            </div>
                            <div class="right-emoji-detail">
                                <a href="#" class="friend-name-detail">${love.userName}</a>
                                <div class="friend-status-detail">
                                    <div class="chat-friend-emoji">
                                        <i class="fab fa-facebook-messenger"></i>
                                        Messenger
                                    </div>
                                    <div class="add-friend-emoji">
                                        <i class="fas fa-user-plus fa-1x"></i>
                                        Add Friend
                                    </div>
                                </div>
                            </div>
                        </div>
                    </c:forEach>
                </div>
                <div class="emoji-care">
                    <c:forEach items="${listCare}" var="care">
                        <div class="friend-emoji-detail">
                            <div class="left-emoji-detail">
                                <div class="friend-emoji-avatar">
                                    <img src="${care.userImage}" alt="" />
                                </div>
                                <div class="type-emoji-popup">
                                    <img src="/Javbook/assets/img/emoji/care.svg" alt="" />
                                </div>
                            </div>
                            <div class="right-emoji-detail">
                                <a href="#" class="friend-name-detail">${care.userName}</a>
                                <div class="friend-status-detail">
                                    <div class="chat-friend-emoji">
                                        <i class="fab fa-facebook-messenger"></i>
                                        Messenger
                                    </div>
                                    <div class="add-friend-emoji">
                                        <i class="fas fa-user-plus fa-1x"></i>
                                        Add Friend
                                    </div>
                                </div>
                            </div>
                        </div>
                    </c:forEach>
                </div>
                <div class="emoji-haha">
                    <c:forEach items="${listHaha}" var="haha">
                        <div class="friend-emoji-detail">
                            <div class="left-emoji-detail">
                                <div class="friend-emoji-avatar">
                                    <img src="${haha.userImage}" alt="" />
                                </div>
                                <div class="type-emoji-popup">
                                    <img src="/Javbook/assets/img/emoji/haha.svg" alt="" />
                                </div>
                            </div>
                            <div class="right-emoji-detail">
                                <a href="#" class="friend-name-detail">${haha.userName}</a>
                                <div class="friend-status-detail">
                                    <div class="chat-friend-emoji">
                                        <i class="fab fa-facebook-messenger"></i>
                                        Messenger
                                    </div>
                                    <div class="add-friend-emoji">
                                        <i class="fas fa-user-plus fa-1x"></i>
                                        Add Friend
                                    </div>
                                </div>
                            </div>
                        </div>
                    </c:forEach>
                </div>
                <div class="emoji-sad">
                    <c:forEach items="${listSad}" var="sad">
                        <div class="friend-emoji-detail">
                            <div class="left-emoji-detail">
                                <div class="friend-emoji-avatar">
                                    <img src="${sad.userImage}" alt="" />
                                </div>
                                <div class="type-emoji-popup">
                                    <img src="/Javbook/assets/img/emoji/sad.svg" alt="" />
                                </div>
                            </div>
                            <div class="right-emoji-detail">
                                <a href="#" class="friend-name-detail">${sad.userName}</a>
                                <div class="friend-status-detail">
                                    <div class="chat-friend-emoji">
                                        <i class="fab fa-facebook-messenger"></i>
                                        Messenger
                                    </div>
                                    <div class="add-friend-emoji">
                                        <i class="fas fa-user-plus fa-1x"></i>
                                        Add Friend
                                    </div>
                                </div>
                            </div>
                        </div>
                    </c:forEach>
                </div>
                <div class="emoji-angry">
                    <c:forEach items="${listAngry}" var="ar">
                        <div class="friend-emoji-detail">
                            <div class="left-emoji-detail">
                                <div class="friend-emoji-avatar">
                                    <img src="${ar.userImage}" alt="" />
                                </div>
                                <div class="type-emoji-popup">
                                    <img src="/Javbook/assets/img/emoji/angry.svg" alt="" />
                                </div>
                            </div>
                            <div class="right-emoji-detail">
                                <a href="#" class="friend-name-detail">${ar.userName}</a>
                                <div class="friend-status-detail">
                                    <div class="chat-friend-emoji">
                                        <i class="fab fa-facebook-messenger"></i>
                                        Messenger
                                    </div>
                                    <div class="add-friend-emoji">
                                        <i class="fas fa-user-plus fa-1x"></i>
                                        Add Friend
                                    </div>
                                </div>
                            </div>
                        </div>
                    </c:forEach>
                </div>
            </div>
        </div>
    </div>
</div>

