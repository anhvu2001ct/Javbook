var displaySignupBtn = document.getElementById("js-display-signup");
var displaySigninBtn = document.getElementById("js-display-signin");
var signin = document.getElementById("sign-in");
var signup = document.getElementById("sign-up");

displaySignupBtn.onclick = function (e) {
    signin.style.animation = "signin-slideOutLeft ease 1s forwards";
    signup.style.animation = "signup-slideInLeft ease 1s forwards";
};

displaySigninBtn.onclick = function (e) {
    signin.style.animation = "signin-slideInRight ease 1s forwards";
    signup.style.animation = "signup-slideOutRight ease 1s forwards";
};
