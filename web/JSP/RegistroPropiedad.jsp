<%-- 
    Document   : index
    Created on : 19-nov-2015, 15:49:18
    Author     : Zigor
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Registro propiedad</title>
        <link rel="stylesheet" type="text/css" href="../CSS/despRegistro.css" media="all">
        <script type="text/javascript" src="../JavaScript/valRegApar.js"></script>
        <link rel="stylesheet" type="text/css" href="../CSS/Estilo.css">
        <link rel="stylesheet" type="text/css" href="../CSS/modProp.css">
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
        <div id="grande2" align="center">
            <form action="ModificacionPropiedad.jsp" id="formProp">
                <div id="2" class="grande">
                    <p class="parrafoPropiedad">Elige un barrio</p><br>
                    <select name="barrio" class="cajasDatos" id="barrio">
                        <option value="Zabalgana">Zabalgana</option>
                        <option value="Aranbizkarra">Aranbizkarra</option>
                        <option value="Salburua">Salburua</option>
                    </select>
                    <p class="parrafoPropiedad">Elige el tipo de propiedad</p><br>
                    <select name="TipoProp" class="cajasDatos" id="tipoProp">
                        <option value="apartamento">Apartamento</option>
                        <option value="chalet">Chalet</option>
                    </select>
                    <p class="parrafoPropiedad">Numero de huespedes</p><br>
                    <input type="number" id="numHuespedes" class="cajasDatos" placeholder="Huespedes"
                           min="1" max="10" required/><br><br><br><br>
                    <input type="button" id="btnValRP" value="Guardar" class="botonBuscar" onclick="clickGuardarRA();getBarrio()"/>
                </div>
            </form>
        </div>
    </body>
</html>