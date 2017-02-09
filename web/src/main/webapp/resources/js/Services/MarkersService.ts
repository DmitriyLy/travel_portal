declare var google,jQuery,$:any;



export class MarkersService {
    static getMarker(id,callbacks:Function[]) {
        $.ajax({
            type: "GET",
            url: '/labels/' + id,
            dataType: 'json',
            success: (MarkerData) => {
                callbacks.forEach((callback, i, arr) => {
                    callback(MarkerData);
                });
            },
            error: (error) => {
                console.log(error);
                $.toast({
                    hideAfter: 5000,
                    heading: 'Произошла ошибка',
                    icon: 'error',
                    text: 'Произошла ошибка №'+error.status+'.<br>Более подробную информацию можно получить в консоли.<br>Просим прощения, за предоставленные неудобства.',
                    position: {
                        top: 75,
                        right: 20,
                    },
                    stack: 5
                });
            }
        });
    }

    static getBookmarkedMarkers(callbacks:Function[]) {
        $.ajax({
            type: "GET",
            url: '/users/me/labels/bookmarked',
            dataType: 'json',
            success: (MarkerData) => {
                callbacks.forEach((callback, i, arr) => {
                    callback(MarkerData);
                });
            },
            error: (error) => {
                console.log(error);
                $.toast({
                    hideAfter: 5000,
                    heading: 'Произошла ошибка',
                    icon: 'error',
                    text: 'Произошла ошибка №'+error.status+'.<br>Более подробную информацию можно получить в консоли.<br>Просим прощения, за предоставленные неудобства.',
                    position: {
                        top: 75,
                        right: 20,
                    },
                    stack: 5
                });
            }
        });
    }

    static addMarkerToBookmarks(id,callbacks:Function[]) {
        $.ajax({
            type: "POST",
            url: '/users/me/labels/bookmarked/'+id,
            dataType: 'json',
            // contentType: "application/json",
            // data: JSON.stringify({}),
            success: (MarkerData) => {
                callbacks.forEach((callback, i, arr) => {
                    callback(MarkerData);
                });
            },
            error: (error) => {
                console.log(error);
                $.toast({
                    hideAfter: 5000,
                    heading: 'Произошла ошибка',
                    icon: 'error',
                    text: 'Произошла ошибка №'+error.status+'.<br>Более подробную информацию можно получить в консоли.<br>Просим прощения, за предоставленные неудобства.',
                    position: {
                        top: 75,
                        right: 20,
                    },
                    stack: 5
                });
            }
        });
    }

    static deleteMarkerFromBookmarks(id,callbacks:Function[]) {
        $.ajax({
            type: "DELETE",
            url: '/users/me/labels/bookmarked/'+id,
            dataType: 'json',
            // contentType: "application/json",
            // data: JSON.stringify({}),
            success: (MarkerData) => {
                callbacks.forEach((callback, i, arr) => {
                    callback(MarkerData);
                });
            },
            error: (error) => {
                console.log(error);
                $.toast({
                    hideAfter: 5000,
                    heading: 'Произошла ошибка',
                    icon: 'error',
                    text: 'Произошла ошибка №'+error.status+'.<br>Более подробную информацию можно получить в консоли.<br>Просим прощения, за предоставленные неудобства.',
                    position: {
                        top: 75,
                        right: 20,
                    },
                    stack: 5
                });
            }
        });
    }


    static deleteMarker(id,callbacks:Function[]) {
        $.ajax({
            type: "DELETE",
            url: '/labels/' + id,
            success: (MarkerData) => {
                callbacks.forEach((callback, i, arr) => {
                    callback(MarkerData);
                });
            },
            error: (error) => {
                console.log(error);
                $.toast({
                    hideAfter: 5000,
                    heading: 'Произошла ошибка',
                    icon: 'error',
                    text: 'Произошла ошибка №'+error.status+'.<br>Более подробную информацию можно получить в консоли.<br>Просим прощения, за предоставленные неудобства.',
                    position: {
                        top: 75,
                        right: 20,
                    },
                    stack: 5
                });
            }
        });
    }


    static reserveMarkerId(callbacks:Function[]) {
        $.ajax({
            type: "GET",
            url: '/reserveLabelId',
            dataType: 'json',
            success: (markerId: any) => {
                callbacks.forEach((callback, i, arr) => {
                    callback(markerId);
                });
            },
            error: (error) => {
                console.log(error);
                $.toast({
                    hideAfter: 5000,
                    heading: 'Произошла ошибка',
                    icon: 'error',
                    text: 'Произошла ошибка №'+error.status+'.<br>Более подробную информацию можно получить в консоли.<br>Просим прощения, за предоставленные неудобства.',
                    position: {
                        top: 75,
                        right: 20,
                    },
                    stack: 5
                });
            }
        });
    }

    static addMarker(MarkerData:any,callbacks:Function[]) {
        $.ajax({
            type: "POST",
            contentType: "application/json",
            url: '/labels',
            data: JSON.stringify(MarkerData),
            dataType: 'json',
            success: (MarkerData) => {
                callbacks.forEach((callback, i, arr) => {
                    callback(MarkerData);
                });
            },
            error: (error) => {
                console.log(error);
                $.toast({
                    hideAfter: 5000,
                    heading: 'Произошла ошибка',
                    icon: 'error',
                    text: 'Произошла ошибка №'+error.status+'.<br>Более подробную информацию можно получить в консоли.<br>Просим прощения, за предоставленные неудобства.',
                    position: {
                        top: 75,
                        right: 20,
                    },
                    stack: 5
                });
            }
        });
    }

    static editMarker(id,MarkerData:any,callbacks:Function[]) {
        $.ajax({
            type: "PATCH",
            contentType: "application/json",
            url: '/labels/'+id,
            data: JSON.stringify(MarkerData),
            dataType: 'json',
            success: (MarkerData) => {
                callbacks.forEach((callback, i, arr) => {
                    callback(MarkerData);
                });
            },
            error: (error) => {
                console.log(error);
                $.toast({
                    hideAfter: 5000,
                    heading: 'Произошла ошибка',
                    icon: 'error',
                    text: 'Произошла ошибка №'+error.status+'.<br>Более подробную информацию можно получить в консоли.<br>Просим прощения, за предоставленные неудобства.',
                    position: {
                        top: 75,
                        right: 20,
                    },
                    stack: 5
                });
            }
        });
    }

    static searchMarkersByParameters(SearchData,callbacks:Function[]) {
        $.ajax({
            type: "POST",
            contentType: "application/json",
            url: '/labels/search/by/parameters',
            data: JSON.stringify(SearchData),
            dataType: 'json',
            success: (MarkersFoundData) => {
                callbacks.forEach((callback, i, arr) => {
                    callback(MarkersFoundData);
                });
            },
            error: (error) => {
                console.log(error);
                $.toast({
                    hideAfter: 5000,
                    heading: 'Произошла ошибка',
                    icon: 'error',
                    text: 'Произошла ошибка №'+error.status+'.<br>Более подробную информацию можно получить в консоли.<br>Просим прощения, за предоставленные неудобства.',
                    position: {
                        top: 75,
                        right: 20,
                    },
                    stack: 5
                });
            }
        });
    }



    static getMyMarkers(callbacks:Function[]) {
        $.ajax({
            type: "GET",
            url: '/users/me/labels/added',
            dataType: 'json',
            success: (MarkersData) => {
                callbacks.forEach((callback, i, arr) => {
                    callback(MarkersData);
                });
            },
            error: (error) => {
                console.log(error);
                $.toast({
                    hideAfter: 5000,
                    heading: 'Произошла ошибка',
                    icon: 'error',
                    text: 'Произошла ошибка №'+error.status+'.<br>Более подробную информацию можно получить в консоли.<br>Просим прощения, за предоставленные неудобства.',
                    position: {
                        top: 75,
                        right: 20,
                    },
                    stack: 5
                });
            }
        });
    }

    static getCommentedMarkers(callbacks:Function[]) {
        $.ajax({
            type: "GET",
            url: '/users/me/labels/commented',
            dataType: 'json',
            success: (MarkersData) => {
                callbacks.forEach((callback, i, arr) => {
                    callback(MarkersData);
                });
            },
            error: (error) => {
                console.log(error);
                $.toast({
                    hideAfter: 5000,
                    heading: 'Произошла ошибка',
                    icon: 'error',
                    text: 'Произошла ошибка №'+error.status+'.<br>Более подробную информацию можно получить в консоли.<br>Просим прощения, за предоставленные неудобства.',
                    position: {
                        top: 75,
                        right: 20,
                    },
                    stack: 5
                });
            }
        });
    }

    static searchMarkersByPhrase(phrase,callbacks:Function[]) {
        callbacks.forEach((callback, i, arr) => {
            callback(phrase);
        });
    }
}