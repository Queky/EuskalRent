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
            <a href="Inicio" class="logo">
                <em><img src="Img/logoEuskalRent.gif"/></em>
                <em>Euskal</em><strong>Rent</strong>
            </a>
            <nav>
                <ul>
                    <%
                        Usuario usuario = (Usuario) session.getAttribute("Usuario");
                    if(usuario.estaLogueado()){
                        %>
                        <li><a href="PaginaModificacionUsuario">Modificar Usuario</a></li>
                        <% if(!usuario.tienePropiedad()){%>
                        <li><a href="PaginaRP">Registrar Propiedad</a></li>
                        <%}else{%>
                        <li><a href="PaginaMP">Modificar Propiedad</a></li>
                        <%}%>
                        <li><a href="PaginaCS">Cerrar Sesion</a></li>
                    <%}else{%>
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
            <%
                ConexionBD CB =ConexionBD.getConexionConBBDD();
                Propiedad propiedad =(Propiedad) session.getAttribute("Propiedad");
                Usuario usuarioPropiedad = CB.recibirDartosUsuario(propiedad.getCorreousuario());
                String fechaInicio= (String)session.getAttribute("fechaInicio");
                String fechaFin = (String) session.getAttribute("fechaFin");
                float coste = propiedad.calcularNumeroDeDias(fechaInicio, fechaFin)* propiedad.getPrecioNoche();
            %>
            <strong><p>Datos de la propiedad:</p></strong>
            <p>Identificador de la propiedad: <%=propiedad.getIdApartamento()%></p>
            <p>Direccion: <%=propiedad.getDireccion()%></p>
            <p>Barrio: <%=propiedad.getBarrio()%></p>
            <p>Tipo de propiedad: <%=propiedad.getTipoPropiedad()%></p>
            <p>Numero de Huespedes: <%=propiedad.getNumHuespedes()%></p>
            <strong><p>Datos del arrendador:</p></strong>
            <p>Nombre: <%=usuarioPropiedad.getNombre()%></p>
            <p>Apellidos: <%=usuarioPropiedad.getApellido()%></p>
            <% if(usuario.getDireccion()!=null){%>
            <p>Direccion: <%=usuarioPropiedad.getDireccion()%></p>
            <%}%>
            <strong><p> Contacto:</p></strong>
            <p>Correo: <%=usuarioPropiedad.getCorreo()%></p>
            <p>Numero de teléfono: <%=usuarioPropiedad.getNumTelefono()%></p>
            <strong><p> Datos de la reserva:</p></strong>
            <p>Fecha de inicio: <%=fechaInicio %></p>
            <p>Fecha fin: <%=fechaFin%></p>
            <p>Numero de días: <%=propiedad.calcularNumeroDeDias(fechaInicio,fechaFin)%></p>
            <p>Precio: <%=coste%></p>
            <p>Tipo de cancelación: <%=propiedad.getPoliticaDeCancelacion()%></p>
            <li><a href="Inicio">Reservar Propiedad</a></li>
            
        </div>
        </section>
    </body>
</html>
