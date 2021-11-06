let addFriendBtns = document.querySelectorAll(".js-add-friend-btn");

addFriendBtns.forEach((addFriendBtn) => {
    addFriendBtn.addEventListener("click", function (e) {
        let iconContainer = e.target.closest(".search-status");
        let icon = iconContainer.querySelector("i");

        let user = e.target.closest(".search-details");
        let userID = user.dataset.id;
        let index = user.dataset.index;

        let query = new QueryData("friend/friendRequest");

        query.addParam("receiverID", userID);
        query.addParam("index", index);

        query.addEvent("load", function () {
            let result = this.response;

            if (result == "success") {
                // they are friends
                if (index == 2) {
                } else if (index == 1) {
                    user.dataset.index = -2;
                    // delete invitations sent to others
                    icon.classList.remove("fa-user-times");
                    icon.classList.add("fa-user-plus");
                } else if (index == -1) {
                    user.dataset.index = 2;
                    // accept invitations of others
                    icon.classList.remove("fas");
                    icon.classList.remove("fa-user-clock");
                    icon.classList.add("fab");
                    icon.classList.add("fa-facebook-messenger");
                    user.dataset.index = 1;
                } else if (index == -2) {
                    user.dataset.index = 1;
                    // send invitation to others
                    icon.classList.remove("fa-user-plus");
                    icon.classList.add("fa-user-times");
                }
            } else {
                // maybe do something in the future
                // if request friend fails
                console.log("hiiaaa");
            }
        });

        query.send("POST");
    });
});
