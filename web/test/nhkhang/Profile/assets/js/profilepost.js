function profilePost() {

    const closePopUp = document.querySelector(".close");
    const inputFile = document.querySelector("#file");
    const statusPhoto = document.getElementById("status-img");
    const textarea = document.querySelector(".status_content  .enter");
    const deletePhoto = document.querySelector(".close-img");
    const frameImg = document.querySelector(".display-img");
    const postBtn = document.querySelector(".pop_ele3 .share");
    const userEditContent = document.querySelector(".status_content  .enter");
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

    };

    inputFile.addEventListener("change", () => {
        let render = new FileReader();
        render.readAsDataURL(inputFile.files[0]);
        render.onload = (oFREvent) => {
            statusPhoto.src = oFREvent.target.result;
            deletePhoto.style.display = "flex";
            frameImg.style.width = "auto";
            frameImg.style.height = "auto";
        };
    });
    postBtn.onclick = sendFile;

    function sendFile() {

        let uploadImg = new QueryUpload("upload/image");
        let uploadData = new QueryData("/profile/crateStatus");
        //uploadImage
        let name = "user" + Date.now() + ".png";
        uploadImg.addParam("file", inputFile.files[0]);
        uploadImg.addParam("savePath", name);

        uploadImg.addEvent("progress", function (e) {
            let percent = e.loaded / e.total * 100;
            console.log('upload process: ' + Math.floor(percent) + '%');
        });
        uploadImg.send();
        // uploadData
        uploadData.addParam("content", userEditContent.value);
        uploadData.addParam("link", "/Javbook/assets/img/user/" + name);
        uploadData.send("POST");
        
        document.querySelector(".popup_model").style.display = "none";
        
    }


    textarea.addEventListener('keydown', () => {
        setTimeout(() => {
            if (textarea.scrollHeight < 150) {
                textarea.style.cssText = 'height:auto; padding:0';
                textarea.style.cssText = 'height:' + textarea.scrollHeight + 'px';
            }

        }, 0);
    });


}
profilePost();