<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<div class="about">
    <div class="about-main">
        <div class="about-content">
            <div class="profile-main">
                <ul class="list">
                    <li class="list-item">
                        <div class="icon">
                            <i class="fas fa-signature"></i>
                        </div>
                        <div class="list-item-content">
                            Name
                            <input
                                disabled
                                class="edit-text"
                                type="text"
                                value="${profileUser.name}"
                            />
                        </div>
                    </li>
                    <c:choose>
                        <c:when test="${audiences.get(3) == 1}">
                            <li class="list-item">
                                <div class="icon">
                                    <i class="fas fa-briefcase"></i>
                                </div>
                                <div class="list-item-content">
                                    Career
                                    <input
                                        disabled
                                        class="edit-text"
                                        type="text"
                                        value="${profileUser.career}"
                                    />
                                </div>
                            </li>
                        </c:when>
                        <c:when test="${audiences.get(3) == 2 && isFriend}">
                            <li class="list-item">
                                <div class="icon">
                                    <i class="fas fa-briefcase"></i>
                                </div>
                                <div class="list-item-content">
                                    Career
                                    <input
                                        disabled
                                        class="edit-text"
                                        type="text"
                                        value="${profileUser.career}"
                                    />
                                </div>
                            </li>
                        </c:when>
                        <c:otherwise></c:otherwise>
                    </c:choose>
                    <c:choose>
                        <c:when test="${audiences.get(1) == 1}">
                            <li class="list-item">
                                <div class="icon">
                                    <i class="fas fa-map-marker-alt"></i>
                                </div>
                                <div class="list-item-content">
                                    Live in
                                    <input
                                        disabled
                                        class="edit-text"
                                        type="text"
                                        value="${profileUser.address}"
                                    />
                                </div>
                            </li>
                        </c:when>
                        <c:when test="${audiences.get(1) == 2 && isFriend}">
                            <li class="list-item">
                                <div class="icon">
                                    <i class="fas fa-map-marker-alt"></i>
                                </div>
                                <div class="list-item-content">
                                    Live in
                                    <input
                                        disabled
                                        class="edit-text"
                                        type="text"
                                        value="${profileUser.address}"
                                    />
                                </div>
                            </li>
                        </c:when>
                        <c:otherwise></c:otherwise>
                    </c:choose>
                    <c:choose>
                        <c:when test="${audiences.get(0) == 1}">
                            <li class="list-item">
                                <div class="icon">
                                    <i class="fas fa-birthday-cake"></i>
                                </div>
                                <div class="list-item-content">
                                    Birthday on
                                    <input
                                        disabled
                                        class="edit-text"
                                        type="date"
                                        value="${profileUser.DOB}"
                                    />
                                </div>
                            </li>
                        </c:when>
                        <c:when test="${audiences.get(0) == 2 && isFriend}">
                            <li class="list-item">
                                <div class="icon">
                                    <i class="fas fa-birthday-cake"></i>
                                </div>
                                <div class="list-item-content">
                                    Birthday on
                                    <input
                                        disabled
                                        class="edit-text"
                                        type="date"
                                        value="${profileUser.DOB}"
                                    />
                                </div>
                            </li>
                        </c:when>
                        <c:otherwise></c:otherwise>
                    </c:choose>
                    <c:choose>
                        <c:when test="${audiences.get(2) == 1}">
                            <li class="list-item">
                                <div class="icon">
                                    <i class="fas fa-user"></i>
                                </div>
                                <div class="list-item-content">
                                    <input
                                        disabled
                                        class="edit-text js-gender-value"
                                        type="text"
                                        value="${profileUser.gender}"
                                    />
                                </div>
                            </li>
                        </c:when>
                        <c:when test="${audiences.get(2) == 2 && isFriend}">
                            <li class="list-item">
                                <div class="icon">
                                    <i class="fas fa-user"></i>
                                </div>
                                <div class="list-item-content">
                                    <input
                                        disabled
                                        class="edit-text js-gender-value"
                                        type="text"
                                        value="${profileUser.gender}"
                                    />
                                </div>
                            </li>
                        </c:when>
                        <c:otherwise></c:otherwise>
                    </c:choose>
                    <c:choose>
                        <c:when test="${audiences.get(5) == 1}">
                            <li class="list-item">
                                <div class="icon">
                                    <i class="fas fa-mobile-alt"></i>
                                </div>
                                <div class="list-item-content">
                                    <input
                                        disabled
                                        class="edit-text"
                                        type="text"
                                        value="${account.phone}"
                                    />
                                </div>
                            </li>
                        </c:when>
                        <c:when test="${audiences.get(5) == 2 && isFriend}">
                            <li class="list-item">
                                <div class="icon">
                                    <i class="fas fa-mobile-alt"></i>
                                </div>
                                <div class="list-item-content">
                                    <input
                                        disabled
                                        class="edit-text"
                                        type="text"
                                        value="${account.phone}"
                                    />
                                </div>
                            </li>
                        </c:when>
                        <c:otherwise></c:otherwise>
                    </c:choose>
                    <c:choose>
                        <c:when test="${audiences.get(4) == 1}">
                            <li class="list-item">
                                <div class="icon">
                                    <i class="fas fa-heart"></i>
                                </div>
                                <div class="list-item-content">
                                    <input
                                        disabled
                                        class="edit-text js-status-value"
                                        type="text"
                                        value="${profileStatus.status}"
                                    />
                                </div>
                            </li>
                        </c:when>
                        <c:when test="${audiences.get(4) == 2 && isFriend}">
                            <li class="list-item">
                                <div class="icon">
                                    <i class="fas fa-heart"></i>
                                </div>
                                <div class="list-item-content">
                                    <input
                                        disabled
                                        class="edit-text js-status-value"
                                        type="text"
                                        value="${profileStatus.status}"
                                    />
                                </div>
                            </li>
                        </c:when>
                        <c:otherwise></c:otherwise>
                    </c:choose>
                </ul>
            </div>
        </div>
    </div>
</div>
