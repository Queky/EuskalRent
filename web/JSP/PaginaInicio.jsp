<%-- 
    Document   : PaginaInicio
    Created on : 18-nov-2015, 23:10:31
    Author     : Iñaki
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
<<<<<<< HEAD
        <meta charset="utf-8">
        <title>EuskalRent</title>
        <link rel="stylesheet" href="../CSS/Estiloa.css">
        <link rel="stylesheet" type="text/css" href="css/normalize.css" />
        <link rel="stylesheet" type="text/css" href="css/demo.css" />
        <link rel="stylesheet" type="text/css" href="css/component.css" />
        <link href='http://fonts.googleapis.com/css?family=Lato:400,700,400italic' rel='stylesheet' type='text/css'>
        <link href='http://fonts.googleapis.com/css?family=Vollkorn:700italic,400' rel='stylesheet' type='text/css'>
        <link href='http://fonts.googleapis.com/css?family=Muli' rel='stylesheet' type='text/css'>
    </head>
    <body>
        <header>
            <a href="PaginaInicio.jsp" class="logo">
                <em>Euskal</em><strong>Rent</strong>
            </a>
            <nav>
                <ul>
                    <li><a href="#">Acceder</a></li>
                    <li><a href="#">Registrarse</a></li>
                </ul>      
            </nav>
        </header>
        <section>
            <div class="cajaPresentacion">
                <h1>Bienvenido a <em>EuskalRent</em></h1>
                <p class="parrafoTop">EuskalRent es tu pagina para buscar un apartamento donde dormir en Vitoria-Gasteiz.</p>
            </div>
            <div class="cajaBusqueda">
                <p class="parroBusqueda">Introduce un barrio</p>
                <input type="text" id="barrio"><br><br>
                <p class="parroBusqueda">Llegada y salida del apartamento</p>
                <input type="date" id="fechaInicio">
                <input type="date" id="fechaFin" placeholder="Inicio"><br><br>
                <input type="submit" id="submit" value="Buscar">
            </div>
        </section>
    </body>
</html>
=======
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
>>>>>>> master
