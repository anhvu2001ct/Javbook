const mess = document.querySelector(".mess");
const add = document.querySelector(".add");
const friend = document.querySelector(".friend");

console.log(mess, friend, add);
function isFriend(isFriend) {
    if (isFriend) {
        mess.style.display = "block"
        friend.style.display = "block"
        add.style.display = "none"
    } else {
        add.style.display = "block"
        mess.style.display = "none"
        friend.style.display = "none"
    }
}
