const changerotate = document.querySelector(".changerotate");
const moreicon = document.querySelector(".more_icon");
const logout = document.querySelector(".leftpanel_logout");
let checkrotate = false;
changerotate.onclick = function () {
    if (checkrotate === false) {
        moreicon.style.transform = "rotate(90deg)";
        logout.style.display = "flex";
        checkrotate = true;
    } else {
        moreicon.style.transform = "rotate(0)";
        logout.style.display = "none";
        checkrotate = false;
    }
};
logout.addEventListener("click", function () {
    console.log("hihi");
    let query = new QueryData("account/logout");

    query.addEvent("load", function () {
        let result = this.response;

        if (result == "success") {
            window.location = "/Javbook/";
            // console.log("ok");
        } else {
            toast(
                {
                    title: "Logout Failed!",
                    type: "error",
                    duration: 10000,
                },
                ["<span>Unknown fault</span>!"]
            );
        }
    });

    query.send("POST");
});
