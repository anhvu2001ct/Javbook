const chatFriendEmoji = document.querySelector(".chat-friend-emoji");
const addFriendEmoji = document.querySelector(".add-friend-emoji");
const selectQuantityEmoji = document.querySelectorAll(".nav-header-emoji li");
const showQuantityEmoji = document.querySelectorAll(".list-friend-emoji > div");

document.querySelector(".dropdown-emoji-exit").onclick=()=>{
    document.querySelector(".main-emoji-popup").style.display="none";
}
selectQuantityEmoji.forEach((select, index) => {
    if(index!=0&&index!=selectQuantityEmoji.length-1){
        let content = parseInt(select.querySelector("p").textContent) 
        if(content == 0){
            select.style.display = "none"
        }
        if(content>99){
            select.querySelector("p").innerText="99+"
        }
    }
    
    if (select.className != "last-emoji" ) {
        select.onclick = () => {
            
            document.querySelector(".active-display-quantity-emoji").classList.remove("active-display-quantity-emoji");
            document.querySelector(".active-emoji").classList.remove("active-emoji");
            if (index === 0) {
                select.classList.add("active-emoji");
                showQuantityEmoji[0].classList.add("active-display-quantity-emoji");
                
            }else{
                
            if (select.querySelector("img").src.includes("like")) {
                select.classList.add("active-emoji");
                showQuantityEmoji[1].classList.add("active-display-quantity-emoji");
            }
            if (select.querySelector("img").src.includes("love")) {
                select.classList.add("active-emoji");

                showQuantityEmoji[2].classList.add("active-display-quantity-emoji");
            }
            if (select.querySelector("img").src.includes("care")) {
                select.classList.add("active-emoji");
                showQuantityEmoji[3].classList.add("active-display-quantity-emoji");
            }
            if (select.querySelector("img").src.includes("haha")) {
                select.classList.add("active-emoji");
                showQuantityEmoji[4].classList.add("active-display-quantity-emoji");
            }
            if (select.querySelector("img").src.includes("sad")) {
                select.classList.add("active-emoji");
                showQuantityEmoji[5].classList.add("active-display-quantity-emoji");
            }
            if (select.querySelector("img").src.includes("angry")) {
                select.classList.add("active-emoji");
                showQuantityEmoji[6].classList.add("active-display-quantity-emoji");
            }
            }
           

        }
    }

})


function isFriendEmoji(isFriend) {
    if (isFriend) {
        chatFriendEmoji.style.display = "block";
        addFriendEmoji.style.display = "none";
    }
    else {
        chatFriendEmoji.style.display = "none";
        addFriendEmoji.style.display = "block";
    }
}