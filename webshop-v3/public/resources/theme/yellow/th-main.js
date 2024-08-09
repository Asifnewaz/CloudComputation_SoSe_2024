/*
Template Name: ShopGrids - Bootstrap 5 eCommerce HTML Template.
Author: GrayGrids
*/

$(function () {
    window.onload = function () {
        window.setTimeout(fadeout, 500);
    }
    function fadeout() {
        document.querySelector('.preloader').style.opacity = '0';
        document.querySelector('.preloader').style.display = 'none';
    }

    $(window).scroll(function () {
        var scrollTop = $(window).scrollTop();
        if (scrollTop > 250) {
            if (!$("#siteSkikyPart").hasClass("sticky-site-div")) {
                $("#siteSkikyPart").addClass("sticky-site-div");
            }
        } else {
            if ($("#siteSkikyPart").hasClass("sticky-site-div")) {
                $("#siteSkikyPart").removeClass("sticky-site-div");
            }
        }
    });
});