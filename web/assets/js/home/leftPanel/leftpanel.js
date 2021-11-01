const changerotate = document.querySelector(".changerotate");
const moreicon = document.querySelector(".more_icon");
const logout = document.querySelector(".leftpanel_logout");
let checkrotate = false;
changerotate.onclick = function () {
  if (checkrotate === false) {
    moreicon.style.transform = "rotate(90deg)";
    logout.style.display = "flex";
    checkrotate = true;
  } else {
    moreicon.style.transform = "rotate(0)";
    logout.style.display = "none";
    checkrotate = false;
  }
};

function logOut() {};
