import {WindowController} from "../Controllers/WindowController";
import {CommentsView} from "../Views/CommentsView";
import {AppController} from "../Controllers/AppController";
import {CommentsViewHolder} from "../Views/CommentsViewHolder";

//import {CommentsView} from "../Views/CommentsView";
declare var $:JQueryStatic|any;

export class ActionBinder {
    static bindActions(container: Object) {
        $(container).find('.open-comments-button').click((event)=>{
            var $button = $(event.currentTarget),
                window : WindowController = $button.parents('.window').data('model'),
                markerId : number = $button.data('marker-id');
            $.get('http://nctravelportal.ddns.net/labels/'+markerId+'/comments',(MarkerCommentsData:any)=>{
                console.log(MarkerCommentsData);
                new WindowController(AppController.instances[0], 'Коментарии', new CommentsView({
                    'comments':MarkerCommentsData.map((comment)=>{
                            return (new CommentsViewHolder({
                                    'id':comment.id,
                                    'owner_id':comment.owner.id,
                                    'owner_name':comment.owner.userName,
                                    'creationDate':comment.creationDate,
                                    'text':comment.text
                                })).render();
                        }).join('')
                }),window);
            });
        });
        $(container).find('.close-window-button').click((event)=>{
            var $button = $(event.currentTarget),
                window : WindowController = $button.parents('.window').data('model');
            window.closeWindow();
        });
    }
}