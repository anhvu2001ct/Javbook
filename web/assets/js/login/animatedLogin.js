var patt_username = /^(?=.{6,20}$)[a-z0-9]+$/;
// Undone
var patt_password = /^(?=.{6,20}$)[a-zA-Z0-9]+$/;

var signupUsername = document.getElementById("sign-up-username");
var signupPassword = document.getElementById("sign-up-password");
var signupRepassword = document.getElementById("sign-up-repassword");

function resetSignup() {
    signupUsername.classList.remove("success");
    signupUsername.classList.remove("error");
    signupPassword.classList.remove("success");
    signupPassword.classList.remove("error");
    signupRepassword.classList.remove("success");
    signupRepassword.classList.remove("error");
    signupUsername.value = "";
    signupPassword.value = "";
    signupRepassword.value = "";
    document.getElementById("js-sign-up-checkbox").checked = false;
}

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
    if (signupPassword.value == "") {
        signupPassword.classList.remove("success");
        signupPassword.classList.remove("error");
    } else if (patt_password.test(signupPassword.value)) {
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

// Toggle Eye Password
var signinPassword = document.getElementById("sign-in-password");
var signupPassword = document.getElementById("sign-up-password");
var signupRepassword = document.getElementById("sign-up-repassword");

var togglePassSignInBtn = document.querySelector(".js-sign-in-toggle-pass-btn");

var togglePassSignUpBtns = document.querySelectorAll(
    ".js-sign-up-toggle-pass-btn"
);

function toggleSignInPassword() {
    togglePassSignInBtn.classList.toggle("hide");
    if (signinPassword.type === "password") {
        signinPassword.type = "text";
    } else {
        signinPassword.type = "password";
    }
}

function resetToggleSignInPassword() {
    togglePassSignInBtn.classList.remove("hide");
    signinPassword.type = "password";
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

togglePassSignInBtn.addEventListener("click", toggleSignInPassword);

for (const togglePassSignUpBtn of togglePassSignUpBtns) {
    togglePassSignUpBtn.addEventListener("click", toggleSignUpPassword);
}

// Toggle Display SISU
var displaySignupBtn = document.getElementById("js-display-signup");
var displaySigninBtn = document.getElementById("js-display-signin");
var signin = document.getElementById("sign-in");
var signup = document.getElementById("sign-up");

displaySignupBtn.onclick = displaySignup;

displaySigninBtn.onclick = displaySignin;

function displaySignup() {
    signin.style.animation = "signin-slideOutLeft ease 1s forwards";
    signup.style.animation = "signup-slideInLeft ease 1s forwards";
}

function displaySignin() {
    signin.style.animation = "signin-slideInRight ease 1s forwards";
    signup.style.animation = "signup-slideOutRight ease 1s forwards";
}
