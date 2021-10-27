(() => {
    var message = {
        success: {
            title: "Update Successfully!",
            message: "You update information successfully!",
            type: "success",
            duration: 10000,
        },
        fail: {
            title: "Update Failed!",
            message: "You <span>failed</span> to update your information!",
            type: "error",
            duration: 10000,
        },
        changePassSuccess: {
            title: "Change Password Successfully!",
            message: "You changed password successfully!",
            type: "success",
            duration: 10000,
        },
        changePassFail: {
            title: "Change Password Failed!",
            type: "error",
            duration: 10000,
            errorMessage: {
                password:
                    "<span>Current Password</span> is <span>incorrect</span>!",
                newPassword:
                    "Password must only contains <span>a-z, A-Z, 0-9</span> with <span>first letter is a-z, A-Z</span> and is between <span>6 and 20 characters long</span>!",
                repassword: "Password must be <span>the same</span>!",
                fail: "<span>Unknown fault</span>!",
            },
        },
    };

    // add active class in selected tab
    const listAboutItems = document.querySelectorAll(
        ".about-main .about-nav .list-item"
    );
    const profileMain = document.querySelector(".profile-main");
    const securityMain = document.querySelector(".security-main");
    const settingMain = document.querySelector(".setting-main");

    function activeLink() {
        listAboutItems.forEach((listAboutItem) => {
            listAboutItem.classList.remove("active");
            profileMain.style.display = "none";
            securityMain.style.display = "none";
            settingMain.style.display = "none";
        });
        this.classList.add("active");
        let contentType = this.getAttribute("data-content-type");

        if (contentType == "Profile") {
            profileMain.style.display = "block";
        } else if (contentType == "Security") {
            securityMain.style.display = "block";
        } else if (contentType == "Setting") {
            settingMain.style.display = "block";
        }
    }

    listAboutItems.forEach((listAboutItem) => {
        listAboutItem.addEventListener("click", activeLink);
    });

    var editTextBtns = document.querySelectorAll(".js-edit-text-btn");
    var editPasswordBtn = document.querySelector(".js-edit-password-btn");

    // Modal Select Audience
    var editSelectAudienceBtns = document.querySelectorAll(
        ".js-edit-select-audience"
    );
    var modalSelectAudience = document.querySelector(".modal-select-audience");
    var selectAudienceInputs = document.querySelectorAll(
        ".js-select-audience-input"
    );

    // Modal Common
    var modals = document.querySelectorAll(".modal");
    var bodyModals = document.querySelectorAll(".modal__body");
    var modalCloseBtns = document.querySelectorAll(".modal__close");

    // Modal Select Gender
    var modalSelectGenderBtn = document.querySelector(".js-edit-gender-btn");
    var modalSelectGender = document.querySelector(".modal-gender");
    var genderInputValue = document.querySelector(".js-gender-value");
    var selectGenderInputs = document.querySelectorAll(
        ".js-select-gender-input"
    );
    // Modal Select Status
    var modalSelectStatusBtn = document.querySelector(".js-edit-status-btn");
    var modalSelectStatus = document.querySelector(".modal-status");
    var statusInputValue = document.querySelector(".js-status-value");
    var selectStatusInputs = document.querySelectorAll(
        ".js-select-status-input"
    );

    function editText() {
        let itemContent = this.parentNode;
        let input = itemContent.querySelector(".edit-text");
        let dataItemType = this.dataset.itemType;
        console.log(dataItemType);
        // save edit text
        if (input.classList.contains("active")) {
            input.disabled = true;
            input.classList.remove("active");
            this.firstElementChild.style.display = "block";
            this.lastElementChild.style.display = "none";
            switch (dataItemType) {
                case "name": {
                    let query = new QueryData("profileUserAbout/updateName");
                    query.addParam("name", input.value);

                    query.addEvent("load", function () {
                        let result = this.response;

                        if (result == "success") {
                            toast(message.success, [message.success.message]);
                        } else {
                            input.value = result;
                            toast(message.fail, [message.fail.message]);
                        }
                    });

                    query.send("POST");
                    break;
                }
                case "career": {
                    let query = new QueryData("profileUserAbout/updateCareer");
                    query.addParam("career", input.value);

                    query.addEvent("load", function () {
                        let result = this.response;

                        if (result == "success") {
                            toast(message.success, [message.success.message]);
                        } else {
                            input.value = result;
                            toast(message.fail, [message.fail.message]);
                        }
                    });

                    query.send("POST");
                    break;
                }

                case "address": {
                    let query = new QueryData("profileUserAbout/updateAddress");
                    query.addParam("address", input.value);

                    query.addEvent("load", function () {
                        let result = this.response;

                        if (result == "success") {
                            toast(message.success, [message.success.message]);
                        } else {
                            input.value = result;
                            toast(message.fail, [message.fail.message]);
                        }
                    });

                    query.send("POST");
                    break;
                }
                case "dob":
                    aboutUpdateDOB();
                    break;
                case "phone": {
                    let query = new QueryData("account/updatePhone");
                    query.addParam("phone", input.value);

                    query.addEvent("load", function () {
                        let result = this.response;

                        if (result == "success") {
                            toast(message.success, [message.success.message]);
                        } else {
                            input.value = result;
                            toast(message.fail, [message.fail.message]);
                        }
                    });

                    query.send("POST");
                    break;
                }
                case "email": {
                    let query = new QueryData("account/updateEmail");
                    query.addParam("email", input.value);

                    query.addEvent("load", function () {
                        let result = this.response;

                        if (result == "success") {
                            toast(message.success, [message.success.message]);
                        } else {
                            input.value = result;
                            toast(message.fail, [message.fail.message]);
                        }
                    });

                    query.send("POST");
                    break;
                }
                default:
                    break;
            }
        }
        // edit text
        else {
            input.removeAttribute("disabled");
            input.classList.add("active");
            this.firstElementChild.style.display = "none";
            this.lastElementChild.style.display = "block";
        }
    }

    // Toggle Password

    // Toggle Password Button
    var toggleCurrentPassBtn = document.querySelector(
        ".js-toggle-current-pass-btn"
    );
    var toggleNewPassBtns = document.querySelectorAll(
        ".js-toggle-new-pass-btn"
    );

    // Toggle Eye Password
    var currentPassword = document.getElementById("js-current-password");
    var newPassword = document.getElementById("js-new-password");
    var newRepassword = document.getElementById("js-new-repassword");

    function toggleCurrentPass() {
        toggleCurrentPassBtn.classList.toggle("hide");
        if (currentPassword.type === "password") {
            currentPassword.type = "text";
        } else {
            currentPassword.type = "password";
        }
    }

    function resetPasswordInputs() {
        currentPassword.value = "";
        newPassword.value = "";
        newRepassword.value = "";

        // change eye
        toggleCurrentPassBtn.classList.remove("hide");
        toggleNewPassBtns.forEach((toggleNewPassBtn) => {
            toggleNewPassBtn.classList.remove("hide");
        });

        currentPassword.type = "password";
        newPassword.type = "password";
        newRepassword.type = "password";
    }

    function toggleNewPass() {
        toggleNewPassBtns.forEach((toggleNewPassBtn) => {
            toggleNewPassBtn.classList.toggle("hide");
        });

        if (newPassword.type === "password") {
            newPassword.type = "text";
            newRepassword.type = "text";
        } else {
            newPassword.type = "password";
            newRepassword.type = "password";
        }
    }

    // Event Toggle Password Button Onclick
    toggleCurrentPassBtn.addEventListener("click", toggleCurrentPass);

    toggleNewPassBtns.forEach((toggleNewPassBtn) => {
        toggleNewPassBtn.addEventListener("click", toggleNewPass);
    });

    function editPassword() {
        let itemContent = this.parentNode;
        let passDiv = itemContent.querySelector(".password");
        let editPassDiv = itemContent.querySelector(".edit-password");
        let isEditing = editPassDiv.style.display == "flex";
        if (isEditing) {
            let query = new QueryData("account/changePassword", "json");

            query.addParam("currentPassword", currentPassword.value);
            query.addParam("newPassword", newPassword.value);
            query.addParam("newRepassword", newRepassword.value);

            query.addEvent("load", function () {
                let result = this.response;
                let msg = [];
                if (result.length == 0) {
                    // show Toast message change password successfully!
                    toast(message.changePassSuccess, [
                        message.changePassSuccess.message,
                    ]);
                } else {
                    result.forEach((element) => {
                        msg.push(message.changePassFail.errorMessage[element]);
                    });
                    toast(message.changePassFail, msg);
                }
            });

            query.send("POST");

            passDiv.style.display = "block";
            editPassDiv.style.display = "none";
            this.firstElementChild.style.display = "block";
            this.lastElementChild.style.display = "none";
            resetPasswordInputs();
        } else {
            passDiv.style.display = "none";
            editPassDiv.style.display = "flex";
            this.firstElementChild.style.display = "none";
            this.lastElementChild.style.display = "block";
        }
    }

    let arrFn = [];
    function editSelectAudience() {
        let selectAudienceType = this.getAttribute("data-select-audience-type");

        modalSelectAudience.style.display = "flex";
        selectAudienceInputs.forEach((selectAudienceInput) => {
            let selectAudienceOrder = selectAudienceInput.getAttribute(
                "data-select-audience-order"
            );
            if (
                (selectAudienceType == "Global" && selectAudienceOrder == 1) ||
                (selectAudienceType == "Friends" && selectAudienceOrder == 2) ||
                (selectAudienceType == "OnlyMe" && selectAudienceOrder == 3)
            ) {
                selectAudienceInput.checked = true;
            }
        });

        let editSelectAudienceBtn = this;
        arrFn = [];
        selectAudienceInputs.forEach((selectAudienceInput) => {
            let fn = editSelectAudienceType.bind(
                null,
                selectAudienceInput,
                editSelectAudienceBtn
            );
            arrFn.push(fn);

            selectAudienceInput.addEventListener("click", fn);
        });
    }

    function editSelectAudienceType(
        selectAudienceInput,
        editSelectAudienceBtn
    ) {
        let selectAudienceOrder = selectAudienceInput.getAttribute(
            "data-select-audience-order"
        );

        let icon = editSelectAudienceBtn.querySelector("i");
        icon.classList.remove("fa-globe-asia");
        icon.classList.remove("fa-user-friends");
        icon.classList.remove("fa-lock");
        if (selectAudienceOrder == 1) {
            editSelectAudienceBtn.setAttribute(
                "data-select-audience-type",
                "Global"
            );
            icon.classList.add("fa-globe-asia");
        } else if (selectAudienceOrder == 2) {
            editSelectAudienceBtn.setAttribute(
                "data-select-audience-type",
                "Friends"
            );
            icon.classList.add("fa-user-friends");
        } else if (selectAudienceOrder == 3) {
            editSelectAudienceBtn.setAttribute(
                "data-select-audience-type",
                "OnlyMe"
            );
            icon.classList.add("fa-lock");
        }
        modalSelectAudience.style.display = "none";

        selectAudienceInputs.forEach((selectAudienceInput, index) => {
            selectAudienceInput.removeEventListener("click", arrFn[index]);
        });
    }

    // Process Select Gender
    function editSelectGender() {
        let selectGenderType = genderInputValue.value;

        modalSelectGender.style.display = "flex";

        selectGenderInputs.forEach((selectGenderInput) => {
            let selectGenderOrder = selectGenderInput.getAttribute(
                "data-select-gender-order"
            );
            if (
                (selectGenderType == "Male" && selectGenderOrder == 1) ||
                (selectGenderType == "Female" && selectGenderOrder == 2) ||
                (selectGenderType == "Others" && selectGenderOrder == 3)
            ) {
                selectGenderInput.checked = true;
            }
        });
    }

    selectGenderInputs.forEach((selectGenderInput) => {
        selectGenderInput.addEventListener("click", () => {
            let selectGenderOrder = selectGenderInput.getAttribute(
                "data-select-gender-order"
            );

            if (selectGenderOrder == 1) {
                genderInputValue.value = "Male";
            } else if (selectGenderOrder == 2) {
                genderInputValue.value = "Female";
            } else if (selectGenderOrder == 3) {
                genderInputValue.value = "Others";
            }
            modalSelectGender.style.display = "none";
        });
    });

    // Process Select Status
    function editSelectStatus() {
        let selectStatusType = statusInputValue.value;

        modalSelectStatus.style.display = "flex";

        selectStatusInputs.forEach((selectStatusInput) => {
            let selectStatusOrder = selectStatusInput.getAttribute(
                "data-select-status-order"
            );
            if (
                (selectStatusType == "Married" && selectStatusOrder == 1) ||
                (selectStatusType == "Single" && selectStatusOrder == 2) ||
                (selectStatusType == "Others" && selectStatusOrder == 3)
            ) {
                selectStatusInput.checked = true;
            }
        });
    }

    selectStatusInputs.forEach((selectStatusInput) => {
        selectStatusInput.addEventListener("click", () => {
            let selectStatusOrder = selectStatusInput.getAttribute(
                "data-select-status-order"
            );

            if (selectStatusOrder == 1) {
                statusInputValue.value = "Married";
            } else if (selectStatusOrder == 2) {
                statusInputValue.value = "Single";
            } else if (selectStatusOrder == 3) {
                statusInputValue.value = "Others";
            }
            modalSelectStatus.style.display = "none";
        });
    });

    editTextBtns.forEach((editTextBtn) => {
        editTextBtn.addEventListener("click", editText);
    });

    editPasswordBtn.addEventListener("click", editPassword);

    editSelectAudienceBtns.forEach((editSelectAudienceBtn) => {
        editSelectAudienceBtn.addEventListener("click", editSelectAudience);
    });

    // Modal Select Gender
    modalSelectGenderBtn.addEventListener("click", editSelectGender);
    // Modal Select Status
    modalSelectStatusBtn.addEventListener("click", editSelectStatus);

    modalCloseBtns.forEach((modalCloseBtn) => {
        modalCloseBtn.addEventListener("click", (e) => {
            e.target.closest(".modal").style.display = "none";
        });
    });

    modals.forEach((modal) => {
        modal.addEventListener("click", (e) => {
            e.target.closest(".modal").style.display = "none";
        });
    });

    bodyModals.forEach((bodyModal) => {
        bodyModal.addEventListener("click", (e) => {
            e.stopPropagation();
        });
    });
})();
