<%-- 
    Document   : PaginaInicio
    Created on : 18-nov-2015, 23:10:31
    Author     : Iñaki
--%>

<%@page import="packEuskalRent.Usuario"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8">
        <title>EuskalRent</title>
        <link href="CSS/Estilo.css" rel="stylesheet" type="text/css"/>
        <link href='http://fonts.googleapis.com/css?family=Lato:400,700,400italic' rel='stylesheet' type='text/css'>
        <link href='http://fonts.googleapis.com/css?family=Vollkorn:700italic,400' rel='stylesheet' type='text/css'>
        <link href='http://fonts.googleapis.com/css?family=Muli' rel='stylesheet' type='text/css'>
        <link rel="shortcut icon" href="Img/iconoEuskalRent.ico">
        <script src="JavaScript/ValidacionBusqueda.js" type="text/javascript"></script>
        <script type="text/javascript" src="JavaScript/JsonPaginaInicio.js" type="text/javascript"></script>
    </head>
    <body>
        <header>
            <a href="Inicio" class="logo">
                <em><img src="Img/logoEuskalRent.gif"/></em>
                <em>Euskal</em><strong>Rent</strong>
            </a>
            <nav>
                <ul>
                    <%
                        Usuario usuario = Usuario.getUsuario();
                    if(usuario.estaLogueado()){
                        %>
                        <li><a href="PaginaModificacionUsuario">Modificar Usuario</a></li>
                        <li><a href="PaginaRP">Registrar Propiedad</a></li>
                        <li><a href="Inicio">Cerrar Sesion<%usuario.cerrarSesion();%></a></li>
                        <%
                    }else{
                        %>
                        <li><a href="Acceso">Acceder</a></li>
                        <li><a href="Registro">Registrarse</a></li>
                        <%
                    }
                    %>
                </ul>      
            </nav>
        </header>
        <section>
            <div>
                <h1 class="cabeceraB1">Bienvenido a <em>EuskalRent</em></h1>
                <p class="cabeceraB2">EuskalRent es tu pagina donde buscar un apartamento para dormir en Vitoria-Gasteiz.</p>
            </div>
            <form action="Busqueda" id="formInicio">
                <div class="cajaBusqueda">
                    <p>Elige un barrio</p>
                    <select name="barrio" class="cajasDatos" id="barrio">
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
                    <input type="button" id="btnBuscar" value="Buscar" class="botonBuscar" onclick="guardarJSon()"/>
                </div>
            </form>
        </section>
    </body>
</html>