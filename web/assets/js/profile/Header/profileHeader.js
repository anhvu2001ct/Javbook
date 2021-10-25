const inputFileCover = document.querySelector('#header-photo-file');
const displayPhotoCover = document.querySelector(".profile-cover");
const inputFileAvatar = document.querySelector('#header-avatar-file');
const displayPhotoAvatar = document.querySelector(".profile-img");
const profileMenu = document.querySelectorAll(".profile-menu-link");
const timeLine = document.querySelector(".timeline");


profileMenu[3].onclick = () => {
    document.querySelector('.active').classList.remove("active");
    profileMenu[3].classList.add("active");
    let query = new QueryData("/profile/changeItem");
    query.addParam("key", "photo");
    query.addEvent("load", function () {
        timeLine.innerHTML = this.response;
        let query2 = new QueryData("/profile/changeJs", "json");
        query2.addParam("key", "photo");

        query2.addEvent("load", function () {
            let script = document.createElement("script");
            script.src = `/Javbook/assets/js/profile/${this.response[3]}`;
            document.body.appendChild(script);
        });
        query2.send("GET");
    });
    query.send("GET");

};
profileMenu[0].onclick = () => {
    document.querySelector('.active').classList.remove("active");
    profileMenu[3].classList.add("active");
    let query = new QueryData("/profile/changeItem");
    query.addParam("key", "post");
    query.addEvent("load", function () {
        timeLine.innerHTML = this.response;
        let query2 = new QueryData("/profile/changeJs", "json");
        query2.addParam("key", "post");

        query2.addEvent("load", function () {
            let script = document.createElement("script");
            script.src = `/Javbook/assets/js/profile/${this.response[2]}`;
            document.body.appendChild(script);
        });
        query2.send("GET");
    });
    query.send("GET");

};
profileMenu[1].onclick = () => {
    document.querySelector('.active').classList.remove("active");
    profileMenu[1].classList.add("active");
    let query = new QueryData("/profile/changeItem");
    query.addParam("key", "about");
    query.addEvent("load", function () {
        timeLine.innerHTML = this.response;
        let query2 = new QueryData("/profile/changeJs", "json");
        query2.addParam("key", "about");

        query2.addEvent("load", function () {
            let script = document.createElement("script");
            script.src = `/Javbook/assets/js/profile/${this.response[1]}`;
            document.body.appendChild(script);
        });
        query2.send("GET");
    });
    query.send("GET");

};
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


