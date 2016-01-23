<%-- 
    Document   : ReservasUsuario
    Created on : 23-ene-2016, 14:31:43
    Author     : BEEP
--%>
<%@page import="packEuskalRent.Reserva"%>
<%@page import="java.util.ArrayList"%>
<%@page import="packEuskalRent.ConexionBD"%>
<%@page import="packEuskalRent.Usuario"%>
<%@page import="java.sql.Date"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8">
        <title>Apartamentos disponibles</title>
        <link rel="stylesheet" href="CSS/Estilo.css">
        <link href='http://fonts.googleapis.com/css?family=Lato:400,700,400italic' rel='stylesheet' type='text/css'>
        <link href='http://fonts.googleapis.com/css?family=Vollkorn:700italic,400' rel='stylesheet' type='text/css'>
        <link href='http://fonts.googleapis.com/css?family=Muli' rel='stylesheet' type='text/css'>
        <link rel="shortcut icon" href="Img/iconoEuskalRent.ico">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.4/jquery.min.js"></script>
        <script src="JavaScript/PaginaBusqueda.js" type="text/javascript"></script>
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
                        Usuario usuario = (Usuario) session.getAttribute("Usuario"); 
                        %>
                        <li><a href="PaginaModificacionUsuario">Modificar Usuario</a></li>
                        <% if(!usuario.tienePropiedad()){%>
                        <li><a href="PaginaRP">Registrar Propiedad</a></li>
                        <%}else{%>
                        <li><a href="PaginaLA">Mis Propiedades</a></li>
                        <%}%>
                        <li><a href="PaginaRU">Mis Reservas</a></li>
                        <li><a href="PaginaCS">Cerrar Sesion</a></li>
             
                </ul>      
            </nav>
        </header>
        <div class="centrado">
            <% 
            ConexionBD conexionBD = ConexionBD.getConexionConBBDD();
            ArrayList<Reserva> resevas = conexionBD.recibirDatosReservas(usuario.getCorreo());
            %>
            <form action="PaginaSB" id="formApart" method="POST">
                <table id="idA">
                <tr>
                    <th></th>
                    <th>Identificador de reserva</th>
                    <th>Fecha Inicio</th>
                    <th>Fecha Fin</th>
                  
                </tr>
                    <%

                   for(Reserva r: resevas){
                    %>
                    <tr class="subrayados" id="fila">
                        <td class="marcable"> <input type="radio" id="idApartamento" name="idApartamento" value="<%=r.getIdReserva()%>" /></td>
                            <td> <%=r.getIdReserva()%></td>
                            <td> <%=r.getFechaInicio() %></td>
                            <td> <%=r.getFechaFin() %></td>
                       
                        </tr>
                        <% }%>
            </table>
            <br>
            <input type="button" name="btnApart" id="btnApart" value="Elegir" class="botonBuscar"/>
            </form>
        </div>
    </body>
</html>
