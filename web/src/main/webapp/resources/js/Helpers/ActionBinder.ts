import {WindowController} from "../Controllers/WindowController";
import {CommentsView} from "../Views/CommentsView";
import {AppController} from "../Controllers/AppController";
import {CommentsViewHolder} from "../Views/CommentsViewHolder";
import {MarkerView} from "../Views/MarkerView";
import {AttachmentsViewHolder} from "../Views/AttachmentsViewHolder";
import {TagViewHolder} from "../Views/TagViewHolder";
import {CommentsFormView} from "../Views/CommentsFormView";
import {CommentsRegisterFormView} from "../Views/CommentsRegisterFormView";
import {WindowDrawer} from "./WindowDrawer";
import {MapController} from "../Controllers/MapController";

//import {CommentsView} from "../Views/CommentsView";
declare var $:JQueryStatic|any;

export class ActionBinder {
    static firstBind:boolean = true;

    static bindActions(container: Object) {
        if(this.firstBind) {
            AppController.instances[0].addClickCallback((mapController:MapController,e)=>{
                if(mapController.mode==1) { // add marker
                    mapController.setMode(2); // edit marker
                    $.ajax({
                        type: "GET",
                        url:'http://nctravelportal.ddns.net/reserveLabelId',
                        dataType: 'json',
                        success:(markerId:any)=> {
                            mapController.putMarker({
                                'latitude':e.latLng.lat(),
                                'longtitude':e.latLng.lng(),
                                'title':'',
                                'id':markerId
                            });
                            var window = WindowDrawer.drawCreateMarkerWindow(markerId,e.latLng.lat(), e.latLng.lng());
                            window.windowContainer.data('marker',{'id':markerId,'latitude':e.latLng.lat(), 'longtitude':e.latLng.lng()});
                        },
                        error: (error) => { alert("Произошла ошибка, пожалуйста, попробуйте позже."); }
                    });
                }
            });


        }

        $(container).find('.rating input[type="checkbox"]').on('change', function() {
            $(container).find('.rating input[type="checkbox"]').not(this).prop('checked', false);
        });

        $(container).find('#insert-marker').click(function () {
            var $button = $(event.currentTarget),
                window : WindowController = $button.parents('.window').data('model'),
                marker : any = $button.parents('.window').data('marker');



            $.ajax({
                type: "POST",
                contentType: "application/json",
                url: 'http://nctravelportal.ddns.net/labels',
                data: JSON.stringify({
                    'id':marker.id,
                    'coordinates':{
                        'latitude':marker.latitude,
                        'longitude':marker.longtitude
                    },
                    'address':{
                        'building':'NODATA',
                        'street':window.windowContainer.find('.address > select').val(),
                        'city':'NODATA',
                        'state':'NODATA',
                        'country':'NODATA'
                    },
                    'review':window.windowContainer.find('.review > textarea').val(),
                    'rating':window.windowContainer.find('.rating input[type=checkbox]:checked').val(),
                    'tags':window.windowContainer.find('.tags input').val().split(',').map((itm)=>{return itm.trim();}),
                    'categories':window.windowContainer.find('.categories input').val().split(',').map((itm)=>{return itm.trim();})
                }),
                dataType: 'json',
                success: (MarkerData) => {
                    console.log(MarkerData);
                    WindowDrawer.drawMarkerWindow(MarkerData.id);
                },
                error: (error) => { console.log(error);alert("Произошла ошибка, пожалуйста, попробуйте позже."); }
            });
        });

        $(container).find('.open-comments-button').click((event)=>{
            var $button = $(event.currentTarget),
                window : WindowController = $button.parents('.window').data('model'),
                markerId : number = $button.data('marker-id');
            WindowDrawer.drawCommentWindow(markerId,window);
        });
        $(container).find('.close-window-button').click((event)=>{
            var $button = $(event.currentTarget),
                window : WindowController = $button.parents('.window').data('model');

            // TODO: fix this
            if($(window.windowContainer).find('.comments').length > 0) {
                this.pushState(location.hash.replace(/-comments/g,''));
            } else if($(window.windowContainer).find('.marker').length > 0) {
                this.pushState('#');
            }

            window.closeWindow();
        });

        $(container).find('#send-comment').click((event)=>{
            var $button = $(event.currentTarget),
                window : WindowController = $button.parents('.window').data('model'),
                markerId : number = $button.data('marker-id'),
                $messageArea = $button.parents('.window').find('#comment-area');

            $.ajax({
                type: "POST",
                contentType: "application/json",
                url: 'http://nctravelportal.ddns.net/labels/'+markerId+'/comments',
                data: JSON.stringify({
                    "text":$messageArea.val()
                }),
                dataType: 'json',
                success: (CommentData) => {
                    $( ".comments > .comments-list" ).prepend(
                        (new CommentsViewHolder({
                            'id':CommentData.id,
                            'owner_name':CommentData.owner.userName,
                            'owner_id':CommentData.owner.id,
                            'creationDate':CommentData.creationDate,
                            'text':CommentData.text,
                        })).render()
                    );
                },
                error: (error) => { alert("Произошла ошибка, пожалуйста, попробуйте позже."); }
            });
        });

        if($(container).find('.attachments a').length>0) {
            $(container).find('.attachments a').featherlightGallery({
                gallery: {
                    fadeIn: 300,
                    fadeOut: 300
                },
                openSpeed: 300,
                closeSpeed: 300
            });
        }

        this.firstBind = false;
    }

    static pushState(state:string) {
        if (history.pushState) {
            history.pushState(null, null, state);
        } else {
            location.hash = state;
        }
    }
}