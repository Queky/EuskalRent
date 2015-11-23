<%-- 
    Document   : index
    Created on : 19-nov-2015, 21:31:42
    Author     : Zigor
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Completar datos propiedad</title>
        <script src="http://maps.google.com/maps/api/js?sensor=false"></script>
        <script type="text/javascript" src="../JavaScript/mapa.js"></script>
        <link rel="stylesheet" type="text/css" href="../CSS/contFotos.css">
        <script type="text/javascript" src="../JavaScript/DnDEscritorio.js"></script>
     
    </head>
    <body>       
        
        <h1>Seleccione en el mapa la localizacion de la propiedad</h1>
        
        <input type="text" id="buscadorDireccion" style=" width:200px" title="Dirección a Geocode" value="" id="busDir"/>
        <input type="button" onclick="buscarDireccion(document.getElementById('buscadorDireccion').value)" id="buscarDireccion" style="width:150px" title="Buscar dirección" value="Buscar dirección"/>
        
        <div id="map" style="width:800px; height:500px;"></div>
        
        <h1>Arrastre las fotos del apartamento al siguiente recuadro</h1>

        <div id="caja"></div>
        
        <h1> Introduzca el precio de alquiler de la propiedad por noche </h1>
    
        <input type="number" name="precio" min="1"></input>
    </body>
</html>
