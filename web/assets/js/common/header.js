
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
    let mess =
            $(".mess_active").length < 100 ? $(".mess_active").length : "99+";
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
            let query = new QueryData("/notification/isSeenNotification");
            query.addParam("notificationid", element.id);
            query.send("POST");

            element.classList.add("seen");
            notification_time[index].classList.add("seen");
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
            message_text[index].classList.add("seen");
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
            let query = new QueryData("/notification/deleteFriendRequest");
            query.addParam("sender", ele.parentNode.parentNode.parentNode.id);
            query.send("POST");
            let query2 = new QueryData("/friend/insertFriend");
            query2.addParam("B", ele.parentNode.parentNode.parentNode.id);
            query2.send("POST");
            numfriend.innerText = parseInt(numfriend.textContent) - 1;
            ele.parentNode.parentNode.parentNode.remove();
        };
    });
    reject.forEach((ele) => {
        ele.onclick = () => {
            let query = new QueryData("/notification/deleteFriendRequest");
            query.addParam("sender", ele.parentNode.parentNode.parentNode.id);
            query.send("POST");
            numfriend.innerText = parseInt(numfriend.textContent) - 1;
            ele.parentNode.parentNode.parentNode.remove();
        };
    });

    countNumber();
}
loadheader();

//data

// Search Friend - Poi Minh Canh
let searchFriendBtn = document.querySelector(".search-btn");
let searchFriend = document.querySelector(".search-txt");

searchFriendBtn.addEventListener("click", function () {
    // console.log("ser", searchFriend.value);
    window.location = `/Javbook/searchFriend?name=${searchFriend.value}`;
});

// Ghi socket o day
let socket = new SocketConnector("test");
socket.addEvent("message", msg => {
    let data = JSON.parse(msg.data);
    console.log(msg.from , data);

});
