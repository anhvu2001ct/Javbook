$(document).on("click", ".header_icon", function () {
  if ($(this).hasClass("active")) {
    $(this).removeClass("active");
    $(".popup_container").hide();
  } else {
    $(this).addClass("active").siblings().removeClass("active");
    $(".popup_container").show();
  }
});

function countNumber() {
  let mess = $(".mess_active").length < 100 ? $(".mess_active").length : "99+";
  let friend = $(".friend").length < 100 ? $(".friend").length : "99+";
  let notifi =
    $(".notifi_active").length < 100 ? $(".notifi_active").length : "99+";

  $(".nummess").text(mess);
  $(".numfriend").text(friend);
  $(".numnotifi").text(notifi);
}

let header_icon = document.querySelectorAll(".header_icon");
let popup_mess = document.querySelector(".popup_mess");

header_icon.forEach((ele, index) => {
  ele.addEventListener("click", () => {
    if (index === 0) {
      popup_mess.innerHTML = "Messages";
      $(".message").show();
      $(".friend").hide();
      $(".notification").hide();
    }
    if (index === 1) {
      popup_mess.innerHTML = "Friend request";
      $(".message").hide();
      $(".friend").show();
      $(".notification").hide();
    }
    if (index === 2) {
      popup_mess.innerHTML = "Notifications";
      $(".message").hide();
      $(".friend").hide();
      $(".notification").show();
    }
  });
});

let notification = document.querySelectorAll(".notification");
let notification_time = document.querySelectorAll(".notification_time");
let numnotifi = document.querySelector(".numnotifi");

let message = document.querySelectorAll(".message");
let message_text = document.querySelectorAll(".message_text");
let nummess = document.querySelector(".nummess");

let accept = document.querySelectorAll(".accept");
let reject = document.querySelectorAll(".rejeinfo");
let numfriend = document.querySelector(".numfriend");

function loadheader() {
  // load lại notification
  notification = document.querySelectorAll(".notification");
  notification_time = document.querySelectorAll(".notification_time");
  numnotifi = document.querySelector(".numnotifi");
  notification.forEach((element, index) => {
    element.addEventListener("click", () => {
      element.style.color = "#ccc8db";
      notification_time[index].style.color = "#ccc8db";
      if (element.className.includes("notifi_active")) {
        numnotifi.innerText = parseInt(numnotifi.textContent) - 1;
      }
      element.classList.remove("notifi_active");
    });
  });
  // load lại message
  message = document.querySelectorAll(".message");
  message_text = document.querySelectorAll(".message_text");
  nummess = document.querySelector(".nummess");

  message.forEach((element, index) => {
    element.addEventListener("click", () => {
      message_text[index].style.color = "#ccc8db";
      if (element.className.includes("mess_active")) {
        nummess.innerText = parseInt(nummess.textContent) - 1;
      }
      element.classList.remove("mess_active");
    });
  });
  // load lại friendRequest
  accept = document.querySelectorAll(".accept");
  reject = document.querySelectorAll(".rejeinfo");
  numfriend = document.querySelector(".numfriend");
  accept.forEach((ele) => {
    ele.onclick = () => {
      numfriend.innerText = parseInt(numfriend.textContent) - 1;
      ele.parentNode.parentNode.parentNode.remove();
    };
  });
  reject.forEach((ele) => {
    ele.onclick = () => {
      numfriend.innerText = parseInt(numfriend.textContent) - 1;
      ele.parentNode.parentNode.parentNode.remove();
    };
  });

  countNumber();
}
loadheader();

// render function
// render message child
function renderMessage({ username = "", image = "", text = "", link = "" }) {
  let main = document.getElementById("popup_inner");
  if (main) {
    let message = document.createElement("div");
    message.classList.add("popup_item", "message", "mess_active");
    message.innerHTML = `
    <a class="popup_item_img wh_40 message_logo" href="${link}"
      ><img
        src="${image}"
        alt=""
        class="scale wh_40 circle"
      />
    </a>
    <div class="popup_item_info message_content">
      <span class="message_user"><strong>${username}</strong></span>
      <span class="message_cp">
        <span class="message_text"
          ><strong>${username}:</strong>${text}</span
        >
      </span>
    </div>
    `;
    main.appendChild(message);
  }
  loadheader();
}

// render friend request
function renderFriendRequest({ image = "", username = "", link = "" }) {
  let main = document.getElementById("popup_inner");
  if (main) {
    let friendRequest = document.createElement("div");
    friendRequest.classList.add("popup_item", "flex", "flex_ac", "friend");
    friendRequest.innerHTML = `
            <a class="popup_item_img wh_40" href="${link}"
              ><img
                src="${image}"
                alt=""
                class="scale wh_40 circle"
            /></a>
            <div class="popup_item_info">
              <a class="popup_item_info_name" href="${link}"
                ><strong>${username}</strong>
              </a>
              <div class="popup_item_info_confirm flex">
                <button class="button accept">Accept</button>
                <button class="button rejeinfo">Reject</button>
              </div>
            </div>
    `;
    main.appendChild(friendRequest);
  }
  loadheader();
}

// render notification
function renderNotification({
  image = "",
  username = "",
  link = "",
  text = "",
  time = "",
}) {
  let main = document.getElementById("popup_inner");
  if (main) {
    let notification = document.createElement("div");
    notification.classList.add("popup_item", "notification", "notifi_active");
    notification.innerHTML = `
  <a class="popup_item_img wh_40 notification_logo" href="${link}"
    ><img
      src="${image}"
      alt=""
      class="scale wh_40 circle"
    />
    <span class="notification_icon">
      <i class="fas fa-comment-alt"></i>
    </span>
  </a>
  <div class="popup_item_info notification_content">
    <span class="notification_text"
      ><strong>${username}</strong> ${text}</span
    >
    <span class="notification_time">about ${time} ago</span>
  </div>
  `;
    main.appendChild(notification);
  }
  loadheader();
}
