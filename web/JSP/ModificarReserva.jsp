<%-- 
    Document   : ModificarReserva
    Created on : 24-ene-2016, 10:18:13
    Author     : inakisanchez
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
        <script type="text/javascript" src="JavaScript/JsonPaginaInicio.js"></script>
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
                        
                        if(session.getAttribute("Usuario")!=null){
                        Usuario usuario = (Usuario) session.getAttribute("Usuario"); 
                        session.setAttribute("Usuario", usuario);
                        
                    if(usuario.estaLogueado()){
                        %>
                        <li><a href="PaginaModificacionUsuario"><%=usuario.getCorreo()%></a></li>
                        <% if(!usuario.tienePropiedad()){%>
                        <li><a href="PaginaRP">Registrar Propiedad</a></li>
                        <%}else{%>
                        <li><a href="PaginaLA">Mis Propiedades</a></li>
                        <%}%>
                         <% if(usuario.tieneReserva()){%>
                        <li><a href="PaginaAR">Mis Reservas</a></li>
                        <%}%>
                        <li><a href="PaginaCS">Cerrar Sesion</a></li>
                    <%}}else{%>
                        <li><a href="Acceso">Acceder</a></li>
                        <li><a href="Registro">Registrarse</a></li>
                        <%
                    }
                    %>
                </ul>      
            </nav>
        </header>
            <div>
                <h1>Modifica tu reserva</h1>
                    
            </div>
    </body>
</html>
