var map;
var centro = new google.maps.LatLng(42.850678,-2.680083);
var marcador;
var infoMarcador;
var localizacion;

function init(){
    var mapOptions = {
        center: centro,
        zoom: 13,
        mapTypeId: google.maps.MapTypeId.SATELLITE
    };
    
    map = new google.maps.Map(document.getElementById('map'), mapOptions);
    
    marcador = new google.maps.Marker({  
        position: centro,
        map: map,
        title:"Centro de Vitoria",
        draggable: true
    });
    
    infoMarcador = new google.maps.InfoWindow({ content:"direccion"
    });
    function mostrarInfo(){
        infoMarcador.open(map, marcador);
    }
    google.maps.event.addListener(marcador, 'click', mostrarInfo);
} 
google.maps.event.addDomListener(window, 'load', init);

function buscarDireccion(direccion) {
    var geoCoder = new google.maps.Geocoder(direccion);
    var consulta = {address:direccion};
    geoCoder.geocode(consulta, function(result, status){
        localizacion = new google.maps.LatLng(result[0].geometry.location.lat(), result[0].geometry.location.lng());
    });
    map.panTo(localizacion);
    map.setZoom(17);
}

