<%-- 
    Document   : PaginaInicio
    Created on : 18-nov-2015, 23:10:31
    Author     : Iñaki
--%>

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
                        boolean logueado=false;
                        if(session.getAttribute("Usuario")!=null){
                        Usuario usuario = (Usuario) session.getAttribute("Usuario"); 
                        session.setAttribute("Usuario", usuario);
                        logueado = true;
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
                        <li><a href="PaginaCS">Cerrar Sesion</a></li>>
                    <%}}else{%>
                        <li><a href="Acceso">Acceder</a></li>
                        <li><a href="Registro">Registrarse</a></li>
                        <%
                    }
                    %>
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
            ResultSet resultset;
            if(logueado){
                Usuario u = (Usuario) s.getAttribute("Usuario");
                resultset = statement.executeQuery("select a.* from euskalrent03.apartamento a left join reserva r on a.idapartamento=r.idapartamento where a.fechadisponibilidad <= '"+s.getAttribute("fechaInicio")+"' and a.numerohuespedes>="+s.getAttribute("numHuespedes")+" and a.barrio='"+s.getAttribute("barrioElegido")+"' and a.idemail!='"+u.getCorreo()+"' and (('"+s.getAttribute("fechaInicio")+"' < r.fechainicio and '"+s.getAttribute("fechaFin")+"' <= r.fechainicio or fechainicio is null) or ('"+s.getAttribute("fechaInicio")+"' >= r.fechafinal and '"+s.getAttribute("fechaFin")+"' > r.fechafinal or fechafinal is null)) ;");
            }else
                resultset = statement.executeQuery("select a.* from euskalrent03.apartamento a left join reserva r on a.idapartamento=r.idapartamento where a.fechadisponibilidad <= '"+s.getAttribute("fechaInicio")+"' and a.numerohuespedes>="+s.getAttribute("numHuespedes")+" and a.barrio='"+s.getAttribute("barrioElegido")+"' and (('"+s.getAttribute("fechaInicio")+"' < r.fechainicio and '"+s.getAttribute("fechaFin")+"' <= r.fechainicio or fechainicio is null) or ('"+s.getAttribute("fechaInicio")+"' >= r.fechafinal and '"+s.getAttribute("fechaFin")+"' > r.fechafinal or fechafinal is null));");  
            %>
            <form action="PaginaSB" id="formApart" method="POST">
                <table id="idA">
                <tr>
                    <th></th>
                    <th>Localizador de apartamento</th>
                    <th>Tipo de propiedad</th>
                    <th>Numero maximo de huespedes</p></th>
                    <th>Barrio</th>
                    <th>Tarifa/Noche</th>
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
                    <tr class="subrayados" id="fila">
                        <td class="marcable"> <input type="radio" id="idApartamento" name="idApartamento" value="<%= resultset.getObject("idapartamento")%>" /></td>
                            <td> <%= resultset.getObject("idapartamento")%></td>
                            <td> <%= resultset.getObject("tipopropiedad") %></td>
                            <td> <%= resultset.getObject("numerohuespedes") %></td>
                            <td> <%= resultset.getObject("barrio") %></td>
                            <td> <%= resultset.getObject("tarifa") %> €</td>
                        </tr>
                        <% }
                    }else{
                        response.sendRedirect("SinApartamentos");
                    }
                    %>
            </table>
            <br>
            <input type="button" name="btnApart" id="btnApart" value="Elegir" class="botonBuscar"/>
            </form>
        </div>
    </body>
</html>