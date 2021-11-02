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

inputFileCover.addEventListener("change", () => {
    // Call API
    let name = "user" + Date.now() + ".png";
    let urlImg = "/Javbook/assets/img/user/" + name;

    let query = new QueryUpload("upload/image");
    query.addParam("file", inputFileCover.files[0]);
    query.addParam("savePath", name);

    query.addEvent("progress", function (e) {
        let percent = (e.loaded / e.total) * 100;
        console.log("upload process: " + Math.floor(percent) + "%");
    });

    query.addEvent("load", function () {
        let query2 = new QueryData("profileUserAbout/updateCoverImg");
        query2.addParam("urlImg", urlImg);

        query2.addEvent("load", function () {
            let result = this.response;

            if (result == "success") {
                // maybe do something in a future
            } else {
                urlImg = result;
            }
            window.setTimeout(() => {
                displayPhotoCover.src = urlImg;
            }, 2000);
        });

        query2.send("POST");
    });

    query.send();
});

inputFileAvatar.addEventListener("change", () => {
    // Call API
    let name = "user" + Date.now() + ".png";
    let urlImg = "/Javbook/assets/img/user/" + name;

    let query = new QueryUpload("upload/image");
    query.addParam("file", inputFileAvatar.files[0]);
    query.addParam("savePath", name);

    query.addEvent("progress", function (e) {
        let percent = (e.loaded / e.total) * 100;
        console.log("upload process: " + Math.floor(percent) + "%");
    });

    query.addEvent("load", function () {
        let query2 = new QueryData("profileUserAbout/updateAvatar");
        query2.addParam("urlImg", urlImg);

        query2.addEvent("load", function () {
            let result = this.response;

            if (result == "success") {
                // maybe do something in a future
            } else {
                urlImg = result;
            }
            window.setTimeout(() => {
                displayPhotoAvatar.src = urlImg;
                window.location.reload();
            }, 2000);
        });

        query2.send("POST");
    });

    query.send();
});

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
