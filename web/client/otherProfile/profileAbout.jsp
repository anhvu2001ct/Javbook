<%@page contentType="text/html" pageEncoding="UTF-8"%>

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
                </ul>
            </div>
        </div>
    </div>
</div>
