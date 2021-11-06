<%-- 
    Document   : miniNotification
    Created on : 31 Oct 2021, 23:05:28
    Author     : ASUS
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>


    <a href="/Javbook/status?${notifi.url}">
        <div class="popup_item notification notifi_active " id="${notifi.notificationid}">
            <span
                class="popup_item_img wh_40 notification_logo"

                ><img
                    src="${notifi.senderavatar}"
                    alt=""
                    class="scale wh_40 circle"
                    />
                <span class="notification_icon">
                    <img src="/Javbook/assets/img/emoji/${notifi.emoji}" alt="">
                </span>
            </span>
            <div class="popup_item_info notification_content">
                <span class="notification_text"
                      ><strong>${notifi.sendername}</strong
                    >${notifi.messnotifi}</span
                >
                <span class="notification_time "
                      >${notifi.time}</span
                >
            </div>
        </div>
    </a>
