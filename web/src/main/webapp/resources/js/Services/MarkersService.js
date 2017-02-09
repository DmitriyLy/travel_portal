define(["require", "exports"], function (require, exports) {
    "use strict";
    var MarkersService = (function () {
        function MarkersService() {
        }
        MarkersService.getMarker = function (id, callbacks) {
            $.ajax({
                type: "GET",
                url: '/labels/' + id,
                dataType: 'json',
                success: function (MarkerData) {
                    callbacks.forEach(function (callback, i, arr) {
                        callback(MarkerData);
                    });
                },
                error: function (error) {
                    console.log(error);
                    $.toast({
                        hideAfter: 5000,
                        heading: 'Произошла ошибка',
                        icon: 'error',
                        text: 'Произошла ошибка №' + error.status + '.<br>Более подробную информацию можно получить в консоли.<br>Просим прощения, за предоставленные неудобства.',
                        position: {
                            top: 75,
                            right: 20,
                        },
                        stack: 5
                    });
                }
            });
        };
        MarkersService.getBookmarkedMarkers = function (callbacks) {
            $.ajax({
                type: "GET",
                url: '/users/me/labels/bookmarked',
                dataType: 'json',
                success: function (MarkerData) {
                    callbacks.forEach(function (callback, i, arr) {
                        callback(MarkerData);
                    });
                },
                error: function (error) {
                    console.log(error);
                    $.toast({
                        hideAfter: 5000,
                        heading: 'Произошла ошибка',
                        icon: 'error',
                        text: 'Произошла ошибка №' + error.status + '.<br>Более подробную информацию можно получить в консоли.<br>Просим прощения, за предоставленные неудобства.',
                        position: {
                            top: 75,
                            right: 20,
                        },
                        stack: 5
                    });
                }
            });
        };
        MarkersService.addMarkerToBookmarks = function (id, callbacks) {
            $.ajax({
                type: "POST",
                url: '/users/me/labels/bookmarked/' + id,
                dataType: 'json',
                // contentType: "application/json",
                // data: JSON.stringify({}),
                success: function (MarkerData) {
                    callbacks.forEach(function (callback, i, arr) {
                        callback(MarkerData);
                    });
                },
                error: function (error) {
                    console.log(error);
                    $.toast({
                        hideAfter: 5000,
                        heading: 'Произошла ошибка',
                        icon: 'error',
                        text: 'Произошла ошибка №' + error.status + '.<br>Более подробную информацию можно получить в консоли.<br>Просим прощения, за предоставленные неудобства.',
                        position: {
                            top: 75,
                            right: 20,
                        },
                        stack: 5
                    });
                }
            });
        };
        MarkersService.deleteMarkerFromBookmarks = function (id, callbacks) {
            $.ajax({
                type: "DELETE",
                url: '/users/me/labels/bookmarked/' + id,
                dataType: 'json',
                // contentType: "application/json",
                // data: JSON.stringify({}),
                success: function (MarkerData) {
                    callbacks.forEach(function (callback, i, arr) {
                        callback(MarkerData);
                    });
                },
                error: function (error) {
                    console.log(error);
                    $.toast({
                        hideAfter: 5000,
                        heading: 'Произошла ошибка',
                        icon: 'error',
                        text: 'Произошла ошибка №' + error.status + '.<br>Более подробную информацию можно получить в консоли.<br>Просим прощения, за предоставленные неудобства.',
                        position: {
                            top: 75,
                            right: 20,
                        },
                        stack: 5
                    });
                }
            });
        };
        MarkersService.deleteMarker = function (id, callbacks) {
            $.ajax({
                type: "DELETE",
                url: '/labels/' + id,
                success: function (MarkerData) {
                    callbacks.forEach(function (callback, i, arr) {
                        callback(MarkerData);
                    });
                },
                error: function (error) {
                    console.log(error);
                    $.toast({
                        hideAfter: 5000,
                        heading: 'Произошла ошибка',
                        icon: 'error',
                        text: 'Произошла ошибка №' + error.status + '.<br>Более подробную информацию можно получить в консоли.<br>Просим прощения, за предоставленные неудобства.',
                        position: {
                            top: 75,
                            right: 20,
                        },
                        stack: 5
                    });
                }
            });
        };
        MarkersService.reserveMarkerId = function (callbacks) {
            $.ajax({
                type: "GET",
                url: '/reserveLabelId',
                dataType: 'json',
                success: function (markerId) {
                    callbacks.forEach(function (callback, i, arr) {
                        callback(markerId);
                    });
                },
                error: function (error) {
                    console.log(error);
                    $.toast({
                        hideAfter: 5000,
                        heading: 'Произошла ошибка',
                        icon: 'error',
                        text: 'Произошла ошибка №' + error.status + '.<br>Более подробную информацию можно получить в консоли.<br>Просим прощения, за предоставленные неудобства.',
                        position: {
                            top: 75,
                            right: 20,
                        },
                        stack: 5
                    });
                }
            });
        };
        MarkersService.addMarker = function (MarkerData, callbacks) {
            $.ajax({
                type: "POST",
                contentType: "application/json",
                url: '/labels',
                data: JSON.stringify(MarkerData),
                dataType: 'json',
                success: function (MarkerData) {
                    callbacks.forEach(function (callback, i, arr) {
                        callback(MarkerData);
                    });
                },
                error: function (error) {
                    console.log(error);
                    $.toast({
                        hideAfter: 5000,
                        heading: 'Произошла ошибка',
                        icon: 'error',
                        text: 'Произошла ошибка №' + error.status + '.<br>Более подробную информацию можно получить в консоли.<br>Просим прощения, за предоставленные неудобства.',
                        position: {
                            top: 75,
                            right: 20,
                        },
                        stack: 5
                    });
                }
            });
        };
        MarkersService.editMarker = function (id, MarkerData, callbacks) {
            $.ajax({
                type: "PATCH",
                contentType: "application/json",
                url: '/labels/' + id,
                data: JSON.stringify(MarkerData),
                dataType: 'json',
                success: function (MarkerData) {
                    callbacks.forEach(function (callback, i, arr) {
                        callback(MarkerData);
                    });
                },
                error: function (error) {
                    console.log(error);
                    $.toast({
                        hideAfter: 5000,
                        heading: 'Произошла ошибка',
                        icon: 'error',
                        text: 'Произошла ошибка №' + error.status + '.<br>Более подробную информацию можно получить в консоли.<br>Просим прощения, за предоставленные неудобства.',
                        position: {
                            top: 75,
                            right: 20,
                        },
                        stack: 5
                    });
                }
            });
        };
        MarkersService.searchMarkersByParameters = function (SearchData, callbacks) {
            $.ajax({
                type: "POST",
                contentType: "application/json",
                url: '/labels/search/by/parameters',
                data: JSON.stringify(SearchData),
                dataType: 'json',
                success: function (MarkersFoundData) {
                    callbacks.forEach(function (callback, i, arr) {
                        callback(MarkersFoundData);
                    });
                },
                error: function (error) {
                    console.log(error);
                    $.toast({
                        hideAfter: 5000,
                        heading: 'Произошла ошибка',
                        icon: 'error',
                        text: 'Произошла ошибка №' + error.status + '.<br>Более подробную информацию можно получить в консоли.<br>Просим прощения, за предоставленные неудобства.',
                        position: {
                            top: 75,
                            right: 20,
                        },
                        stack: 5
                    });
                }
            });
        };
        MarkersService.getMyMarkers = function (callbacks) {
            $.ajax({
                type: "GET",
                url: '/users/me/labels/added',
                dataType: 'json',
                success: function (MarkersData) {
                    callbacks.forEach(function (callback, i, arr) {
                        callback(MarkersData);
                    });
                },
                error: function (error) {
                    console.log(error);
                    $.toast({
                        hideAfter: 5000,
                        heading: 'Произошла ошибка',
                        icon: 'error',
                        text: 'Произошла ошибка №' + error.status + '.<br>Более подробную информацию можно получить в консоли.<br>Просим прощения, за предоставленные неудобства.',
                        position: {
                            top: 75,
                            right: 20,
                        },
                        stack: 5
                    });
                }
            });
        };
        MarkersService.getCommentedMarkers = function (callbacks) {
            $.ajax({
                type: "GET",
                url: '/users/me/labels/commented',
                dataType: 'json',
                success: function (MarkersData) {
                    callbacks.forEach(function (callback, i, arr) {
                        callback(MarkersData);
                    });
                },
                error: function (error) {
                    console.log(error);
                    $.toast({
                        hideAfter: 5000,
                        heading: 'Произошла ошибка',
                        icon: 'error',
                        text: 'Произошла ошибка №' + error.status + '.<br>Более подробную информацию можно получить в консоли.<br>Просим прощения, за предоставленные неудобства.',
                        position: {
                            top: 75,
                            right: 20,
                        },
                        stack: 5
                    });
                }
            });
        };
        MarkersService.searchMarkersByPhrase = function (phrase, callbacks) {
            callbacks.forEach(function (callback, i, arr) {
                callback(phrase);
            });
        };
        return MarkersService;
    }());
    exports.MarkersService = MarkersService;
});
