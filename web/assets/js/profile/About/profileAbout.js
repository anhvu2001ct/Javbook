(() => {
    // add active class in selected tab
    const listAboutItems = document.querySelectorAll(
        ".about-main .about-nav .list-item"
    );
    const profileMain = document.querySelector(".profile-main");
    const passwordMain = document.querySelector(".password-main");
    const settingMain = document.querySelector(".setting-main");

    function activeLink() {
        listAboutItems.forEach((listAboutItem) => {
            listAboutItem.classList.remove("active");
            profileMain.style.display = "none";
            passwordMain.style.display = "none";
            settingMain.style.display = "none";
        });
        this.classList.add("active");
        let contentType = this.getAttribute("data-content-type");
        console.log(contentType);
        if (contentType == "Profile") {
            profileMain.style.display = "block";
        } else if (contentType == "Password") {
            passwordMain.style.display = "block";
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

        // save edit text
        if (input.classList.contains("active")) {
            input.setAttribute("value", input.value);
            input.disabled = true;
            input.classList.remove("active");
            this.firstElementChild.style.display = "block";
            this.lastElementChild.style.display = "none";
        }
        // edit text
        else {
            input.removeAttribute("disabled");
            input.classList.add("active");
            this.firstElementChild.style.display = "none";
            this.lastElementChild.style.display = "block";
        }
    }

    function editPassword() {
        let itemContent = this.parentNode;
        let passDiv = itemContent.querySelector(".password");
        let editPassDiv = itemContent.querySelector(".edit-password");
        let isEditing = editPassDiv.style.display == "flex";
        if (isEditing) {
            passDiv.style.display = "block";
            editPassDiv.style.display = "none";
            this.firstElementChild.style.display = "block";
            this.lastElementChild.style.display = "none";
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
})();
