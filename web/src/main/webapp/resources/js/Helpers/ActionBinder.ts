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

//import {CommentsView} from "../Views/CommentsView";
declare var $:JQueryStatic|any;

export class ActionBinder {
    static firstBind:boolean = true;

    static bindActions(container: Object) {
        $(container).find('#addMarkerButton').click((event)=>{
            var $marker = $(event.currentTarget),
                markerId : number = 3;
                // markerId : number = $button.data('marker-id');
            WindowDrawer.drawMarkerWindow(markerId);
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
                type: "PUT",
                url: 'http://nctravelportal.ddns.net/labels/'+markerId+'/comments',
                data: {
                    'text':$messageArea.text()
                },
                success: (data)=>{
                    console.log(data);
                }
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
    }

    static pushState(state:string) {
        if (history.pushState) {
            history.pushState(null, null, state);
        } else {
            location.hash = state;
        }
    }
}