<%-- 
    Document   : ReservasUsuario
    Created on : 23-ene-2016, 14:31:43
    Author     : BEEP
--%>
<%@page import="packEuskalRent.Propiedad"%>
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
                    <li><a href="PaginaModificacionUsuario"><%=usuario.getCorreo()%></a></li>
                        <% if (!usuario.tienePropiedad()) {%>
                    <li><a href="PaginaRP">Registrar Propiedad</a></li>
                        <%} else {%>
                   <li><a href="PaginaLA">Mis Propiedades</a></li>
                        <%}%>
                        <% if(usuario.tieneReserva()){%>
                    <li><a href="PaginaAR">Mis Reservas</a></li>
                        <%}%>
                    <li><a href="PaginaCS">Cerrar Sesion</a></li>

                </ul>      
            </nav>
        </header>
        <div class="centrado">
            <%
                ConexionBD conexionBD = ConexionBD.getConexionConBBDD();
                ArrayList<Propiedad> propiedades = conexionBD.recibirDartosPropiedad(usuario.getCorreo());
            %>
            <h2>Seleccione el apartamento que desea modificar:</h2>
            <form action="PaginaGLA" id="formApart" method="POST">
                <table id="idA">
                    <tr>
                        <th></th>
                        <th>Identificador de apartamento</th>
                        <th>Tipo Propiedad</th>
                        <th>Barrio</th>
                        <th>Dirección</th>
                        <th>Numero de huespedes</th>
                        <th>Precio por noche</th>
                        <th>Tipo de cancelación</th>


                    </tr>
                    <%
                        for (Propiedad p : propiedades) {
                    %>
                    <tr class="subrayados" id="fila">
                        <td class="marcable"> <input type="radio" id="idApartamento" name="idApartamento" value="<%=p.getIdApartamento()%>" /></td>
                        <td> <%=p.getIdApartamento()%></td>
                        <td> <%=p.getTipoPropiedad()%></td>
                        <td> <%=p.getBarrio()%></td>
                        <td> <%=p.getDireccion()%></td>
                        <td> <%=p.getNumHuespedes()%></td>
                        <td> <%=p.getPrecioNoche()%>€</td>
                        <td> <%=p.getPoliticaDeCancelacion()%></td>
                    </tr>
                    <% }%>
                </table>
                <br>
                <input type="submit" name="btnApart" id="btnApart" value="Modificar" class="botonBuscar"/>
                <input type="submit" name="btnApart" id="btnApart" value="Eliminar" class="botonBuscar"/>
            </form>
                <form action="PaginaRP">
                    <br><input type="submit" name="btnAnadirApart" id="btnAnadirApart" value="Añadir otro apartamento" class="botonBuscar" />
                </form>
        </div>
    </body>
</html>
