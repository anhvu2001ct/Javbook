<%-- 
    Document   : homePage
    Created on : 29 Oct 2021, 14:12:26
    Author     : NhatQuynh
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Javbook</title>
        <link
            rel="icon"
            href="/Javbook/assets/img/logo/Javbook_black.png"
            type="image/x-icon"
            />
        <script src="https://kit.fontawesome.com/ff4d20b881.js" crossorigin="anonymous"></script>
        <link
            rel="stylesheet"
            href="/Javbook/assets/css/common/variables.css"
            />
        <link rel="stylesheet" href="/Javbook/assets/css/common/base.css" />
        <link
            rel="stylesheet"
            href="/Javbook/assets/css/home/leftpanel.css"
            />
        <link
            rel="stylesheet"
            href="/Javbook/assets/css/home/rightPanel.css"
            />

        <link
            rel="stylesheet"
            href="/Javbook/assets/css/common/header.css"
            />
        <link
            rel="stylesheet"
            href="/Javbook/assets/css/common/notification.css"
            />
        <link
            rel="stylesheet"
            href="/Javbook/assets/css/profile/profilePost.css"
            />
        <link
            rel="stylesheet"
            href="/Javbook/assets/css/common/postBox.css"
            />
        <link
            rel="stylesheet"
            href="/Javbook/assets/css/profile/popupEmoji.css"
            />
    </head>
    <body>
        <%@include file="leftPanel.jsp" %>
        <%@include file="rightPanel.jsp" %>
        <%@include file="../common/header.jsp" %>
        <%@include file="../common/notification.jsp" %>
        <div class="home-post">
            <%@include file="homePost.jsp" %>
            <div class="list-post home-box">
                <%@include file="homeStatus.jsp" %>
            </div>
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
        <div class="popup-emoji-box"><%@include file="../profile/popupEmoji.jsp" %></div>
        <script src="/Javbook/assets/js/common/query.js"></script>
        <script src="https://code.jquery.com/jquery-3.6.0.js"></script>
        <script src="/Javbook/assets/js/home/LeftPanel/leftpanel.js"></script>
        <script src="/Javbook/assets/js/common/ws.js"></script>
        <script src="/Javbook/assets/js/common/header.js"></script>
        <script src="/Javbook/assets/js/common/notification.js"></script>
        <script src="/Javbook/assets/js/profile/Post/postBox.js" async></script>
        <script src="/Javbook/assets/js/profile/Post/profilePost.js" async></script>
        <script src="/Javbook/assets/js/profile/Post/popupEmoji.js" async></script>


    </body>
</html>
