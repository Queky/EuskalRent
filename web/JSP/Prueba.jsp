<%-- 
    Document   : Prueba
    Created on : 23-nov-2015, 15:36:07
    Author     : BEEP
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
    <head>
        
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Completar datos propiedad</title>
        <script src="http://maps.google.com/maps/api/js?sensor=false"></script>
        <script type="text/javascript" src="../JavaScript/googleMaps.js"></script>
        
    </head>
    <body>       
        
        <h1>Seleccione en el mapa la localizacion de la propiedad</h1>
        
        <input type="text" id="buscadorDireccion" style=" width:200px" title="Dirección a Geocode" value="" id="busDir" class="Direccion"/>
        <input type="button" onclick="buscarDireccion(document.getElementById('buscadorDireccion').value)" id="buscarDireccion" style="width:150px" title="Buscar dirección" value="Buscar dirección"/>
        
        <div id="map" style="width:800px; height:500px;"></div>
        
       
    </body>
</html>