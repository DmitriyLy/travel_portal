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
        <link rel="stylesheet" type="text/css" href="${contextPath}/resources/css/bootstrap/bootstrap.min.css"/>
        <link rel="stylesheet" type="text/css" href="${contextPath}/resources/css/bootstrap/bootstrap-theme.min.css"/>
        <link rel="stylesheet" type="text/css" href="${contextPath}/resources/css/font-awesome/font-awesome.min.css"/>
        <link rel="stylesheet" type="text/css" href="${contextPath}/resources/css/mmenu/jquery.mmenu.all.css"/>
        <link rel="stylesheet" type="text/css" href="${contextPath}/resources/css/featherlight/featherlight.css"/>
        <link rel="stylesheet" type="text/css" href="${contextPath}/resources/css/featherlight/featherlight.gallery.css"/>
        <%--<link rel="stylesheet" type="text/css" href="${contextPath}/resources/css/material-design/bootstrap-material-design.css">--%>
        <%--<link rel="stylesheet" type="text/css" href="${contextPath}/resources/css/material-design/ripples.min.css">--%>
        <link rel="stylesheet" type="text/css" href="${contextPath}/resources/css/style.css"/>
        <link rel="stylesheet" type="text/css" href="${contextPath}/resources/css/dark-style.css"/>
    </head>
    <body>
        <div id="header-menu" class="navbar navbar-fixed-top navbar-default"> <!-- navbar-inverse -->
            <div class="container">
                <a id="open-sidebar-menu" href="#menu" class="pull-left" style="display:none;"><i class="fa fa-bars fa-2x" aria-hidden="true"></i></a>
                <div class="pull-left title">
                    <img src="${contextPath}/resources/images/logo.png" alt="logo image" class="logo-image">
                    <span>Travel Portal</span>
                </div>
                <div class="pull-right">
                    <span id="dn-mode-button"><i class="fa fa-moon-o" aria-hidden="true"></i></span>
                    <span>Name: ${pageContext.request.userPrincipal.name}</span>
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
        <script type="text/javascript" src="${contextPath}/resources/js/ThirdPartyLibraries/jquery/jquery.min.js"></script>
        <script type="text/javascript" src="${contextPath}/resources/js/ThirdPartyLibraries/bootstrap/bootstrap.min.js"></script>
        <!--<script type="text/javascript" src="${contextPath}/resources/js/ThirdPartyLibraries/material-design/material.min.js"></script>
        <script type="text/javascript" src="${contextPath}/resources/js/ThirdPartyLibraries/material-design/ripples.min.js"></script>-->
        <script type="text/javascript" src="${contextPath}/resources/js/ThirdPartyLibraries/mmenu/jquery.mmenu.all.min.js"></script>
        <script type="text/javascript" src="${contextPath}/resources/js/ThirdPartyLibraries/heredoc/heredoc.js"></script>
        <script type="text/javascript" src="${contextPath}/resources/js/ThirdPartyLibraries/featherlight/featherlight.js"></script>
        <script type="text/javascript" src="${contextPath}/resources/js/ThirdPartyLibraries/featherlight/featherlight.gallery.js"></script>
        <%--<script type="text/javascript" src="${contextPath}/resources/js/Helpers/ReplaceTemplateVars.js"></script>--%>
        <script src="https://developers.google.com/maps/documentation/javascript/examples/markerclusterer/markerclusterer.js"></script>
        <script type="text/javascript" src="https://maps.googleapis.com/maps/api/js?key=${googleMapsAPIKey}"></script>
        <script type="text/javascript" src="${contextPath}/resources/js/ThirdPartyLibraries/requirejs/require.js" data-main="${contextPath}/resources/js/init.js"></script>
    </body>
</html>