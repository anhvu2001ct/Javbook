<%-- 
    Document   : postBox
    Created on : Oct 24, 2021, 10:38:18 PM
    Author     : Mr Khang
--%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<c:if test="${statusUser.size()==null}">
    

    <div class="post box">
        <div class="post-item">
            <div class="status-main">
                <img src="/Javbook/assets/img/default/avatar.png" class="status-img" />
                <div class="post-detail">
                    <div class="post-title">
                        <a href="">Javbook User</a>
                    </div>

                    <div class="post-state">
                        <span class="post-date">6 hours ago</span>

                        <i class="fas fa-globe-asia"></i>
                        <i class="fas fa-lock"></i>
                        <i class="fas fa-user-friends"></i>
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
                <p class="content">Hi everybody =))</p>
            </div>
            <div class="post-photos">
                <img
                    src="/Javbook/assets/img/default/avatar.png"
                    alt=""
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
                    <img src="/Javbook/assets/img/emoji/unlike.png" alt="" class="icon-status" />
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
                    <button class="send-comment main-send">
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
                                                        <span class="toolTipText tooltipIcon6"
                                                              >Angry</span
                                                        >
                                                    </div>
                                                </li>
                                            </ul>
                                        </div>
                                    </div>
                                    <span class="reply-main">Reply</span>
                                    <span>1 hour</span>
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
                                                            <img src="/Javbook/assets/img/emoji/like.svg" alt="" />
                                                            <span class="toolTipText">Like</span>
                                                        </div>
                                                    </li>

                                                    <li>
                                                        <div class="tooltip">
                                                            <img src="/Javbook/assets/img/emoji/love.svg" alt="" />
                                                            <span class="toolTipText tooltipIcon2"
                                                                  >Love</span
                                                            >
                                                        </div>
                                                    </li>

                                                    <li>
                                                        <div class="tooltip">
                                                            <img src="/Javbook/assets/img/emoji/care.svg" alt="" />
                                                            <span class="toolTipText tooltipIcon3"
                                                                  >Care</span
                                                            >
                                                        </div>
                                                    </li>

                                                    <li>
                                                        <div class="tooltip">
                                                            <img src="/Javbook/assets/img/emoji/haha.svg" alt="" />
                                                            <span class="toolTipText tooltipIcon4"
                                                                  >Haha</span
                                                            >
                                                        </div>
                                                    </li>

                                                    <li>
                                                        <div class="tooltip">
                                                            <img src="/Javbook/assets/img/emoji/sad.svg" alt="" />
                                                            <span class="toolTipText tooltipIcon5"
                                                                  >Sad</span
                                                            >
                                                        </div>
                                                    </li>

                                                    <li>
                                                        <div class="tooltip">
                                                            <img src="/Javbook/assets/img/emoji/angry.svg" alt="" />
                                                            <span class="toolTipText tooltipIcon6"
                                                                  >Angry</span
                                                            >
                                                        </div>
                                                    </li>
                                                </ul>
                                            </div>
                                        </div>
                                        <span class="reply-level">Reply</span>
                                        <span>1 hour</span>
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
   
<c:forEach items="${statusUser}" var="status" >

    <div class="post box" id="${status.statusId}">
        <div class="post-item">
            <div class="status-main">
                <img src="/Javbook/assets/img/default/avatar.png" class="status-img" />
                <div class="post-detail">
                    <div class="post-title">
                        <a href="">${status.userName}</a>
                    </div>

                    <div class="post-state">
                        <span class="post-date">
                            12
                            hours ago
                        </span>
                        <c:if test="${status.mood==1}">
                            <i class="fas fa-globe-asia"></i>

                        </c:if>
                        <c:if test="${status.mood==3}">
                            <i class="fas fa-lock"></i>

                        </c:if>
                        <c:if test="${status.mood==2}">
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
                <p class="content">${status.text}</p>
            </div>
            <div class="post-photos">
                <img
                    src="${status.statusImg}"
                    alt=""
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
                    <img src="/Javbook/assets/img/emoji/unlike.png" alt="" class="icon-status" />
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
                    <button class="send-comment main-send">
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
                                                        <span class="toolTipText tooltipIcon6"
                                                              >Angry</span
                                                        >
                                                    </div>
                                                </li>
                                            </ul>
                                        </div>
                                    </div>
                                    <span class="reply-main">Reply</span>
                                    <span>1 hour</span>
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
                                                            <img src="/Javbook/assets/img/emoji/like.svg" alt="" />
                                                            <span class="toolTipText">Like</span>
                                                        </div>
                                                    </li>

                                                    <li>
                                                        <div class="tooltip">
                                                            <img src="/Javbook/assets/img/emoji/love.svg" alt="" />
                                                            <span class="toolTipText tooltipIcon2"
                                                                  >Love</span
                                                            >
                                                        </div>
                                                    </li>

                                                    <li>
                                                        <div class="tooltip">
                                                            <img src="/Javbook/assets/img/emoji/care.svg" alt="" />
                                                            <span class="toolTipText tooltipIcon3"
                                                                  >Care</span
                                                            >
                                                        </div>
                                                    </li>

                                                    <li>
                                                        <div class="tooltip">
                                                            <img src="/Javbook/assets/img/emoji/haha.svg" alt="" />
                                                            <span class="toolTipText tooltipIcon4"
                                                                  >Haha</span
                                                            >
                                                        </div>
                                                    </li>

                                                    <li>
                                                        <div class="tooltip">
                                                            <img src="/Javbook/assets/img/emoji/sad.svg" alt="" />
                                                            <span class="toolTipText tooltipIcon5"
                                                                  >Sad</span
                                                            >
                                                        </div>
                                                    </li>

                                                    <li>
                                                        <div class="tooltip">
                                                            <img src="/Javbook/assets/img/emoji/angry.svg" alt="" />
                                                            <span class="toolTipText tooltipIcon6"
                                                                  >Angry</span
                                                            >
                                                        </div>
                                                    </li>
                                                </ul>
                                            </div>
                                        </div>
                                        <span class="reply-level">Reply</span>
                                        <span>1 hour</span>
                                    </div>
                                </div>
                            </div>

                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</c:forEach>

<script src="/Javbook/assets/js/common/postBox.js" async></script>
<script src="/Javbook/assets/js/profile/Post/profilePost.js" async></script>
