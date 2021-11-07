const inputFileCover = document.querySelector("#header-photo-file");
const displayPhotoCover = document.querySelector(".profile-cover");
const inputFileAvatar = document.querySelector("#header-avatar-file");
const displayPhotoAvatar = document.querySelector(".profile-img");
const profileMenu = document.querySelectorAll(".profile-menu-link");
const timeLine = document.querySelector(".timeline");
const tabMenu = ["Post", "About", "Friends", "Photo"];
let listOldJS = [];

function profileTabChange(index) {
    let query = new QueryData("/profile/changeItem");
    query.addParam("key", tabMenu[index]);
    query.addParam("id", timeLine.id);
    let query2 = new QueryData("/profile/changeJs", "json");
    query2.addParam("key", tabMenu[index]);
    let path = `/Javbook/assets/js/profile/${tabMenu[index]}`;
    query.addEvent("load", function () {
        timeLine.innerHTML = this.response;
        query2.addEvent("load", function () {
            this.response.forEach((response) => {
                let script = document.createElement("script");
                script.src = `${path}/${response}`;
                document.body.appendChild(script);
                listOldJS.push(script);
            });
        });
        query2.send("GET");
    });
    query.send("GET");
    document.querySelector(".active").classList.remove("active");
    profileMenu[index].classList.add("active");
}

profileMenu.forEach((item, index) => {
    item.onclick = () => {
        listOldJS.forEach((script) => script.remove());
        listOldJS = [];
        profileTabChange(index);
        window.history.replaceState(
            null,
            "",
            `${index ? tabMenu[index] : "."}`
        );
    };
});

if (inputFileCover != null) {
    inputFileCover.addEventListener("change", () => {
        // Call API
        let name = "cover" + Date.now() + ".png";
        let urlImg = "/Javbook/assets/img/cover/" + name;

        let query = new QueryUpload("upload/image");
        query.addParam("file", inputFileCover.files[0]);
        query.addParam("savePath", "cover");
        query.addParam("fileName", name);

        query.addEvent("progress", function (e) {
            let percent = (e.loaded / e.total) * 100;
            console.log("upload process: " + Math.floor(percent) + "%");
        });

        query.addEvent("load", function () {
            let query2 = new QueryData("profileUserAbout/updateCoverImg");
            query2.addParam("urlImg", urlImg);
            query2.addParam("oldUrlImg", displayPhotoCover.src);

            query2.addEvent("load", function () {
                let result = this.response;

                if (result == "success") {
                    // maybe do something in a future
                } else {
                    urlImg = result;
                }
                window.setTimeout(() => {
                    displayPhotoCover.src = urlImg;
                }, 3000);
            });

            query2.send("POST");
        });

        query.send();
    });
}

if (inputFileAvatar != null) {
    inputFileAvatar.addEventListener("change", () => {
        // Call API
        let name = "avatar" + Date.now() + ".png";
        let urlImg = "/Javbook/assets/img/avatar/" + name;

        let query = new QueryUpload("upload/image");
        query.addParam("file", inputFileAvatar.files[0]);
        query.addParam("savePath", "avatar");
        query.addParam("fileName", name);

        query.addEvent("progress", function (e) {
            let percent = (e.loaded / e.total) * 100;
            console.log("upload process: " + Math.floor(percent) + "%");
        });

        query.addEvent("load", function () {
            let query2 = new QueryData("profileUserAbout/updateAvatar");
            query2.addParam("urlImg", urlImg);
            query2.addParam("oldUrlImg", displayPhotoAvatar.src);

            query2.addEvent("load", function () {
                let result = this.response;

                if (result == "success") {
                    // maybe do something in a future
                } else {
                    urlImg = result;
                }

                window.setTimeout(() => {
                    let oldImg = displayPhotoAvatar.src;
                    displayPhotoAvatar.src = urlImg;
                    // Replace all img
                    let imgs = document.querySelectorAll("img");
                    imgs.forEach((img) => {
                        if (img.src === oldImg) {
                            img.src = urlImg;
                        }
                    });
                }, 3000);
            });

            query2.send("POST");
        });

        query.send();
    });
}

// Canh

let addFriendBtn = document.querySelector(".js-add-friend-btn");

if (addFriendBtn != null) {
    addFriendBtn.addEventListener("click", function (e) {
        console.log("hihi");
        let icon = addFriendBtn.querySelector("i");
        let title = addFriendBtn.querySelector("span");
        let userID = addFriendBtn.dataset.id;
        let index = addFriendBtn.dataset.index;

        let query = new QueryData("friend/friendRequest");
        query.addParam("receiverID", userID);
        query.addParam("index", index);
        query.addEvent("load", function () {
            let result = this.response;
            if (result == "success") {
                // they are friends
                if (index == 2) {
                    addFriendBtn.dataset.index = -2;
                    title.innerHTML = "Add Friend";
                    // delete friend
                    icon.classList.remove("fa-user-check");
                    icon.classList.add("fa-user-plus");
                } else if (index == 1) {
                    addFriendBtn.dataset.index = -2;
                    title.innerHTML = "Add Friend";
                    // delete invitations sent to others
                    icon.classList.remove("fa-user-times");
                    icon.classList.add("fa-user-plus");
                } else if (index == -1) {
                    addFriendBtn.dataset.index = 2;
                    title.innerHTML = "Friends";
                    // accept invitations of others
                    icon.classList.remove("fa-user-clock");
                    icon.classList.add("fa-user-check");
                } else if (index == -2) {
                    addFriendBtn.dataset.index = 1;
                    title.innerHTML = "Waiting";
                    // send invitation to others
                    icon.classList.remove("fa-user-plus");
                    icon.classList.add("fa-user-times");
                }
            } else {
                // maybe do something in the future
                // if request friend fails
            }
        });
        query.send("POST");
    });
}

{
    let map = {};
    tabMenu.forEach((val, idx) => {
        map[val] = idx;
    });
    let page = window.location.pathname.split("/");
    page = page[page.length - 1];
    if (map[page] == undefined) page = "Post";
    profileTabChange(map[page]);
}
