<%@page contentType="text/html" pageEncoding="UTF-8"%> <%@ taglib
uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<div class="small_zooomout_container">
    <!-- <div class="small_zoomout hongyen" >
        <img
          src="/image/logo.jpg"
          alt=""
          title="Hong Yen"
          class="small_zoomout_img"
        />
        <div class="small_zoomout_icon"><i class="fas fa-times"></i></div>
      </div> -->
</div>
<div class="boxchat_container">
    <div class="boxchat">
        <div class="boxchat_header">
            <div class="boxchat_header_title">
                <a href="minhcanh">
                    <span class="boxchat_header_title_img wh_wrap_header">
                        <img
                            src="/Javbook/assets/img/default/cover.jpg"
                            alt=""
                            class="custom_image"
                        />
                    </span>
                    <span class="boxchat_header_title_username">
                        minh canh
                    </span>
                </a>
            </div>

            <div class="boxchat_header_icon">
                <span class="zoomout icon"><i class="fas fa-minus"></i></span>
                <span class="exit icon"><i class="fas fa-times"></i></span>
            </div>
        </div>

        <div class="boxchat_inner">
            <div class="otheruser">
                <div class="otheruser_image wh_wrap_inner">
                    <img
                        src="/Javbook/assets/img/default/cover.jpg"
                        alt=""
                        class="custom_image"
                    />
                </div>
                <div class="otheruser_chat">
                    <span class="otheruser_chat_message"
                        >ahihiiiiiiiiiiiiiiiiiiii2</span
                    >
                    <span class="otheruser_chat_message"
                        ><img
                            src="/Javbook/assets/img/default/cover.jpg"
                            alt=""
                            class="otheruser_chat_message_image"
                    /></span>
                </div>
            </div>
            <div class="owneruser">
                <div class="owneruser_chat">
                    <span class="owneruser_chat_message"
                        >ahihiiiiiiiiiiiiiiiiiiii2</span
                    >

                    <span class="owneruser_chat_message"
                        ><img
                            src="/Javbook/assets/img/default/cover.jpg"
                            alt=""
                            class="owner_chat_message_image"
                    /></span>
                </div>
            </div>
        </div>

        <div class="boxchat_footer">
            <div class="boxchat_footer_image">
                <label for="messagefile"
                    ><i class="fas fa-images"></i>Image</label
                >
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
    </div>
    <div class="boxchat">
        <div class="boxchat_header">
            <div class="boxchat_header_title">
                <a href="hongyen">
                    <span class="boxchat_header_title_img wh_wrap_header">
                        <img
                            src="/Javbook/assets/img/default/avatar.png"
                            alt=""
                            class="custom_image"
                        />
                    </span>
                    <span class="boxchat_header_title_username">
                        Hong Yen
                    </span>
                </a>
            </div>

            <div class="boxchat_header_icon">
                <span class="zoomout icon"><i class="fas fa-minus"></i></span>
                <span class="exit icon"><i class="fas fa-times"></i></span>
            </div>
        </div>

        <div class="boxchat_inner">
            <div class="otheruser">
                <div class="otheruser_image wh_wrap_inner">
                    <img
                        src="/Javbook/assets/img/default/avatar.png"
                        alt=""
                        class="custom_image"
                    />
                </div>
                <div class="otheruser_chat">
                    <span class="otheruser_chat_message"
                        >ahihiiiiiiiiiiiiiiiiiiii2</span
                    >
                    <span class="otheruser_chat_message"
                        ><img
                            src="/Javbook/assets/img/default/avatar.png"
                            alt=""
                            class="otheruser_chat_message_image"
                    /></span>
                </div>
            </div>

            <div class="owneruser">
                <div class="owneruser_chat">
                    <span class="owneruser_chat_message"
                        >ahihiiiiiiiiiiiiiiiiiiii2</span
                    >

                    <span class="owneruser_chat_message"
                        ><img
                            src="/Javbook/assets/img/default/avatar.png"
                            alt=""
                            class="owner_chat_message_image"
                    /></span>
                </div>
            </div>
        </div>

        <div class="boxchat_footer">
            <div class="boxchat_footer_image">
                <label for="messagefile"
                    ><i class="fas fa-images"></i>Image</label
                >
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
    </div>
</div>

<script src="/Javbook/assets/js/boxChat/boxChat.js"></script>
