const closePopUp = document.querySelector(".close");
const inputFile = document.querySelector("#file");
const statusPhoto = document.getElementById("status-img");
const textarea = document.querySelector(".status_content  .enter");
const deletePhoto = document.querySelector(".close-img");
const frameImg = document.querySelector(".display-img");
let render = new FileReader();
document.getElementById("input").addEventListener("click", function () {
  document.querySelector(".popup_model").style.display = "flex";
});
closePopUp.addEventListener("click", function () {
  document.querySelector(".popup_model").style.display = "none";
});
deletePhoto.onclick = () => {
  statusPhoto.src = "";
  deletePhoto.style.display = "none";
  frameImg.style.width = "0";
  frameImg.style.height = "0";
  
}

inputFile.addEventListener("change", () => {

  render.readAsDataURL(inputFile.files[0]);
  render.onload = (oFREvent) => {
    statusPhoto.src = oFREvent.target.result;
    deletePhoto.style.display = "flex";
    frameImg.style.width = "auto";
    frameImg.style.height = "auto";
  };
});
textarea.addEventListener('keydown', () => {
  setTimeout(() => {
    if (textarea.scrollHeight < 150) {
      textarea.style.cssText = 'height:auto; padding:0';
      textarea.style.cssText = 'height:' + textarea.scrollHeight + 'px';
    }

  }, 0);
});




