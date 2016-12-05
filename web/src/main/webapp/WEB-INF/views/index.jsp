<%@ taglib prefix="spring" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:set var="contextPath" value="${pageContext.request.contextPath}"/>
<c:set var="googleMapsAPIKey" value="AIzaSyAB7I9khA0R1g7Ug_lOq4-AD1zkvIdFHQI"/>

<!DOCTYPE html>
<html>
    <head>
        <title>Travel Portal</title>
        <link rel="stylesheet" type="text/css" href="//fonts.googleapis.com/css?family=Roboto:300,400,500,700">
        <link rel="stylesheet" type="text/css" href="//fonts.googleapis.com/icon?family=Material+Icons">
        <link rel="stylesheet" type="text/css" href="${contextPath}/css/bootstrap/bootstrap.min.css"/>
        <link rel="stylesheet" type="text/css" href="${contextPath}/css/bootstrap/bootstrap-theme.min.css"/>
        <link rel="stylesheet" type="text/css" href="${contextPath}/css/font-awesome/font-awesome.min.css"/>
        <link rel="stylesheet" type="text/css" href="${contextPath}/css/mmenu/jquery.mmenu.all.css"/>
        <link rel="stylesheet" type="text/css" href="${contextPath}/css/material-design/bootstrap-material-design.css">
        <link rel="stylesheet" type="text/css" href="${contextPath}/css/material-design/ripples.min.css">
        <link rel="stylesheet" type="text/css" href="${contextPath}/css/style.css"/>
    </head>
    <body>
        <div id="header-menu" class="navbar navbar-fixed-top navbar-default"> <!-- navbar-inverse -->
            <div class="container">
                <a id="open-sidebar-menu" href="#menu" class="pull-left" style="display:none;"><i class="fa fa-bars fa-2x" aria-hidden="true"></i></a>
                <div class="pull-left title">
                    <img src="${contextPath}/images/logo.png" alt="logo image" class="logo-image">
                    <span>Travel Portal</span>
                </div>
            </div>
        </div>
        <div class="container-fluid fill container-navbar-padding">
            <div id="map"></div>
            <div id="actions-container">
                <ul id="subactions-container">
                    <li><a href="javascript:void(0)" class="btn btn-fab btn-fab-mini" id="zoom-in-button"><i class="material-icons">zoom_in</i></a></li>
                    <li><a href="javascript:void(0)" class="btn btn-fab btn-fab-mini" id="zoom-out-button"><i class="material-icons">zoom_out</i></a></li>
                </ul>
                <a href="javascript:void(0)" id="addMarkerButton" class="btn btn-fab toggle-icon" data-std-icon="more_vert" data-hover-icon="add_location"><i class="material-icons">more_vert</i></a> <!-- more_vert | add_location -->
            </div>

            <!-- Window Container -->
            <div id="windows-container">

            </div>
            <!-- /Window Container -->
        </div>

        <!-- APP LIKE MENU -->
        <nav id="menu">
            <ul>
                <li><a href="/">Home</a></li>
                <li><a href="/about">About us</a>
                    <ul>
                        <li><a href="/about/history">History</a></li>
                        <li><a href="/about/team">The team</a></li>
                        <li><a href="/about/address">Our address</a></li>
                    </ul>
                </li>
                <li><a href="/contact">Contact</a></li>
            </ul>
        </nav>

        <!-- SCRIPTS MUST BE AFTER THAT LINE -->
        <script type="text/javascript">
            var GOOGLE_MAP_API_KEY  = "${googleMapsAPIKey}",
                RESOURCES_DIR       = "${contextPath}";
        </script>
        <!-- GLOBAL VARS MUST BE BEFORE THAT LINE -->
        <script type="text/javascript" src="${contextPath}/js/ThirdPartyLibraries/jquery/jquery.min.js"></script>
        <script type="text/javascript" src="${contextPath}/js/ThirdPartyLibraries/bootstrap/bootstrap.min.js"></script>
        <script type="text/javascript" src="${contextPath}/js/ThirdPartyLibraries/material-design/material.min.js"></script>
        <script type="text/javascript" src="${contextPath}/js/ThirdPartyLibraries/material-design/ripples.min.js"></script>
        <script type="text/javascript" src="${contextPath}/js/ThirdPartyLibraries/mmenu/jquery.mmenu.all.min.js"></script>
        <script type="text/javascript" src="${contextPath}/js/Controllers/MapController.js"></script>
        <script type="text/javascript" src="${contextPath}/js/Controllers/MapController.Windows.js"></script>
        <script type="text/javascript" src="https://maps.googleapis.com/maps/api/js?key=GOOGLE_MAP_API_KEY"></script>
        <script type="text/javascript">
            if(jQuery==="undefined"){
                console.log("Please add jQuery v2.1.4 to the page before that script.")
            } else {
                var MapSingletone;
                (function ($) {
                    $(document).ready(function () {
                        MapSingletone = new MapController('map', {
                            zoom: 11,
                            center: new google.maps.LatLng(40.6700, -73.9400),
                            disableDefaultUI: true,
                            //styles: [{"featureType":"all","elementType":"labels.text.fill","stylers":[{"saturation":36},{"color":"#000000"},{"lightness":40}]},{"featureType":"all","elementType":"labels.text.stroke","stylers":[{"visibility":"on"},{"color":"#000000"},{"lightness":16}]},{"featureType":"all","elementType":"labels.icon","stylers":[{"visibility":"off"}]},{"featureType":"administrative","elementType":"geometry.fill","stylers":[{"color":"#000000"},{"lightness":20}]},{"featureType":"administrative","elementType":"geometry.stroke","stylers":[{"color":"#000000"},{"lightness":17},{"weight":1.2}]},{"featureType":"administrative.country","elementType":"labels.text","stylers":[{"color":"#fb7f41"},{"weight":"0.01"}]},{"featureType":"administrative.locality","elementType":"labels","stylers":[{"visibility":"on"}]},{"featureType":"administrative.neighborhood","elementType":"labels","stylers":[{"visibility":"simplified"}]},{"featureType":"administrative.neighborhood","elementType":"labels.text.fill","stylers":[{"lightness":"17"}]},{"featureType":"administrative.land_parcel","elementType":"labels","stylers":[{"visibility":"off"}]},{"featureType":"landscape","elementType":"geometry","stylers":[{"color":"#000000"},{"lightness":20}]},{"featureType":"landscape","elementType":"labels","stylers":[{"visibility":"on"}]},{"featureType":"landscape.man_made","elementType":"labels","stylers":[{"visibility":"off"}]},{"featureType":"landscape.man_made","elementType":"labels.text","stylers":[{"visibility":"off"}]},{"featureType":"landscape.natural","elementType":"labels","stylers":[{"visibility":"on"}]},{"featureType":"poi","elementType":"geometry","stylers":[{"color":"#000000"},{"lightness":21},{"visibility":"off"}]},{"featureType":"poi","elementType":"labels","stylers":[{"visibility":"off"}]},{"featureType":"road","elementType":"labels","stylers":[{"visibility":"simplified"}]},{"featureType":"road.highway","elementType":"geometry","stylers":[{"visibility":"on"},{"color":"#ff4700"}]},{"featureType":"road.highway","elementType":"geometry.fill","stylers":[{"lightness":17}]},{"featureType":"road.highway","elementType":"geometry.stroke","stylers":[{"color":"#000000"},{"lightness":29},{"weight":0.2}]},{"featureType":"road.highway","elementType":"labels","stylers":[{"invert_lightness":true},{"visibility":"off"}]},{"featureType":"road.highway.controlled_access","elementType":"geometry.fill","stylers":[{"color":"#3b3b3b"}]},{"featureType":"road.arterial","elementType":"geometry","stylers":[{"color":"#000000"},{"lightness":18}]},{"featureType":"road.arterial","elementType":"geometry.fill","stylers":[{"color":"#ff4700"},{"lightness":"39"},{"gamma":"0.43"},{"saturation":"-47"}]},{"featureType":"road.arterial","elementType":"labels","stylers":[{"visibility":"off"}]},{"featureType":"road.local","elementType":"geometry","stylers":[{"color":"#000000"},{"lightness":16}]},{"featureType":"road.local","elementType":"geometry.stroke","stylers":[{"color":"#555555"}]},{"featureType":"road.local","elementType":"labels","stylers":[{"visibility":"off"}]},{"featureType":"transit","elementType":"geometry","stylers":[{"color":"#000000"},{"lightness":19}]},{"featureType":"water","elementType":"geometry","stylers":[{"color":"#000000"},{"lightness":17}]}]
                            styles: [{"featureType":"landscape","elementType":"geometry","stylers":[{"saturation":"-100"}]},{"featureType":"poi","elementType":"labels","stylers":[{"visibility":"off"}]},{"featureType":"poi","elementType":"labels.text.stroke","stylers":[{"visibility":"off"}]},{"featureType":"road","elementType":"labels.text","stylers":[{"color":"#545454"}]},{"featureType":"road","elementType":"labels.text.stroke","stylers":[{"visibility":"off"}]},{"featureType":"road.highway","elementType":"geometry.fill","stylers":[{"saturation":"-87"},{"lightness":"-40"},{"color":"#ffffff"}]},{"featureType":"road.highway","elementType":"geometry.stroke","stylers":[{"visibility":"off"}]},{"featureType":"road.highway.controlled_access","elementType":"geometry.fill","stylers":[{"color":"#f0f0f0"},{"saturation":"-22"},{"lightness":"-16"}]},{"featureType":"road.highway.controlled_access","elementType":"geometry.stroke","stylers":[{"visibility":"off"}]},{"featureType":"road.highway.controlled_access","elementType":"labels.icon","stylers":[{"visibility":"on"}]},{"featureType":"road.arterial","elementType":"geometry.stroke","stylers":[{"visibility":"off"}]},{"featureType":"road.local","elementType":"geometry.stroke","stylers":[{"visibility":"off"}]},{"featureType":"water","elementType":"geometry.fill","stylers":[{"saturation":"-52"},{"hue":"#00e4ff"},{"lightness":"-16"}]}]
                        });
                    });
                })(jQuery);
            }
        </script> 
        <script type="text/javascript" src="${contextPath}/js/custom.js"></script>
    </body>
</html>