define(["require", "exports", "../Controllers/AppController", "../Controllers/WindowController", "../Views/TagViewHolder", "../Views/MarkerView", "../Views/CommentsViewHolder", "../Views/AttachmentsViewHolder", "../Views/CommentsView", "../Views/CommentsFormView", "../Views/CommentsRegisterFormView", "./ActionBinder", "../Views/CreateMarkerView", "../Views/MarkersOverviewView", "../Views/MarkerOverviewViewHolder", "../Views/SearchView", "../Services/AttachmentsService"], function (require, exports, AppController_1, WindowController_1, TagViewHolder_1, MarkerView_1, CommentsViewHolder_1, AttachmentsViewHolder_1, CommentsView_1, CommentsFormView_1, CommentsRegisterFormView_1, ActionBinder_1, CreateMarkerView_1, MarkersOverviewView_1, MarkerOverviewViewHolder_1, SearchView_1, AttachmentsService_1) {
    "use strict";
    var WindowDrawer = (function () {
        function WindowDrawer() {
        }
        WindowDrawer.drawMarkerWindow = function (MarkerData, window, callbacks) {
            if (window === void 0) { window = undefined; }
            if (callbacks === void 0) { callbacks = []; }
            var result = new WindowController_1.WindowController(AppController_1.AppController.instances[0], 'О Метке', new MarkerView_1.MarkerView({
                'marker_id': MarkerData.id,
                'owner_id': MarkerData.owner.id,
                'owner_name': MarkerData.owner.userName,
                'creationDate': MarkerData.creationDate,
                'address': 
                /*MarkerData.address.country + ', ' +
                 MarkerData.address.state + '. ' +
                 MarkerData.address.city + '. ' +
                 MarkerData.address.street + ', ' +
                 MarkerData.address.building*/ MarkerData.address.street,
                'rating': MarkerData.rating,
                'review': MarkerData.review,
                'categories': MarkerData.categories.map(function (itm) {
                    return (new TagViewHolder_1.TagViewHolder({
                        'name': itm
                    })).render();
                }).join(' '),
                'tags': MarkerData.tags.map(function (itm) {
                    return (new TagViewHolder_1.TagViewHolder({
                        'name': itm
                    })).render();
                }).join(' '),
                'attachments': MarkerData.attachments.map(function (itm) {
                    return (new AttachmentsViewHolder_1.AttachmentsViewHolder({
                        'id': itm.id,
                        'full': itm.name,
                        'thumb': itm.nightstand
                    })).render();
                }).join(''),
                'categories_visibility': MarkerData.categories.length ? '' : 'hidden',
                'tags_visibility': MarkerData.tags.length ? '' : 'hidden',
                'attachments_visibility': MarkerData.attachments.length ? '' : 'hidden',
                'commentCount': MarkerData.commentCount,
                'actions_visibility': MarkerData.owner.id == USER_ID ? '' : 'hidden'
            }), window);
            ActionBinder_1.ActionBinder.pushState('#marker-' + MarkerData.id);
            callbacks.forEach(function (callback, i, arr) {
                callback(result);
            });
            return result;
        };
        WindowDrawer.drawCreateMarkerWindow = function (MarkerData, AddressData, Categories, window, callbacks) {
            if (window === void 0) { window = undefined; }
            if (callbacks === void 0) { callbacks = []; }
            var result = new WindowController_1.WindowController(AppController_1.AppController.instances[0], 'О Метке', new CreateMarkerView_1.CreateMarkerView({
                'marker_id': MarkerData.id,
                'latitude': MarkerData.latitude,
                'longitude': MarkerData.longitude,
                'address': AddressData.results.map(function (item) { return '<option>' + item.formatted_address + '</option>'; }).join(''),
                'available_categories': Categories.map(function (item) { return '<option>' + item + '</option>'; }).join(''),
                'owner_name': 'Вы',
                'creation_date': 'Сейчас',
                'review': '',
                'selected_categories': '',
                'selected_tags': '',
                'op_type': 'add',
                'attachment_notice': ''
            }), window);
            result.windowContainer.find('.rating input[type=checkbox][value=0]').attr('checked', true);
            callbacks.forEach(function (callback, i, arr) {
                callback(result);
            });
            return result;
        };
        WindowDrawer.drawEditMarkerWindow = function (MarkerData, AddressData, Categories, window, callbacks) {
            if (window === void 0) { window = undefined; }
            if (callbacks === void 0) { callbacks = []; }
            var result = new WindowController_1.WindowController(AppController_1.AppController.instances[0], 'О Метке', new CreateMarkerView_1.CreateMarkerView({
                'marker_id': MarkerData.id,
                'latitude': MarkerData.coordinates.latitude,
                'longitude': MarkerData.coordinates.longitude,
                'address': AddressData.results.map(function (item) { return '<option>' + item.formatted_address + '</option>'; }).join(''),
                'available_categories': Categories.map(function (item) { return '<option ' + (MarkerData.categories.indexOf(item) == -1 ? '' : 'selected="selected"') + '>' + item + '</option>'; }).join(''),
                'owner_name': MarkerData.owner.userName,
                'creation_date': MarkerData.creationDate,
                'review': MarkerData.review,
                'selected_categories': MarkerData.categories.length > 0 ? MarkerData.categories.join(':delimiter:') : '',
                'selected_tags': MarkerData.tags.length > 0 ? MarkerData.tags.join(', ') : '',
                'op_type': 'edit',
                'attachment_notice': '<em id="review-info" class="info help-block">Изрбражения меняются не дожидаясь сохранения.</em>'
            }), window);
            MarkerData.attachments.forEach(function (itm, i, arr) {
                var attachment = $((new AttachmentsViewHolder_1.AttachmentsViewHolder({
                    'id': itm.id,
                    'full': itm.name,
                    'thumb': itm.nightstand
                })).render()).insertBefore($(result.windowContainer).find('.attachment-container > *:nth-last-child(1)'));
                $(attachment).click(function (e) {
                    AttachmentsService_1.AttachmentsService.deleteAttachment(window.windowContainer.find('input[name=marker_id]').val(), itm.id, [function (AttachmentDeleteResult) {
                            $(attachment).remove();
                        }, function (AttachmentDeleteResult) {
                            $.toast({
                                hideAfter: 5000,
                                heading: 'Вложение удалено',
                                icon: 'info',
                                text: 'Ваше вложение к метке удалено.',
                                position: {
                                    top: 75,
                                    right: 20,
                                },
                                stack: 5
                            });
                        }]);
                    e.preventDefault();
                    return false;
                });
                $(attachment).data("attachment_id", itm.id);
            });
            result.windowContainer.find('.rating input[type=checkbox][value=' + MarkerData.rating + ']').attr('checked', true);
            callbacks.forEach(function (callback, i, arr) {
                callback(result);
            });
            return result;
        };
        WindowDrawer.drawCommentWindow = function (MarkerId, MarkerCommentsData, window, callbacks) {
            if (window === void 0) { window = undefined; }
            if (callbacks === void 0) { callbacks = []; }
            var result = new WindowController_1.WindowController(AppController_1.AppController.instances[0], 'Коментарии', new CommentsView_1.CommentsView({
                'comments': MarkerCommentsData.map(function (comment) {
                    return (new CommentsViewHolder_1.CommentsViewHolder({
                        'id': comment.id,
                        'owner_id': comment.owner.id,
                        'owner_name': comment.owner.userName,
                        'creationDate': comment.creationDate,
                        'text': comment.text,
                        'actions_visibility': comment.owner.id == USER_ID ? '' : 'hidden',
                        'marker_id': MarkerId
                    })).render();
                }).join(''),
                'form': IS_AUTHENTICATED !== false ? (new CommentsFormView_1.CommentsFormView({
                    'marker_id': MarkerId
                })) : (new CommentsRegisterFormView_1.CommentsRegisterFormView({
                    // TODO: REDIRECT AFTER LOGIN
                    'facebook_url': '/signGoogle?fallback_url=' + encodeURI('marker-comments-' + MarkerId),
                    'google_url': '/signGoogle?fallback_url=' + encodeURI('marker-comments-' + MarkerId)
                }))
            }), window);
            ActionBinder_1.ActionBinder.pushState('#marker-comments-' + MarkerId);
            callbacks.forEach(function (callback, i, arr) {
                callback(result);
            });
            return result;
        };
        WindowDrawer.drawSearchWindow = function (CategoriesData, TagsData, window, callbacks) {
            if (window === void 0) { window = undefined; }
            if (callbacks === void 0) { callbacks = []; }
            var result = new WindowController_1.WindowController(AppController_1.AppController.instances[0], 'Поиск', new SearchView_1.SearchView({
                'available_categories': CategoriesData.map(function (item) { return '<option>' + item + '</option>'; }).join(''),
                'available_tags': TagsData.map(function (item) { return (new TagViewHolder_1.TagViewHolder({ 'name': item })).render(); }).join(' ')
            }), window);
            ActionBinder_1.ActionBinder.pushState('#search');
            callbacks.forEach(function (callback, i, arr) {
                callback(result);
            });
            return result;
        };
        WindowDrawer.drawMarkersListWindow = function (title, MarkersData, additionalClass, window, callbacks) {
            if (additionalClass === void 0) { additionalClass = ''; }
            if (window === void 0) { window = undefined; }
            if (callbacks === void 0) { callbacks = []; }
            var result = new WindowController_1.WindowController(AppController_1.AppController.instances[0], title, new MarkersOverviewView_1.MarkersOverviewView({
                'additional_class': additionalClass,
                'markers': MarkersData.length ? MarkersData.map(function (MarkerData) {
                    return (new MarkerOverviewViewHolder_1.MarkerOverviewViewHolder({
                        'id': MarkerData.id,
                        'owner_id': MarkerData.owner.id,
                        'owner_name': MarkerData.owner.userName,
                        'creationDate': MarkerData.creationDate,
                        'actions_visibility': MarkerData.owner.id == USER_ID ? '' : 'hidden'
                    })).render();
                }).join('') : '<div class="col-xs-12">Нет меток для отображения</div>'
            }), window);
            callbacks.forEach(function (callback, i, arr) {
                callback(result);
            });
            return result;
        };
        return WindowDrawer;
    }());
    exports.WindowDrawer = WindowDrawer;
});
