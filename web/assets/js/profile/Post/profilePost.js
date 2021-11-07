(() => {
  const closePopUp = document.querySelector(".close");
  const inputFile = document.querySelector("#file");
  const statusPhoto = document.getElementById("status-img");
  const textarea = document.querySelector(".status_content  .enter");
  const deletePhoto = document.querySelector(".close-img");
  const frameImg = document.querySelector(".display-img");
  const postBtn = document.querySelector(".pop_ele3 .share");
  const userEditContent = document.querySelector(".status_content  .enter");
  const select = document.querySelector("#select");
  let option = 1;
  select.addEventListener("change", () => {
    option = select.options[select.selectedIndex].value;

  });


  document.getElementById("input").addEventListener("click", function () {
    document.querySelector(".popup-main-post").style.display = "flex";
    statusPhoto.src = "";
    let userAvatarPopup = document.querySelector(".popup-main-post .wh_40 img");
    let userAvatar = document.querySelector(".userAvatar");
    userAvatarPopup.src = userAvatar.src;

  });
  closePopUp.addEventListener("click", function () {
    document.querySelector(".popup_model").style.display = "none";
    userEditContent.value = "";
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

    let uploadData = new QueryData("/status/crateStatus");
    let query = new QueryData("/status/getEncodeID");
    //uploadImage
    let name = "post" + Date.now() + ".png";
    // uploadData
    uploadData.addParam("content", userEditContent.value);
    let statusID;
    let userNamePost = document.querySelector(".profile-name");
    let userImgPost = document.querySelector(".userAvatar");
    uploadData.addParam("audience", option);
    if (inputFile.files[0] != undefined) {
      uploadData.addParam("link", "/Javbook/assets/img/post/" + name);
    }
    uploadData.addEvent("load", function () {
      statusID = this.response;
      console.log(statusID)
      query.addParam("id", statusID)
      query.addEvent("load", function () {
        let encodeID = this.response;
        if (inputFile.files[0] != undefined) {
          let uploadImg = new QueryUpload("upload/image");
          uploadImg.addParam("file", inputFile.files[0]);
          uploadImg.addParam("savePath", "post");
          uploadImg.addParam("fileName", name);
          let link = "/Javbook/assets/img/post/" + name;

          // uploadData.addParam("link", link);
          uploadImg.addEvent("progress", function (e) {
            let percent = e.loaded / e.total * 100;
            console.log('upload process: ' + Math.floor(percent) + '%');
          });
          query.addParam("id", statusID);
          uploadImg.addEvent("load", function () {
            window.setTimeout(() => {

              renderNewPost(userEditContent, link, option, userNamePost.textContent, userImgPost.src, statusID, encodeID);
            }, 2000);
          });
          uploadImg.send();
        }
        else {
          renderNewPost(userEditContent, "", option, userNamePost.textContent, userImgPost.src, statusID, encodeID);
        }
      })
      query.send("GET")
      document.querySelector(".popup_model").style.display = "none";


      statusPhoto.src = "";
      deletePhoto.style.display = "none";
    })

    uploadData.send("POST");

  }

  function renderNewPost(text, img, option, name, url, statusID, encodeID) {
    let today = new Date();
    let date = (today.getMonth() + 1) + '/' + today.getDate() + '/' + today.getFullYear();
    let time = today.getHours() + ":" + today.getMinutes();
    let dateTime = date + ' ' + time;

    let postbox = document.createElement("div");
    postbox.classList.add("post");
    postbox.classList.add("home-box");
    postbox.classList.add("box");
    postbox.setAttribute("data-id", "zMTOwUTN")
    postbox.setAttribute("id", statusID);
    let html = `
        
  <div class="post-item" >
    <div class="status-main">
      <img src="${url}" class="status-img" />
      <div class="post-detail">
        <div class="post-title">
          <a href="">${name}</a>
        </div>

        <div class="post-state">
          <span class="post-date">${dateTime}</span>
${(option === 1) ? "<i class='fas fa-globe-asia'></i>" : (option === 2) ? " <i class='fas fa-user-friends'></i>" : " <i class='fas fa-lock'></i>"}
          
         
         
        </div>
      </div>
      <div class="edit-post">
        <i class="fas fa-ellipsis-h"></i>
        <div class="edit-post-item">
          <ul>
            <li class="view" id="${encodeID}" ><i class="fas fa-eye"></i> View</li>
            <li class="edit"><i class="fas fa-pen-nib"> </i> Edit</li>
            <li class="delete"><i class="far fa-trash-alt"></i> Delete</li>
          </ul>
        </div>
      </div>
    </div>
    <div class="post-content">
      <p class="content">${text.value}</p>
    </div>
    <div class="post-photos">
      <img
        src="${img}"
        alt=""
        class="post-photo"
        id=${encodeID}
      />
    </div>
  </div>
  <div class="post-count">
    <div class="post-count-left">
      <ul>
        <li>
          <img src="/Javbook/assets/img/emoji/like.svg" alt="0" />
        </li>

        <li>
          <img src="/Javbook/assets/img/emoji/love.svg" alt="0" />
        </li>

        <li>
          <img src="/Javbook/assets/img/emoji/care.svg" alt="0" />
        </li>
      </ul>
      <p class="count-emoji">0</p>
    </div>
    <div class="post-count-right">
      <span>
        <p class="count-comment">0</p>
        comments
      </span>
      <span>
        <p class="count-share">0</p>
        share</span
      >
    </div>
  </div>
  <div class="post-action">
    <div class="actions">
      <div class="emoji">
        <img
          src="/Javbook/assets/img/emoji/unlike.png"
          alt=""
          class="icon-status"
        />
        <p>Like</p>
        <div class="list-icon">
          <ul>
            <li>
              <div class="tooltip">
                <img src="/Javbook/assets/img/emoji/like.svg" alt="" />
                <span class="toolTipText">Like</span>
              </div>
            </li>

            <li>
              <div class="tooltip">
                <img src="/Javbook/assets/img/emoji/love.svg" alt="" />
                <span class="toolTipText tooltipIcon2">Love</span>
              </div>
            </li>

            <li>
              <div class="tooltip">
                <img src="/Javbook/assets/img/emoji/care.svg" alt="" />
                <span class="toolTipText tooltipIcon3">Care</span>
              </div>
            </li>

            <li>
              <div class="tooltip">
                <img src="/Javbook/assets/img/emoji/haha.svg" alt="" />
                <span class="toolTipText tooltipIcon4">Haha</span>
              </div>
            </li>

            <li>
              <div class="tooltip">
                <img src="/Javbook/assets/img/emoji/sad.svg" alt="" />
                <span class="toolTipText tooltipIcon5">Sad</span>
              </div>
            </li>

            <li>
              <div class="tooltip">
                <img src="/Javbook/assets/img/emoji/angry.svg" alt="" />
                <span class="toolTipText tooltipIcon6">Angry</span>
              </div>
            </li>
          </ul>
        </div>
      </div>

      <div class="comment-status">
        <i class="far fa-comment-alt"></i>
        Comment
      </div>
      <div class="share">
        <i class="fas fa-share"></i>
        Share
      </div>
    </div>
  </div>

  <div class="comment box">
    <div class="comment-box">
      <div class="send-comment-box">
        <img
          src="${url}"
          alt=""
          class="ava_cmt user-avatar-send"
        />
        <textarea
          name="send=comment"
          class="send-text-comment"
          placeholder="Write a comment…"
        ></textarea>
        <button class="send-comment main-send" data-id="5MTOzkTN">
          <i class="fas fa-paper-plane"></i>
        </button>
      </div>
      <div class="comment-item">
        <div class="main-comment">
          <div class="comment-level-item"></div>
        </div>
      </div>
    </div>
  </div>

           `;
    postbox.innerHTML = html;
    document.querySelector(".list-post").prepend(postbox);
    text.value = "";
    postBox();

  }
  textarea.addEventListener('keydown', () => {
    setTimeout(() => {
      if (textarea.scrollHeight < 150) {
        textarea.style.cssText = 'height:auto; padding:0';
        textarea.style.cssText = 'height:' + textarea.scrollHeight + 'px';
      }

    }, 0);
  });
})();