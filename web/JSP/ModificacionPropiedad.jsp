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
        <script type="text/javascript" src="JavaScript/mapa.js"></script>
        <link rel="stylesheet" type="text/css" href="CSS/contFotos.css">
        <script type="text/javascript" src="JavaScript/DnDEscritorio.js"></script>
        <link rel="stylesheet" type="text/css" href="CSS/modProp.css">
        <link rel="stylesheet" type="text/css" href="CSS/Estilo.css">
        <link rel="shortcut icon" href="Img/iconoEuskalRent.ico">
        <script type="text/javascript" src="JavaScript/valModApar.js"></script>
        <script type="text/javascript" src="JavaScript/webStorage.js"></script>
    </head>
    <body>
        <header>
            <a href="Inicio" class="logo">
                <em><img src="Img/logoEuskalRent.gif"/></em>
                <em>Euskal</em><strong>Rent</strong>
            </a>
            <nav>
                <ul>
                   <li><a href="PaginaModificacionUsuario">Modificar Usuario</a></li>
                     <li><a href="PaginaRP">Registrar Propiedad</a></li>
                     <li><a href="PaginaCS">Cerrar Sesion</a></li>
                </ul>      
            </nav>
        </header>
        <h2 align="center">Rellene los siguientes campos para terminar de registrar su propiedad</h2>
        <div id="grande" align="center">
            <form action="datosModProp" id="formModProp">
              
                <div class="parrafoPropiedad">
                <p>Arrastre la foto su propiedad al siguiente recuadro:</p>
                <div name="Caja" id="caja"></div>
                <div id="2" class="grande">
                    <p class="parrafoPropiedad">Elige un barrio</p><br>
                    <select name="barrio" class="cajasDatos" id="barrio">
                        <option value="Zabalgana">Zabalgana</option>
                        <option value="Aranbizkarra">Aranbizkarra</option>
                        <option value="Salburua">Salburua</option>
                    </select>
                    <p class="parrafoPropiedad">Elige el tipo de propiedad</p><br>
                    <select name="tipoProp" class="cajasDatos" id="tipoProp">
                        <option value="Apartamento">Apartamento</option>
                        <option value="Chalet">Chalet</option>
                    </select>
                    <p class="parrafoPropiedad">Número de huespedes</p><br>
                    <input type="number" name="numHuespedes" id="numHuespedes" class="cajasDatos" placeholder="Huespedes"
                           min="1" max="10" required/><br><br><br><br>
                <p>Introduzca el precio por noche</p>   
                <input name="Precio"type="number" id="precio" class="desp" placeholder="precio/noche" min="1" required/><br>         
                <p>Calendario para ver días ocupados de la propiedad</p>
                <input type="date" id="calendario" class="cajasDatos" required><br>
                <p>Seleccione el tipo de política de cancelación para su propiedad</p>
                <select name="Politica" id="politica" class="desp" required>
                    <option value="Flexible">Flexible</option>
                    <option value="Premium">Premium</option>
                </select>
                <div class="parrafoPropiedad">
                    <p>Seleccione en el mapa la localización de la propiedad</p>
                    <input type="text" id="buscadorDireccion" name="Direccion" class="desp" placeholder="Busca una dirección" value="" onkeyup="buscarDireccion(this.id.value)" 
                           oninput="buscarDireccion(document.getElementById('buscadorDireccion').value)" required/>
                    <div id="map" style="width:500px; height:200px;"></div>
                </div>
                <br><br>
                <input type="submit" id="btnValMP" value="Guardar" class="botonBuscar" onclick=""/>
                </div>
            </form> 
        </div>
    </body>
</html>
