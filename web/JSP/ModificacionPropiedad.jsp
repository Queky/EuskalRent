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
        <link rel="stylesheet" type="text/css" href="../CSS/modProp.css">
        <link rel="stylesheet" type="text/css" href="../CSS/Estilo.css">
        <script type="text/javascript" src="../JavaScript/valModApar.js"></script>
        <script type="text/javascript" src="../JavaScript/webStorage.js"></script>

    </head>
    <body>
        <header>
            <a href="PaginaInicio.jsp" class="logo">
                <em>Euskal</em><strong>Rent</strong>
            </a>
            <nav>
                <ul>
                    <li><a href="#">Acceder</a></li>
                    <li><a href="RegistroUsuario.jsp">Registrarse</a></li>
                </ul>      
            </nav>
        </header>
        <h2 align="center">Rellene los siguientes campos para comenzar a registrar su propiedad</h2>
        <div id="grande" align="center">
            <form action="" id="formModProp">
                <div>
                    <p>Seleccione en el mapa la localizacion de la propiedad</p>
                    <input type="text" id="buscadorDireccion" class="desp" placeholder="Busca una dirección" value="" onkeyup="buscarDireccion(this.id.value)" 
                       oninput="buscarDireccion(document.getElementById('buscadorDireccion').value)"/>
                    <div id="map" style="width:500px; height:200px;"></div>
                </div>
                <p>Arrastre las fotos del apartamento al siguiente recuadro</p>
                <div id="caja"></div>
                <p>Introduzca el precio de alquiler de la propiedad por noche</p>   
                <input type="number" id="precio" class="desp" placeholder="precio/noche" min="1"/><br>         
                <p>Calendario para ver dias ocupados de la propiedad</p>
                <input type="date" id="calendario"><br>
                <p>Seleccione el tipo de política de cancelación para su propiedad</p>
                <select name="Política de cancelación" id="politica" class="desp">
                    <option value="Flexible">Flexible</option>
                    <option value="Premium">Premium</option>
                </select>
                <br><br>
                <input type="button" id="btnValMP" value="Guardar" class="botonBuscar" onclick="clickGuardarMA()"/>
            </form> 
        </div>        
    </body>
</html>