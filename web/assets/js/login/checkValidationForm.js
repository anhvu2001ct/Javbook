var patt_username = /^(?=.{6,20}$)[a-z0-9]+$/;
// Undone
var patt_password = /^(?=.{6,20}$)[a-zA-Z0-9]+$/;

var signupUsername = document.getElementById("sign-up-username");
var signupPassword = document.getElementById("sign-up-password");
var signupRepassword = document.getElementById("sign-up-repassword");

function checkUsername() {
    if (signupUsername.value == "") {
        signupUsername.classList.remove("success");
        signupUsername.classList.remove("error");
    } else if (patt_username.test(signupUsername.value)) {
        signupUsername.classList.add("success");
        signupUsername.classList.remove("error");
    } else {
        signupUsername.classList.remove("success");
        signupUsername.classList.add("error");
    }
}

function checkPassword() {
    console.log("hihi" + patt_password.test(signupPassword.value));
    if (signupPassword.value == "") {
        signupPassword.classList.remove("success");
        signupPassword.classList.remove("error");
    } else if (patt_password.test(signupPassword.value)) {
        console.log("DMM");
        signupPassword.classList.add("success");
        signupPassword.classList.remove("error");
    } else {
        signupPassword.classList.remove("success");
        signupPassword.classList.add("error");
    }
}

function checkConfirmPassword() {
    if (signupRepassword.value == "") {
        signupRepassword.classList.remove("success");
        signupRepassword.classList.remove("error");
    } else if (patt_password.test(signupRepassword.value)) {
        signupRepassword.classList.add("success");
        signupRepassword.classList.remove("error");
    } else {
        signupRepassword.classList.remove("success");
        signupRepassword.classList.add("error");
    }
}
