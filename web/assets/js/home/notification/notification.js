// Toast function
function toast({
  title = "",
  message = "",
  image = "",
  type = "",
  link= "#",
  duration = 3000,
}) {
  const main = document.getElementById("toast");
  if (main) {
    const toast = document.createElement("div");

    // Auto remove toast
    const autoRemoveId = setTimeout(function () {
      main.removeChild(toast);
    }, duration + 1000);

    // Remove toast when clicked
    toast.onclick = function (e) {
      if (e.target.closest(".toast__close")) {
        main.removeChild(toast);
        clearTimeout(autoRemoveId);
      }
    };

    const srcimg = image;
    const delay = (duration / 1000).toFixed(2);

    toast.classList.add("toast", `toast--${type}`);
    toast.style.animation = `slideInLeft ease .3s, fadeOut linear 1s ${delay}s forwards`;

    toast.innerHTML = `
                      <div class="toast__icon">
                        <a class="wh_40" href="${link}"
                            ><img
                                src="${srcimg}"
                                alt=""
                                class="scale wh_40 circle"
                        /></a>
                      </div>
                      <div class="toast__body">
                        <span class="toast__msg"><strong>${title} </strong>${message}</span><br>
                        <span class="notification_time">vài giây trước</span>
                      </div>
                      <div class="toast__close">
                          <i class="fas fa-times"></i>
                      </div>
                  `;
    main.appendChild(toast);
  }
}
