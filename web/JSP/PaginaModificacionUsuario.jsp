<%-- 
    Document   : PaginaModificacionUsuario
    Created on : 21-nov-2015, 13:47:41
    Author     : BEEP
--%>

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<link href='../CSS/ModificacionUsusario.css' rel='stylesheet' type='text/css'>
<script src="../JavaScript/ValidacionModificacionUsuario.js" language="javascript" type="text/javascript"></script>
<script src="http://maps.google.com/maps/api/js?sensor=false" language="javascript" type="text/javascript"></script>
<script type="text/javascript" src="../JavaScript/googleMaps.js" language="javascript" type="text/javascript"></script>
<!DOCTYPE html>
<html>
    <html>
	<head>
           

	</head>
        
          <header>
            <a href="PaginaInicio.jsp" class="logo">
                <em>Euskal</em><strong>Rent</strong>
            </a>
            <nav>
                <ul>
                    <li><a href="#">Acceder</a></li>
                    <li><a href="RegistroUsuario.jsp">Registrarse</a></li>
                </ul>      
            </nav>
        </header>
	<body>
		<div class="testbox">
			<h1 class="uploader-header">Tus datos:</h1>
                        <div class="uploader-controls">
				<p>Añade tu foto de perfil favorita:</p>
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
  <input type="text" id="buscadorDireccion" placeholder="Dirección" class="form-input" onkeyup="buscarDireccion(this.id.value)" oninput="buscarDireccion(document.getElementById('buscadorDireccion').value)" title="Dirección a Geocode" value="" id="busDir" onchange=""/>
       
  <div id="map" style="width: 300px; height: 200px"class="map"></div></div>
  <input type="submit" value="  Guardar  " class="button"/>
                         
       
         </form>
                        </div>
                </div>
	</body>
</html>

