var signinPassword = document.getElementById("sign-in-password");
var signupPassword = document.getElementById("sign-up-password");
var signupRepassword = document.getElementById("sign-up-repassword");

var togglePassBtns = document.querySelectorAll(".js-toggle-pass-btn");

function togglePassword() {
    for (const togglePassBtn of togglePassBtns) {
        togglePassBtn.classList.toggle("hide");
    }
    if (signinPassword.type === "password") {
        signinPassword.type = "text";
        signupPassword.type = "text";
        signupRepassword.type = "text";
    } else {
        signinPassword.type = "password";
        signupPassword.type = "password";
        signupRepassword.type = "password";
    }
}

for (const togglePassBtn of togglePassBtns) {
    togglePassBtn.addEventListener("click", togglePassword);
}
