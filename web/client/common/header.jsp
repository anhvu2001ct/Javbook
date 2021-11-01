<%-- 
    Document   : header
    Created on : 29 Oct 2021, 14:13:50
    Author     : ASUS
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!--header-->
<div class="header_container">
    <div class="header flex flex_jsb flex_ac">
        <div class="header_element flex_center">
            <a class="header_brand wh_40" href="/Javbook/"
               ><img
                    src="/Javbook/test/nhatquynh/header/assets/img/logo/Javbook_white.png"
                    alt=""
                    class="scale wh_40 circle"
                    /></a>
            <span class="header_brand_title">Javbook</span>

            <div class="header_item flex_center wh_40">
                <span class="search-box flex">
                    <input
                        type="text"
                        name=""
                        class="search-txt"
                        placeholder="Search on Javabook"
                        />
                    <a class="search-btn flex_center wh_40 circle" href=""
                       ><i class="fas fa-search"></i
                        ></a>
                </span>
            </div>
        </div>

        <div class="header_element flex_center">
            <div
                class="header_item header_icon flex_center wh_40"
                href="#"
                title="Messages"
                >
                <i class="fas fa-comments"></i>
                <span class="num nummess">0</span>
            </div>

            <div
                class="header_item header_icon flex_center wh_40"
                href="#"
                title="Friend request"
                >
                <i class="fas fa-user-friends"></i>
                <span class="num numfriend">0</span>
            </div>

            <div
                class="header_item header_icon flex_center wh_40"
                href="#"
                title="Notification"
                >
                <i class="fas fa-bell"></i>
                <span class="num numnotifi">0</span>
            </div>

            <div class="profile_border"></div>
            <a class="imageuser" href="/Javbook/profile/${uid2}/"
               ><img

                    src="${userinfo.avatar}"
                    alt=""
                    class="scale wh_40 circle"
                    /></a>
        </div>
    </div>
    <!-- popup_container  -->
    <div class="popup_container">
        <div class="popup_title">
            <h2 class="popup_mess">Friend request</h2>
        </div>

        <div class="popup_inner flex" id="popup_inner">
            <div class="popup_item flex flex_ac friend">
                <a class="popup_item_img wh_40" href="#"
                   ><img
                        src="/Javbook/test/nhatquynh/header/assets/img/logo/logo.jpg"
                        alt=""
                        class="scale wh_40 circle"
                        /></a>
                <div class="popup_item_info">
                    <a class="popup_item_info_name" href="#"
                       ><strong>Le Nhat Quynh 1</strong>
                    </a>
                    <div class="popup_item_info_confirm flex">
                        <button class="button accept">Accept</button>
                        <button class="button rejeinfo">Reject</button>
                    </div>
                </div>
            </div>


            <div class="popup_item message mess_active">
                <a class="popup_item_img wh_40 message_logo" href="#"
                   ><img
                        src="/Javbook/test/nhatquynh/header/assets/img/logo/logo.jpg"
                        alt=""
                        class="scale wh_40 circle"
                        />
                </a>
                <div class="popup_item_info message_content">
                    <span class="message_user"><strong>Hoang Khang</strong></span>
                    <span class="message_cp">
                        <span class="message_text"
                              ><strong>Khang:</strong> đã bình luận về bài viết của
                            bạn</span
                        >
                    </span>
                </div>
            </div>

            <c:if test="${!notifications.isEmpty()}">
                <c:forEach items="${notifications}" var="notifi">
                    <div class="popup_item notification notifi_active">
                        <a class="popup_item_img wh_40 notification_logo" href="#"
                           ><img
                                src="${notifi.useravatar}"
                                alt=""
                                class="scale wh_40 circle"
                                />
                            <span class="notification_icon">
                                <i class="fas fa-${notifi.typeicon}"></i>
                            </span>
                        </a>
                        <div class="popup_item_info notification_content">
                            <span class="notification_text"
                                  ><strong>${notifi.username}</strong>${notifi.messnotifi}</span
                            >
                            <span class="notification_time">${notifi.timenotifi}</span>
                        </div>
                    </div>
                </c:forEach>
            </c:if>


            <c:if test="${!notificomments.isEmpty()}">
                <c:forEach items="${notificomments}" var="nc">
                    <div class="popup_item notification notifi_active">
                        <a class="popup_item_img wh_40 notification_logo" href="#"
                           ><img
                                src="${nc.useravatar}"
                                alt=""
                                class="scale wh_40 circle"
                                />
                            <span class="notification_icon">
                                <i class="fas fa-${nc.typeicon}"></i>
                            </span>
                        </a>
                        <div class="popup_item_info notification_content">
                            <span class="notification_text"
                                  ><strong>${nc.username}</strong> ${nc.messnotifi}</span
                            >
                            <span class="notification_time">${nc.timenotifi}</span>
                        </div>
                    </div>
                </c:forEach>
            </c:if>


        </div>
    </div>
</div>
