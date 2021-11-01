<%-- 
    Document   : miniNotification
    Created on : 31 Oct 2021, 23:05:28
    Author     : ASUS
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<c:if test="${!PARAM.isEmpty()}">
    <c:forEach items="${PARAM}" var="param">
        <div class="popup_item notification notifi_active">
            <a class="popup_item_img wh_40 notification_logo" href="#"
               ><img
                    src="${param.useravatar}"
                    alt=""
                    class="scale wh_40 circle"
                    />
                <span class="notification_icon">
                    <i class="fas fa-${param.typeicon}"></i>
                </span>
            </a>
            <div class="popup_item_info notification_content">
                <span class="notification_text"
                      ><strong>${param.username}</strong> ${param.messnotifi}</span
                >
                <span class="notification_time">${param.timenotifi}</span>
            </div>
        </div>
    </c:forEach>
</c:if>