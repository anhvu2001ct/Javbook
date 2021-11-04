<%-- 
    Document   : postStatus
    Created on : 29 Oct 2021, 22:23:01
    Author     : ASUS
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

    <div class="timeline-right timeline-home">
        <div class="post_box flex_cl">
            <div class="post_ele1 flex flex_ac">
                <div class="wh_40">
                    <img
                        class="wh_40 scale circle userAvatar"
                        src="${userinfo.avatar}"
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


