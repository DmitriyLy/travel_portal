import {MapController} from "./MapController";
import {WindowView} from "../Views/WindowView";
import {View} from "../Views/View";
declare var google,jQuery,$:any;



export class WindowController {
    title : string;
    content : any;
    childrenWindows : WindowController[] = [];
    mapController : MapController;
    parentWindow : WindowController;
    windowContainer : any;
    windowView : WindowView;

    /***
     * Creates window.
     */
    constructor(mapController : MapController, windowView : View, title : string, content : string|View, parentWindow : WindowController = null) {
        this.title = title;
        this.content = content;
        this.mapController = mapController;
        if(parentWindow != null) {
            parentWindow.closeChildrenWindows();
            this.parentWindow = parentWindow;
            this.parentWindow.childrenWindows.push(this);
        } else {
            if(mapController.mainWindow != null)
                mapController.mainWindow.closeWindow();
            mapController.mainWindow = this;
        }
        this.windowView = windowView;
        this.windowContainer = this.showWindow();
        return this;
    }

    /***
     * Shows window.
     */
    showWindow() {
        if(this.windowView == null)
            return "";

        return $(this.windowView.render({
            "title": this.title,
            "content": this.content instanceof View ? this.content.render() : this.content
        })).data('model',this).appendTo($('#windows-container'));

        // WindowView.render({
        //     "title":this.title,
        //     "content":MarkerView.render({
        //         "user":"User",
        //         "date":"13.10.1995",
        //         "rate":"5",
        //         "content":"Lorem ipsum text",
        //         "comments":"None"
        //     })
        // })
    }

    /***
     * Closes window.
     */
    closeWindow() {
        this.closeChildrenWindows();
        $(this.windowContainer).remove();
    }

    /***
     * Closes children windows.
     */
    closeChildrenWindows() {
        if(this.childrenWindows.length>0) {
            this.childrenWindows.forEach(function(childrenWindow, i, arr) {
                childrenWindow.closeWindow();
            });
        }
    }
}