declare var google,jQuery,$:any;

export class GeoCodeService {
    static getGeoCodeData(latitude,longitude,key, callbacks:Function[] = []) {
        $.ajax({
            type: "GET",
            url:'https://maps.google.com/maps/api/geocode/json?latlng='+latitude+','+longitude+'&sensor=false&key='+key,
            dataType: 'json',
            success: (MarkerGeoData:any)=>{
                callbacks.forEach((callback,i,arr)=>{
                    callback(MarkerGeoData);
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