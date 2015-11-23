/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */



function initAddress(){
  var geocoder = new google.maps.Geocoder();
  var address = 'Vitoria-Gateiz';
  geocoder.geocode( { 'address': address}, function(results, status) {
    if (status == google.maps.GeocoderStatus.OK) {
  var map = new google.maps.Map(document.getElementById('address'), {
    center: results[0].geometry.location,
    zoom: 15
  });
    }
  });
}
google.maps.event.addDomListener(window, 'load', initAddress);

