import {View} from "./View";

export class CommentsRegisterFormView extends View {

    constructor(params) {
        super('<div class="col-xs-12 text-center"><b>чтобы оставлять комментарии<br>вы должны войти:</b></div>' +
                '<div class="col-xs-6 text-center"><a href="$facebook_url$"><i class="fa fa-facebook-square fa-3x" aria-hidden="true"></i></a></div>' +
                '<div class="col-xs-6 text-center"><a href="$google_url$"><i class="fa fa-google-plus fa-3x" aria-hidden="true"></i></a></div>', params);
    }
}