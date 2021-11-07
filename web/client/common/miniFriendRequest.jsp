<%-- 
    Document   : miniFriendRequest
    Created on : 6 Nov 2021, 20:46:01
    Author     : Lê Nhật Quỳnh
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<div class="popup_item flex flex_ac friend" id="${friendrq.sender}">
    <a class="popup_item_img wh_40" href="/Javbook/profile/${friendrq.sender}/"
       ><img
            src="${friendrq.senderavatar}"
            alt=""
            class="scale wh_40 circle"
            /></a>
    <div class="popup_item_info">
        <a class="popup_item_info_name" href="#"
           ><strong>${friendrq.sendername}</strong>
        </a>
        <div class="popup_item_info_confirm flex">
            <button class="button accept">Accept</button>
            <button class="button rejeinfo">Reject</button>
        </div>
        <span class="notification_time ">${friendrq.time}</span>
    </div>
</div>
