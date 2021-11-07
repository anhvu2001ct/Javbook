i<%-- Document : profileheader Created on : Oct 11, 2021, 7:57:36 PM Author : Mr
Khang --%> <%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
        <meta charset="UTF-8" />
        <meta http-equiv="X-UA-Compatible" content="IE=edge" />
        <meta name="viewport" content="width=device-width, initial-scale=1.0" />
        <title>Profile</title>
        <link
            rel="icon"
            href="/Javbook/assets/img/logo/Javbook_black.png"
            type="image/gif"
            sizes="16x16"
        />
        <link
            rel="stylesheet"
            href="/Javbook/assets/css/common/variables.css"
        />
        <link rel="stylesheet" href="/Javbook/assets/css/common/base.css" />
        <link
            rel="stylesheet"
            href="/Javbook/assets/css/profile/profileHeader.css"
        />
        <link
            rel="stylesheet"
            href="/Javbook/assets/css/profile/profilePost.css"
        />
        <link rel="stylesheet" href="/Javbook/assets/css/common/postBox.css" />
        <link
            rel="stylesheet"
            href="/Javbook/assets/css/profile/profilePhoto.css"
        />
        <link
            rel="stylesheet"
            href="/Javbook/assets/css/profile/profileAbout.css"
        />
        <!-- Toast Message -->
        <link
            rel="stylesheet"
            href="/Javbook/assets/css/common/toastMessage.css"
        />
        <link
            rel="stylesheet"
            href="/Javbook/assets/css/profile/profileFriends.css"
        />
        <link rel="stylesheet" href="/Javbook/assets/css/common/header.css" />
        <link rel="stylesheet" href="/Javbook/assets/css/boxChat/boxChat.css" />
        <link
            rel="stylesheet"
            href="/Javbook/assets/css/profile/popupEmoji.css"
        />
        <link
            rel="stylesheet"
            href="/Javbook/assets/fonts/fontawesome-5.15.4/css/all.min.css"
        />
        <script src="/Javbook/assets/js/common/query.js"></script>
        <!-- Toast Message -->
        <script src="/Javbook/assets/js/common/toastMessage.js"></script>
    </head>
    <body>
        <%@include file="../common/header.jsp" %>

        <div class="main-container">
            <div class="profile">
                <div class="profile-name-background"></div>
                <div class="profile-avatar">
                    <img
                        src="${profileUser.avatar}"
                        alt=""
                        class="profile-img"
                    />

                    <div class="profile-name">${profileUser.name}</div>
                </div>
                <div class="edit-header-avatar">
                    <label for="header-avatar-file">
                        <i class="fas fa-camera"></i>
                    </label>
                    <input
                        type="file"
                        name="photo-file"
                        id="header-avatar-file"
                        accept="image/* "
                    />
                </div>
                <div class="photo-profile-cover">
                    <div class="edit-cover-img">
                        <label for="header-photo-file">
                            <i class="far fa-edit fa-lg"></i>
                        </label>
                        <input
                            type="file"
                            name="photo-file"
                            id="header-photo-file"
                            accept="image/* "
                        />
                    </div>
                    <img
                        src="${profileUser.coverImg}"
                        alt=""
                        class="profile-cover"
                    />
                </div>

                <div class="profile-menu">
                    <a class="profile-menu-link active">Post</a>
                    <a class="profile-menu-link">About</a>
                    <a class="profile-menu-link">Friends</a>
                    <a class="profile-menu-link">Photos</a>
                    <div class="friendAndMess">
                        <c:choose>
                            <c:when test="${isFriend==2}">
                                <div class="addFriend js-add-friend-btn">
                                    <i class="fas fa-user-check fa-1x"></i>
                                    Friends
                                </div>
                            </c:when>
                            <c:when test="${isFriend==-2}">
                                <div class="addFriend js-add-friend-btn">
                                    <i class="fas fa-user-plus fa-1x"></i>
                                    Add Friends
                                </div>
                            </c:when>
                            <c:when test="${isFriend==1}">
                                <div class="addFriend js-add-friend-btn">
                                    <i class="fas fa-user-times fa-1x"></i>
                                    Waiting
                                </div>
                            </c:when>
                            <c:otherwise>
                                <div class="addFriend js-add-friend-btn">
                                    <i class="fas fa-user-clock fa-1x"></i>
                                    Accept
                                </div>
                            </c:otherwise>
                        </c:choose>

                        <div class="addFriend">
                            <i class="fab fa-facebook-messenger fa-lg mess"></i>
                            Message
                        </div>
                    </div>
                </div>
            </div>
            <div class="timeline" id="${curId}"></div>
        </div>
        <!-- popup  -->
        <div class="popup_model flex_center-post popup-main-post">
            <div class="post_popup" id="post_popup">
                <div class="pop_ele1 flex_center">
                    <span class="pop_title">Create Post</span>
                    <span class="close pointer">+</span>
                </div>

                <div class="pop_ele2 flex">
                    <div class="wh_40">
                        <img
                            class="wh_40 scale circle"
                            src="/Javbook/assets/img/default/avatar.png"
                            alt=""
                        />
                    </div>
                    <div class="status_content flex_gr1">
                        <textarea
                            name="input_field"
                            cols=""
                            rows=""
                            class="enter"
                            placeholder="What's your mind?"
                        ></textarea>
                        <div class="display-img">
                            <img src="" alt="" id="status-img" />
                            <span class="close-img"
                                ><i class="fas fa-times"></i
                            ></span>
                        </div>
                    </div>
                </div>

                <div class="pop_ele3 flex">
                    <select name="object" id="select" class="popup_btn pointer">
                        <option value="1">Public</option>
                        <option value="2">Friends</option>
                        <option value="3">Only me</option>
                    </select>
                    <div class="input_file popup_btn pointer">
                        <input
                            type="file"
                            name="file"
                            id="file"
                            accept="image/*"
                        />
                        <label for="file" class="photo pointer">
                            <i class="far fa-images"></i>
                            <span class="p_l5">Photo/Video</span>
                        </label>
                    </div>
                    <span class="share popup_btn pointer">Post</span>
                </div>
            </div>
        </div>
        <div class="popup_model flex_center-post popup-post-box">
            <div class="post_popup" id="post_popup">
                <div class="pop_ele1 flex_center">
                    <span class="pop_title">Edit Post</span>
                    <span class="close pointer">+</span>
                </div>

                <div class="pop_ele2 flex">
                    <div class="wh_40">
                        <img
                            class="wh_40 scale circle"
                            src="/Javbook/assets/img/default/avatar.png"
                            alt=""
                        />
                    </div>
                    <div class="status_content flex_gr1">
                        <textarea
                            name="input_field"
                            cols=""
                            rows=""
                            class="enter"
                            placeholder="What's your mind?"
                        ></textarea>
                        <div class="display-img">
                            <img src="" alt="" id="status-img" />
                        </div>
                    </div>
                </div>

                <div class="pop_ele3 flex">
                    <select name="object" id="select" class="popup_btn pointer">
                        <option value="public">Public</option>
                        <option value="friends">Friends</option>
                        <option value="only_me">Only me</option>
                    </select>

                    <span class="share popup_btn pointer">Save</span>
                </div>
            </div>
        </div>
        <div class="popup-emoji-box"><%@include file="popupEmoji.jsp" %></div>
        
        <%@include file="/client/boxChat/boxChatContainer.jsp" %>
         
        <script src="/Javbook/assets/js/profile/Header/profileHeader.js"></script>
        <script src="https://code.jquery.com/jquery-3.6.0.js"></script>
        <script src="/Javbook/assets/js/common/ws.js"></script>
        <script src="/Javbook/assets/js/common/header.js"></script>
        <script src="/Javbook/assets/js/common/message.js"></script>
    </body>
</html>
