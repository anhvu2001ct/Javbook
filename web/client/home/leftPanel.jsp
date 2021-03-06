<%-- 
    Document   : leftPanel
    Created on : 29 Oct 2021, 14:15:19
    Author     : ASUS
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!--leftPanel-->
<div class="leftpanel flex flex_column">

    <a href="/Javbook/profile/${uid2}/">
        <div class="profile flex hov m_10 bd_rd p_element h_52 flex_al_ct">
            <div class="profile_img m_10"><img
                    src="${userinfo.avatar}"
                    alt="" class="bd_circle w_icon h_icon scale"
                    />
            </div>
            <div class="profile-name font_weight">${userinfo.name}</div>
        </div>
    </a>

    <div class="leftpanel_friend flex hov p_element  m_10 bd_rd h_52 flex_al_ct">
        <div class="friend_icon m_10"><i class="fas fa-user-friends w_icon h_auto font_icon"></i></div>
        <div class="friend_title font_weight">Friends</div>
    </div>

    <div class="leftpanel_group flex hov m_10 bd_rd p_element h_52 flex_al_ct">
        <div class="group_icon m_10"><i class="fas fa-users  w_icon h_auto font_icon"></i></div>
        <div class="group_title font_weight">Group</div>
    </div>

    <div class="leftpanel_fanpage flex hov m_10 bd_rd p_element h_52 flex_al_ct">
        <div class="fanpage_icon m_10"><i class="fas fa-pager  w_icon h_auto font_icon"></i></div>
        <div class="fanpage_title font_weight">Fanpage</div>
    </div>

    <div class="leftpanel_message flex hov m_10 bd_rd p_element h_52 flex_al_ct">
        <div class="message_icon m_10"><i class="fas fa-comments  w_icon h_auto font_icon"></i></div>
        <div class="message_title font_weight">Messages</div>
    </div>

    <div class="leftpanel_more flex hov m_10 bd_rd p_element h_52 flex_al_ct changerotate">
        <div class="more_icon m_10"><i class="fas fa-angle-right w_icon h_auto font_icon "></i></div>
        <div class="more_title font_weight">More</div>
    </div>
    <div class="leftpanel_logout hov m_10 bd_rd p_element h_52 flex_al_ct ">
        <div class="more_icon m_10"><i class="fas fa-sign-out-alt  w_icon h_auto font_icon "></i></div>
        <div class="more_title font_weight">Log Out</div>
    </div>
   


</div>