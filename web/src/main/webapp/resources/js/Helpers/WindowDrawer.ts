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
import {MarkersOverviewView} from "../Views/MarkersOverviewView";
import {MarkerOverviewViewHolder} from "../Views/MarkerOverviewViewHolder";
import {SearchView} from "../Views/SearchView";
import {AttachmentsService} from "../Services/AttachmentsService";
declare var $:JQueryStatic|any;
declare var IS_AUTHENTICATED:boolean;
declare var GOOGLE_MAP_API_KEY:number;
declare var USER_ID:number;

export class WindowDrawer {
    static drawMarkerWindow(MarkerData: any, window: WindowController = undefined, callbacks: Function[] = []) {
        var result = new WindowController(AppController.instances[0], 'О Метке', new MarkerView({
            'marker_id':MarkerData.id,
            'owner_id':MarkerData.owner.id,
            'owner_name':MarkerData.owner.userName,
            'creationDate':MarkerData.creationDate,
            'address':
            /*MarkerData.address.country + ', ' +
             MarkerData.address.state + '. ' +
             MarkerData.address.city + '. ' +
             MarkerData.address.street + ', ' +
             MarkerData.address.building*/MarkerData.address.street,
            'rating':MarkerData.rating,
            'review':MarkerData.review,
            'categories':MarkerData.categories.map((itm)=>{ return (new TagViewHolder({
                'name':itm
            })).render(); }).join(' '),
            'tags':MarkerData.tags.map((itm)=>{ return (new TagViewHolder({
                'name':itm
            })).render(); }).join(' '),
            'attachments':MarkerData.attachments.map((itm)=>{ return (new AttachmentsViewHolder({
                'id':itm.id,
                'full':itm.name,
                'thumb':itm.nightstand
            })).render();}).join(''),
            'categories_visibility':MarkerData.categories.length?'':'hidden',
            'tags_visibility':MarkerData.tags.length?'':'hidden',
            'attachments_visibility':MarkerData.attachments.length?'':'hidden',
            'commentCount':MarkerData.commentCount,
            'actions_visibility':MarkerData.owner.id==USER_ID?'':'hidden'
        }),window);
        ActionBinder.pushState('#marker-'+MarkerData.id);

        callbacks.forEach((callback,i,arr)=>{
            callback(result);
        });

        return result;
    }

    static drawCreateMarkerWindow(MarkerData : any, AddressData:any, Categories:any, window: WindowController = undefined, callbacks: Function[] = []) : WindowController {
        var result = new WindowController(AppController.instances[0], 'О Метке', new CreateMarkerView({
            'marker_id' : MarkerData.id,
            'latitude' : MarkerData.latitude,
            'longitude' : MarkerData.longitude,
            'address': AddressData.results.map((item) => { return '<option>'+item.formatted_address+'</option>'; }).join(''),
            'available_categories': Categories.map((item)=>{ return '<option>'+item+'</option>'; }).join(''),
            'owner_name' : 'Вы',
            'creation_date': 'Сейчас',
            'review': '',
            'selected_categories': '',
            'selected_tags':'',
            'op_type':'add',
            'attachment_notice':''
        }), window);

        result.windowContainer.find('.rating input[type=checkbox][value=0]').attr('checked',true);

        callbacks.forEach((callback,i,arr)=>{
            callback(result);
        });

        return result;
    }

    static drawEditMarkerWindow(MarkerData:any, AddressData:any, Categories:any, window: WindowController = undefined, callbacks: Function[] = []) : WindowController {
        var result = new WindowController(AppController.instances[0], 'О Метке', new CreateMarkerView({
            'marker_id' : MarkerData.id,
            'latitude' : MarkerData.coordinates.latitude,
            'longitude' : MarkerData.coordinates.longitude,
            'address': AddressData.results.map((item) => { return '<option>'+item.formatted_address+'</option>'; }).join(''),
            'available_categories': Categories.map((item)=>{ return '<option '+(MarkerData.categories.indexOf(item)==-1?'':'selected="selected"')+'>'+item+'</option>'; }).join(''),
            'owner_name' : MarkerData.owner.userName,
            'creation_date': MarkerData.creationDate,
            'review': MarkerData.review,
            'selected_categories': MarkerData.categories.length>0 ? MarkerData.categories.join(':delimiter:') : '',
            'selected_tags':MarkerData.tags.length>0 ? MarkerData.tags.join(', ') : '',
            'op_type':'edit',
            'attachment_notice':'<em id="review-info" class="info help-block">Изрбражения меняются не дожидаясь сохранения.</em>'
        }),window);

        MarkerData.attachments.forEach((itm,i,arr)=>{
            var attachment = $( (new AttachmentsViewHolder({
                'id':itm.id,
                'full':itm.name,
                'thumb':itm.nightstand
            })).render() ).insertBefore($(result.windowContainer).find('.attachment-container > *:nth-last-child(1)'));
            $(attachment).click((e)=>{
                AttachmentsService.deleteAttachment(window.windowContainer.find('input[name=marker_id]').val(),itm.id,[(AttachmentDeleteResult)=>{
                    $(attachment).remove();
                },(AttachmentDeleteResult)=>{
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
            $(attachment).data("attachment_id",itm.id);
        });

        result.windowContainer.find('.rating input[type=checkbox][value='+MarkerData.rating+']').attr('checked',true);

        callbacks.forEach((callback,i,arr)=>{
            callback(result);
        });

        return result;
    }

    static drawCommentWindow(MarkerId,MarkerCommentsData:any, window: WindowController = undefined, callbacks: Function[] = []) {
        var result = new WindowController(AppController.instances[0], 'Коментарии', new CommentsView({
            'comments':MarkerCommentsData.map((comment)=>{
                return (new CommentsViewHolder({
                    'id':comment.id,
                    'owner_id':comment.owner.id,
                    'owner_name':comment.owner.userName,
                    'creationDate':comment.creationDate,
                    'text':comment.text,
                    'actions_visibility': comment.owner.id==USER_ID?'':'hidden',
                    'marker_id': MarkerId
                })).render();
            }).join(''),
            'form':IS_AUTHENTICATED !== false ? (new CommentsFormView({
                'marker_id':MarkerId
            })):(new CommentsRegisterFormView({
                // TODO: REDIRECT AFTER LOGIN
                'facebook_url':'/signGoogle?fallback_url='+encodeURI('marker-comments-'+MarkerId),
                'google_url':'/signGoogle?fallback_url='+encodeURI('marker-comments-'+MarkerId)
                // 'facebook_url':'/auth/facebook',
                // 'google_url':'/auth/google'
            }))
        }),window);

        ActionBinder.pushState('#marker-comments-'+MarkerId);

        callbacks.forEach((callback,i,arr)=>{
            callback(result);
        });
        return result;
    }

    static drawSearchWindow(CategoriesData:any,TagsData:any,window: WindowController = undefined, callbacks: Function[] = []) {
        var result = new WindowController(AppController.instances[0], 'Поиск', new SearchView({
            'available_categories':CategoriesData.map((item)=>{ return '<option>'+item+'</option>'; }).join(''),
            'available_tags':TagsData.map((item)=>{ return (new TagViewHolder({'name':item})).render(); }).join(' ')
        }),window);

        ActionBinder.pushState('#search');

        callbacks.forEach((callback,i,arr)=>{
            callback(result);
        });
        return result;
    }

    static drawMarkersListWindow(title,MarkersData:any, additionalClass='', window: WindowController = undefined, callbacks: Function[] = []) {
        var result = new WindowController(AppController.instances[0], title, new MarkersOverviewView({
            'additional_class':additionalClass,
            'markers':MarkersData.length?MarkersData.map((MarkerData)=>{
                return (new MarkerOverviewViewHolder({
                    'id':MarkerData.id,
                    'owner_id':MarkerData.owner.id,
                    'owner_name':MarkerData.owner.userName,
                    'creationDate':MarkerData.creationDate,
                    'actions_visibility': MarkerData.owner.id==USER_ID?'':'hidden'
                })).render();
            }).join(''):'<div class="col-xs-12">Нет меток для отображения</div>'
        }),window);

        callbacks.forEach((callback,i,arr)=>{
            callback(result);
        });
        return result;
    }
}