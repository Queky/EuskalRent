/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
window.onload=actualizar;
function actualizar() {
    var datos = JSON.parse(localStorage.getItem('RegistroApartamento'));
    var correo = datos.correo;
    var nombre= datos.nombre;
    var apellidos= datos.apellidos;
    document.getElementById("email").value=correo;
    document.getElementById("nombre").value=nombre;
    document.getElementById("apellidos").value=apellidos;
    
}
/*

function clickGuardarJSON(){
    
    var correo = document.getElementById("email").value;
    var nombre = document.getElementById("nombre").value;
    var apellidos = document.getElementById("apellidos").value;
    var contrasena = document.getElementById("contrasena").value;
    
    var json = {"correo":correo,"nombre":nombre,"apellidos":apellidos,"contraseña":contrasena};
    alert("11");
    var datosLS = JSON.stringify(json);
    localStorage.setItem("RegistroApartamento",datosLS);
} */
/*
function clickGuardarMA() {
    var precio = document.getElementById("precio").value;
    var politica = document.getElementById("politica").value;
    var json = {"precio":precio,"politica":politica};

    var datosSS = JSON.stringify(json);
    sessionStorage.setItem("ModificacionApartamento",datosSS);
}

var datos = JSON.parse(localStorage.getItem('RegistroApartamento'));

function getDatosRegProp() {
    var barrioRegistrado = datos.barrio;
    var tipoApartReg = datos.tipoProp;
    var numHueReg = datos.numHuespedes;
}
*/