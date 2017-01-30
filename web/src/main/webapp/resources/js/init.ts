import { AppController } from "./Controllers/AppController";
import { DayNightModeEventController } from "./Controllers/DayNightModeEventController";
import { FloatingButtonsEventController } from "./Controllers/FloatingButtonsEventController";
import { MMenuEventController } from "./Controllers/MMenuEventController";
import {ActionBinder} from "./Helpers/ActionBinder";
import {WindowDrawer} from "./Helpers/WindowDrawer";

declare var google,$:JQueryStatic|any;

// Init Map
AppController.instantiateMap('map', {
    zoom: 11,
    latlng: new google.maps.LatLng(46.4701764,30.6293825),
    styles: [{"featureType":"landscape","elementType":"geometry","stylers":[{"saturation":"-100"}]},{"featureType":"poi","elementType":"labels","stylers":[{"visibility":"off"}]},{"featureType":"poi","elementType":"labels.text.stroke","stylers":[{"visibility":"off"}]},{"featureType":"road","elementType":"labels.text","stylers":[{"color":"#545454"}]},{"featureType":"road","elementType":"labels.text.stroke","stylers":[{"visibility":"off"}]},{"featureType":"road.highway","elementType":"geometry.fill","stylers":[{"saturation":"-87"},{"lightness":"-40"},{"color":"#ffffff"}]},{"featureType":"road.highway","elementType":"geometry.stroke","stylers":[{"visibility":"off"}]},{"featureType":"road.highway.controlled_access","elementType":"geometry.fill","stylers":[{"color":"#f0f0f0"},{"saturation":"-22"},{"lightness":"-16"}]},{"featureType":"road.highway.controlled_access","elementType":"geometry.stroke","stylers":[{"visibility":"off"}]},{"featureType":"road.highway.controlled_access","elementType":"labels.icon","stylers":[{"visibility":"on"}]},{"featureType":"road.arterial","elementType":"geometry.stroke","stylers":[{"visibility":"off"}]},{"featureType":"road.local","elementType":"geometry.stroke","stylers":[{"visibility":"off"}]},{"featureType":"water","elementType":"geometry.fill","stylers":[{"saturation":"-52"},{"hue":"#00e4ff"},{"lightness":"-16"}]}]
});

// AppController.instances[0].map.addListener('click', function(e) {
//     console.log('Click');
//     AppController.instances[0].putMarker({
//         'latitude':e.latLng.lat(),
//         'longtitude':e.latLng.lng(),
//         'title':'omnomnom',
//         'marker_id':3
//     });
// });


var arr = [];
arr.push({'marker_id':1  ,'title':'test','latitude':    74.0213879   ,'longtitude':       48.8893152});
arr.push({'marker_id':2  ,'title':'test','latitude':    86.2527357   ,'longtitude':       34.7288109});
arr.push({'marker_id':3  ,'title':'test','latitude':    68.2533560	 ,'longtitude':   37.722398});
arr.push({'marker_id':4  ,'title':'test','latitude':    54.0505290   ,'longtitude':       34.4157472});
arr.push({'marker_id':5  ,'title':'test','latitude':    83.6416777   ,'longtitude':       51.3907171});
arr.push({'marker_id':6  ,'title':'test','latitude':    74.4093209   ,'longtitude':       45.5392806});
arr.push({'marker_id':7  ,'title':'test','latitude':    73.4938946   ,'longtitude':       42.4130654});
arr.push({'marker_id':8  ,'title':'test','latitude':    50.2152887   ,'longtitude':       63.2278044});
arr.push({'marker_id':9  ,'title':'test','latitude':    58.1158545   ,'longtitude':       46.9270164});
arr.push({'marker_id':10 ,'title':'test','latitude':     53.4705596  ,'longtitude':        65.4302003});
arr.push({'marker_id':11 ,'title':'test','latitude':     65.5723299  ,'longtitude':        48.1676857});
arr.push({'marker_id':12 ,'title':'test','latitude':     64.0283128  ,'longtitude':        45.9100604});
arr.push({'marker_id':13 ,'title':'test','latitude':     48.9450620  ,'longtitude':        68.5767691});
arr.push({'marker_id':14 ,'title':'test','latitude':     85.1656157  ,'longtitude':        65.0837113});
arr.push({'marker_id':15 ,'title':'test','latitude':     73.1026683  ,'longtitude':        60.5572319});
arr.push({'marker_id':16 ,'title':'test','latitude':     58.1222821  ,'longtitude':        52.6394679});
arr.push({'marker_id':17 ,'title':'test','latitude':     61.5742507  ,'longtitude':        54.1011484});
arr.push({'marker_id':18 ,'title':'test','latitude':     76.6903907  ,'longtitude':        46.2289231});
arr.push({'marker_id':19 ,'title':'test','latitude':     74.1518162  ,'longtitude':        34.4625017});
arr.push({'marker_id':20 ,'title':'test','latitude':     61.4205276  ,'longtitude':        62.7389858});
arr.push({'marker_id':21 ,'title':'test','latitude':     68.3319213  ,'longtitude':        60.9898627});
arr.push({'marker_id':22 ,'title':'test','latitude':     52.0613199  ,'longtitude':        56.2123482});
arr.push({'marker_id':23 ,'title':'test','latitude':     79.3456397  ,'longtitude':        44.3736371});
arr.push({'marker_id':24 ,'title':'test','latitude':     53.8581984  ,'longtitude':        40.6704547});
arr.push({'marker_id':25 ,'title':'test','latitude':     58.9714426  ,'longtitude':        49.7667043});
arr.push({'marker_id':26 ,'title':'test','latitude':     58.3761984	 ,'longtitude':       57.749506});
arr.push({'marker_id':27 ,'title':'test','latitude':     81.8103496  ,'longtitude':        48.7276576});
arr.push({'marker_id':28 ,'title':'test','latitude':     84.9579471  ,'longtitude':        69.8425117});
arr.push({'marker_id':29 ,'title':'test','latitude':     68.9562172  ,'longtitude':        51.1588825});
arr.push({'marker_id':30 ,'title':'test','latitude':     47.8292010	 ,'longtitude':   64.893108});
arr.push({'marker_id':31 ,'title':'test','latitude':     79.9960708  ,'longtitude':        69.8785585});
arr.push({'marker_id':32 ,'title':'test','latitude':     46.5681230  ,'longtitude':        45.5584868});
arr.push({'marker_id':33 ,'title':'test','latitude':     73.8680477	 ,'longtitude':   48.806697});
arr.push({'marker_id':34 ,'title':'test','latitude':     76.8142232  ,'longtitude':        45.3526961});
arr.push({'marker_id':35 ,'title':'test','latitude':     61.9215865  ,'longtitude':        49.3428014});
arr.push({'marker_id':36 ,'title':'test','latitude':     71.0128096  ,'longtitude':        64.1547609});
arr.push({'marker_id':37 ,'title':'test','latitude':     52.9628983  ,'longtitude':        43.2388645});
arr.push({'marker_id':38 ,'title':'test','latitude':     66.6885676  ,'longtitude':        42.6249544});
arr.push({'marker_id':39 ,'title':'test','latitude':     77.5873418	 ,'longtitude':   55.593496});
arr.push({'marker_id':40 ,'title':'test','latitude':     71.6265340  ,'longtitude':        45.6234893});
arr.push({'marker_id':41 ,'title':'test','latitude':     63.3894922  ,'longtitude':        41.2487988});
arr.push({'marker_id':42 ,'title':'test','latitude':     67.8792360  ,'longtitude':        52.6200024});
arr.push({'marker_id':43 ,'title':'test','latitude':     54.3309081  ,'longtitude':        40.7872136});
arr.push({'marker_id':44 ,'title':'test','latitude':     67.5279981  ,'longtitude':        68.2374522});
arr.push({'marker_id':45 ,'title':'test','latitude':     50.3060493  ,'longtitude':        62.2265759});
arr.push({'marker_id':46 ,'title':'test','latitude':     56.1680495  ,'longtitude':        51.8548711});
arr.push({'marker_id':47 ,'title':'test','latitude':     49.3870785  ,'longtitude':        45.6956345});
arr.push({'marker_id':48 ,'title':'test','latitude':     53.3434908  ,'longtitude':        39.9069528});
arr.push({'marker_id':49 ,'title':'test','latitude':     54.8425776  ,'longtitude':        66.5825269});
arr.push({'marker_id':50 ,'title':'test','latitude':     46.6110622  ,'longtitude':        38.9742098});
arr.push({'marker_id':51 ,'title':'test','latitude':     78.7624563  ,'longtitude':            62.5779916});
arr.push({'marker_id':52 ,'title':'test','latitude':     49.8712333  ,'longtitude':        49.6413244});
arr.push({'marker_id':53 ,'title':'test','latitude':     78.0515864  ,'longtitude':        62.7717494});
arr.push({'marker_id':54 ,'title':'test','latitude':     85.4204779  ,'longtitude':        57.1046747});
arr.push({'marker_id':55 ,'title':'test','latitude':     49.3671710  ,'longtitude':        54.2914643});
arr.push({'marker_id':56 ,'title':'test','latitude':     60.5120183  ,'longtitude':        70.0526925});
arr.push({'marker_id':57 ,'title':'test','latitude':     77.4536984	 ,'longtitude':    53.41542});
arr.push({'marker_id':58 ,'title':'test','latitude':     62.5591275  ,'longtitude':        32.0339618});
arr.push({'marker_id':59 ,'title':'test','latitude':     55.7117891  ,'longtitude':        51.8031038});
arr.push({'marker_id':60 ,'title':'test','latitude':     58.8419559  ,'longtitude':        61.8810796});
arr.push({'marker_id':61 ,'title':'test','latitude':     56.0792897  ,'longtitude':        70.6892553});
arr.push({'marker_id':62 ,'title':'test','latitude':     82.2535840  ,'longtitude':        49.0156474});
arr.push({'marker_id':63 ,'title':'test','latitude':     80.0844526  ,'longtitude':        62.0632827});
arr.push({'marker_id':64 ,'title':'test','latitude':     49.1077302  ,'longtitude':        45.5124582});
arr.push({'marker_id':65 ,'title':'test','latitude':     54.8674078	 ,'longtitude':   51.006612});
arr.push({'marker_id':66 ,'title':'test','latitude':     66.6451806  ,'longtitude':        54.0567803});
arr.push({'marker_id':67 ,'title':'test','latitude':     63.2175038  ,'longtitude':        59.2047493});
arr.push({'marker_id':68 ,'title':'test','latitude':     80.3108298  ,'longtitude':        39.1480606});
arr.push({'marker_id':69 ,'title':'test','latitude':     49.0665641  ,'longtitude':        51.0066957});
arr.push({'marker_id':70 ,'title':'test','latitude':     54.7706930  ,'longtitude':        41.4050608});
arr.push({'marker_id':71 ,'title':'test','latitude':     80.1246936	 ,'longtitude':   65.746998});
arr.push({'marker_id':72 ,'title':'test','latitude':     83.3361604  ,'longtitude':        65.4667292});
arr.push({'marker_id':73 ,'title':'test','latitude':     60.6880115  ,'longtitude':        56.4341584});
arr.push({'marker_id':74 ,'title':'test','latitude':     68.9348484  ,'longtitude':        42.8058489});
arr.push({'marker_id':75 ,'title':'test','latitude':     82.5447538  ,'longtitude':        49.8924278});
arr.push({'marker_id':76 ,'title':'test','latitude':     46.8340478  ,'longtitude':        48.6288484});
arr.push({'marker_id':77 ,'title':'test','latitude':     82.3177974  ,'longtitude':        66.5716272});
arr.push({'marker_id':78 ,'title':'test','latitude':     73.0358724  ,'longtitude':        56.5538898});
arr.push({'marker_id':79 ,'title':'test','latitude':     69.6872893  ,'longtitude':        36.6859443});
arr.push({'marker_id':80 ,'title':'test','latitude':     80.1997974  ,'longtitude':        70.6259749});
arr.push({'marker_id':81 ,'title':'test','latitude':     58.8243762	 ,'longtitude':   49.772639});
arr.push({'marker_id':82 ,'title':'test','latitude':     56.2074697  ,'longtitude':        50.2916554});
arr.push({'marker_id':83 ,'title':'test','latitude':     58.5422281  ,'longtitude':        38.5298285});
arr.push({'marker_id':84 ,'title':'test','latitude':     54.2467676  ,'longtitude':        64.2272429});
arr.push({'marker_id':85 ,'title':'test','latitude':     49.4681300  ,'longtitude':        55.0368007});
arr.push({'marker_id':86 ,'title':'test','latitude':     58.4850369  ,'longtitude':        33.5434629});
arr.push({'marker_id':87 ,'title':'test','latitude':     62.5961160  ,'longtitude':        39.8850963});
arr.push({'marker_id':88 ,'title':'test','latitude':     72.3938229	 ,'longtitude':   54.474281});
arr.push({'marker_id':89 ,'title':'test','latitude':     72.1694277  ,'longtitude':        48.8954122});
arr.push({'marker_id':90 ,'title':'test','latitude':     76.8675102  ,'longtitude':        60.3361861});
arr.push({'marker_id':91 ,'title':'test','latitude':     57.0017244  ,'longtitude':        33.6487576});
arr.push({'marker_id':92 ,'title':'test','latitude':     79.1873202  ,'longtitude':        34.8921847});
arr.push({'marker_id':93 ,'title':'test','latitude':     62.6242528  ,'longtitude':        37.3880323});
arr.push({'marker_id':94 ,'title':'test','latitude':     55.6566836  ,'longtitude':        70.6117724});
arr.push({'marker_id':95 ,'title':'test','latitude':     80.9367070  ,'longtitude':        58.2176065});
arr.push({'marker_id':96 ,'title':'test','latitude':     54.8200488  ,'longtitude':        45.5979194});
arr.push({'marker_id':97 ,'title':'test','latitude':     85.8253479  ,'longtitude':        48.6851416});
arr.push({'marker_id':98 ,'title':'test','latitude':     76.7427293  ,'longtitude':        36.3739007});
arr.push({'marker_id':99 ,'title':'test','latitude':     49.3228395  ,'longtitude':        35.2899068});
arr.push({'marker_id':100,'title':'test','latitude':       74.7399849,'longtitude':          47.8631202});
arr.push({'marker_id':101,'title':'test','latitude':      56.5169719 ,'longtitude':         65.1268639});
arr.push({'marker_id':102,'title':'test','latitude':      61.3953245 ,'longtitude':         42.8478483});
arr.push({'marker_id':103,'title':'test','latitude':      74.8235368 ,'longtitude':         56.9348491});
arr.push({'marker_id':104,'title':'test','latitude':      48.1491419 ,'longtitude':         52.1942034});
arr.push({'marker_id':105,'title':'test','latitude':      60.5130518 ,'longtitude':         47.6103608});
arr.push({'marker_id':106,'title':'test','latitude':      61.9360882 ,'longtitude':         64.3959917});
arr.push({'marker_id':107,'title':'test','latitude':      55.3807141 ,'longtitude':         57.0940957});
arr.push({'marker_id':108,'title':'test','latitude':      50.5641717 ,'longtitude':         59.1556069});
arr.push({'marker_id':109,'title':'test','latitude':      72.2066834 ,'longtitude':         49.5711311});
arr.push({'marker_id':110,'title':'test','latitude':      65.9494397 ,'longtitude':         37.1859128});
arr.push({'marker_id':111,'title':'test','latitude':      81.7934468,'longtitude':	    46.773794});
arr.push({'marker_id':112,'title':'test','latitude':      54.8711740 ,'longtitude':         33.0004554});
arr.push({'marker_id':113,'title':'test','latitude':      48.7679539 ,'longtitude':         32.9347435});
arr.push({'marker_id':114,'title':'test','latitude':      54.9633750 ,'longtitude':         49.6259329});
arr.push({'marker_id':115,'title':'test','latitude':      60.2210145 ,'longtitude':         44.8407851});
arr.push({'marker_id':116,'title':'test','latitude':      47.3834126 ,'longtitude':         66.3933767});
arr.push({'marker_id':117,'title':'test','latitude':      59.0682872 ,'longtitude':         35.9698117});
arr.push({'marker_id':118,'title':'test','latitude':      48.2300455,'longtitude':	    69.532238});
arr.push({'marker_id':119,'title':'test','latitude':      75.6296177 ,'longtitude':     65.0434389});
arr.push({'marker_id':120,'title':'test','latitude':      72.1323990 ,'longtitude':     60.8442813});
arr.push({'marker_id':121,'title':'test','latitude':      70.0444039 ,'longtitude':     55.2997484});
arr.push({'marker_id':122,'title':'test','latitude':      80.0537748 ,'longtitude':     34.0243975});
arr.push({'marker_id':123,'title':'test','latitude':      60.3577127 ,'longtitude':     43.0911969});
arr.push({'marker_id':124,'title':'test','latitude':      49.7995369 ,'longtitude':     55.7390076});
arr.push({'marker_id':125,'title':'test','latitude':      83.3022831 ,'longtitude':     40.3991451});
arr.push({'marker_id':126,'title':'test','latitude':      58.6058238 ,'longtitude':     68.8232624});
arr.push({'marker_id':127,'title':'test','latitude':      67.1097110 ,'longtitude':     67.3181349});
arr.push({'marker_id':128,'title':'test','latitude':      65.9095858 ,'longtitude':     42.9919017});
arr.push({'marker_id':129,'title':'test','latitude':      83.1076174 ,'longtitude':     54.0656753});
arr.push({'marker_id':130,'title':'test','latitude':      77.5197911,'longtitude':	    32.751527});
arr.push({'marker_id':131,'title':'test','latitude':      46.8216440 ,'longtitude':         33.2395301});
arr.push({'marker_id':132,'title':'test','latitude':      63.6335898 ,'longtitude':         57.2883145});
arr.push({'marker_id':133,'title':'test','latitude':      68.6261820,'longtitude':	    47.873109});
arr.push({'marker_id':134,'title':'test','latitude':      78.9742392 ,'longtitude':         68.7173071});
arr.push({'marker_id':135,'title':'test','latitude':      67.1835440,'longtitude':	    60.403546});
arr.push({'marker_id':136,'title':'test','latitude':      65.0458975 ,'longtitude':         39.9580624});
arr.push({'marker_id':137,'title':'test','latitude':      49.9168887 ,'longtitude':         43.7101895});
arr.push({'marker_id':138,'title':'test','latitude':      56.2563194 ,'longtitude':         39.8581344});
arr.push({'marker_id':139,'title':'test','latitude':      74.9109999 ,'longtitude':         42.3776857});
arr.push({'marker_id':140,'title':'test','latitude':      73.7854719 ,'longtitude':         69.7772117});
arr.push({'marker_id':141,'title':'test','latitude':      58.3798975 ,'longtitude':         51.2761734});
arr.push({'marker_id':142,'title':'test','latitude':      63.4952040,'longtitude':	      65.0377});
arr.push({'marker_id':143,'title':'test','latitude':      57.2049286 ,'longtitude':         50.9999727});
arr.push({'marker_id':144,'title':'test','latitude':      54.4312869 ,'longtitude':         39.8828789});
arr.push({'marker_id':145,'title':'test','latitude':      75.0814953 ,'longtitude':         63.4568108});
arr.push({'marker_id':146,'title':'test','latitude':      47.3297733 ,'longtitude':         60.1582358});
arr.push({'marker_id':147,'title':'test','latitude':      83.3289772 ,'longtitude':         33.4729629});
arr.push({'marker_id':148,'title':'test','latitude':      63.1786039 ,'longtitude':         36.3775598});
arr.push({'marker_id':149,'title':'test','latitude':      48.2188654 ,'longtitude':         56.7349879});
arr.push({'marker_id':150,'title':'test','latitude':      47.7877125 ,'longtitude':         65.2482305});
arr.push({'marker_id':151,'title':'test','latitude':      48.5407507,'longtitude':	    52.552408});
arr.push({'marker_id':152,'title':'test','latitude':      80.7430776 ,'longtitude':         30.9261452});
arr.push({'marker_id':153,'title':'test','latitude':      69.1553422 ,'longtitude':         52.5691166});
arr.push({'marker_id':154,'title':'test','latitude':      53.7274044 ,'longtitude':         39.7276842});
arr.push({'marker_id':155,'title':'test','latitude':      54.7418280 ,'longtitude':         37.4020309});
arr.push({'marker_id':156,'title':'test','latitude':      57.8151207 ,'longtitude':         39.1944879});
arr.push({'marker_id':157,'title':'test','latitude':      50.3878559 ,'longtitude':         38.7219681});
arr.push({'marker_id':158,'title':'test','latitude':      82.8352340 ,'longtitude':         41.7335455});
arr.push({'marker_id':159,'title':'test','latitude':      69.2855098 ,'longtitude':         55.7718495});
arr.push({'marker_id':160,'title':'test','latitude':      82.2172003 ,'longtitude':         41.4146501});
arr.push({'marker_id':161,'title':'test','latitude':      56.3759266 ,'longtitude':         64.0109851});
arr.push({'marker_id':162,'title':'test','latitude':      73.9215496 ,'longtitude':         48.2194937});
arr.push({'marker_id':163,'title':'test','latitude':      78.9225154 ,'longtitude':         65.9314739});
arr.push({'marker_id':164,'title':'test','latitude':      61.3816287 ,'longtitude':         35.8427264});
arr.push({'marker_id':165,'title':'test','latitude':      85.4911838 ,'longtitude':         41.7510042});
arr.push({'marker_id':166,'title':'test','latitude':      50.1523712 ,'longtitude':         61.1587227});
arr.push({'marker_id':167,'title':'test','latitude':      79.9760999 ,'longtitude':         52.2355215});
arr.push({'marker_id':168,'title':'test','latitude':      85.7493630 ,'longtitude':         65.2422116});
arr.push({'marker_id':169,'title':'test','latitude':      48.8912960 ,'longtitude':         54.9295802});
arr.push({'marker_id':170,'title':'test','latitude':      49.8113900 ,'longtitude':         49.6537283});
arr.push({'marker_id':171,'title':'test','latitude':      73.4480094 ,'longtitude':         49.9533791});
arr.push({'marker_id':172,'title':'test','latitude':      64.1233726 ,'longtitude':         63.1763227});
arr.push({'marker_id':173,'title':'test','latitude':      47.2247845 ,'longtitude':         67.8719787});
arr.push({'marker_id':174,'title':'test','latitude':      46.9377867 ,'longtitude':         50.3214583});
arr.push({'marker_id':175,'title':'test','latitude':      74.2908178 ,'longtitude':         43.1027754});
arr.push({'marker_id':176,'title':'test','latitude':      62.8382152 ,'longtitude':         42.3017631});
arr.push({'marker_id':177,'title':'test','latitude':      65.7919782 ,'longtitude':         59.4162331});
arr.push({'marker_id':178,'title':'test','latitude':      58.5137293,'longtitude':	    65.170237});
arr.push({'marker_id':179,'title':'test','latitude':      63.5298869 ,'longtitude':         39.8316771});
arr.push({'marker_id':180,'title':'test','latitude':      51.8148765 ,'longtitude':         52.3534967});
arr.push({'marker_id':181,'title':'test','latitude':      79.3661255 ,'longtitude':         41.5867462});
arr.push({'marker_id':182,'title':'test','latitude':      85.9324115 ,'longtitude':         32.4248984});
arr.push({'marker_id':183,'title':'test','latitude':      74.6835570 ,'longtitude':         41.2714541});
arr.push({'marker_id':184,'title':'test','latitude':      49.4827040 ,'longtitude':         36.9861221});
arr.push({'marker_id':185,'title':'test','latitude':      78.6975527 ,'longtitude':         70.3535943});
arr.push({'marker_id':186,'title':'test','latitude':      76.4332781 ,'longtitude':         40.4404892});
arr.push({'marker_id':187,'title':'test','latitude':      50.7712329 ,'longtitude':         44.0475429});
arr.push({'marker_id':188,'title':'test','latitude':      49.6369769,'longtitude':	    41.307681});
arr.push({'marker_id':189,'title':'test','latitude':      76.9289678 ,'longtitude':         58.5663061});
arr.push({'marker_id':190,'title':'test','latitude':      83.5869559 ,'longtitude':         50.9203029});
arr.push({'marker_id':191,'title':'test','latitude':      54.0802531 ,'longtitude':         61.9268135});
arr.push({'marker_id':192,'title':'test','latitude':      63.1904932 ,'longtitude':         48.9901315});
arr.push({'marker_id':193,'title':'test','latitude':      86.2132409 ,'longtitude':         46.3730699});
arr.push({'marker_id':194,'title':'test','latitude':      71.3749632 ,'longtitude':         41.2129561});
arr.push({'marker_id':195,'title':'test','latitude':      77.1132021 ,'longtitude':         35.2712088});
arr.push({'marker_id':196,'title':'test','latitude':      62.6417115 ,'longtitude':         65.9643906});
arr.push({'marker_id':197,'title':'test','latitude':      81.5623296 ,'longtitude':         33.4507706});
arr.push({'marker_id':198,'title':'test','latitude':      67.1246298 ,'longtitude':         45.8385352});
arr.push({'marker_id':199,'title':'test','latitude':      76.2708362 ,'longtitude':         51.3130454});
arr.push({'marker_id':200,'title':'test','latitude':      85.2084477 ,'longtitude':         63.6293059});
arr.push({'marker_id':201,'title':'test','latitude':      83.2715758 ,'longtitude':         61.0780334});
arr.push({'marker_id':202,'title':'test','latitude':      75.8079502 ,'longtitude':         62.7690192});
arr.push({'marker_id':203,'title':'test','latitude':      72.1963209 ,'longtitude':         50.1821605});
arr.push({'marker_id':204,'title':'test','latitude':      68.6554466 ,'longtitude':         40.4279143});
arr.push({'marker_id':205,'title':'test','latitude':      63.0285416 ,'longtitude':         39.8076533});
arr.push({'marker_id':206,'title':'test','latitude':      61.1365422 ,'longtitude':         55.3171081});
arr.push({'marker_id':207,'title':'test','latitude':      46.8044928 ,'longtitude':         52.7123378});
arr.push({'marker_id':208,'title':'test','latitude':      86.3896302 ,'longtitude':         63.2863343});
arr.push({'marker_id':209,'title':'test','latitude':      73.0058180 ,'longtitude':         55.0143425});
arr.push({'marker_id':210,'title':'test','latitude':      58.6838564 ,'longtitude':         49.5037268});
arr.push({'marker_id':211,'title':'test','latitude':      61.5886646 ,'longtitude':         49.8313831});
arr.push({'marker_id':212,'title':'test','latitude':      47.9965144 ,'longtitude':         57.9668498});
arr.push({'marker_id':213,'title':'test','latitude':      48.8503664 ,'longtitude':         41.2648753});
arr.push({'marker_id':214,'title':'test','latitude':      71.3250260 ,'longtitude':         64.7490364});
arr.push({'marker_id':215,'title':'test','latitude':      80.4065896 ,'longtitude':         32.5523918});
arr.push({'marker_id':216,'title':'test','latitude':      49.9829882 ,'longtitude':         57.9075107});
arr.push({'marker_id':217,'title':'test','latitude':      64.6903407,'longtitude':	    57.101873});
arr.push({'marker_id':218,'title':'test','latitude':      58.7353232 ,'longtitude':         63.9835409});
arr.push({'marker_id':219,'title':'test','latitude':      57.1549750 ,'longtitude':         69.5529067});
arr.push({'marker_id':220,'title':'test','latitude':      74.4640467 ,'longtitude':         46.9487492});
arr.push({'marker_id':221,'title':'test','latitude':      71.2267240,'longtitude':	    70.218472});
arr.push({'marker_id':222,'title':'test','latitude':      81.5760648 ,'longtitude':         61.6246614});
arr.push({'marker_id':223,'title':'test','latitude':      73.0295471 ,'longtitude':         46.7383081});
arr.push({'marker_id':224,'title':'test','latitude':      74.2967254 ,'longtitude':         52.2751139});
arr.push({'marker_id':225,'title':'test','latitude':      73.5111134 ,'longtitude':         63.5154524});
arr.push({'marker_id':226,'title':'test','latitude':      80.3882623,'longtitude':	    35.566467});
arr.push({'marker_id':227,'title':'test','latitude':      86.1904287 ,'longtitude':         30.9119281});
arr.push({'marker_id':228,'title':'test','latitude':      66.6421558 ,'longtitude':         69.8289081});
arr.push({'marker_id':229,'title':'test','latitude':      47.3889087 ,'longtitude':         44.8399419});
arr.push({'marker_id':230,'title':'test','latitude':      72.5640555 ,'longtitude':         50.3098762});
arr.push({'marker_id':231,'title':'test','latitude':      67.7805521 ,'longtitude':         56.3454004});
arr.push({'marker_id':232,'title':'test','latitude':      83.3814248 ,'longtitude':         65.4258478});
arr.push({'marker_id':233,'title':'test','latitude':      81.9555260 ,'longtitude':         57.5788308});
arr.push({'marker_id':234,'title':'test','latitude':      64.3466485 ,'longtitude':         41.6664331});
arr.push({'marker_id':235,'title':'test','latitude':      67.3112438 ,'longtitude':         58.5606421});
arr.push({'marker_id':236,'title':'test','latitude':      55.2810827 ,'longtitude':         41.9395071});
arr.push({'marker_id':237,'title':'test','latitude':      70.2788137 ,'longtitude':         37.9668862});
arr.push({'marker_id':238,'title':'test','latitude':      56.1743872 ,'longtitude':         32.3251767});
arr.push({'marker_id':239,'title':'test','latitude':      81.6156903 ,'longtitude':         60.0002046});
arr.push({'marker_id':240,'title':'test','latitude':      55.2879625 ,'longtitude':         60.0684446});
arr.push({'marker_id':241,'title':'test','latitude':      49.8263265 ,'longtitude':       49.4202529});
arr.push({'marker_id':242,'title':'test','latitude':      85.3615021 ,'longtitude':       64.3039828});
arr.push({'marker_id':243,'title':'test','latitude':      48.5103185 ,'longtitude':       54.3321083});
arr.push({'marker_id':244,'title':'test','latitude':      72.7824174 ,'longtitude':       49.7862137});
arr.push({'marker_id':245,'title':'test','latitude':      46.9878134 ,'longtitude':       69.0063429});
arr.push({'marker_id':246,'title':'test','latitude':      59.3394154 ,'longtitude':       62.6424912});
arr.push({'marker_id':247,'title':'test','latitude':      70.9443053 ,'longtitude':       55.5524355});
arr.push({'marker_id':248,'title':'test','latitude':      57.4205951 ,'longtitude':       50.8892138});
arr.push({'marker_id':249,'title':'test','latitude':      72.8433009 ,'longtitude':       43.6296771});
arr.push({'marker_id':250,'title':'test','latitude':      48.3370924 ,'longtitude':       38.0477547});
arr.push({'marker_id':251,'title':'test','latitude':      50.3449480 ,'longtitude':       67.2847717});
arr.push({'marker_id':252,'title':'test','latitude':      79.2606187 ,'longtitude':       41.4968906});
arr.push({'marker_id':253,'title':'test','latitude':      46.5283362 ,'longtitude':  34.269613});
arr.push({'marker_id':254,'title':'test','latitude':      52.9376412 ,'longtitude':       65.5130823});
arr.push({'marker_id':255,'title':'test','latitude':      75.9581301 ,'longtitude':       59.6370815});
arr.push({'marker_id':256,'title':'test','latitude':      74.9433500 ,'longtitude':       34.9221983});
arr.push({'marker_id':257,'title':'test','latitude':      79.3061920 ,'longtitude':       55.6325206});
arr.push({'marker_id':258,'title':'test','latitude':      59.6598562 ,'longtitude':       53.9978335});
arr.push({'marker_id':259,'title':'test','latitude':      55.7235058 ,'longtitude':       53.8708049});
arr.push({'marker_id':260,'title':'test','latitude':      60.2580584 ,'longtitude':  66.650302});
arr.push({'marker_id':261,'title':'test','latitude':      71.6311705 ,'longtitude':       61.3930265});
arr.push({'marker_id':262,'title':'test','latitude':      49.3549210 ,'longtitude':       35.9625116});
arr.push({'marker_id':263,'title':'test','latitude':      59.1590742 ,'longtitude':       50.4086402});
arr.push({'marker_id':264,'title':'test','latitude':      77.8747174 ,'longtitude':       40.8290768});
arr.push({'marker_id':265,'title':'test','latitude':      66.6425597 ,'longtitude':       42.2184418});
arr.push({'marker_id':266,'title':'test','latitude':      55.4189276 ,'longtitude':       69.6676004});
arr.push({'marker_id':267,'title':'test','latitude':      72.3309725 ,'longtitude':       32.2555432});
arr.push({'marker_id':268,'title':'test','latitude':      46.6113313 ,'longtitude':       34.0616246});
arr.push({'marker_id':269,'title':'test','latitude':      68.7358618 ,'longtitude':  36.006105});
arr.push({'marker_id':270,'title':'test','latitude':      74.8630610 ,'longtitude':       62.1754104});
arr.push({'marker_id':271,'title':'test','latitude':      59.0151856 ,'longtitude':  45.432729});
arr.push({'marker_id':272,'title':'test','latitude':      69.7544077 ,'longtitude':       64.0009669});
arr.push({'marker_id':273,'title':'test','latitude':      69.6848590 ,'longtitude':  56.706233});
arr.push({'marker_id':274,'title':'test','latitude':      61.6863202 ,'longtitude':       64.3747724});
arr.push({'marker_id':275,'title':'test','latitude':      54.4692358 ,'longtitude':       55.3856147});
arr.push({'marker_id':276,'title':'test','latitude':      62.5855112 ,'longtitude':       42.1814325});
arr.push({'marker_id':277,'title':'test','latitude':      50.0686988 ,'longtitude':       35.3989744});
arr.push({'marker_id':278,'title':'test','latitude':      59.0562614 ,'longtitude':       47.2109831});
arr.push({'marker_id':279,'title':'test','latitude':      62.7394069 ,'longtitude':       54.8422969});
arr.push({'marker_id':280,'title':'test','latitude':      67.3719624 ,'longtitude':       50.8778566});
arr.push({'marker_id':281,'title':'test','latitude':      61.5340496 ,'longtitude':       46.0635294});
arr.push({'marker_id':282,'title':'test','latitude':      80.2266774 ,'longtitude':       45.9960631});
arr.push({'marker_id':283,'title':'test','latitude':      76.9386193 ,'longtitude':       59.2616417});
arr.push({'marker_id':284,'title':'test','latitude':      54.0298173 ,'longtitude':       45.7490141});
arr.push({'marker_id':285,'title':'test','latitude':      76.6846200 ,'longtitude':       32.2298773});
arr.push({'marker_id':286,'title':'test','latitude':      61.2192382 ,'longtitude':       52.4456515});
arr.push({'marker_id':287,'title':'test','latitude':      84.3495281 ,'longtitude':       67.7194262});
arr.push({'marker_id':288,'title':'test','latitude':      75.6972630 ,'longtitude':       39.0229895});
arr.push({'marker_id':289,'title':'test','latitude':      63.1452535 ,'longtitude':  48.748201});
arr.push({'marker_id':290,'title':'test','latitude':      85.3832779 ,'longtitude':       51.3352696});
arr.push({'marker_id':291,'title':'test','latitude':      50.8402487 ,'longtitude':       38.1671882});
arr.push({'marker_id':292,'title':'test','latitude':      68.0565030 ,'longtitude':       54.4182181});
arr.push({'marker_id':293,'title':'test','latitude':      62.6634098 ,'longtitude':       52.1821484});
arr.push({'marker_id':294,'title':'test','latitude':      61.9245770 ,'longtitude':       32.7773387});
arr.push({'marker_id':295,'title':'test','latitude':      72.1438335 ,'longtitude':       51.6902528});
arr.push({'marker_id':296,'title':'test','latitude':      69.9854745 ,'longtitude':       67.9768705});
arr.push({'marker_id':297,'title':'test','latitude':      67.1156276 ,'longtitude':       52.7966974});
arr.push({'marker_id':298,'title':'test','latitude':      53.2174666 ,'longtitude':       33.6607639});
arr.push({'marker_id':299,'title':'test','latitude':      49.7403637 ,'longtitude':       61.4911838});
arr.push({'marker_id':300,'title':'test','latitude':      54.7959739 ,'longtitude':       44.0764377});
arr.push({'marker_id':301,'title':'test','latitude':      73.9821031 ,'longtitude':  60.612517});
arr.push({'marker_id':302,'title':'test','latitude':      61.8664166 ,'longtitude':       36.5257224});
arr.push({'marker_id':303,'title':'test','latitude':      68.1510335 ,'longtitude':       35.9897326});
arr.push({'marker_id':304,'title':'test','latitude':      66.2504145 ,'longtitude':       50.9209106});
arr.push({'marker_id':305,'title':'test','latitude':      69.1931678 ,'longtitude':       42.1464974});


AppController.instances[0].resetMarkers(arr);




// Modules init
// 1. Material Design Module Init
// $.material.init();
// 2. MMenu module init and map resizing fix
MMenuEventController.init();
// 3. Floating action buttons events
FloatingButtonsEventController.init();
// 4. Day-Night mode buttons events
DayNightModeEventController.init();
ActionBinder.bindActions($('html body'));
// END

$(document).ready(()=>{
    setTimeout(()=>{
        AppController.instances[0].reloadMarkers();
    },200);
});



// check for #marker-999999
if (location.hash.match(/^#marker-([0-9]+)/g)) {
    var m = (/^#marker-([0-9]+)/g).exec(location.hash);
    if (m.length) {
        WindowDrawer.drawMarkerWindow(parseInt(m[1]));
    }
}

// check for #marker-comments-999999
if (location.hash.match(/^#marker-comments-([0-9]+)/g)) {
    var m = (/^#marker-comments-([0-9]+)/g).exec(location.hash);
    if (m.length) {
        WindowDrawer.drawMarkerWindow(parseInt(m[1]), (MarkerWindow)=> {
            WindowDrawer.drawCommentWindow(parseInt(m[1]), MarkerWindow);
        });
    }
}