<%-- 
    Document   : Acceder
    Created on : 24-nov-2015, 11:35:23
    Author     : inakisanchez
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <link href='CSS/RegistroUsuario.css' rel='stylesheet' type='text/css'>
    <link href="//netdna.bootstrapcdn.com/font-awesome/3.1.1/css/font-awesome.css" rel="stylesheet">
    <link href='http://fonts.googleapis.com/css?family=Lato:400,700,400italic' rel='stylesheet' type='text/css'>
    <link href='http://fonts.googleapis.com/css?family=Vollkorn:700italic,400' rel='stylesheet' type='text/css'>
    <link href='http://fonts.googleapis.com/css?family=Muli' rel='stylesheet' type='text/css'>
    <link rel="shortcut icon" href="Img/iconoEuskalRent.ico">
    <script src="JavaScript/ValidacionLogin.js" type="text/javascript"></script>
    <html>
        <head>
            <meta charset="utf-8">
            <title>Accede a tu cuenta</title>
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
            <section>
                <div class="loginBox">
                    <h1>Accede a tu cuenta</h1>
                    <form action="PaginaAccederjava" method="POST" >
                            <label id="icon" for="email"><i class="icon-envelope "></i></label>
                            <input type="email" name="email" id="email" placeholder="Correo"
                                   class="form-input" required/>
                            
                            <label id="icon" for="password"> <i class="icon-shield"></i></label>
                            <input type="password" name="prueba" placeholder="Contraseña" class="form-input" required/>
                            <div class="botonRegistro">
                                <input type="submit" value="Acceder" class="button" id="btnAcceso"/>
                            </div>
                        </form>
                </div>
            </section>
        </body>
</html>