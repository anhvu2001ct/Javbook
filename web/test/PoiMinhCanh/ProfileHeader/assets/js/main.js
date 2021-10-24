const inputFileCover = document.querySelector('#header-photo-file');
const displayPhotoCover = document.querySelector(".profile-cover");
const inputFileAvatar = document.querySelector('#header-avatar-file');
const displayPhotoAvatar = document.querySelector(".profile-img");
const profileMenu = document.querySelectorAll(".profile-menu-link");

profileMenu.forEach((item) => {
  item.onclick = () => {
    document.querySelector('.active').classList.remove("active");
    item.classList.add("active");
  }
})
inputFileCover.addEventListener("change", () => {
  var oFReader = new FileReader();
  oFReader.readAsDataURL(inputFileCover.files[0]);
  oFReader.onload = (oFREvent) => {
    displayPhotoCover.src = oFREvent.target.result;
  };

}
)
inputFileAvatar.addEventListener("change", () => {
  var oFReader = new FileReader();
  oFReader.readAsDataURL(inputFileAvatar.files[0]);
  oFReader.onload = (oFREvent) => {
    displayPhotoAvatar.src = oFREvent.target.result;
  };

}
)


