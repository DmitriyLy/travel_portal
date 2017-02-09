declare var google,jQuery,$:any;

export class CommentsService {
    static getCommentsForMarker(id,callbacks:Function[]) {
        $.ajax({
            type: "GET",
            url:'/labels/'+id+'/comments',
            dataType: 'json',
            success: (MarkerCommentsData:any)=>{
                callbacks.forEach((callback,i,arr)=>{
                    callback(MarkerCommentsData);
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

    static deleteComment(MarkerId,CommentId,callbacks:Function[]) {
        $.ajax({
            type: "DELETE",
            url: '/labels/'+MarkerId+'/comments/'+CommentId,
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