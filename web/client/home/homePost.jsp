<%-- 
    Document   : postStatus
    Created on : 29 Oct 2021, 22:23:01
    Author     : ASUS
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!--post status-->
<!-- post container -->
<div class="timeline-right">
    <div class="post_box flex_cl">
        <div class="post_ele1 flex flex_ac">
            <div class="wh_40">
                <img
                    class="wh_40 scale circle"
                    src="/Javbook/assets/img/default/avatar.png"
                    alt=""
                    />
            </div>

            <div class="input flex flex_ac pointer" id="input">
                What's your mind?
            </div>
        </div>
        <div class="post_ele2 flex flex_ac">
            <div class="photo flex_gr1 p_l5 pointer hv">
                <i class="far fa-images"></i>
                <span class="p_l5">Photo/Video</span>
            </div>
            <div class="tagfriend flex_gr1 p_l5 pointer hv">
                <i class="fas fa-user-tag"></i>
                <span class="p_l5">Tag Friend</span>
            </div>
            <div class="feeling flex_gr1 p_l5 pointer hv">
                <i class="far fa-grin"></i>
                <span class="p_l5">Feeling</span>
            </div>
        </div>
    </div>

    <div class="list-post"></div>
</div>

<!-- popup  -->
<div class="popup_model flex_center-post">
    <div class="post_popup" id="post_popup">

        <div class="pop_ele1 flex_center-post">
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
                    <span class="close-img"><i class="fas fa-times"></i></span>
                </div>
            </div>
        </div>

        <div class="pop_ele3 flex">
            <select name="object" id="select" class="popup_btn pointer">
                <option value="public">Public</option>
                <option value="friends">Friends</option>
                <option value="only_me">Only me</option>
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