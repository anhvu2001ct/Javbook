<%-- 
    Document   : miniMessage
    Created on : 6 Nov 2021, 20:48:29
    Author     : Lê Nhật Quỳnh
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<div class="popup_item message mess_active">
    <a class="popup_item_img wh_40 message_logo" href="#"
       ><img
            src="${user.avatar}"
            alt=""
            class="scale wh_40 circle"
            />
    </a>
    <div class="popup_item_info message_content">
        <span class="message_user"
              ><strong>${user.name}</strong></span
        >
        <span class="message_cp">
            <span class="message_text"
                  ><strong>${user.name}</strong> ${user.text}</span
            >
        </span>
    </div>
</div>