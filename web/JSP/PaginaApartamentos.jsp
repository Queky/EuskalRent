<%-- 
    Document   : PaginaApartamentos
    Created on : 29-dic-2015, 8:48:31
    Author     : inakisanchez
--%>

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
                        Usuario usuario = Usuario.getUsuario();
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
                String idAp = request.getParameter("idApartamento");
                Class.forName("com.mysql.jdbc.Driver").newInstance();
                Connection connection = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/euskalrent03","root","root");
                HttpSession s=request.getSession();
                Statement statement = connection.createStatement();
                //"+s.getAttribute("fechaInicio").toString()+"
                ResultSet resultset = statement.executeQuery("select * from euskalrent03.apartamento a where a.idapartamento="+idAp+";");
                resultset.next();
            %>
        </div>
        </section>
    </body>
</html>
