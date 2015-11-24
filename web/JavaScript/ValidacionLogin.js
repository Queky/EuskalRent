/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

window.onload = revisar;

function revisionGeneral () {
    var correcto=true;
    var email = document.getElementById("email");
    if(!revisarEmail()){
        correcto = false;
        email.className='error';
    }
    var contraseña = document.getElementById("contraseña");
    if(!revisarContraseña()){
        correcto = false;
        contraseña.className='error';
    }
    if(correcto)
        document.getElementById("formLogin").submit();
}

function revisarEmail () {
    var email = document.getElementById("email");
    //var ex = /([a-zA-Z0-9_.-])+@(([a-zA-z0-9-])+.)+([a-zA-Z0-9-]{2,4})+$/;
    var ex = /\S+@\S+\.\S+/;
    if(!ex.test(email.value) || email==="")
        return false;
    else
        return true;
}

function revisarContraseña() {
    var contraseña = document.getElementById("contraseña");
    if(contraseña.value==="" || contraseña.value===null)
        return false;
    else
        return true;
}

function revisar () {
    document.getElementById("btnAcceso").addEventListener("click", revisionGeneral, false);
    var email = document.getElementById("email");
    email.oninput = function() {
        if(!revisarEmail())
            email.className='error';
        else
            email.className='form-input';
    }
    var contraseña = document.getElementById("contraseña");
    contraseña.oninput = function () {
        if(!revisarContraseña())
            contraseña.className='error';
        else
            contraseña.className='form-input';
    }
}