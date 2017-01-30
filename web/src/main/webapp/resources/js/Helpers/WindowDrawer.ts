
//import {CommentsView} from "../Views/CommentsView";
import {AppController} from "../Controllers/AppController";
import {WindowController} from "../Controllers/WindowController";
import {TagViewHolder} from "../Views/TagViewHolder";
import {MarkerView} from "../Views/MarkerView";
import {CommentsViewHolder} from "../Views/CommentsViewHolder";
import {AttachmentsViewHolder} from "../Views/AttachmentsViewHolder";
import {CommentsView} from "../Views/CommentsView";
import {CommentsFormView} from "../Views/CommentsFormView";
import {CommentsRegisterFormView} from "../Views/CommentsRegisterFormView";
import {ActionBinder} from "./ActionBinder";
import {CreateMarkerView} from "../Views/CreateMarkerView";
declare var $:JQueryStatic|any;
declare var IS_AUTHENTICATED:boolean;
declare var GOOGLE_MAP_API_KEY:number;

export class WindowDrawer {
    static drawMarkerWindow(id: number, callback: Function = null) {
        $.ajax({
            type: "GET",
            url:'http://nctravelportal.ddns.net/labels/'+id,
            dataType: 'json',
            success:(MarkerData:any)=>{
                var result = new WindowController(AppController.instances[0], 'О Метке', new MarkerView({
                    "marker_id":MarkerData.id,
                    "owner_id":MarkerData.owner.id,
                    "owner_name":MarkerData.owner.userName,
                    "creationDate":MarkerData.creationDate,
                    "address":
                        /*MarkerData.address.country + ", " +
                        MarkerData.address.state + ". " +
                        MarkerData.address.city + ". " +
                        MarkerData.address.street + ", " +
                        MarkerData.address.building*/MarkerData.address.street,
                    "rating":MarkerData.rating,
                    "review":MarkerData.review,
                    "categories":MarkerData.categories.map((itm)=>{ return (new TagViewHolder({
                        'name':itm
                    })).render(); }).join(' '),
                    "tags":MarkerData.tags.map((itm)=>{ return (new TagViewHolder({
                        'name':itm
                    })).render(); }).join(' '),
                    "attachments":MarkerData.attachments.map((itm)=>{ return (new AttachmentsViewHolder({
                        'full':itm.name,
                        'thumb':itm.name
                    })).render();}).join(''),
                    "commentCount":MarkerData.commentCount
                }));
                if (typeof callback === "function")
                    callback(result);
                ActionBinder.pushState('#marker-'+id);
            },
            error: (error) => { alert("Произошла ошибка, пожалуйста, попробуйте позже."); }
        });
    }

    static drawCreateMarkerWindow(markerId:number, latitude:number, longtitude:number, callback: Function = null) : WindowController {


        var AddressData;
        $.ajax({
            type: "GET",
            url:'https://maps.google.com/maps/api/geocode/json?latlng='+latitude+','+longtitude+'&sensor=false&key='+GOOGLE_MAP_API_KEY,
            dataType: 'json',
            success: (MarkerCommentsData:any)=>{
                AddressData = MarkerCommentsData;
                console.log(MarkerCommentsData);
            },
            async:false,
            error: (error) => { alert("Произошла ошибка, пожалуйста, попробуйте позже."); }
        });

        var result = new WindowController(AppController.instances[0], 'О Метке', new CreateMarkerView({
            "address": AddressData.results.map((item) => { return '<option>'+item.formatted_address+'</option>'; })
        }));

        if (typeof callback === "function")
            callback(result);

        return result;
    }

    static drawCommentWindow(id: number, window: WindowController, callback: Function = null) {
        $.ajax({
            type: "GET",
            url:'http://nctravelportal.ddns.net/labels/'+id+'/comments',
            dataType: 'json',
            success: (MarkerCommentsData:any)=>{
                var result = new WindowController(AppController.instances[0], 'Коментарии', new CommentsView({
                    'comments':MarkerCommentsData.map((comment)=>{
                        return (new CommentsViewHolder({
                            'id':comment.id,
                            'owner_id':comment.owner.id,
                            'owner_name':comment.owner.userName,
                            'creationDate':comment.creationDate,
                            'text':comment.text
                        })).render();
                    }).join(''),
                    'form':IS_AUTHENTICATED !== false ? (new CommentsFormView({
                        'marker_id':id
                    })):(new CommentsRegisterFormView({
                        // TODO: REDIRECT AFTER LOGIN
                        // 'facebook_url':'/auth/facebook?fallback_url='+encodeURI('#marker-comments-'+id),
                        // 'google_url':'/auth/google?fallback_url='+encodeURI('#marker-comments-'+id)
                        'facebook_url':'/auth/facebook',
                        'google_url':'/auth/google'
                    }))
                }),window);
                if (typeof callback === "function")
                    callback(result);



                ActionBinder.pushState('#marker-comments-'+id);
            },
            error: (error) => { alert("Произошла ошибка, пожалуйста, попробуйте позже."); }
        });
    }
}