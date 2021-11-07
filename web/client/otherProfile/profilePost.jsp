<%-- 
    Document   : profilepost
    Created on : Oct 11, 2021, 8:13:00 PM
    Author     : Mr Khang
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<div class="post-container" >
    <div class="timeline-left">
        <div class="intro box">
            <div class="intro-title">Introduction</div>
            <div class="info">
                <div class="info-item">
                    <i class="fas fa-signature"></i>
                    <p><span>Name</span> ${profileUser.name}</p>
                </div>
                <c:choose>
                    <c:when test="${audiences.get(3) == 1}">
                        <div class="info-item">
                            <i class="fas fa-briefcase"></i>
                            <p><span>Career</span> ${profileUser.career}</p>
                        </div>
                    </c:when>
                    <c:when test="${audiences.get(3) == 2 && isFriend}">
                        <div class="info-item">
                            <i class="fas fa-briefcase"></i>
                            <p><span>Career</span> ${profileUser.career}</p>
                        </div>
                    </c:when>
                    <c:otherwise> </c:otherwise>
                </c:choose>
                <c:choose>
                    <c:when test="${audiences.get(1) == 1}">
                        <div class="info-item">
                            <i class="fas fa-home"></i>
                            <p><span>Live in</span> ${profileUser.address}</p>
                        </div>
                    </c:when>
                    <c:when test="${audiences.get(1) == 2 && isFriend}">
                        <div class="info-item">
                            <i class="fas fa-home"></i>
                            <p><span>Live in</span> ${profileUser.address}</p>
                        </div>
                    </c:when>
                    <c:otherwise> </c:otherwise>
                </c:choose>
                <c:choose>
                    <c:when test="${audiences.get(0) == 1}">
                        <div class="info-item">
                            <i class="fas fa-birthday-cake"></i>
                            <p>${profileUser.DOB}</p>
                        </div>
                    </c:when>
                    <c:when test="${audiences.get(0) == 2 && isFriend}">
                        <div class="info-item">
                            <i class="fas fa-birthday-cake"></i>
                            <p>${profileUser.DOB}</p>
                        </div>
                    </c:when>
                    <c:otherwise> </c:otherwise>
                </c:choose>
                <c:choose>
                    <c:when test="${audiences.get(2) == 1}">
                        <div class="info-item">
                            <i class="fas fa-transgender-alt"></i>
                            <p>${profileUser.gender}</p>
                        </div>
                    </c:when>
                    <c:when test="${audiences.get(2) == 2 && isFriend}">
                        <div class="info-item">
                            <i class="fas fa-transgender-alt"></i>
                            <p>${profileUser.gender}</p>
                        </div>
                    </c:when>
                    <c:otherwise> </c:otherwise>
                </c:choose>
                <c:choose>
                    <c:when test="${audiences.get(5) == 1}">
                        <div class="info-item">
                            <i class="fas fa-mobile-alt"></i>
                            <p>${account.phone}</p>
                        </div>
                    </c:when>
                    <c:when test="${audiences.get(5) == 2 && isFriend}">
                        <div class="info-item">
                            <i class="fas fa-mobile-alt"></i>
                            <p>${account.phone}</p>
                        </div>
                    </c:when>
                    <c:otherwise> </c:otherwise>
                </c:choose>
                <c:choose>
                    <c:when test="${audiences.get(4) == 1}">
                        <div class="info-item">
                            <i class="fas fa-heart"></i>
                            <p>${profileStatus.status}</p>
                        </div>
                    </c:when>
                    <c:when test="${audiences.get(4) == 2 && isFriend}">
                        <div class="info-item">
                            <i class="fas fa-heart"></i>
                            <p>${profileStatus.status}</p>
                        </div>
                    </c:when>
                    <c:otherwise> </c:otherwise>
                </c:choose>
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

                <div class="input flex flex_ac pointer" id="">
                    Write something to ...
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



