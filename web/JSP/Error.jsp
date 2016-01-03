<%-- 
    Document   : Error
    Created on : 02-ene-2016, 18:16:38
    Author     : inakisanchez
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Error</title>
        <link rel="stylesheet" href="CSS/Estilo.css">
        <link href='http://fonts.googleapis.com/css?family=Lato:400,700,400italic' rel='stylesheet' type='text/css'>
        <link href='http://fonts.googleapis.com/css?family=Vollkorn:700italic,400' rel='stylesheet' type='text/css'>
        <link href='http://fonts.googleapis.com/css?family=Muli' rel='stylesheet' type='text/css'>
        <link rel="shortcut icon" href="Img/iconoEuskalRent.ico">

    </head>
    <body>
        <header>
            <a href="Inicio" class="logo">
                <em><img src="Img/logoEuskalRent.gif"/></em>
                <em>Euskal</em><strong>Rent</strong>
            </a>
            <nav>
                <ul>
                    <li><a href="Acceso">Acceder</a></li>
                    <li><a href="Registro">Registrarse</a></li>
                </ul>      
            </nav>
        </header>
        <div class="centrado">
            <h1>¡Vaya! Parece que hubo un error inesperado...</h1> 
            <img src="Img/saLiao.png"/>
            <h3><b>Exception:</b><br></h3> 
            <p><i>${pageContext.exception.message}</i><p>
        </div>
    </body>
</html>
