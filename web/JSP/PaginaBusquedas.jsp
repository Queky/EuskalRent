<%-- 
    Document   : PaginaInicio
    Created on : 18-nov-2015, 23:10:31
    Author     : Iñaki
--%>

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
            <% 
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            Connection connection = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/euskalrent03","root","root");
            HttpSession s=request.getSession();
            Statement statement = connection.createStatement();
            //"+s.getAttribute("fechaInicio").toString()+"
            ResultSet resultset = statement.executeQuery("select * from euskalrent03.apartamento a where a.fechadisponibilidad <= '"+s.getAttribute("fechaInicio")+"' and a.numerohuespedes<="+s.getAttribute("numHuespedes")+";");
            %>
            <table>
                <tr>
                    <th>Localizador de apartamento</th>
                    <th>Tipo de propiedad</TH>
                    <th>Numero maximo de huespedes</th>
                    <th>Barrio</th>
                    <th>Tarifa</th>
                </tr>
                <% while(resultset.next()){ %>
                <tr class="subrayados">
                    <td> <%= resultset.getObject("idapartamento") %></td>
                    <td> <%= resultset.getObject("tipopropiedad") %></td>
                    <td> <%= resultset.getObject("numerohuespedes") %></td>
                    <td> <%= resultset.getObject("barrio") %></td>
                    <td> <%= resultset.getObject("tarifa") %> €</td>
                </tr>
                <% } %>
            </table>
        </div>
    </body>
</html>