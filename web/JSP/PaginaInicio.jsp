<%-- 
    Document   : PaginaInicio
    Created on : 18-nov-2015, 23:10:31
    Author     : Iñaki
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <link rel="stylesheet" type="text/css" href="../CSS/Estiloa.css">
        <script src="../JavaScript/ValidacionBusqueda.js"></script>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Euskal Rent</title>
    </head>
    <body>
        <div>
            <form action="" id="formBusqueda">
                Introduce el barrio:
                <input type="text" name="campoBarrio" id="barrio"><br>
                Introduce una fecha de inicio del alojamiento:
                <input type="date" name="calendarioInicio">
                <input type="date" name="calendarioFin"><br>
                <input type="button" value="Buscar" id="btnBuscar">
            </form>
        </div>
    </body>
</html>


<header class="header" role="banner">
    <nav>
        <ul>
            <h3>Euskal Rent</h3>
            <li><b href="#">Acceder</b>
            </li>
            <li><b href="#">Registrarse</b>
            </li>
        </ul>
    </nav>
</header>
<div class="container" role="main">
    <h1>Sticky Header</h1>
    <h2>Hides on scroll down, reveals on scroll up</h2>
    <h2>Header will Reveal on Page Bottom</h2>
</div>