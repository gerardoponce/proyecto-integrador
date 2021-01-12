//Custom Script

$(document).ready(function(){
    //Owl Banner Slider
    $("#banner-slider .owl-carousel").owlCarousel({
        items: 1,
        loop: true,
        autoplay: true,
        nav:true,
    });
    //Pedido
    $("#datetime").datetimepicker();
});


