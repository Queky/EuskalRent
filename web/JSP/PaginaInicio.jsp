<%-- 
    Document   : PaginaInicio
    Created on : 18-nov-2015, 23:10:31
    Author     : Iñaki
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <link rel="stylesheet" type="text/css" href="../CSS/Estiloa.css">
        <script src="../JavaScript/ValidacionBusqueda.js"></script>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <div>
            <form action="">
                <input type="submit" value="Acceder">
            </form>
            <form action="">
                <input type="submit" value="Registrarse">
            </form>
        </div>
        <div>
            <form action="" id="formBusqueda">
                Introduce el barrio:
                <input type="text" name="campoBarrio" id="barrio"><br>
                Introduce una fecha de inicio del alojamiento:
                <input type="date" name="calendarioInicio">
                <input type="date" name="calendarioFin"><br>
                <input type="button" value="Buscar" id="btnBuscar">
            </form>
        </div>
    </body>
</html>
