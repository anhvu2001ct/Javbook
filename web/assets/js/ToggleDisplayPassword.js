var passField = document.getElementById("password");
var togglePassBtn = document.querySelector(".js-toggle-pass-btn");

togglePassBtn.onclick = function () {
    if (passField.type === "password") {
        passField.type = "text";
    } else {
        passField.type = "password";
    }
    togglePassBtn.classList.toggle("hide");
};
