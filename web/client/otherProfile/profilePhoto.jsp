<%-- 
    Document   : profilePhoto
    Created on : Oct 25, 2021, 3:26:04 PM
    Author     : Mr Khang
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<c:choose>
    <c:when test="${photos.size()==1}">
        <div class="none-photo">
            <h1>This person currently doesn't have any photos</h1>
        </div>
    </c:when>

    <c:otherwise>

        <div class="photos-item">
            <c:forEach items="${photos}" var="photo" >
                <c:if test="${photo!=null}">
                    <a href="${photo}" data-lightbox="myPhoto">
                        <img src="${photo}" />
                    </a> 
                </c:if>

            </c:forEach>
        </div>
    </c:otherwise>
</c:choose>


