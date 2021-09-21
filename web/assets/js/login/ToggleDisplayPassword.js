var signinPassword = document.getElementById("sign-in-password");
var signupPassword = document.getElementById("sign-up-password");
var signupRepassword = document.getElementById("sign-up-repassword");

var togglePassSignInBtns = document.querySelectorAll(
    ".js-sign-in-toggle-pass-btn"
);
var togglePassSignUpBtns = document.querySelectorAll(
    ".js-sign-up-toggle-pass-btn"
);

function toggleSignInPassword() {
    for (const togglePassSignInBtn of togglePassSignInBtns) {
        togglePassSignInBtn.classList.toggle("hide");
    }
    if (signinPassword.type === "password") {
        signinPassword.type = "text";
    } else {
        signinPassword.type = "password";
    }
}

function toggleSignUpPassword() {
    for (const togglePassSignUpBtn of togglePassSignUpBtns) {
        togglePassSignUpBtn.classList.toggle("hide");
    }
    if (signupPassword.type === "password") {
        signupPassword.type = "text";
        signupRepassword.type = "text";
    } else {
        signupPassword.type = "password";
        signupRepassword.type = "password";
    }
}

for (const togglePassSignInBtn of togglePassSignInBtns) {
    togglePassSignInBtn.addEventListener("click", toggleSignInPassword);
}

for (const togglePassSignUpBtn of togglePassSignUpBtns) {
    togglePassSignUpBtn.addEventListener("click", toggleSignUpPassword);
}
