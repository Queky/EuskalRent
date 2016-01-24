<%-- 
    Document   : InfoReservas
    Created on : 24-ene-2016, 17:33:51
    Author     : BEEP
--%>

<%@page import="packEuskalRent.Reserva"%>
<%@page import="java.text.ParseException"%>
<%@page import="java.util.Date"%>
<%@page import="java.text.SimpleDateFormat"%>
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
                        <% if(!usuario.tienePropiedad()){%>
                        <li><a href="PaginaRP">Registrar Propiedad</a></li>
                        <%}else{%>
                        <li><a href="PaginaLA">Mis Propiedades</a></li>
                        <%}%>
                         <% if(usuario.tieneReserva()){%>
                        <li><a href="PaginaAR">Mis Reservas</a></li>
                        <%}%>
                        <li><a href="PaginaCS">Cerrar Sesion</a></li>
                </ul>      
            </nav>
        </header>
        <section>
            <div class="cajaBusqueda2">
                <%
                    ConexionBD CB = ConexionBD.getConexionConBBDD();
                    Propiedad propiedad = (Propiedad) session.getAttribute("Propiedad");
                    Reserva reserva = (Reserva) session.getAttribute("Reserva");
                    Usuario usuarioPropiedad = CB.recibirDartosUsuario(propiedad.getCorreousuario());
                    Date fechaInicio = reserva.getFechaInicio();
                    Date fechaFin = reserva.getFechaFin();
                 
                    float coste = propiedad.calcularNumeroDeDias(fechaInicio,fechaFin) * propiedad.getPrecioNoche();
                    session.setAttribute("Coste", coste);
                %>
                <strong><h3>Datos de la propiedad</h3></strong>
                <p><u>Identificador de la propiedad:</u> <%=propiedad.getIdApartamento()%></p>
                <p><u>Direccion:</u> <%=propiedad.getDireccion()%></p>
                <p><u>Barrio:</u> <%=propiedad.getBarrio()%></p>
                <p><u>Tipo de propiedad:</u> <%=propiedad.getTipoPropiedad()%></p>
                <p><u>Numero de Huespedes:</u> <%=propiedad.getNumHuespedes()%></p>
            </div><div class="cajaBusqueda2">
                <strong><h3>Datos del arrendador</h3></strong>
                <p><u>Nombre:</u> <%=usuarioPropiedad.getNombre()%></p>
                <p><u>Apellidos:</u> <%=usuarioPropiedad.getApellido()%></p>
                    <% if (usuario.getDireccion() != null) {%>
                <p><u>Direccion:</u> <%=usuarioPropiedad.getDireccion()%></p>
                    <%}%>
            </div><div class="cajaBusqueda2">
                <strong><h3> Contacto</h3></strong>
                <p><u>Correo:</u> <%=usuarioPropiedad.getCorreo()%></p>
                <p><u>Numero de teléfono:</u> <%=usuarioPropiedad.getNumTelefono()%></p>
            </div><div class="cajaBusqueda2">
                <strong><h3> Datos de la reserva</h3></strong>
                <p><u>Fecha de inicio:</u> <%=fechaInicio%></p>
                <p><u>Fecha fin:</u> <%=fechaFin%></p>
                <p><u>Numero de días:</u> <%=propiedad.calcularNumeroDeDias(fechaInicio, fechaFin)%></p>
                <p><u>Precio:</u> <%=coste%></p>
                <p><u>Tipo de cancelación:</u> <%=propiedad.getPoliticaDeCancelacion()%></p>
                <p><u>Estado de la reserva:</u> <%=reserva.getEstado()%></p>
            </div>
                <%if(reserva.getEstado().equals("Reservada")){%>
            <form action="PaginaCR">
                <input type="submit" name="btnRegistroAp" id="btnRegistroAp" value="Cancelar Reserva" class="botonBuscar" />
            </form><%}%>
        </section>
    </body>
</html>
