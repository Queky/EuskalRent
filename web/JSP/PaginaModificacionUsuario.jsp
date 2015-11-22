<%-- 
    Document   : PaginaModificacionUsuario
    Created on : 21-nov-2015, 13:47:41
    Author     : BEEP
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<link href='../CSS/ModificacionUsusario.css' rel='stylesheet' type='text/css'>
<link href='http://fonts.googleapis.com/css?family=Cabin:400,500,600' rel='stylesheet' type='text/css'>
<script src="../JavaScript/ValidacionModificacionUsuario.js" language="javascript" type="text/javascript"></script>
<!DOCTYPE html>
<html>
    <html>
	<head>
		<title>Modificación del Usuario</title>	
	</head>
	<body>
		<div class="uploader">
			<h1 class="uploader-header">Tu Foto de Perfil</h1>
                            <div class="fileOutput" id="fileOutput"></div>
	
			
                        
			<div class="uploader-controls">
				<p><strong>Añade tu foto de perfil favorita</strong></p>
				
			</div>
                            <label id="icon" for="email"><i class="icon-envelope "></i></label>
  <input type="email" name="email" id="email" placeholder="Correo" class="form-input" 
         onkeyup="revisar(this); revisaremail(this)" required/>
  
  <label id="icon" for="name"> <i class="icon-user"></i></label>
  <input type="text" name="nombre" pattern="[A-Za-z]{3,}"  id="nombre" placeholder="Nombre" class="form-input" 
         onkeyup="revisar(this); revisarNombreApellidos(this)" required/>
  
  <label id="icon" for="apellidos"><i class="icon-user"></i></label>
  <input type="text" name="apellidos" id="apellidos" placeholder="Apellidos" class="form-input" 
         onkeyup="revisar(this); revisarNombreApellidos(this)" required/>
  
  <label id="icon" for="password"> <i class="icon-shield"></i></label>
  <input type="password" name="contraseña" id="contraseña" placeholder="Contraseña" class="form-input"
         onkeyup="revisar(this)" required />
		</div>
	</body>
</html>

