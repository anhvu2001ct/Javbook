<%-- 
    Document   : statusPage
    Created on : Nov 3, 2021, 11:14:26 PM
    Author     : Mr Khang
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Javbook</title>
        <link
            rel="icon"
            href="/Javbook/assets/img/logo/Javbook_black.png"
            type="image/gif"
            sizes="16x16"
            />
        <link
            rel="stylesheet"
            href="/Javbook/assets/css/common/postPage.css"
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
        <link rel="stylesheet" href="/Javbook/assets/css/common/header.css" />
        <link rel="stylesheet" href="/Javbook/assets/css/boxChat/boxChat.css" />
        <link
            rel="stylesheet"
            href="/Javbook/assets/css/profile/popupEmoji.css"
            />
        <link
            rel="stylesheet"
            href="/Javbook/assets/css/common/notification.css"
            />
    </head>
    <body>
        <%@include file="../common/header.jsp" %>
        <%@include file="../common/notification.jsp" %>
        <c:forEach items="${posts}" var="post">
            <div class="post-page">
                <div class="post-page-img">
                    <img src="${post.status.statusImg}" alt="" />
                </div>
                <div class="post-page-box">
                    <div class="post box" id="${post.status.statusId}">
                        <div class="post-item">
                            <div class="status-main">
                                <img src="${post.status.userImage}" class="status-img" />
                                <div class="post-detail">
                                    <div class="post-title">
                                        <a href="">${post.status.userName}</a>
                                    </div>

                                    <div class="post-state">
                                        <span class="post-date">${post.status.time}</span>
                                        <c:if test="${post.status.mood==1}">
                                            <i class="fas fa-globe-asia"></i>
                                        </c:if>
                                        <c:if test="${post.status.mood==3}">
                                            <i class="fas fa-lock"></i>
                                        </c:if>
                                        <c:if test="${post.status.mood==2}">
                                            <i class="fas fa-user-friends"></i>
                                        </c:if>
                                    </div>
                                </div>

                            </div>
                            <div class="post-content">
                                <div class="content-before">
                                    <p class="content" contenteditable="false">
                                        ${post.status.text}
                                    </p>
                                    <c:if test="${post.status.accountID == userID}">
                                        <button class="edit-post">Edit</button>  
                                    </c:if>

                                </div>

                                <div class="edit-content">
                                    <textarea class="edit-text-content"></textarea>
                                    <div>
                                        <button class="save-content">Finished Editing</button>
                                        <button class="cancel-edit">Cancel</button>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <div class="post-count">
                            <div class="post-count-left">
                                <ul>
                                    <li>
                                        <c:choose>
                                            <c:when test="${empty post.status.max1}">
                                                <img src="/Javbook/assets/img/emoji/like.svg" alt="0" />
                                            </c:when>
                                            <c:otherwise>
                                                <img
                                                    src="/Javbook/assets/img/emoji/${post.status.max1}"
                                                    alt="1"
                                                    />
                                            </c:otherwise>
                                        </c:choose>
                                    </li>
                                    <li>
                                        <c:choose>
                                            <c:when test="${empty post.status.max2}">
                                                <img src="/Javbook/assets/img/emoji/like.svg" alt="0" />
                                            </c:when>
                                            <c:otherwise>
                                                <img
                                                    src="/Javbook/assets/img/emoji/${post.status.max2}"
                                                    alt="1"
                                                    />
                                            </c:otherwise>
                                        </c:choose>
                                    </li>
                                </ul>
                                <p class="count-emoji">${post.status.numberOfEmoji}</p>
                            </div>
                            <div class="post-count-right">
                                <span>
                                    <p class="count-comment">0</p>
                                    comments
                                </span>
                                <span>
                                    <p class="count-share">0</p>
                                    share</span
                                >
                            </div>
                        </div>
                        <div class="post-action">
                            <div class="actions">
                                <div class="emoji emoji-main" id="${post.status.userEmotion}">
                                    <img
                                        src="/Javbook/assets/img/emoji/unlike.png"
                                        alt=""
                                        class="icon-status"
                                        />
                                    <p>Like</p>
                                    <div class="list-icon">
                                        <ul>
                                            <li>
                                                <div class="tooltip">
                                                    <img src="/Javbook/assets/img/emoji/like.svg" alt="" />
                                                    <span class="toolTipText">Like</span>
                                                </div>
                                            </li>

                                            <li>
                                                <div class="tooltip">
                                                    <img src="/Javbook/assets/img/emoji/love.svg" alt="" />
                                                    <span class="toolTipText tooltipIcon2">Love</span>
                                                </div>
                                            </li>

                                            <li>
                                                <div class="tooltip">
                                                    <img src="/Javbook/assets/img/emoji/care.svg" alt="" />
                                                    <span class="toolTipText tooltipIcon3">Care</span>
                                                </div>
                                            </li>

                                            <li>
                                                <div class="tooltip">
                                                    <img src="/Javbook/assets/img/emoji/haha.svg" alt="" />
                                                    <span class="toolTipText tooltipIcon4">Haha</span>
                                                </div>
                                            </li>

                                            <li>
                                                <div class="tooltip">
                                                    <img src="/Javbook/assets/img/emoji/sad.svg" alt="" />
                                                    <span class="toolTipText tooltipIcon5">Sad</span>
                                                </div>
                                            </li>

                                            <li>
                                                <div class="tooltip">
                                                    <img src="/Javbook/assets/img/emoji/angry.svg" alt="" />
                                                    <span class="toolTipText tooltipIcon6">Angry</span>
                                                </div>
                                            </li>
                                        </ul>
                                    </div>
                                </div>

                                <div class="comment-status">
                                    <i class="far fa-comment-alt"></i>
                                    Comment
                                </div>
                                <div class="share">
                                    <i class="fas fa-share"></i>
                                    Share
                                </div>
                            </div>
                        </div>

                        <div class="comment box">
                            <div class="comment-box">
                                <div class="send-comment-box">
                                    <img src="${avatar}" alt="" class="ava_cmt user-avatar-send" />
                                    <textarea
                                        name="send=comment"
                                        class="send-text-comment"
                                        placeholder="Write a comment…"
                                        ></textarea>
                                    <button class="send-comment main-send">
                                        <i class="fas fa-paper-plane"></i>
                                    </button>
                                </div>
                                <div class="comment-item">
                                    <c:if test="${post.comment!=null}">
                                        <c:forEach items="${post.comment}" var="comment">
                                            <c:if test="${comment.first!=null}">
                                                <div class="main-comment" id="${comment.first.commentId}">
                                                    <div class="comment-user">
                                                        <img
                                                            src="${comment.first.userImage}"
                                                            alt=""
                                                            class="ava_cmt avatar-main-comment"
                                                            />
                                                        <div class="comment-content-box">
                                                            <div class="content-main-comment">
                                                                <div class="comment-main-title">
                                                                    <a href="" class="main-user-name"
                                                                       >${comment.first.userName}</a
                                                                    >
                                                                </div>
                                                                <p class="text-comment">${comment.first.text}</p>
                                                                <div class="display-comment-emoji main-display-comment-emoji">
                                                                    <ul>
                                                                        <li>
                                                                            <c:choose>
                                                                                <c:when test="${empty comment.first.max1}">
                                                                                    <img
                                                                                        src="/Javbook/assets/img/emoji/like.svg"
                                                                                        alt="0"
                                                                                        />
                                                                                </c:when>
                                                                                <c:otherwise>
                                                                                    <img
                                                                                        src="/Javbook/assets/img/emoji/${comment.first.max1}"
                                                                                        alt="1"
                                                                                        />
                                                                                </c:otherwise>
                                                                            </c:choose>
                                                                        </li>
                                                                        <li>
                                                                            <c:choose>
                                                                                <c:when test="${empty comment.first.max2}">
                                                                                    <img
                                                                                        src="/Javbook/assets/img/emoji/like.svg"
                                                                                        alt="0"
                                                                                        />
                                                                                </c:when>
                                                                                <c:otherwise>
                                                                                    <img
                                                                                        src="/Javbook/assets/img/emoji/${comment.first.max2}"
                                                                                        alt="1"
                                                                                        />
                                                                                </c:otherwise>
                                                                            </c:choose>
                                                                        </li>
                                                                    </ul>
                                                                    <p class="count-comment-enmoji">
                                                                        ${comment.first.numberOfEmoji}
                                                                    </p>
                                                                </div>  
                                                                <c:if test="${comment.first.userID == userID}">
                                                                    <div class="delete-comment">
                                                                        <i class="far fa-trash-alt fa-lg"></i>
                                                                    </div>
                                                                </c:if>
                                                            </div>
                                                            <div class="main-comment-action">
                                                                <div
                                                                    class="emoji commnent-emoji"
                                                                    id="${comment.first.userEmotion}"
                                                                    >
                                                                    <span>Like</span>
                                                                    <div class="list-icon">
                                                                        <ul>
                                                                            <li>
                                                                                <div class="tooltip">
                                                                                    <img
                                                                                        src="/Javbook/assets/img/emoji/like.svg"
                                                                                        alt=""
                                                                                        />
                                                                                    <span class="toolTipText">Like</span>
                                                                                </div>
                                                                            </li>

                                                                            <li>
                                                                                <div class="tooltip">
                                                                                    <img
                                                                                        src="/Javbook/assets/img/emoji/love.svg"
                                                                                        alt=""
                                                                                        />
                                                                                    <span class="toolTipText tooltipIcon2"
                                                                                          >Love</span
                                                                                    >
                                                                                </div>
                                                                            </li>

                                                                            <li>
                                                                                <div class="tooltip">
                                                                                    <img
                                                                                        src="/Javbook/assets/img/emoji/care.svg"
                                                                                        alt=""
                                                                                        />
                                                                                    <span class="toolTipText tooltipIcon3"
                                                                                          >Care</span
                                                                                    >
                                                                                </div>
                                                                            </li>

                                                                            <li>
                                                                                <div class="tooltip">
                                                                                    <img
                                                                                        src="/Javbook/assets/img/emoji/haha.svg"
                                                                                        alt=""
                                                                                        />
                                                                                    <span class="toolTipText tooltipIcon4"
                                                                                          >Haha</span
                                                                                    >
                                                                                </div>
                                                                            </li>

                                                                            <li>
                                                                                <div class="tooltip">
                                                                                    <img
                                                                                        src="/Javbook/assets/img/emoji/sad.svg"
                                                                                        alt=""
                                                                                        />
                                                                                    <span class="toolTipText tooltipIcon5"
                                                                                          >Sad</span
                                                                                    >
                                                                                </div>
                                                                            </li>

                                                                            <li>
                                                                                <div class="tooltip">
                                                                                    <img
                                                                                        src="/Javbook/assets/img/emoji/angry.svg"
                                                                                        alt=""
                                                                                        />
                                                                                    <span class="toolTipText tooltipIcon6"
                                                                                          >Angry</span
                                                                                    >
                                                                                </div>
                                                                            </li>
                                                                        </ul>
                                                                    </div>
                                                                </div>
                                                                <span class="reply-main">Reply</span>
                                                                <span class="time-comment">${comment.first.time}</span>
                                                            </div>
                                                        </div>
                                                    </div>

                                                    <div class="comment-level-item">
                                                        <c:if test="${comment.second!=null}">
                                                            <c:forEach items="${comment.second}" var="comment2">
                                                                <div class="comment-level" id="${comment2.comment2Id}">
                                                                    <img
                                                                        src="${comment2.userImage}"
                                                                        alt=""
                                                                        class="ava_cmt_rep avatar-level-comment"
                                                                        />
                                                                    <div class="comment-content-box">
                                                                        <div class="content-main-comment">
                                                                            <div class="comment-main-title">
                                                                                <a href="" class="main-user-name"
                                                                                   >${comment2.userName}</a
                                                                                >
                                                                            </div>
                                                                            <p>
                                                                                <span class="reply_user"></span>
                                                                                ${comment2.text}
                                                                            </p>
                                                                            <div class="display-comment-emoji level-display-comment-emoji">
                                                                                <ul>
                                                                                    <li>
                                                                                        <c:choose>
                                                                                            <c:when test="${empty comment2.max1}">
                                                                                                <img
                                                                                                    src="/Javbook/assets/img/emoji/like.svg"
                                                                                                    alt="0"
                                                                                                    />
                                                                                            </c:when>
                                                                                            <c:otherwise>
                                                                                                <img
                                                                                                    src="/Javbook/assets/img/emoji/${comment2.max1}"
                                                                                                    alt="1"
                                                                                                    />
                                                                                            </c:otherwise>
                                                                                        </c:choose>
                                                                                    </li>
                                                                                    <li>
                                                                                        <c:choose>
                                                                                            <c:when test="${empty comment2.max2}">
                                                                                                <img
                                                                                                    src="/Javbook/assets/img/emoji/like.svg"
                                                                                                    alt="0"
                                                                                                    />
                                                                                            </c:when>
                                                                                            <c:otherwise>
                                                                                                <img
                                                                                                    src="/Javbook/assets/img/emoji/${comment2.max2}"
                                                                                                    alt="1"
                                                                                                    />
                                                                                            </c:otherwise>
                                                                                        </c:choose>
                                                                                    </li>
                                                                                </ul>
                                                                                <p class="count-comment-enmoji">
                                                                                    ${comment2.numberOfEmoji}
                                                                                </p>
                                                                            </div>
                                                                            <c:if test="${comment2.userID == userID}">
                                                                                <div class="delete-comment">
                                                                                    <i class="far fa-trash-alt fa-lg"></i>
                                                                                </div>
                                                                            </c:if>
                                                                        </div>
                                                                        <div class="main-comment-action">
                                                                            <div
                                                                                class="emoji commnent-emoji"
                                                                                id="${comment2.userEmotion}"
                                                                                >
                                                                                <span>Like</span>
                                                                                <div class="list-icon">
                                                                                    <ul>
                                                                                        <li>
                                                                                            <div class="tooltip">
                                                                                                <img
                                                                                                    src="/Javbook/assets/img/emoji/like.svg"
                                                                                                    alt=""
                                                                                                    />
                                                                                                <span class="toolTipText">Like</span>
                                                                                            </div>
                                                                                        </li>

                                                                                        <li>
                                                                                            <div class="tooltip">
                                                                                                <img
                                                                                                    src="/Javbook/assets/img/emoji/love.svg"
                                                                                                    alt=""
                                                                                                    />
                                                                                                <span class="toolTipText tooltipIcon2"
                                                                                                      >Love</span
                                                                                                >
                                                                                            </div>
                                                                                        </li>

                                                                                        <li>
                                                                                            <div class="tooltip">
                                                                                                <img
                                                                                                    src="/Javbook/assets/img/emoji/care.svg"
                                                                                                    alt=""
                                                                                                    />
                                                                                                <span class="toolTipText tooltipIcon3"
                                                                                                      >Care</span
                                                                                                >
                                                                                            </div>
                                                                                        </li>

                                                                                        <li>
                                                                                            <div class="tooltip">
                                                                                                <img
                                                                                                    src="/Javbook/assets/img/emoji/haha.svg"
                                                                                                    alt=""
                                                                                                    />
                                                                                                <span class="toolTipText tooltipIcon4"
                                                                                                      >Haha</span
                                                                                                >
                                                                                            </div>
                                                                                        </li>

                                                                                        <li>
                                                                                            <div class="tooltip">
                                                                                                <img
                                                                                                    src="/Javbook/assets/img/emoji/sad.svg"
                                                                                                    alt=""
                                                                                                    />
                                                                                                <span class="toolTipText tooltipIcon5"
                                                                                                      >Sad</span
                                                                                                >
                                                                                            </div>
                                                                                        </li>

                                                                                        <li>
                                                                                            <div class="tooltip">
                                                                                                <img
                                                                                                    src="/Javbook/assets/img/emoji/angry.svg"
                                                                                                    alt=""
                                                                                                    />
                                                                                                <span class="toolTipText tooltipIcon6"
                                                                                                      >Angry</span
                                                                                                >
                                                                                            </div>
                                                                                        </li>
                                                                                    </ul>
                                                                                </div>
                                                                            </div>
                                                                            <span class="reply-level">Reply</span>
                                                                            <span class="time-comment">${comment2.time}</span>
                                                                        </div>
                                                                    </div>
                                                                </div>
                                                            </c:forEach>
                                                        </c:if>
                                                    </div>
                                                </div>
                                            </c:if>
                                        </c:forEach>
                                    </c:if>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </c:forEach>
        <div class="popup-emoji-box"><%@include file="../profile/popupEmoji.jsp" %></div>
        
        <%@include file="/client/boxChat/boxChatContainer.jsp" %>
         
        <script src="/Javbook/assets/js/common/query.js"></script>
        <script src="https://code.jquery.com/jquery-3.6.0.js"></script>
        <script src="/Javbook/assets/js/common/ws.js"></script>
        <script src="/Javbook/assets/js/common/notification.js"></script>
        <script src="/Javbook/assets/js/common/header.js"></script>
        <script src="/Javbook/assets/js/common/message.js"></script>
        <script src="/Javbook/assets/js/common/statusPage.js"></script>     
        <script src="/Javbook/assets/js/profile/Post/popupEmoji.js"></script>

    </body>
</html>
