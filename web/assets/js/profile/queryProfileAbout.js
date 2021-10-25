signupBtn = document.querySelector("#js-sign-up-btn");

signupBtn.onclick = function () {
    this.disabled = true;
    this.classList.add("btn--disabled");

    time = 5;
    // Show time remain to remove btn disabled
    let timerId = setInterval(() => {
        this.innerHTML = `Sign up (${time}s)`;
        time--;
    }, 1000);

    // Clear intervals after 6 sec with the timer id
    setTimeout(() => {
        this.disabled = false;
        this.classList.remove("btn--disabled");
        this.innerHTML = "Sign up";
        clearInterval(timerId);
    }, 6000);

    let signupUsername = document.getElementById("sign-up-username");
    let signupPassword = document.getElementById("sign-up-password");
    let signupRepassword = document.getElementById("sign-up-repassword");
    let signupCheckbox = document.getElementById("js-sign-up-checkbox");

    let query = new QueryData("login/createNewAccount", "json");

    query.addParam("signupUsername", signupUsername.value);
    query.addParam("signupPassword", signupPassword.value);
    query.addParam("signupRepassword", signupRepassword.value);
    query.addParam("signupCheckbox", signupCheckbox.checked);

    query.addEvent("load", function () {
        let result = this.response;
        let msg = [];
        if (result.length == 0) {
            // show Toast message signup successfully!
            msg.push(message.success.message);
            toast(message.success, msg);
            // Autofill username and password into signin form
            document.getElementById("sign-in-username").value =
                signupUsername.value;
            document.getElementById("sign-in-password").value =
                signupPassword.value;
            // reset toggle signin password
            resetToggleSignInPassword();
            // reset input and validation input
            resetSignup();

            // show Signin form
            displaySignin();
        } else {
            result.forEach((element) => {
                msg.push(message.fail.errorMessage[element]);
            });
            toast(message.fail, msg);
        }
        console.log(result);
    });

    query.send("POST");
};

signinBtn = document.querySelector("#js-sign-in-btn");

signinBtn.onclick = function () {
    this.disabled = true;
    this.classList.add("btn--disabled");

    time = 5;
    // Show time remain to remove btn disabled
    let timerId = setInterval(() => {
        this.innerHTML = `Sign in (${time}s)`;
        time--;
    }, 1000);

    // Clear intervals after 6 sec with the timer id
    setTimeout(() => {
        this.disabled = false;
        this.classList.remove("btn--disabled");
        this.innerHTML = "Sign up";
        clearInterval(timerId);
    }, 6000);

    let query = new QueryData("login/signin");
    query.addParam(
        "signinUsername",
        document.getElementById("sign-in-username").value
    );

    query.addParam(
        "signinPassword",
        document.getElementById("sign-in-password").value
    );

    query.addParam(
        "signinRememberPassword",
        document.getElementById("js-sign-in-checkbox").checked
    );

    query.addEvent("load", function () {
        let result = this.response;
        let msg = [];
        if (result == "fail") {
            msg.push(message.fail.errorMessage.account);
            toast(message.fail, msg);
        } else {
            window.location = ".";
        }
    });

    query.send("POST");
};

// Modal Select Status
var modalSelectStatusBtn = document.querySelector(".js-edit-status-btn");
var modalSelectStatus = document.querySelector(".modal-status");
var statusInputValue = document.querySelector(".js-status-value");
var selectStatusInputs = document.querySelectorAll(".js-select-status-input");

// Query

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

// Modal Select Gender
modalSelectGenderBtn.addEventListener("click", editSelectGender);
