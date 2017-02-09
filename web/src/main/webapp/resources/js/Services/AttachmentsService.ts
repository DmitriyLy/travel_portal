declare var google,jQuery,$:any;



export class AttachmentsService {
    static deleteAttachment(MarkerId,AttachmentId,callbacks:Function[]) {
        $.ajax({
            type: "DELETE",
            url: '/labels/'+MarkerId+'/attachments/'+AttachmentId,
            success: (MarkerData) => {
                callbacks.forEach((callback, i, arr) => {
                    callback(MarkerData);
                });
            },
            error: (error) => {
                console.log(error);
                $.toast({
                    hideAfter: 5000,
                    heading: 'Произошла ошибка',
                    icon: 'error',
                    text: 'Произошла ошибка №'+error.status+'.<br>Более подробную информацию можно получить в консоли.<br>Просим прощения, за предоставленные неудобства.',
                    position: {
                        top: 75,
                        right: 20,
                    },
                    stack: 5
                });
            }
        });
    }
}