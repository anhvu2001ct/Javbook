<%-- 
    Document   : profileheader
    Created on : Oct 11, 2021, 7:57:36 PM
    Author     : Mr Khang
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta charset="UTF-8" />
        <meta http-equiv="X-UA-Compatible" content="IE=edge" />
        <meta name="viewport" content="width=device-width, initial-scale=1.0" />
        <title>Document</title>
        <script
            src="https://kit.fontawesome.com/466439df6f.js"
            crossorigin="anonymous"
        ></script>
        <link rel="stylesheet" href="./assets/css/Common/variables.css" />
        <link rel="stylesheet" href="./assets/css/Common/base.css" />
        <link rel="stylesheet" href="./assets/css/profile/profileheader.css" />
        <script src="./assets/js/profilepost.js" async  ></script>
        <script src="./assets/js/profileheader.js" async></script>
        <link rel="stylesheet" href="./assets/css/profile/profilepost.css" />
        <script
            src="https://kit.fontawesome.com/466439df6f.js"
            crossorigin="anonymous"
        ></script>


        <script src="/Javbook/assets/js/common/query.js" async></script>

    </head>
    <body>
        <div class="main-container">
            <div class="profile">
                <div class="profile-name-background"></div>
                <div class="profile-avatar">
                    <img src="./assets/image/avatar.jpg" alt="" class="profile-img" />

                    <div class="profile-name">Nguyễn Hoàng Khang</div>
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
                        src="https://scontent.fvca1-2.fna.fbcdn.net/v/t1.6435-9/153880781_1269206826834221_640873498255439976_n.jpg?_nc_cat=100&ccb=1-5&_nc_sid=e3f864&_nc_ohc=TSfn9YA190wAX-S5rLI&_nc_ht=scontent.fvca1-2.fna&oh=f93eb6f75dc683485e9368c55058ae26&oe=61721FE1"
                        alt=""
                        class="profile-cover"
                        />
                </div>

                <div class="profile-menu">
                    <a class="profile-menu-link active">Post</a>
                    <a class="profile-menu-link">About</a>
                    <a class="profile-menu-link">Friends</a>
                    <a class="profile-menu-link">Photos</a>
                </div>
            </div>
            <div class="timeline">
                <%@include file="profilepost.jsp" %> 
            </div>
        </div>
        <!-- popup  -->
        <div class="popup_model flex_center">
            <div class="post_popup" id="post_popup">

                <div class="pop_ele1 flex_center">
                    <span class="pop_title">Create Post</span>
                    <span class="close pointer">+</span>
                </div>

                <div class="pop_ele2 flex">
                    <div class="wh_40">
                        <img
                            class="wh_40 scale circle"
                            src="./assets/image/avatar.jpg"
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
                            <span class="close-img"><i class="fas fa-times"></i></span>
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
                        <input type="file" name="file" id="file" accept="image/*" />
                        <label for="file" class="photo pointer">
                            <i class="far fa-images"></i>
                            <span class="p_l5">Photo/Video</span>
                        </label>
                    </div>
                    <span class="share popup_btn pointer">Post</span>
                </div>
            </div>
        </div>
    </body>
</html>
