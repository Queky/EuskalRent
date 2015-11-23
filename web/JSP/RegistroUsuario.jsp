<%-- 
    Document   : RegistroUsuario
    Created on : 19-nov-2015, 11:42:42
    Author     : BEEP
--%>
<html>
    <link href='../CSS/RegistroUsuario.css' rel='stylesheet' type='text/css'>
    <link href="//netdna.bootstrapcdn.com/font-awesome/3.1.1/css/font-awesome.css" rel="stylesheet">
    <link href='http://fonts.googleapis.com/css?family=Lato:400,700,400italic' rel='stylesheet' type='text/css'>
    <link href='http://fonts.googleapis.com/css?family=Vollkorn:700italic,400' rel='stylesheet' type='text/css'>
    <link href='http://fonts.googleapis.com/css?family=Muli' rel='stylesheet' type='text/css'>
    <script src="../JavaScript/ValidacionesRegistro.js" language="javascript" type="text/javascript"></script>
    <html>
        <head>
            <meta charset="utf-8">
            <title>Pagina Registro</title>
        </head>
        <body>
            <header>
                <a href="PaginaInicio.jsp" class="logo">
                    <em>Euskal</em><strong>Rent</strong>
                </a>
                <nav>
                    <ul>
                        <li><a href="#">Acceder</a></li>
                        <li><a href="#">Registrarse</a></li>
                    </ul>      
                </nav>
            </header>
            <section>
                <div class="testbox">
                    <h1>Registro</h1>
                    <form action="https://www.google.es" method="post">

                        <label id="icon" for="email"><i class="icon-envelope "></i></label>
                        <input type="email" name="email" id="email" placeholder="Correo" class="form-input" 
                               onkeyup="revisar(this);
                                       revisaremail(this)" required/>

                        <label id="icon" for="name"> <i class="icon-user"></i></label>
                        <input type="text" name="nombre" pattern="[A-Za-z]{3,}"  id="nombre" placeholder="Nombre" class="form-input" 
                               onclick="revisar(this);
                                       revisarNombreApellidos(this)" required/>

                        <label id="icon" for="apellidos"><i class="icon-user"></i></label>
                        <input type="text" name="apellidos" id="apellidos" placeholder="Apellidos" class="form-input" 
                               onkeyup="revisar(this);
                                       revisarNombreApellidos(this)" required/>

                        <label id="icon" for="password"> <i class="icon-shield"></i></label>
                        <input type="password" name="contraseña" id="contraseña" placeholder="Contraseña" class="form-input"
                               onkeyup="revisar(this)" required />
                        <div class="botonRegistro">
                        <input type="submit" value="Registrarse" class="button"/>
                        </div>
                        <form/>
                </div>
                <section/>
                <body/>
                <html/>