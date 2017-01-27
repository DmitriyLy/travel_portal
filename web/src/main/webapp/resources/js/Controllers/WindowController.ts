import {MapController} from "./MapController";
import {WindowView} from "../Views/WindowView";
import {View} from "../Views/View";
import {ActionBinder} from "../Helpers/ActionBinder";
declare var google,jQuery,$:any;



export class WindowController {
    title : string;
    content : any;
    childrenWindows : WindowController[] = [];
    mapController : MapController;
    parentWindow : WindowController;
    windowContainer : JQueryStatic|Object;

    /***
     * Creates window.
     */
    constructor(mapController : MapController, title : string, content : string|View, parentWindow : WindowController = null) {
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

        this.windowContainer = this.showWindow();
        ActionBinder.bindActions(this.windowContainer);
        return this;
    }

    /***
     * Shows window.
     */
    showWindow() {
        return $(new WindowView({
            "title": this.title,
            "content": this.content instanceof View ? this.content.render() : this.content
        }).render()).data('model',this).appendTo($('#windows-container'));
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