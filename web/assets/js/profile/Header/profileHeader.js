const inputFileCover = document.querySelector('#header-photo-file');
const displayPhotoCover = document.querySelector(".profile-cover");
const inputFileAvatar = document.querySelector('#header-avatar-file');
const displayPhotoAvatar = document.querySelector(".profile-img");
const profileMenu = document.querySelectorAll(".profile-menu-link");
const timeLine = document.querySelector(".timeline");

profileMenu.forEach((item, index) => {
    item.onclick = () => {
        let listScript = document.querySelectorAll("script");
        listScript.forEach((script) => {
            if (!script.src.includes("profileHeader")) {
                if (!script.src.includes("common/query")) {
                    script.remove();
                }
            }
        })
        document.querySelector('.active').classList.remove("active");
        item.classList.add("active");
        let query = new QueryData("/profile/changeItem");
        let query2 = new QueryData("/profile/changeJs", "json");
        let path;
        if (index === 0) {
            query.addParam("key", "post");
            query2.addParam("key", "post");
            path = "/Javbook/assets/js/profile/Post"
        }
        if (index === 1) {
            query.addParam("key", "about");
            query2.addParam("key", "about");
            path = "/Javbook/assets/js/profile/About"

        }
        if (index === 2) {
            query.addParam("key", "friends");
            query2.addParam("key", "friends");
            path = "/Javbook/assets/js/profile/Friends"

        }
        if (index === 3) {
            query.addParam("key", "photo");
            query2.addParam("key", "photo");
            path = "/Javbook/assets/js/profile/Photo"

        }
        query.addEvent("load", function () {
            timeLine.innerHTML = this.response;
            query2.addEvent("load", function () {
                this.response.forEach((response) => {
                    let script = document.createElement("script");
                    script.src = `${path}/${response}`;
                    document.body.appendChild(script);
                })

            });
            query2.send("GET");
        });
        query.send("GET");
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


