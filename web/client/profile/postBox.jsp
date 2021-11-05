<%-- Document : postBox Created on : Oct 24, 2021, 10:38:18 PM Author : Mr Khang
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<c:if test="${posts.isEmpty()}">
    <div class="post box">
        <div class="post-item">
            <div class="status-main">
                <img src="/Javbook/assets/img/default/avatar.png" class="status-img" />
                <div class="post-detail">
                    <div class="post-title">
                        <a href="">Javbook User</a>
                    </div>

                    <div class="post-state">
                        <span class="post-date"> 1 minute ago</span>
                        <i class="fas fa-globe-asia"></i>
                    </div>
                </div>
            </div>
            <div class="post-content">
                <p class="content">Hi everybody =))</p>
            </div>
            <div class="post-photos">
                <img
                    src="/Javbook/assets/img/default/avatar.png"
                    alt="Image"
                    class="post-photo"
                    />
            </div>
        </div>
        <div class="post-count">
            <div class="post-count-left">
                <ul>
                    <li>
                        <img src="/Javbook/assets/img/emoji/like.svg" alt="0" />
                    </li>

                    <li>
                        <img src="/Javbook/assets/img/emoji/love.svg" alt="0" />
                    </li>

                    <li>
                        <img src="/Javbook/assets/img/emoji/care.svg" alt="0" />
                    </li>
                </ul>
                <p class="count-emoji">0</p>
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
                <div class="emoji">
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
                    <img
                        src="/Javbook/assets/img/default/avatar.png"
                        alt=""
                        class="ava_cmt user-avatar-send"
                        />
                    <textarea
                        name="send=comment"
                        class="send-text-comment"
                        placeholder="Write a comment…"
                        ></textarea>
                    <button class="send-comment">
                        <i class="fas fa-paper-plane"></i>
                    </button>
                </div>

                <div class="comment-item">
                    <div class="main-comment">
                        <div class="comment-user">
                            <img
                                src="/Javbook/assets/img/logo/Javbook_white.png"
                                alt=""
                                class="ava_cmt avatar-main-comment"
                                />
                            <div class="comment-content-box">
                                <div class="content-main-comment">
                                    <div class="comment-main-title">
                                        <a href="" class="main-user-name">Javbook</a>
                                    </div>
                                    <p>Welcome to Javbook</p>
                                    <div class="display-comment-emoji">
                                        <ul>
                                            <li>
                                                <img src="/Javbook/assets/img/emoji/like.svg" alt="0" />
                                            </li>

                                            <li>
                                                <img src="/Javbook/assets/img/emoji/love.svg" alt="0" />
                                            </li>
                                        </ul>
                                        <p class="count-comment-enmoji">0</p>
                                    </div>
                                </div>
                                <div class="main-comment-action">
                                    <div class="emoji commnent-emoji">
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
                                                        <span class="toolTipText tooltipIcon2">Love</span>
                                                    </div>
                                                </li>

                                                <li>
                                                    <div class="tooltip">
                                                        <img
                                                            src="/Javbook/assets/img/emoji/care.svg"
                                                            alt=""
                                                            />
                                                        <span class="toolTipText tooltipIcon3">Care</span>
                                                    </div>
                                                </li>

                                                <li>
                                                    <div class="tooltip">
                                                        <img
                                                            src="/Javbook/assets/img/emoji/haha.svg"
                                                            alt=""
                                                            />
                                                        <span class="toolTipText tooltipIcon4">Haha</span>
                                                    </div>
                                                </li>

                                                <li>
                                                    <div class="tooltip">
                                                        <img
                                                            src="/Javbook/assets/img/emoji/sad.svg"
                                                            alt=""
                                                            />
                                                        <span class="toolTipText tooltipIcon5">Sad</span>
                                                    </div>
                                                </li>

                                                <li>
                                                    <div class="tooltip">
                                                        <img
                                                            src="/Javbook/assets/img/emoji/angry.svg"
                                                            alt=""
                                                            />
                                                        <span class="toolTipText tooltipIcon6">Angry</span>
                                                    </div>
                                                </li>
                                            </ul>
                                        </div>
                                    </div>
                                    <span class="reply-main">Reply</span>
                                    <span>1 m</span>
                                </div>
                            </div>
                        </div>

                        <div class="comment-level-item">
                            <div class="comment-level">
                                <img
                                    src="/Javbook/assets/img/default/avatar.png"
                                    alt=""
                                    class="ava_cmt_rep avatar-level-comment"
                                    />
                                <div class="comment-content-box">
                                    <div class="content-main-comment">
                                        <div class="comment-main-title">
                                            <a href="" class="main-user-name">Javbook User</a>
                                        </div>
                                        <p>
                                            <span class="reply_user">Javbook</span> Hello Javbook!!!
                                        </p>
                                        <div class="display-comment-emoji">
                                            <ul>
                                                <li>
                                                    <img
                                                        src="/Javbook/assets/img/emoji/like.svg"
                                                        alt="0"
                                                        />
                                                </li>

                                                <li>
                                                    <img
                                                        src="/Javbook/assets/img/emoji/love.svg"
                                                        alt="0"
                                                        />
                                                </li>
                                            </ul>
                                            <p class="count-comment-enmoji">0</p>
                                        </div>
                                    </div>
                                    <div class="main-comment-action">
                                        <div class="emoji commnent-emoji">
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
                                                            <span class="toolTipText tooltipIcon2">Love</span>
                                                        </div>
                                                    </li>

                                                    <li>
                                                        <div class="tooltip">
                                                            <img
                                                                src="/Javbook/assets/img/emoji/care.svg"
                                                                alt=""
                                                                />
                                                            <span class="toolTipText tooltipIcon3">Care</span>
                                                        </div>
                                                    </li>

                                                    <li>
                                                        <div class="tooltip">
                                                            <img
                                                                src="/Javbook/assets/img/emoji/haha.svg"
                                                                alt=""
                                                                />
                                                            <span class="toolTipText tooltipIcon4">Haha</span>
                                                        </div>
                                                    </li>

                                                    <li>
                                                        <div class="tooltip">
                                                            <img
                                                                src="/Javbook/assets/img/emoji/sad.svg"
                                                                alt=""
                                                                />
                                                            <span class="toolTipText tooltipIcon5">Sad</span>
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
                                        <span>1 m</span>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</c:if>
<c:forEach items="${posts}" var="post">
    <div class="post box" id="${post.status.statusId}">
        <div class="post-item">
            <div class="status-main">
                <img src="${post.status.userImage}" class="status-img" />
                <div class="post-detail">
                    <div class="post-title">
                        <a href="/Javbook/profile/${post.status.getID()}/">${post.status.userName}</a>
                    </div>

                    <div class="post-state">
                        <span class="post-date"> ${post.status.time} </span>
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
                <div class="edit-post">
                    <i class="fas fa-ellipsis-h"></i>
                    <div class="edit-post-item">
                        <ul>
                            <li class="edit"><i class="fas fa-pen-nib"> </i> Edit</li>
                            <li class="delete"><i class="far fa-trash-alt"></i> Delete</li>
                        </ul>
                    </div>
                </div>
            </div>
            <div class="post-content">
                <p class="content">${post.status.text}</p>
            </div>
            <div class="post-photos">
                <img src="${post.status.statusImg}" alt="" class="post-photo" id="${post.status.getIDStatus()}" />
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
                                                    <a href="/Javbook/profile/${comment.first.getID()}/" class="main-user-name"
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
                                                                <a href="/Javbook/profile/${comment2.getID()}/" class="main-user-name"
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
</c:forEach>

<script src="/Javbook/assets/js/profile/Post/postBox.js" async></script>
<script src="/Javbook/assets/js/profile/Post/profilePost.js" async></script>
