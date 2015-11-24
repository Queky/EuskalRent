<%-- 
    Document   : PaginaInicio
    Created on : 18-nov-2015, 23:10:31
    Author     : Iñaki
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8">
        <title>EuskalRent</title>
        <link rel="stylesheet" href="../CSS/Estilo.css">
        <link href='http://fonts.googleapis.com/css?family=Lato:400,700,400italic' rel='stylesheet' type='text/css'>
        <link href='http://fonts.googleapis.com/css?family=Vollkorn:700italic,400' rel='stylesheet' type='text/css'>
        <link href='http://fonts.googleapis.com/css?family=Muli' rel='stylesheet' type='text/css'>
        <script src="../JavaScript/ValidacionBusqueda.js" type="text/javascript"></script>
    </head>
    <body>
        <header>
            <a href="PaginaInicio.jsp" class="logo">
                <em>Euskal</em><strong>Rent</strong>
            </a>
            <nav>
                <ul>
                    <li><a href="Acceder.jsp">Acceder</a></li>
                    <li><a href="RegistroUsuario.jsp">Registrarse</a></li>
                </ul>      
            </nav>
        </header>
        <section>
            <div>
                <h1 class="cabeceraB1">Bienvenido a <em>EuskalRent</em></h1>
                <p class="cabeceraB2">EuskalRent es tu pagina donde buscar un apartamento para dormir en Vitoria-Gasteiz.</p>
            </div>
            <form action="PaginaBusquedas.jsp" id="formInicio">
                <div class="cajaBusqueda">
                    <p>Elige un barrio</p>
                    <select name="Barrio" class="cajasDatos" id="barrio">
                        <option value="zabalgana">Zabalgana</option>
                        <option value="aranbizkarra">Aranbizkarra</option>
                        <option value="salburua">Salburua</option>
                    </select>
                    <p>Numero de huespedes</p>
                    <input type="number" id="numHuespedes" class="cajasDatos" placeholder="Huespedes"
                           min="1" max="10" required/>
                    <p>Entrada al apartamento</p>
                    <input type="date" id="fechaInicio" class="cajasDatos" required/><br>
                    <p>Salida del apartamento</p>
                    <input type="date" id="fechaFin" class="cajasDatos" required/><br><br>
                    <input type="button" id="btnBuscar" value="Buscar" class="botonBuscar"/>
                </div>
            </form>
        </section>
    </body>
</html>