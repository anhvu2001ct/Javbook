const changerotate = document.querySelector(".changerotate");
const moreicon = document.querySelector(".more_icon");
let checkrotate = false;
changerotate.onclick = function () {
  if (checkrotate === false) {
    moreicon.style.transform = "rotate(90deg)";
    checkrotate = true;
  } else {
    moreicon.style.transform = "rotate(0)";
    checkrotate = false;
  }
};
