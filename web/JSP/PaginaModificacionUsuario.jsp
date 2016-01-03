<%-- 
    Document   : PaginaModificacionUsuario
    Created on : 21-nov-2015, 13:47:41
    Author     : BEEP
--%>
<%@page import="packEuskalRent.Usuario"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href='http://fonts.googleapis.com/css?family=Lato:400,700,400italic' rel='stylesheet' type='text/css'>
<link href='http://fonts.googleapis.com/css?family=Vollkorn:700italic,400' rel='stylesheet' type='text/css'>
<link href='http://fonts.googleapis.com/css?family=Muli' rel='stylesheet' type='text/css'>
<link href='CSS/ModificacionUsusario.css' rel='stylesheet' type='text/css'>
<link rel="shortcut icon" href="Img/iconoEuskalRent.ico">
<script src="JavaScript/ValidacionModificacionUsuario.js" language="javascript" type="text/javascript"></script>
<script src="http://maps.google.com/maps/api/js?sensor=false" language="javascript" type="text/javascript"></script>
<script type="text/javascript" src="JavaScript/mapa.js" language="javascript" type="text/javascript"></script>
<script type="text/javascript" src="JavaScript/JSON_1yDandD.js" language="javascript" type="text/javascript"></script>
<!DOCTYPE html>
<html>
    <html>
        <head>


        </head>

        <header>
            <a href="Inicio" class="logo">
                <em><img src="Img/logoEuskalRent.gif"/></em>
                <em>Euskal</em><strong>Rent</strong>
            </a>
            <nav><% Usuario usuario = Usuario.getUsuario();%>
                <ul><% if(usuario.estaLogueado()){%>
                    <li><a href="PaginaModificacionUsuario">Modificar Usuario</a></li>
                     <% if(!usuario.tienePropiedad()){%>
                        <li><a href="PaginaRP">Registrar Propiedad</a></li>
                        <%}else{%>
                        <li><a href="PaginaMP">Modificar Propiedad</a></li>
                        <%}%>
                    <li><a href="PaginaCS">Cerrar Sesion</a></li>
                </ul> <%}%>     
            </nav>
        </header>
        <section>

            <div class="testbox">
                <h1 class="uploader-header">Tus datos:</h1>
                <div class="uploader-controls">
                    <p>Añade tu foto de perfil favorita:</p>
                </div>
                <div class="fileOutput" id="fileOutput"  onchange ="revisar(this)"></div>

                <div>    <form action="mUsuario" method="post">


                        <input type="email" name="email" id="email" value="<%=usuario.getCorreo()%>" placeholder="Correo" class="form-input" 
                               onkeyup="revisar(this);
                                       revisaremail(this)" required/>
                        <input type="text" name="nombre" pattern="[A-Za-z]{3,}"  id="nombre" value="<%=usuario.getNombre()%>"placeholder="Nombre" class="form-input" 
                               onkeyup="revisar(this);
                                       revisarNombreApellidos(this)" required/>
                        <input type="text" name="apellidos" value="<%=usuario.getApellido()%>" id="apellidos" placeholder="Apellidos" class="form-input" 
                               onkeyup="revisar(this);
                                       revisarNombreApellidos(this)" required/>
                        <%if (usuario.getNumTelefono() != null) {%>
                        <input type="number" name="telefono" id="numtelefono" value="<%=usuario.getNumTelefono()%>" placeholder="Numero de movil" class="form-input"
                               onkeyup="revisar(this);
                                       revisarNumeroTelefono(this)" required />
                        <%} else {%>
                        <input type="number" name="telefono" id="numtelefono"  placeholder="Numero de movil" class="form-input"
                               onkeyup="revisar(this);
                                       revisarNumeroTelefono(this)" required />
                        <%}%>
                        <%if (usuario.getDireccion() != null) {%>
                        <input type="text" id="buscadorDireccion" placeholder="Dirección" name="direccion"
                               class="form-input" onkeyup="buscarDireccion(this.id.value)" value="<%=usuario.getDireccion()%>"
                               title="Dirección a Geocode" value="" id="busDir"
                               oninput="buscarDireccion(document.getElementById('buscadorDireccion').value)" 
                               onload="buscarDireccion(document.getElementById('buscadorDireccion').value)"/>
                        <%} else {%> 
                        <input type="text" id="buscadorDireccion" placeholder="Dirección" name="direccion"
                               class="form-input" onkeyup="buscarDireccion(this.id.value)" 
                               oninput="buscarDireccion(document.getElementById('buscadorDireccion').value)"
                               title="Dirección a Geocode" value="" id="busDir" onchange=""/>
                        <%}%>
                        <div id="map" style="width: 300px; height: 200px"class="map"></div>
                        <input type="submit" value="  Guardar  " class="button" id="btnModificacionUsuario"/> </form>
                </div>

            </div>   

        </section>
    </html>

