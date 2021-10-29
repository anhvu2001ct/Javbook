const postActionBox = document.querySelectorAll(".post-action");
const listEmoji = document.querySelectorAll(".post-action .tooltip  img");
const iconText = document.querySelectorAll(".post-action .emoji p");
const emojiPost = document.querySelectorAll(".post-action .icon-status");
const listEmojiComment = document.querySelectorAll(".comment-item .tooltip  img")
const iconTextComment = document.querySelectorAll(".comment-item  .emoji>span");
const likePost = document.querySelectorAll(".post-action .emoji");
const likeComment = document.querySelectorAll(".comment-item .emoji span");
const icon = ["like", "love", "care", "haha", "sad", "angry"];
const nameIcon = ["Like", "Love", "Care", "Haha", "Sad", "Angry"];
const iconTextColor = ["#2078f4", "#f33e58", "#f7b125", "#f7b125", "#f7b125", "#e9710f"];
const commentText = document.querySelector(".send-text-comment");
const commentBox = document.querySelector(".comment");
const commentBTn = document.querySelector(".comment-status");
const replyMainBtn = document.querySelectorAll(".main-comment-action >.reply-main");
const replyLevelBtn = document.querySelectorAll(".main-comment-action .reply-level");
const displaySendComment = document.querySelectorAll(".comment-level-item");
const editPost = document.querySelectorAll(".edit-post-item .edit");
const closePopUp = document.querySelector(".close");
const userAvatar = document.querySelectorAll(".status-main .status-img");
const userContent = document.querySelectorAll(".post-content .content");
const userImage = document.querySelectorAll(".post-photos .post-photo");
const userEditAvatar = document.querySelector(".post_popup .wh_40 img");
const userEditContent = document.querySelector(".status_content  .enter");
const userEditImage = document.querySelector(".display-img #status-img");
const frameImg = document.querySelector(".display-img");
const saveEditBtn = document.querySelector(".pop_ele3 .share");
// const is

let isUpdate;
let numberOfEmoji = parseInt(document.querySelector(".count-emoji").textContent)
let countComment = parseInt(document.querySelectorAll(".post-count-right span p")[0].textContent)
let countShare = parseInt(document.querySelectorAll(".post-count-right span p")[1].textContent)
function checkEmojiCount() {

    if (countShare == 0) {
        document.querySelectorAll(".post-count-right span")[1].style.display = "none";

    } if (countShare > 99) {
        document.querySelectorAll(".post-count-right span p")[1].innerText = "99+";

    }
    if (countComment == 0) {
        document.querySelectorAll(".post-count-right span")[0].style.display = "none";
    }
    if (countComment > 99) {
        document.querySelectorAll(".post-count-right span p")[0].innerText = "99+";
    }
    if (numberOfEmoji > 99) {
        document.querySelector(".count-emoji").innerText = "99+";
    }
    if (numberOfEmoji == 0) {
        document.querySelector(".post-count-left> ul").style.display = "none"
        document.querySelector(".post-count-left> p").style.display = "none"


    }
}

checkEmojiCount();

saveEditBtn.onclick = () => {
    userContent[isUpdate].innerText = userEditContent.value;
    document.querySelector(".popup_model").style.display = "none";
}

closePopUp.addEventListener("click", function () {
    document.querySelector(".popup_model").style.display = "none";
});
editPost.forEach((edit, index) => {
    edit.onclick = () => {
        document.querySelector(".popup_model").style.display = "flex";
        userEditAvatar.src = userAvatar[index].src;
        userEditContent.value = userContent[index].textContent;
        userEditImage.src = userImage[index].src;
        frameImg.style.width = "auto";
        frameImg.style.height = "auto";
        isUpdate = index;
    }
})
replyMainBtn.forEach((btn, index) => {
    btn.onclick = () => {
        let user = btn.parentNode.parentNode.parentNode.querySelector(".main-user-name").textContent;
        if (displaySendComment[index].querySelector(".send-comment-box") == null) {
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
              <button class="send-comment">
                <i class="fas fa-paper-plane"></i>
              </button>`

            sendComment.innerHTML = html;
            displaySendComment[index].appendChild(sendComment);
        }
    }

});
replyLevelBtn.forEach((btn, index) => {
    let parentNode = btn.parentNode.parentNode.parentNode.parentNode;
    let parentBox = btn.parentNode.parentNode.parentNode.parentNode.parentNode.parentNode.parentNode.parentNode.parentNode;
    let avatar = parentBox.querySelector(".status-img");
    // console.log(avatar)
    btn.onclick = () => {
        if (parentNode.querySelector(".send-comment-box") == null) {

            let sendComment = document.createElement("div");
            sendComment.classList.add("send-comment-box");
            let html = `<img
               src = "${avatar.src}"
               alt = ""
               class="ava_cmt user-avatar-send"
                   />
             <textarea
               name="send=comment"
               class="send-text-comment"
               placeholder="Write a comment…"
             ></textarea>
             <button class="send-comment">
               <i class="fas fa-paper-plane"></i>
             </button>`

            sendComment.innerHTML = html;
            parentNode.appendChild(sendComment);
        }
    }
})
listEmoji.forEach((emoji, indexList) => {
    emoji.onclick = () => {
        let index = Math.floor(indexList / 6);
        emojiPost[index].src = `./assets/Emoji/${icon[indexList % 6]}.svg`;
        iconText[index].innerText = nameIcon[indexList % 6];
        iconText[index].style.color = iconTextColor[indexList % 6]
        const img = document.querySelectorAll(".post-count-left > ul > li img");
        if (numberOfEmoji == 0) {
            document.querySelector(".post-count-left> ul").style.display = "flex"
            document.querySelector(".post-count-left> p").style.display = "block"

            img[0].src = `./assets/Emoji/${icon[indexList % 6]}.svg`;
            for (let i = 1; i < img.length; i++) {
                img[i].style.display = "none"
            }
            document.querySelectorAll(".post-count-left > ul > li")[0].style.display = "block"
            document.querySelector(".count-emoji").innerText = "Nguyễn Hoàng Khang";
        }
        if (numberOfEmoji == 1) {
            document.querySelector(".count-emoji").innerText = `You and Nguyễn Anh Vũ `;
        }
        if (numberOfEmoji != 0 && numberOfEmoji != 1  ) {
            document.querySelector(".count-emoji").innerText = `You and ${numberOfEmoji} others`;
        }
    }
});
listEmojiComment.forEach((emoji, indexList) => {
    emoji.onclick = () => {
        let index = Math.floor(indexList / 6);
        iconTextComment[index].innerText = nameIcon[indexList % 6];
        iconTextComment[index].style.color = iconTextColor[indexList % 6]
    }
});
iconText.forEach((like, index) => {
    like.onclick = () => {

        if (!emojiPost[index].src.includes("unlike.png")) {
            emojiPost[index].src = "./assets/Emoji/unlike.png";
            like.innerText = nameIcon[0];
            like.style.color = ""
        } else {
            emojiPost[index].src = `./assets/Emoji/${icon[0]}.svg`;
            like.innerText = nameIcon[0];
            like.style.color = iconTextColor[0]
        }
    }
});

likeComment.forEach((like, index) => {
    like.onclick = () => {
        if (window.getComputedStyle(like).getPropertyValue("color") == "rgb(204, 200, 219)") {

            like.style.color = iconTextColor[0];
        } else {
            like.style.color = "rgb(204, 200, 219)"
        }
    }
})

commentBTn.onclick = () => {
    commentBox.style.display = 'block';
}