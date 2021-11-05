let addFriendBtns = document.querySelectorAll(".js-add-friend-btn");

addFriendBtns.forEach((addFriendBtn) => {
    addFriendBtn.addEventListener("click", function (e) {
        let user = e.target.closest(".search-details");
        let userID = user.dataset.id;

        let query = new QueryData("friend/friendRequest");

        query.addParam("receiverID", userID);

        query.addEvent("load", function () {
            let result = this.response;

            if (result == "success") {
                console.log("hii");
            } else {
                // maybe do something in the future
                // if request friend fails
                console.log("hiiaaa");
            }
        });

        query.send("POST");
    });
});
