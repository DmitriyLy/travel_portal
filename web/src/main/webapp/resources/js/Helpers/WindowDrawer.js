define(["require", "exports", "../Controllers/AppController", "../Controllers/WindowController", "../Views/TagViewHolder", "../Views/MarkerView", "../Views/CommentsViewHolder", "../Views/AttachmentsViewHolder", "../Views/CommentsView", "../Views/CommentsFormView", "../Views/CommentsRegisterFormView", "./ActionBinder", "../Views/CreateMarkerView"], function (require, exports, AppController_1, WindowController_1, TagViewHolder_1, MarkerView_1, CommentsViewHolder_1, AttachmentsViewHolder_1, CommentsView_1, CommentsFormView_1, CommentsRegisterFormView_1, ActionBinder_1, CreateMarkerView_1) {
    "use strict";
    var WindowDrawer = (function () {
        function WindowDrawer() {
        }
        WindowDrawer.drawMarkerWindow = function (id, callback) {
            if (callback === void 0) { callback = null; }
            $.ajax({
                type: "GET",
                url: 'http://nctravelportal.ddns.net/labels/' + id,
                dataType: 'json',
                success: function (MarkerData) {
                    var result = new WindowController_1.WindowController(AppController_1.AppController.instances[0], 'О Метке', new MarkerView_1.MarkerView({
                        "marker_id": MarkerData.id,
                        "owner_id": MarkerData.owner.id,
                        "owner_name": MarkerData.owner.userName,
                        "creationDate": MarkerData.creationDate,
                        "address": 
                        /*MarkerData.address.country + ", " +
                        MarkerData.address.state + ". " +
                        MarkerData.address.city + ". " +
                        MarkerData.address.street + ", " +
                        MarkerData.address.building*/ MarkerData.address.street,
                        "rating": MarkerData.rating,
                        "review": MarkerData.review,
                        "categories": MarkerData.categories.map(function (itm) {
                            return (new TagViewHolder_1.TagViewHolder({
                                'name': itm
                            })).render();
                        }).join(' '),
                        "tags": MarkerData.tags.map(function (itm) {
                            return (new TagViewHolder_1.TagViewHolder({
                                'name': itm
                            })).render();
                        }).join(' '),
                        "attachments": MarkerData.attachments.map(function (itm) {
                            return (new AttachmentsViewHolder_1.AttachmentsViewHolder({
                                'full': itm.name,
                                'thumb': itm.name
                            })).render();
                        }).join(''),
                        "commentCount": MarkerData.commentCount
                    }));
                    if (typeof callback === "function")
                        callback(result);
                    ActionBinder_1.ActionBinder.pushState('#marker-' + id);
                },
                error: function (error) { alert("Произошла ошибка, пожалуйста, попробуйте позже."); }
            });
        };
        WindowDrawer.drawCreateMarkerWindow = function (markerId, latitude, longtitude, callback) {
            if (callback === void 0) { callback = null; }
            var AddressData;
            $.ajax({
                type: "GET",
                url: 'https://maps.google.com/maps/api/geocode/json?latlng=' + latitude + ',' + longtitude + '&sensor=false&key=' + GOOGLE_MAP_API_KEY,
                dataType: 'json',
                success: function (MarkerCommentsData) {
                    AddressData = MarkerCommentsData;
                    console.log(MarkerCommentsData);
                },
                async: false,
                error: function (error) { alert("Произошла ошибка, пожалуйста, попробуйте позже."); }
            });
            var result = new WindowController_1.WindowController(AppController_1.AppController.instances[0], 'О Метке', new CreateMarkerView_1.CreateMarkerView({
                "address": AddressData.results.map(function (item) { return '<option>' + item.formatted_address + '</option>'; })
            }));
            if (typeof callback === "function")
                callback(result);
            return result;
        };
        WindowDrawer.drawCommentWindow = function (id, window, callback) {
            if (callback === void 0) { callback = null; }
            $.ajax({
                type: "GET",
                url: 'http://nctravelportal.ddns.net/labels/' + id + '/comments',
                dataType: 'json',
                success: function (MarkerCommentsData) {
                    var result = new WindowController_1.WindowController(AppController_1.AppController.instances[0], 'Коментарии', new CommentsView_1.CommentsView({
                        'comments': MarkerCommentsData.map(function (comment) {
                            return (new CommentsViewHolder_1.CommentsViewHolder({
                                'id': comment.id,
                                'owner_id': comment.owner.id,
                                'owner_name': comment.owner.userName,
                                'creationDate': comment.creationDate,
                                'text': comment.text
                            })).render();
                        }).join(''),
                        'form': IS_AUTHENTICATED !== false ? (new CommentsFormView_1.CommentsFormView({
                            'marker_id': id
                        })) : (new CommentsRegisterFormView_1.CommentsRegisterFormView({
                            // TODO: REDIRECT AFTER LOGIN
                            // 'facebook_url':'/auth/facebook?fallback_url='+encodeURI('#marker-comments-'+id),
                            // 'google_url':'/auth/google?fallback_url='+encodeURI('#marker-comments-'+id)
                            'facebook_url': '/auth/facebook',
                            'google_url': '/auth/google'
                        }))
                    }), window);
                    if (typeof callback === "function")
                        callback(result);
                    ActionBinder_1.ActionBinder.pushState('#marker-comments-' + id);
                },
                error: function (error) { alert("Произошла ошибка, пожалуйста, попробуйте позже."); }
            });
        };
        return WindowDrawer;
    }());
    exports.WindowDrawer = WindowDrawer;
});
