import {WindowController} from "../Controllers/WindowController";
import {AttachmentsViewHolder} from "../Views/AttachmentsViewHolder";
import {WindowDrawer} from "../Helpers/WindowDrawer";
import {MarkersService} from "../Services/MarkersService";
import {AttachmentsService} from "../Services/AttachmentsService";
import {AppController} from "../Controllers/AppController";
declare var google,jQuery,$:any;

export class MarkerEditEventListener {
    static eventCallback(window : WindowController) {
        ///////////////////
        //  EDIT MARKER  //
        ///////////////////

        // Rating
        window.windowContainer.find('.marker .rating input[type=checkbox]').on('change',function(){
            window.windowContainer.find('.rating input[type=checkbox]').not(this).prop('checked', false);
            $("#CreateMarker").valid();
        });

        // Categories
        window.windowContainer.find('.marker #categories-container').chosen();
        window.windowContainer.find('.marker #categories-container').change((event) => {
            if($(event.currentTarget).val()) {
                $( ".categories input[name=categories]" ).val($(event.currentTarget).val().join(':delimiter:'));
            } else {
                $( ".categories input[name=categories]" ).val("");
            }
        });
        // AttachmentsService.deleteAttachment(window.windowContainer.find('input[name=marker_id]').val(),AttachmentData.id,[(AttachmentDeleteResult)=>{
        //     console.log(AttachmentDeleteResult);
        // }]);
        // Attachments
        if(window.windowContainer.find('.marker input[name=marker_id]').length>0) {
            window.windowContainer.find('.marker #attachment-file-input').ajaxfileupload({
                action: '/labels/' + window.windowContainer.find('input[name=marker_id]').val() + '/attachments',
                valid_extensions: ['png', 'jpg', 'jpeg'],
                auto_upload: true,
                onComplete: (AttachmentData) => {
                    var attachment = $((new AttachmentsViewHolder({
                        'id': AttachmentData.id,
                        'full': AttachmentData.name,
                        'thumb': AttachmentData.nightstand
                    })).render()).insertBefore(window.windowContainer.find('.attachment-container > *:nth-last-child(1)'));

                    $(attachment).click((e) => {
                        AttachmentsService.deleteAttachment(window.windowContainer.find('input[name=marker_id]').val(),AttachmentData.id,[(AttachmentDeleteResult)=>{
                            $(attachment).remove();
                        },(AttachmentDeleteResult) => {
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
                    $(attachment).data("attachment_id", AttachmentData.id);

                    $.toast({
                        hideAfter: 5000,
                        heading: 'Вложение добавлено',
                        icon: 'info',
                        text: 'Ваше вложение к метке добавлено.',
                        position: {
                            top: 75,
                            right: 20,
                        },
                        stack: 5
                    });
                },
                onCancel: () => {}
            });
        }
        window.windowContainer.find('.close-window-button').click((event)=>{
            $('#map').removeClass('inactive');
        });


        // Save Button
        window.windowContainer.find('.marker #insert-marker').click((event) => {
            var $button = $(event.currentTarget),
                window : WindowController = $button.parents('.window').data('model'),
                op_type = window.windowContainer.find('input[name=op_type]').val();

            if($( "#CreateMarker" ).valid()) {
                if(op_type == "add") {
                    MarkersService.addMarker({
                        'id': window.windowContainer.find('input[name=marker_id]').val(),
                        'coordinates': {
                            'latitude': window.windowContainer.find('input[name=latitude]').val(),
                            'longitude': window.windowContainer.find('input[name=longitude]').val()
                        },
                        'address': {
                            'building': 'NODATA',
                            'street': window.windowContainer.find('.address > select').val(),
                            'city': 'NODATA',
                            'state': 'NODATA',
                            'country': 'NODATA'
                        },
                        'review': window.windowContainer.find('.review > textarea').val(),
                        'rating': parseInt(window.windowContainer.find('.rating input[type=checkbox]:checked').val()),
                        'tags': window.windowContainer.find('.tags input').val().split(',').map((itm) => {
                            return itm.trim();
                        }).filter((entry) => {
                            return entry.trim() != '';
                        }),
                        'categories': window.windowContainer.find('.categories input[name=categories]').val().split(':delimiter:').map((itm) => {
                            return itm.trim();
                        }).filter((entry) => {
                            return entry.trim() != '';
                        })
                    }, [(MarkerData) => {
                        $('#map').removeClass('inactive');
                        AppController.instances[0].map.setZoom(18);
                        AppController.instances[0].map.setCenter(new google.maps.LatLng(MarkerData.coordinates.latitude, MarkerData.coordinates.longitude));
                        AppController.instances[0].reloadMarkers();
                        WindowDrawer.drawMarkerWindow(MarkerData);
                    }, (MarkerData) => {
                        $.toast({
                            hideAfter: 5000,
                            heading: 'Создание метки',
                            icon: 'info',
                            text: 'Ваша метка успешно создана',
                            position: {
                                top: 75,
                                right: 20,
                            },
                            stack: 5
                        });
                    }]);
                } else if (op_type == "edit") {
                    MarkersService.editMarker(window.windowContainer.find('input[name=marker_id]').val(),{
                        'review': window.windowContainer.find('.review > textarea').val(),
                        'rating': window.windowContainer.find('.rating input[type=checkbox]:checked').val(),
                        'tags': window.windowContainer.find('.tags input').val().split(',').map((itm) => {
                            return itm.trim();
                        }).filter((entry) => {
                            return entry.trim() != '';
                        }),
                        'categories': window.windowContainer.find('.categories input[name=categories]').val().split(':delimiter:').map((itm) => {
                            return itm.trim();
                        }).filter((entry) => {
                            return entry.trim() != '';
                        })
                    }, [(MarkerData) => {
                        WindowDrawer.drawMarkerWindow(MarkerData);
                    }]);
                }
            }
        });

        // Validation
        if(window.windowContainer.find('.marker #CreateMarker').length > 0){
            $( "#CreateMarker" ).validate( {
                rules: {
                    'review': {
                        required: true,
                        minlength: 2,
                        maxlength: 1500
                    },
                    rating: "required"
                },
                messages: {
                    'review': {
                        required: "Пожалуйста, оставьте ревью.",
                        minlength: "Ваше сообщение должно состоять минимум из 2 символов.",
                        maxlength: "Ваще сообщение должно состоять максимум из 2000 символов."
                    },
                    'rating': {
                        required: "Пожалуйста, оставьте оценку."
                    }
                },
                errorElement: "em",
                errorPlacement: function ( error, element ) {
                    error.addClass( "help-block" );
                    element.parents( ".col-xs-12" ).addClass( "has-feedback" );

                    if ( element.prop( "type" ) === "checkbox" ) {
                        error.insertAfter( element.parents( "span" ).first() );
                    } else {
                        error.insertAfter( element );
                    }
                    if ( !element.next( "span" )[ 0 ] ) {
                        if ( element.prop( "type" ) === "checkbox" ) {
                            $( "<span class='glyphicon glyphicon-remove form-control-feedback'></span>" ).insertAfter( element.parents( "span" ).first() );
                        } else {
                            $( "<span class='glyphicon glyphicon-remove form-control-feedback'></span>" ).insertAfter( element );
                        }
                    }
                },
                success: function ( label, element ) {
                    // Add the span element, if doesn't exists, and apply the icon classes to it.

                    if ( $( element ).prop( "type" ) === "checkbox" ) {
                        if ( !$(element).parents("span").first().next( "span" )[ 0 ] ) {
                            $("<span class='glyphicon glyphicon-ok form-control-feedback'></span>").insertAfter($(element).parents("span").first());
                        }
                    } else {
                        if ( !$( element ).next( "span" )[ 0 ] ) {
                            $("<span class='glyphicon glyphicon-ok form-control-feedback'></span>").insertAfter($(element));
                        }
                    }

                },
                highlight: function ( element, errorClass, validClass ) {
                    $( element ).parents( ".col-sm-5" ).addClass( "has-error" ).removeClass( "has-success" );
                    if ( $( element ).prop( "type" ) === "checkbox" ) {
                        $( element ).parents( "span" ).first().next( "span" ).addClass( "glyphicon-remove" ).removeClass( "glyphicon-ok" )
                    } else {
                        $( element ).next( "span" ).addClass( "glyphicon-remove" ).removeClass( "glyphicon-ok" );
                    }
                },
                unhighlight: function ( element, errorClass, validClass ) {
                    $( element ).parents( ".col-sm-5" ).addClass( "has-success" ).removeClass( "has-error" );
                    if ( $( element ).prop( "type" ) === "checkbox" ) {
                        $( element ).parents( "span" ).first().next( "span" ).addClass( "glyphicon-ok" ).removeClass( "glyphicon-remove" );
                    } else {
                        $( element ).next( "span" ).addClass( "glyphicon-ok" ).removeClass( "glyphicon-remove" );
                    }
                }
            });
        }

    }
}