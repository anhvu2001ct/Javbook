<%@page contentType="text/html" pageEncoding="UTF-8"%> 
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<div class="boxchat_header">
    <div class="boxchat_header_title">
        <a href="/Javbook/profile/${profileUser.getEncodeID()}/">
            <span class="boxchat_header_title_img wh_wrap_header">
                <img
                    src="${profileUser.avatar}"
                    alt=""
                    class="custom_image"
                />
            </span>
            <span class="boxchat_header_title_username"> ${profileUser.name} </span>
        </a>
    </div>

    <div class="boxchat_header_icon">
        <span class="zoomout icon"><i class="fas fa-minus"></i></span>
        <span class="exit icon"><i class="fas fa-times"></i></span>
    </div>
</div>

<div class="boxchat_inner">
    <c:forEach items="${chatList}" var="chatItem">
        <c:choose>
            <c:when test="${chatItem.second}">
                <div class="owneruser">
                    <div class="owneruser_chat">
                        <c:if test="${chatItem.first.text != null}">
                            <span class="owneruser_chat_message">${chatItem.first.text}</span>
                        </c:if>
                        <c:if test="${chatItem.first.chatImg != null}">
                            <span class="owneruser_chat_message"
                                ><img
                                    src="${chatItem.first.chatImg}"
                                    alt=""
                                    class="owner_chat_message_image"
                                />
                            </span>
                        </c:if>
                    </div>
                </div>
            </c:when>
            <c:otherwise> 
                <div class="otheruser">
                    <div class="otheruser_image wh_wrap_inner">
                        <img
                            src="${profileUser.avatar}"
                            alt=""
                            class="custom_image"
                        />
                    </div>
                    <div class="otheruser_chat">
                        <c:if test="${chatItem.first.text != null}">
                            <span class="otheruser_chat_message">${chatItem.first.text}</span>
                        </c:if>
                        <c:if test="${chatItem.first.chatImg != null}">
                            <span class="otheruser_chat_message"
                                ><img
                                    src="${chatItem.first.chatImg}"
                                    alt=""
                                    class="owner_chat_message_image"
                                />
                            </span>
                        </c:if>
                    </div>
                </div>
            </c:otherwise>
        </c:choose>
    </c:forEach>
</div>

<div class="boxchat_footer">
    <div class="boxchat_footer_image">
        <label for="messagefile"><i class="fas fa-images"></i>Image</label>
        <input
            type="file"
            name="messagefile"
            id="messagefile"
            accept="image/*"
            multiple
            required
        />
    </div>
    <div class="boxchat_footer_groupinput">
        <div class="boxchat_footer_input">
            <div class="boxchat_footer_input_img"></div>
            <textarea
                name=""
                id="textbox"
                class="textbox"
                placeholder="Aa"
                rows="1"
            ></textarea>
        </div>
        <div class="boxchat_footer_sender">
            <i class="fas fa-paper-plane"></i>
        </div>
    </div>
</div>

<script src="/Javbook/assets/js/boxChat/boxChat.js"></script>
