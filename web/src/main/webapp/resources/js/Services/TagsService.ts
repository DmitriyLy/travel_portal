declare var google,jQuery,$:any;

export class TagsService {
    static getPopularTags(callbacks:Function[] = []) {
        $.ajax({
            type: "GET",
            url: '/resources/tags.json',
            dataType: 'json',
            success: (TagsData:any)=>{
                callbacks.forEach((callback,i,arr)=>{
                    callback(TagsData);
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