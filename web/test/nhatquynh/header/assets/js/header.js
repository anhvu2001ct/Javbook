$(document).on("click", ".header_icon", function () {
  if ($(this).hasClass("active")) {
    $(this).removeClass("active");
    $(".popup_container").hide();
  } else {
    $(this).addClass("active").siblings().removeClass("active");
    $(".popup_container").show();
  }
  $(".popup_inner").hide();
  if ($(this)) {
    $(".popup_inner").show();
    console.log($(this));
  }
});
