<%-- 
    Document   : PaginaModificacionUsuario
    Created on : 21-nov-2015, 13:47:41
    Author     : BEEP
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<link href='../CSS/ModificacionUsusario.css' rel='stylesheet' type='text/css'>
<link href='http://fonts.googleapis.com/css?family=Cabin:400,500,600' rel='stylesheet' type='text/css'>
<script src="../JavaScript/ValidacionModificacionUsuario.js" language="javascript" type="text/javascript"></script>
<script src="../JavaScript/googleMaps.js" language="javascript" type="text/javascript"></script>
<!DOCTYPE html>
<html>
    <html>
	<head>
		<title>Modificación del Usuario</title>	
	</head>
	<body>
		<div class="uploader">
			<h1 class="uploader-header">Tus datos:</h1>
                        <div id="address" class="map"></div>
                        <div class="uploader-controls">
				<p>Añade tu foto de perfil favorita</p>
                      </div>
                        <div class="fileOutput" id="fileOutput"  onchange ="revisar(this)"></div>
                            
			
                        
                        <div>    <form>

  <input type="email" name="email" id="email" placeholder="Correo" class="form-input" 
         onkeyup="revisar(this); revisaremail(this)" required/>
  <input type="text" name="nombre" pattern="[A-Za-z]{3,}"  id="nombre" placeholder="Nombre" class="form-input" 
         onkeyup="revisar(this); revisarNombreApellidos(this)" required/>
  <input type="text" name="apellidos" id="apellidos" placeholder="Apellidos" class="form-input" 
         onkeyup="revisar(this); revisarNombreApellidos(this)" required/>
  <input type="number" name="telefono" id="contraseña" placeholder="Numero de movil" class="form-input"
         onkeyup="revisar(this)" required />
  
  <input type="submit" value="Registrarse" class="button"/>

                            </form> </div>
  
		</div>
	</body>
</html>
