var message = {
    success: {
        title: "Sign Up Successfully!",
        message: "Your account is created. Welcome to Javbook!",
        type: "success",
        duration: 10000,
    },
    fail: {
        title: "Sign Up Failed!",
        type: "error",
        duration: 15000,
        errorMessage: {
            username:
                "Username must only contains <span>a-z, 0-9</span> with <span>first letter is a-z</span> and is between <span>6 and 20 characters long</span>!",
            available_username: "This username is <span>not available</span>!",
            password:
                "Password must only contains <span>a-z, A-Z, 0-9</span> with <span>first letter is a-z, A-Z</span> and is between <span>6 and 20 characters long</span>!",
            repassword: "Password must be <span>the same</span>!",
            checkbox: "You must agree <span>all terms & conditions</span>!",
            account: "Username or password <span>incorrect</span>!",
        },
    },
};

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
