import {ActionBinder} from "../Helpers/ActionBinder";
import {WindowController} from "../Controllers/WindowController";
declare var google,jQuery,$:any;

export class WindowEventListener {
    static eventCallback(window : WindowController) {
        ///////////////////
        //    WINDOW     //
        ///////////////////

        // Close Window Button
        window.windowContainer.find('.close-window-button').click((event)=>{
            if(window.parentWindow==undefined) {
                ActionBinder.pushState('#');
                window.closeWindow();
                return;
            }
            if(window.parentWindow.windowContainer.find('.marker .open-comments-button').length > 0) {
                ActionBinder.pushState('#marker-'+window.parentWindow.windowContainer.find('.marker .open-comments-button').data('marker-id'));
            }
            if(window.parentWindow.windowContainer.find('.comments').length > 0) {
                ActionBinder.pushState('#marker-comments-'+window.parentWindow.windowContainer.find('#send-comment').data('marker-id'));
            }
            if(window.parentWindow.windowContainer.find('.search').length > 0) {
                ActionBinder.pushState('#search');
            }
            if(window.parentWindow.windowContainer.find('.marker-list.search-list').length > 0) {
                ActionBinder.pushState('#search');
            }
            if(window.parentWindow.windowContainer.find('.marker-list.favourites').length > 0) {
                ActionBinder.pushState('#favourites');
            }
            if(window.parentWindow.windowContainer.find('.marker-list.my-markers').length > 0) {
                ActionBinder.pushState('#my-markers');
            }
            if(window.parentWindow.windowContainer.find('.marker-list.my-comments').length > 0) {
                ActionBinder.pushState('#my-comments');
            }
            //
            // // TODO: fix this
            // if(window.windowContainer.find('.comments').length > 0) {
            //     ActionBinder.pushState(location.hash.replace(/-comments/g,''));
            // } else if(window.parentWindow.windowContainer.find('.marker').length > 0) {
            //     ActionBinder.pushState('#');
            // }

            window.closeWindow();
        });
    }
}