/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

window.onload = revisar;

function revisionGeneral() {
    var correcto = true;
    var email = document.getElementById("email");
    if(!revisarEmail()){
        correcto=false;
        email.className='error';
    }
    var nombre = document.getElementById("nombre");
    if(!revisarNombre()){
        correcto=false;
        nombre.className='error';
    }
    var apellido = document.getElementById("apellidos");
    if(!revisarApellido()){
        correcto=false;
        apellido.className='error';
    }
    var contrasena = document.getElementById("contrasena");
    if(!revisarContrasena()){
        correcto=false;
        contrasena.className='error';
    }
    if(correcto){
        document.getElementById("formRegUsuario").submit();
        alert("11");
    }
    }
function revisarEmail () {
    var email = document.getElementById("email");
    var ex = /\S+@\S+\.\S+/;
    if(!ex.test(email.value) || email.value==="")
        return false;
    else
        return true;
}

function revisarNombre() {
    var nombre = document.getElementById("nombre");
    var ex = /[A-Za-z]{3,}/;
    if(!ex.test(nombre.value) || nombre.value==="")
        return false;
    else
        return true;
}

function revisarApellido() {
    var apellido = document.getElementById("apellidos");
    var ex= /[A-Za-z]{3,}/;
    if(!ex.test(apellido.value) || apellido.value==="")
        return false;
    else
        return true;
}

function revisarContrasena() {
    var contrasena = document.getElementById("contrasena");
    if(contrasena.value==="" || contrasena===null)
        return false;
    else
        return true;
}

function revisar(){
    document.getElementById("btnRegistro").addEventListener("click", revisionGeneral, false);
    var email = document.getElementById("email");
    email.oninput = function() {
        if(!revisarEmail())
            email.className='error';
        else
            email.className='form-input';
    }
    
    var nombre = document.getElementById("nombre");
    nombre.oninput = function() {
        if(!revisarNombre())
            nombre.className='error';
        else
            nombre.className='form-input';
    }
    
    var apellido = document.getElementById("apellidos");
    apellido.oninput = function() {
        if(!revisarApellido())
            apellido.className='error';
        else
            apellido.className='form-input';
    }
    
    var contrasena = document.getElementById("contrasena");
    contrasena.oninput = function() {
        if(!revisarContrasena())
            contrasena.className='error';
        else
            contrasena.className='form-input';
    }
}