messageBtns = document.querySelectorAll(".js-message-btn");

messageBtns.forEach((messageBtn) => {
    messageBtn.addEventListener("click", function () {
        let query = new QueryData("boxChat/getBoxChat");
        query.addParam("otherID", this.dataset.otherId);
        query.addEvent("load", function () {
            let result = this.response;
            if (result != null) {
                var chatBox = document.createElement("div"); // is a node
                chatBox.classList.add("boxchat");
                chatBox.innerHTML = result;
                document
                    .querySelector(".boxchat_container")
                    .appendChild(chatBox);
            }
        });
        query.send("POST");
    });
});
