const listEmoji = document.querySelectorAll(".post-action .tooltip  img");
const iconText = document.querySelectorAll(".post-action .emoji p");
const emojiPost = document.querySelectorAll(".post-action .icon-status");
const listEmojiComment = document.querySelectorAll(".comment-item .tooltip  img")
const iconTextComment = document.querySelectorAll(".comment-item  .emoji>span");
const likeComment = document.querySelectorAll(".comment-item .emoji span");
const icon = ["like", "love", "care", "haha", "sad", "angry"];
const nameIcon = ["Like", "Love", "Care", "Haha", "Sad", "Angry"];
const iconTextColor = ["#2078f4", "#f33e58", "#f7b125", "#f7b125", "#f7b125", "#e9710f"];
const replyMainBtn = document.querySelectorAll(".main-comment-action >.reply-main");
const replyLevelBtn = document.querySelectorAll(".main-comment-action .reply-level");
const displaySendComment = document.querySelectorAll(".comment-level-item");
const editPost = document.querySelector(" .edit-post");
const contentBox = document.querySelector(".content-before");
const editBox = document.querySelector(".edit-content")
const userAvatar = document.querySelectorAll(".status-main .status-img");
const statusContent = document.querySelector(".content");
const editText = document.querySelector(".edit-text-content");
const cancelEdit = document.querySelector(".cancel-edit");
const saveContent= document.querySelector(".save-content");
console.log(editText);
editPost.onclick= () => {
    contentBox.style.display="none";
    editBox.style.display="block";
    editText.value = statusContent.innerText.trim();
}
cancelEdit.onclick = () => {
    contentBox.style.display="block";
    editBox.style.display="none";
}
saveContent.onclick = () => {
    contentBox.style.display="block";
    editBox.style.display="none";
    statusContent.innerText=editText.value;
}
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

