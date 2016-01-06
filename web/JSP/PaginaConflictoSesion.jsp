<%-- 
    Document   : PaginaApartamentos
    Created on : 29-dic-2015, 8:48:31
    Author     : inakisanchez
--%>

<%@page import="packEuskalRent.ConexionBD"%>
<%@page import="packEuskalRent.Propiedad"%>
<%@page import="packEuskalRent.Usuario"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<script src="JavaScript/PaginaApartamento.js" type="text/javascript"></script>
<link rel="stylesheet" href="CSS/Estilo.css">
<link href='http://fonts.googleapis.com/css?family=Lato:400,700,400italic' rel='stylesheet' type='text/css'>
<link href='http://fonts.googleapis.com/css?family=Vollkorn:700italic,400' rel='stylesheet' type='text/css'>
<link href='http://fonts.googleapis.com/css?family=Muli' rel='stylesheet' type='text/css'>
<link rel="shortcut icon" href="Img/iconoEuskalRent.ico">
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Apartamento elegido</title>
    </head>
    <body>
        <header>
            <a href="" class="logo">
                <em><img src="Img/logoEuskalRent.gif"/></em>
                <em>Euskal</em><strong>Rent</strong>
            </a>
            <nav>
                <ul>
                  
                   
                </ul>      
            </nav>
        </header><%Usuario usuario = (Usuario) session.getAttribute("Usuario"); %>
        <section>
           <strong> <p> El usuario <%=usuario.getCorreo()%> ya a iniciado sesion, que dese hacer:</p></strong>
            <p><a href='Inicio'>Continuar con la ultima sesion</a></p>
            <p><a href='PaginaCS'>Cerrar Sesion</a></p>
        </section>
    </body>
</html>

