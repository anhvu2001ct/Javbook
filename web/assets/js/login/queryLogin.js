signupBtn = document.querySelector("#js-sign-up-btn");

var message = {
    success: {
        title: "Successfully!",
        message: "Your account is created. Welcome to Javbook!",
        type: "success",
        duration: 5000,
    },
    fail: {
        title: "Failed!",
        type: "error",
        duration: 5000,
        errorMessage: {
            username: "Your username just have a-z, 0-9",
            password: "Password must be the same!",
            checkbox: "You must agree all terms & conditions!",
        },
    },
};

signupBtn.onclick = function () {
    let query = new QueryData("login/createNewAccount", "json");

    query.addParam(
        "signupUsername",
        document.getElementById("sign-up-username").value
    );

    query.addParam(
        "signupPassword",
        document.getElementById("sign-up-password").value
    );

    query.addParam(
        "signupRepassword",
        document.getElementById("sign-up-repassword").value
    );

    query.addParam(
        "signupCheckbox",
        document.getElementById("js-sign-up-checkbox").checked
    );

    query.addEvent("load", function () {
        let result = this.response;
        if (result.length == 0) {
            toast(message.success, message.success.message);
            displaySignup();
        } else {
            let msg = "";
            result.forEach((element) => {
                msg += message.fail.errorMessage[element];
            });
            toast(message.fail, msg);
        }
        console.log(result);
    });

    query.send("POST");
};
