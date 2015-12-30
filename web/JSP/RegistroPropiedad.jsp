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
        <link href='http://fonts.googleapis.com/css?family=Lato:400,700,400italic' rel='stylesheet' type='text/css'>
        <link href='http://fonts.googleapis.com/css?family=Vollkorn:700italic,400' rel='stylesheet' type='text/css'>
        <link href='http://fonts.googleapis.com/css?family=Muli' rel='stylesheet' type='text/css'>
        <script type="text/javascript" src="JavaScript/valRegApar.js"></script>
        <link rel="stylesheet" type="text/css" href="CSS/Estilo.css">
        <link rel="stylesheet" type="text/css" href="CSS/modProp.css">
        <script type="text/javascript" src="JavaScript/webStorage.js"></script>

    </head>
    <body>
        <header>
            <a href="PaginaInicio.jsp" class="logo">
                <em>Euskal</em><strong>Rent</strong>
            </a>
            <nav>
                <ul>
                    <li><a href="PaginaAcceder.jsp">Acceder</a></li>
                    <li><a href="RegistroUsuario.jsp">Registrarse</a></li>
                </ul>      
            </nav>
        </header><br>
        <h2 align="center">Rellene los siguientes campos para comenzar a registrar su propiedad</h2>
        <div id="grande2" align="center">
            <form action="../datosGenProp" id="formProp">
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
                    <input type="submit" id="btnValRP" value="Guardar" class="botonBuscar" onclick=""/>
                </div>
            </form>
        </div>
    </body>
</html>