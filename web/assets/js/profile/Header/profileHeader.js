const inputFileCover = document.querySelector('#header-photo-file');
const displayPhotoCover = document.querySelector(".profile-cover");
const inputFileAvatar = document.querySelector('#header-avatar-file');
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
            })

        });
        query2.send("GET");
    });
    query.send("GET");
    document.querySelector('.active').classList.remove("active");
    profileMenu[index].classList.add("active");
}

profileMenu.forEach((item, index) => {
    item.onclick = () => {
        listOldJS.forEach(script => script.remove());
        listOldJS = [];
        profileTabChange(index);
        window.history.replaceState(null, "", `${tabMenu[index]}`);
    }
})
inputFileCover.addEventListener("change", () => {
    var oFReader = new FileReader();
    oFReader.readAsDataURL(inputFileCover.files[0]);
    oFReader.onload = (oFREvent) => {
        displayPhotoCover.src = oFREvent.target.result;
    };

}
);
inputFileAvatar.addEventListener("change", () => {
    var oFReader = new FileReader();
    oFReader.readAsDataURL(inputFileAvatar.files[0]);
    oFReader.onload = (oFREvent) => {
        displayPhotoAvatar.src = oFREvent.target.result;
    };

}
);

{
    let map = {};
    tabMenu.forEach((val, idx) => {map[val] = idx;});
    let params = new URLSearchParams(window.location.search);
    let tabPage = "Post";
    if (params.has("page")) {
        let page = params.get("page");
        if (map[page] != undefined) tabPage = page;
    }
    profileTabChange(map[tabPage]);
}