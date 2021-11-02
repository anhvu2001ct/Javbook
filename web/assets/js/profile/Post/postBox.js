function postBox() {
  const icon = ["like", "love", "care", "haha", "sad", "angry"];
  const nameIcon = ["Like", "Love", "Care", "Haha", "Sad", "Angry"];
  const iconTextColor = ["#2078f4", "#f33e58", "#f7b125", "#f7b125", "#f7b125", "#e9710f"];
  const postActionBox = document.querySelectorAll(".post-action");
  const listEmoji = document.querySelectorAll(".post-action .tooltip  img");
  const iconText = document.querySelectorAll(".post-action .emoji p");
  const emojiPost = document.querySelectorAll(".post-action .icon-status");
  let listEmojiComment = document.querySelectorAll(".comment-item .tooltip  img");
  let iconTextComment = document.querySelectorAll(".comment-item  .emoji>span");
  const likePost = document.querySelectorAll(".post-action .emoji");
  let likeComment = document.querySelectorAll(".comment-item .emoji span");
  const commentText = document.querySelector(".send-text-comment");
  const commentBox = document.querySelector(".comment");
  const commentBTn = document.querySelector(".comment-status");
  let replyMainBtn = document.querySelectorAll(".main-comment-action >.reply-main");
  let replyLevelBtn = document.querySelectorAll(".main-comment-action .reply-level");
  let displaySendComment = document.querySelectorAll(".comment-level-item");
  const editPost = document.querySelectorAll(".edit-post-item .edit");
  const closePopUp = document.querySelector(".popup-post-box .close");
  const userAvatar = document.querySelectorAll(".status-main .status-img");
  const userContent = document.querySelectorAll(".post-content .content");
  const userImage = document.querySelectorAll(".post-photos .post-photo");
  const userEditAvatar = document.querySelector(".popup-post-box .post_popup .wh_40 img");
  const userEditContent = document.querySelector(".popup-post-box .status_content  .enter");
  const userEditImage = document.querySelector(".popup-post-box .display-img #status-img");
  const frameImg = document.querySelector(".popup-post-box .display-img");
  const saveEditBtn = document.querySelector(".popup-post-box .pop_ele3 .share");
  const contentMainComment = document.querySelectorAll(".comment-item  ");
  const mainSend = document.querySelectorAll(".main-send");
  let levelSend = document.querySelector(".level-send");
  const numberOfEmoji = document.querySelectorAll(".count-emoji");
  const countComment = document.querySelectorAll(".post-count-right span .count-comment");
  const countShare = document.querySelectorAll(".post-count-right span .count-share");
  let countCommentEmoji = document.querySelectorAll(".count-comment-enmoji");
  let isUpdate;
  let deletePost = document.querySelectorAll(".delete");
  const selectPostBox = document.querySelector(".popup-post-box #select");
  let optionPostBox = 1;
  let parentBox;
  let postCountLeft = document.querySelectorAll(".post-count-left");
  let mainCommentEmojiPopup = document.querySelectorAll(".main-display-comment-emoji");
  let levelCommentEmojiPopup = document.querySelectorAll(".level-display-comment-emoji");
  let isEmojiMain = document.querySelectorAll(".emoji-main");
  let isEmojiLevel = document.querySelectorAll(".commnent-emoji");
  isEmojiLevel.forEach((emoji) => {
    index = parseInt(emoji.id);
    let pTag = emoji.parentNode.parentNode.querySelector(".count-comment-enmoji");
    if (index != 0) {
      pTag.classList.add("liked")
      emoji.querySelector("span").innerText = nameIcon[index - 1];
      emoji.querySelector("span").style.color = iconTextColor[index - 1];
    }
  })
  isEmojiMain.forEach((box) => {
    let pTag = box.parentNode.parentNode.parentNode.querySelector(".post-count-left p ");

    index = parseInt(box.id);
    if (index != 0) {
      pTag.classList.add("liked");
      box.querySelector(".icon-status").src = `/Javbook/assets/img/emoji/${icon[index - 1]}.svg`
      box.querySelector("p").innerText = nameIcon[index - 1];
      box.querySelector("p").style.color = iconTextColor[index - 1];
    }
  })
  selectPostBox.addEventListener("change", () => {
    optionPostBox = selectPostBox.selectedIndex;
  });

  deletePost.forEach((deletePost, index) => {
    deletePost.onclick = () => {
      let deletePostUser = deletePost.parentNode.parentNode.parentNode.parentNode.parentNode.parentNode;
      let query = new QueryData("/status/deleteStatus");
      query.addParam("id", deletePostUser.id);
      query.send("POST");
      deletePostUser.remove();


    };
  });



  mainSend.forEach((mainSend, index) => {

    mainSend.addEventListener("click", () => {

      let value = mainSend.parentNode.querySelector(".send-text-comment");
      let commentId = 0;
      let query = new QueryData("/status/createComment");
      query.addParam("text", value.value.trim());
      query.addParam("id", mainSend.parentNode.parentNode.parentNode.parentNode.id);
      query.addEvent("load", function () {
        commentId = this.response;

        renderMainComment(mainSend, value, commentId);
      });


      query.send("POST");

    });
  });
  function renderMainComment(mainSend, value, commentId) {
    let displayMainComment = mainSend.parentNode.parentNode.querySelector(".comment-item");
    let createComment = document.createElement("div");
    createComment.classList.add("main-comment");
    createComment.setAttribute("id", commentId);
    if (value.value.trim() === "") {
      return false;
    }
    let html = `
    
    <div class="comment-user">
      <img
        src="${mainSend.parentNode.querySelector(".user-avatar-send").src}"
        alt=""
        class="ava_cmt avatar-main-comment"
      />
      <div class="comment-content-box">
        <div class="content-main-comment">
          <div class="comment-main-title">
            <a href="" class="main-user-name">Nguyễn Hoàng Khang</a>
          </div>
          <p>${value.value.trim()}</p>
          <div class="display-comment-emoji main-display-comment-emoji">
            <ul>
              <li>
                <img src="/Javbook/assets/img/emoji/like.svg" alt="0" />
              </li>
  
              <li>
                <img src="/Javbook/assets/img/emoji/love.svg" alt="0" />
              </li>
            </ul>
            <p class="count-comment-enmoji">0</p>
          </div>
        </div>
        <div class="main-comment-action">
          <div class="emoji commnent-emoji">
            <span>Like</span>
            <div class="list-icon">
              <ul>
                <li>
                  <div class="tooltip">
                    <img src="/Javbook/assets/img/emoji/like.svg" alt="" />
                    <span class="toolTipText">Like</span>
                  </div>
                </li>
  
                <li>
                  <div class="tooltip">
                    <img src="/Javbook/assets/img/emoji/love.svg" alt="" />
                    <span class="toolTipText tooltipIcon2">Love</span>
                  </div>
                </li>
  
                <li>
                  <div class="tooltip">
                    <img src="/Javbook/assets/img/emoji/care.svg" alt="" />
                    <span class="toolTipText tooltipIcon3">Care</span>
                  </div>
                </li>
  
                <li>
                  <div class="tooltip">
                    <img src="/Javbook/assets/img/emoji/haha.svg" alt="" />
                    <span class="toolTipText tooltipIcon4">Haha</span>
                  </div>
                </li>
  
                <li>
                  <div class="tooltip">
                    <img src="/Javbook/assets/img/emoji/sad.svg" alt="" />
                    <span class="toolTipText tooltipIcon5">Sad</span>
                  </div>
                </li>
  
                <li>
                  <div class="tooltip">
                    <img src="/Javbook/assets/img/emoji/angry.svg" alt="" />
                    <span class="toolTipText tooltipIcon6">Angry</span>
                  </div>
                </li>
              </ul>
            </div>
          </div>
          <span class="reply-main">Reply</span>
          <span>1 m</span>
        </div>
      </div>
    </div>
  
    <div class="comment-level-item"></div>
    `;
    createComment.innerHTML = html;
    displayMainComment.prepend(createComment);
    countCommentEmoji = document.querySelectorAll(".count-comment-enmoji");
    listEmojiComment = document.querySelectorAll(".comment-item .tooltip  img");
    iconTextComment = document.querySelectorAll(".comment-item  .emoji>span");
    replyMainBtn = document.querySelectorAll(".main-comment-action >.reply-main");
    replyLevelBtn = document.querySelectorAll(".main-comment-action .reply-level");
    displaySendComment = document.querySelectorAll(".comment-level-item");
    likeComment = document.querySelectorAll(".comment-item .emoji span");
    clickEmojiComment();
    checkEmojiCount();
    noneDisplayEmoji();
    replyMain();
    postCountLeft = document.querySelectorAll(".post-count-left");
    mainCommentEmojiPopup = document.querySelectorAll(".main-display-comment-emoji");
    levelCommentEmojiPopup = document.querySelectorAll(".level-display-comment-emoji");
    value.value = "";
    deleteAndCreateEmoji();
    popupEmotion()
  }

  function loopLevelComment(levelSend) {

    levelSend.addEventListener("click", () => {
      let avatar = levelSend.parentNode.parentNode.querySelector(".user-avatar-send").src;
      let value = levelSend.parentNode.querySelector(".send-text-comment");
      let comment2Id = 0;
      let query = new QueryData("/status/createComment2");
      query.addParam("text", value.value.trim());
      query.addParam("id", levelSend.parentNode.parentNode.parentNode.id);
      query.addEvent("load", function () {
        comment2Id = this.response;
        renderLevelComment(levelSend, value, avatar, comment2Id);
      });


      query.send("POST");


    });

  }

  function renderLevelComment(level, value, avatar, comment2Id) {
    let displayLevelComment = level.parentNode.parentNode;
    let Box = displayLevelComment.querySelector(".send-comment-box");


    if (value.value.trim() === "") {
      return false;
    }
    let createComment = document.createElement("div");
    createComment.classList.add("comment-level");
    createComment.setAttribute("id", comment2Id)
    let html = `
   
    <img
      src="${avatar}"
      alt=""
      class="ava_cmt_rep avatar-level-comment"
    />
    <div class="comment-content-box">
      <div class="content-main-comment">
        <div class="comment-main-title">
          <a href="" class="main-user-name">Nguyễn Hoàng Khang</a>
        </div>
        <p>
          <span class="reply_user"></span> ${value.value.trim()}
        </p>
        <div class="display-comment-emoji level-display-comment-emoji">
          <ul>
            <li>
              <img src="/Javbook/assets/img/emoji/like.svg" alt="0" />
            </li>

            <li>
              <img src="/Javbook/assets/img/emoji/love.svg" alt="0" />
            </li>
          </ul>
          <p class="count-comment-enmoji">0</p>
        </div>
      </div>
      <div class="main-comment-action">
        <div class="emoji commnent-emoji">
          <span>Like</span>
          <div class="list-icon">
            <ul>
              <li>
                <div class="tooltip">
                  <img src="/Javbook/assets/img/emoji/like.svg" alt="" />
                  <span class="toolTipText">Like</span>
                </div>
              </li>

              <li>
                <div class="tooltip">
                  <img src="/Javbook/assets/img/emoji/love.svg" alt="" />
                  <span class="toolTipText tooltipIcon2"
                    >Love</span
                  >
                </div>
              </li>

              <li>
                <div class="tooltip">
                  <img src="/Javbook/assets/img/emoji/care.svg" alt="" />
                  <span class="toolTipText tooltipIcon3"
                    >Care</span
                  >
                </div>
              </li>

              <li>
                <div class="tooltip">
                  <img src="/Javbook/assets/img/emoji/haha.svg" alt="" />
                  <span class="toolTipText tooltipIcon4"
                    >Haha</span
                  >
                </div>
              </li>

              <li>
                <div class="tooltip">
                  <img src="/Javbook/assets/img/emoji/sad.svg" alt="" />
                  <span class="toolTipText tooltipIcon5"
                    >Sad</span
                  >
                </div>
              </li>

              <li>
                <div class="tooltip">
                  <img src="/Javbook/assets/img/emoji/angry.svg" alt="" />
                  <span class="toolTipText tooltipIcon6"
                    >Angry</span
                  >
                </div>
              </li>
            </ul>
          </div>
        </div>
        <span class="reply-level">Reply</span>
        <span>1 m</span>
      </div>
    </div>
 
        `;
    createComment.innerHTML = html;
    Box.remove();
    displayLevelComment.appendChild(createComment);
    likeComment = document.querySelectorAll(".comment-item .emoji span");
    countCommentEmoji = document.querySelectorAll(".count-comment-enmoji");
    listEmojiComment = document.querySelectorAll(".comment-item .tooltip  img");
    iconTextComment = document.querySelectorAll(".comment-item  .emoji>span");
    replyMainBtn = document.querySelectorAll(".main-comment-action >.reply-main");
    replyLevelBtn = document.querySelectorAll(".main-comment-action .reply-level");
    displaySendComment = document.querySelectorAll(".comment-level-item");
    clickEmojiComment();
    checkEmojiCount();
    noneDisplayEmoji();
    replyLevel();
    deleteAndCreateEmoji();
    postCountLeft = document.querySelectorAll(".post-count-left");
    mainCommentEmojiPopup = document.querySelectorAll(".main-display-comment-emoji");
    levelCommentEmojiPopup = document.querySelectorAll(".level-display-comment-emoji");
    value.value = "";
    popupEmotion();
  }
  function noneDisplayEmoji() {
    let countDisplayEmojiPost = document.querySelectorAll(".post-count-left ul li img");
    let countDisplayEmojiComment = document.querySelectorAll(".display-comment-emoji ul li img");
    countDisplayEmojiPost.forEach((emoji, index) => {
      if (emoji.alt === '0') {
        emoji.style.display = "none";
      }
    });
    countDisplayEmojiComment.forEach((emoji, index) => {
      if (emoji.alt === '0') {
        emoji.style.display = "none";
      }
    });
    numberOfEmoji.forEach((numberOfEmoji, index) => {
      let emojiNumber = parseInt(numberOfEmoji.textContent);
      if (emojiNumber > 99) {
        document.querySelector(".count-emoji")[index].innerText = "99+";
      }
      if (emojiNumber === 0) {
        document.querySelectorAll(".post-count-left> ul")[index].style.display = "none";
        document.querySelectorAll(".post-count-left> p")[index].style.display = "none";


      }
    });
  }
  noneDisplayEmoji();

  function checkEmojiCount() {
    countCommentEmoji.forEach((emoji, index) => {
      let countEmoji = parseInt(emoji.textContent);
      if (countEmoji === 0) {
        emoji.style.display = "none";
        emoji.parentNode.style.display = "none";
      }
    });
    countShare.forEach((countShare, index) => {
      let sharenumber = parseInt(countShare.textContent);
      if (sharenumber === 0) {
        document.querySelectorAll(".post-count-right span .count-share")[index].parentNode.style.display = "none";

      }
      if (sharenumber > 99) {
        document.querySelectorAll(".post-count-right span .count-share")[index].innerText = "99+";

      }
    });

    countComment.forEach((countComment, index) => {
      countComment.innerText = contentMainComment[index].querySelectorAll(".content-main-comment").length;
      let commentNumber = parseInt(countComment.textContent);
      if (commentNumber === 0) {
        document.querySelectorAll(".post-count-right span .count-comment")[index].parentNode.style.display = "none";
      }
      if (commentNumber > 99) {
        document.querySelectorAll(".post-count-right span .count-comment")[index].innerText = "99+";
      }

    });

  }

  checkEmojiCount();

  closePopUp.onclick = () => {
    document.querySelector(".popup-post-box").style.display = "none";
  };
  saveEditBtn.onclick = () => {
    userContent[isUpdate].innerText = userEditContent.value;
    document.querySelector(".popup-post-box").style.display = "none";
    let query = new QueryData("/status/editStatus");
    query.addParam("text", userEditContent.value);
    query.addParam("mood", optionPostBox + 1);
    query.addParam("id", parentBox.id);
    query.send("POST");
    let stateBox = parentBox.querySelector(".post-state i");
    if (optionPostBox == 0) {
      stateBox.className = "fas fa-globe-asia"
    }
    if (optionPostBox == 1) {
      stateBox.className = "fas fa-user-friends"
    }
    if (optionPostBox == 2) {
      stateBox.className = "fas fa-lock"

    }
  };


  editPost.forEach((edit, index) => {
    edit.onclick = () => {
      parentBox = edit.parentNode.parentNode.parentNode.parentNode.parentNode.parentNode;
      let state = document.querySelector(".post-state i");
      if (state.className.includes("globe")) {
        selectPostBox.value = selectPostBox.options[0].value;
      }
      if (state.className.includes("friends")) {
        selectPostBox.value = selectPostBox.options[1].value;
      }
      if (state.className.includes("lock")) {
        selectPostBox.value = selectPostBox.options[2].value;
      }
      document.querySelector(".popup-post-box").style.display = "flex";
      userEditAvatar.src = userAvatar[index].src;
      userEditContent.value = userContent[index].textContent;
      userEditImage.src = userImage[index].src;
      frameImg.style.width = "auto";
      frameImg.style.height = "auto";

      isUpdate = index;


    };
  });
  function replyMain() {
    replyMainBtn.forEach((btn, index) => {
      btn.onclick = () => {
        let user = btn.parentNode.parentNode.parentNode.querySelector(".main-user-name").textContent;
        if (displaySendComment[index].querySelector(".send-comment-box") === null) {
          let sendComment = document.createElement("div");
          sendComment.classList.add("send-comment-box");
          let html = `<img
                    src = "${userAvatar[index].src}"
                    alt = ""
                    class="ava_cmt user-avatar-send"
                        />
                  <textarea
                    name="send=comment"
                    class="send-text-comment"
                    placeholder="Write a comment…"
                  ></textarea>
                  <button class="send-comment level-send">
                    <i class="fas fa-paper-plane"></i>
                  </button>`;

          sendComment.innerHTML = html;
          displaySendComment[index].appendChild(sendComment);

          levelSend = document.querySelector(".level-send");
          loopLevelComment(levelSend);
        }
      };

    });
  }
  replyMain();
  function replyLevel() {

    replyLevelBtn.forEach((btn, index) => {

      let parentNode = btn.parentNode.parentNode.parentNode.parentNode;
      let parentBox = btn.parentNode.parentNode.parentNode.parentNode.parentNode.parentNode.parentNode.parentNode.parentNode;

      btn.onclick = () => {
        if (parentNode.querySelector(".send-comment-box") === null) {

          let sendComment = document.createElement("div");
          sendComment.classList.add("send-comment-box");
          let html = `<img
                   src = "${parentBox.querySelector(".user-avatar-send").src}"
                   alt = ""
                   class="ava_cmt user-avatar-send"
                       />
                 <textarea
                   name="send=comment"
                   class="send-text-comment"
                   placeholder="Write a comment…"
                 ></textarea>
                 <button class="send-comment level-send">
                   <i class="fas fa-paper-plane"></i>
                 </button>`;

          sendComment.innerHTML = html;
          parentNode.appendChild(sendComment);
          levelSend = document.querySelector(".level-send");
          loopLevelComment(levelSend);


        }
      };
    });
  }
  replyLevel();
  listEmoji.forEach((emoji, indexList) => {

    emoji.onclick = () => {
      let index = Math.floor(indexList / 6);
      let query = new QueryData("/emotion/createStatusEmoji");
      let postBox = emoji.parentNode.parentNode.parentNode.parentNode.parentNode.parentNode.parentNode.parentNode;
      query.addParam("id", postBox.id);
      query.addParam("emoji", (indexList % 6) + 1)
      postReaction(emojiPost[index], iconText[index], iconText[index], postBox, "create", indexList);
      query.send("POST");

    };
  });
  function postReaction(image, text, color, postBox, type, indexList) {
    let query = new QueryData("/status/getTopStatusEmoji");
    let count = postBox.querySelector(".count-emoji");
    let imgStatus = postBox.querySelectorAll(".post-count-left img")
    let string = "";
    let list = null;
    query.addParam("id", postBox.id);
    query.addEvent("load", function () {
      string = this.response;
      string = string.replace("[", "")
      list = string.replace("]", "")
      list = list.split(",")
      count.innerText = list[0];
      if (list[1] !== undefined) {
        imgStatus[0].src = `/Javbook/assets/img/emoji/${list[1].trim()}`
      }
      if (list[2] !== undefined) {
        imgStatus[1].src = `/Javbook/assets/img/emoji/${list[2].trim()}`
      }
      if (type == "create") {
        image.src = `/Javbook/assets/img/emoji/${icon[indexList % 6]}.svg`;
        text.innerText = nameIcon[indexList % 6];
        color.style.color = iconTextColor[indexList % 6];
        postBox.querySelector(".post-count-left ul ").style.display = "flex"
        postBox.querySelector(".post-count-left ul li").style.display = "block"
        postBox.querySelector(".post-count-left ul img").style.display = "block"
        postBox.querySelector(".post-count-left p").style.display = "block"
      } else {
        image.src = "/Javbook/assets/img/emoji/unlike.png";
        text.innerText = nameIcon[0];
        color.style.color = "";
        if (parseInt(list[0]) == 0) {
          postBox.querySelector(".post-count-left ul ").style.display = "none"
          postBox.querySelector(".post-count-left ul li").style.display = "none"
          postBox.querySelector(".post-count-left ul img").style.display = "none"
          postBox.querySelector(".post-count-left p").style.display = "none"
        }
      }

    })

    query.send("GET");
  }
  function clickEmojiComment() {
    listEmojiComment.forEach((emoji, indexList) => {
      emoji.onclick = () => {
        let index = Math.floor(indexList / 6);
        let commentBox = emoji.parentNode.parentNode.parentNode.parentNode.parentNode.parentNode.parentNode;
        let img = commentBox.querySelector(".display-comment-emoji li img");
        let mainComment = emoji.parentNode.parentNode.parentNode.parentNode.parentNode.parentNode.parentNode.parentNode.parentNode;
        let levelComment = emoji.parentNode.parentNode.parentNode.parentNode.parentNode.parentNode.parentNode.parentNode;
        if (mainComment.className.includes("main-comment")) {
          let uploadData = new QueryData("/emotion/createCommentEmoji");
          uploadData.addParam("id", mainComment.id);
          uploadData.addParam("emoji", (indexList % 6) + 1);
          uploadData.send("POST");
          commentReaction(iconTextComment[index], iconTextComment[index], indexList, img, mainComment, "create");
        }
        if (levelComment.className.includes("comment-level")) {
          let uploadData2 = new QueryData("/emotion/createComment2Emoji");
          uploadData2.addParam("id", levelComment.id);
          uploadData2.addParam("emoji", (indexList % 6) + 1);
          uploadData2.send("POST")
          commentReaction(iconTextComment[index], iconTextComment[index], indexList, img, levelComment, "create");
        }

      };
    });
  }
  clickEmojiComment();
  function commentReaction(name, color, indexList, like, content, type) {
    if (content.className.includes("main-comment")) {
      let uploadData = new QueryData("/status/getTopCommentEmoji");
      uploadData.addParam("id", content.id);
      let count = content.querySelector(".count-comment-enmoji");
      let img = content.querySelectorAll(".comment-user .main-display-comment-emoji img")
      uploadData.addEvent("load", function () {
        string = this.response;
        string = string.replace("[", "")
        list = string.replace("]", "")
        list = list.split(",")
        count.innerText = list[0];
        if (list[1] !== undefined) {
          img[0].src = `/Javbook/assets/img/emoji/${list[1].trim()}`
        }
        if (list[2] !== undefined) {
          img[1].src = `/Javbook/assets/img/emoji/${list[2].trim()}`
        }
        if (type == "create") {
          name.innerText = nameIcon[indexList % 6];
          console.log(indexList)
          color.style.color = iconTextColor[indexList % 6];
          content.querySelector(".comment-user .main-display-comment-emoji").style.display = "flex"
          content.querySelector(".comment-user .main-display-comment-emoji img").style.display = "block"
          content.querySelector(".comment-user .main-display-comment-emoji p").style.display = "block"
        } else {
          like.style.color = "rgb(204, 200, 219)";
          like.innerText = "Like"
          if (parseInt(list[0]) == 0) {
            content.querySelector(".comment-user .main-display-comment-emoji").style.display = "none"
            content.querySelector(".comment-user .main-display-comment-emoji img").style.display = "none"
            content.querySelector(".comment-user .main-display-comment-emoji p").style.display = "none"
          }
        }
      })
      uploadData.send("GET")


    }
    if (content.className.includes("comment-level")) {
      let uploadData2 = new QueryData("/status/getTopComment2Emoji");
      uploadData2.addParam("id", content.id);
      let count = content.querySelector(".count-comment-enmoji");
      let img = content.querySelectorAll(".level-display-comment-emoji img")
      uploadData2.addEvent("load", function () {
        string = this.response;
        string = string.replace("[", "")
        list = string.replace("]", "")
        list = list.split(",")
        count.innerText = list[0];
        if (list[1] !== undefined) {
          img[0].src = `/Javbook/assets/img/emoji/${list[1].trim()}`
        }
        if (list[2] !== undefined) {
          img[1].src = `/Javbook/assets/img/emoji/${list[2].trim()}`
        }
        if (type == "create") {
          name.innerText = nameIcon[indexList % 6];
          color.style.color = iconTextColor[indexList % 6];
          content.querySelector(".level-display-comment-emoji").style.display = "flex"
          content.querySelector(".level-display-comment-emoji img").style.display = "block"
          content.querySelector(".level-display-comment-emoji p").style.display = "block"
        } else {
          like.style.color = "rgb(204, 200, 219)";
          like.innerText = "Like"
          if (parseInt(list[0]) == 0) {
            content.querySelector(".level-display-comment-emoji").style.display = "none"
            content.querySelector(".level-display-comment-emoji img").style.display = "none"
            content.querySelector(".level-display-comment-emoji p").style.display = "none"
          }
        }
      })
      uploadData2.send("GET")

    }

  }
  iconText.forEach((like, index) => {

    like.onclick = () => {
      let query = new QueryData("/emotion/createStatusEmoji");
      let postBox = like.parentNode.parentNode.parentNode.parentNode;
      query.addParam("id", postBox.id);
      if (!emojiPost[index].src.includes("unlike.png")) {
        let query2 = new QueryData("/emotion/deleteStatusEmoji");
        query2.addParam("id", postBox.id);
        query2.send("POST")

        postReaction(emojiPost[index], like, like, postBox, "delete", 0);

      } else {
        query.addParam("emoji", 1);
        query.send("POST")
        let postBox = like.parentNode.parentNode.parentNode.parentNode;
        postReaction(emojiPost[index], like, like, postBox, "create", 0);

      }
    };
  });

  function deleteAndCreateEmoji() {
    likeComment.forEach((like, index) => {
      like.onclick = () => {

        let displayEmojiLocation = like.parentNode.parentNode.parentNode.querySelector(".display-comment-emoji");
        let mainComment = like.parentNode.parentNode.parentNode.parentNode.parentNode;
        let levelComment = like.parentNode.parentNode.parentNode.parentNode;
        if (window.getComputedStyle(like).getPropertyValue("color") === "rgb(204, 200, 219)") {

          if (mainComment.className.includes("main-comment")) {
            let uploadData = new QueryData("/emotion/createCommentEmoji");
            uploadData.addParam("id", mainComment.id);
            uploadData.addParam("emoji", 1);
            uploadData.send("POST");
            commentReaction(like, like, 0, like, mainComment, "create")

          }
          if (levelComment.className.includes("comment-level")) {
            let uploadData2 = new QueryData("/emotion/createComment2Emoji");
            uploadData2.addParam("id", levelComment.id);
            uploadData2.addParam("emoji", 1);
            uploadData2.send("POST")
            commentReaction(like, like, 0, like, levelComment, "create")
          }
        } else {
          if (mainComment.className.includes("main-comment")) {
            let uploadData = new QueryData("/emotion/deleteCommentEmoji");
            uploadData.addParam("id", mainComment.id);
            uploadData.send("POST")
            commentReaction(0, 0, 0, like, mainComment, "delete")
          }
          if (levelComment.className.includes("comment-level")) {
            let uploadData2 = new QueryData("/emotion/deleteComment2Emoji");
            uploadData2.addParam("id", levelComment.id);
            uploadData2.send("POST")
            commentReaction(0, 0, 0, like, levelComment, "delete")
          }

        }
      };
    });
  }
  commentBTn.onclick = () => {
    commentBox.style.display = 'block';
  };
  deleteAndCreateEmoji()

  function popupEmotion() {

    postCountLeft.forEach((emoji) => {
      emoji.onclick = () => {
        let statusID = emoji.parentNode.parentNode.id;
        displayPopupEmoji(statusID, "status");

      }
    })
    mainCommentEmojiPopup.forEach((comment) => {
      comment.onclick = () => {
        let commentId = comment.parentNode.parentNode.parentNode.parentNode;
        displayPopupEmoji(commentId.id, "comment")

      }
    })
    levelCommentEmojiPopup.forEach((comment) => {
      comment.onclick = () => {
        let comment2Id = comment.parentNode.parentNode.parentNode;
        displayPopupEmoji(comment2Id.id, "comment2")
      }
    })
  }

  popupEmotion();
  function displayPopupEmoji(value, type) {
    let uploadData = new QueryData("/emotion/renderPopup");

    uploadData.addParam("id", value);
    uploadData.addParam("type", type);
    uploadData.addEvent("load", function () {
      document.querySelector(".popup-emoji-box").innerHTML = this.response;
      document.querySelector(".popup-emoji").style.display = "block";
      popupEmoji();
    })
    uploadData.send("GET");
  }

}
postBox();