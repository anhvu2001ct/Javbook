<%-- 
    Document   : profilepost
    Created on : Oct 11, 2021, 8:13:00 PM
    Author     : Mr Khang
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>




<div class="post-container" >
    <div class="timeline-left">
        <div class="intro box">
            <div class="intro-title">Introduction</div>
            <div class="info">
                <div class="info-item">
                    <i class="fas fa-briefcase"></i>
                    <p>
                        <span>Career</span> ${profileUser.career} 
                    </p>
                </div>
                <div class="info-item">
                    <i class="fas fa-home"></i>
                    <p>
                        <span>Live in</span> ${profileUser.address}
                    </p>
                </div>
                <div class="info-item">
                    <i class="fas fa-birthday-cake"></i>
                    <p>${profileUser.DOB}</p>
                </div>
                <div class="info-item">
                    <i class="fas fa-transgender-alt"></i>
                    <p>${profileUser.gender}</p>
                </div>
                <div class="info-item">
                    <i class="fas fa-heart"></i>
                    <p>${profileStatus.status}</p>
                </div>
            </div>
        </div>
    </div>
    <!-- post container -->
    <div class="flex_cl">
        <div class="timeline-right">
        <div class="post_box flex_cl">
            <div class="post_ele1 flex flex_ac">
                <div class="wh_40">
                    <img
                        class="wh_40 scale circle userAvatar"
                        src="${avatar}"
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


    </div>
    <div class="list-post">
        <%@include file="postBox.jsp" %>
    </div>
    </div>
</div>



