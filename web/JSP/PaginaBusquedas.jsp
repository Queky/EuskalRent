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
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.4/jquery.min.js"></script>
        <script>
        $(document).ready(function(){
            $("p").click(function(){
                //window.location.href="ApartamentoElegido";
                $(location).attr('href', 'ApartamentoElegido');
            });
        });
        </script>
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
                    <th><p>Localizador de apartamento</th>
                    <th><p>Tipo de propiedad</p></TH>
                    <th><p>Numero maximo de huespedes</p></th>
                    <th><p>Barrio</p></th>
                    <th><p>Tarifa/Noche</p></th>
                </tr>
                    <%
                    int cont=1;
                    while(resultset.next()){
                        cont++;
                    }
                    resultset.beforeFirst();
                    if(cont>1){
                        while(resultset.next()){
                    %>
                        <tr class="subrayados">
                            <td><p> <%= resultset.getObject("idapartamento") %></p></td>
                            <td><p> <%= resultset.getObject("tipopropiedad") %></p></td>
                            <td><p> <%= resultset.getObject("numerohuespedes") %></p></td>
                            <td><p> <%= resultset.getObject("barrio") %></p></td>
                            <td><p> <%= resultset.getObject("tarifa") %> €</p></td>
                </tr>
                        <% }
                    }else{
                        response.sendRedirect("SinApartamentos");
                    }%>
            </table>
        </div>
    </body>
</html>