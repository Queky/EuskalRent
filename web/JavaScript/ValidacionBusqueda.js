/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

window.onload = revisar;

function revisionGeneral () {
    var correcto = true;
    if(!revisarHuespedes()){
        var huespedes = document.getElementById("numHuespedes");
        huespedes.className='error';
        correcto=false;
    }
    if(!revisarFechaInicio()){
        var fechaInicio = document.getElementById("fechaInicio");
        fechaInicio.className='error';
        correcto=false;
    }
    if(!revisarFechaFin()){
        var fechaFin = document.getElementById("fechaFin");
        fechaFin.className='error';
        correcto=false;
    }
    if(correcto)
        document.getElementById("formInicio").submit();
}

function revisarHuespedes() {
    var huespedes = document.getElementById("numHuespedes");
    var exp = /[1-9]/;
    if(huespedes.value>10 || !exp.test(huespedes.value) || huespedes==="")
        return false;
    else
        return true;
}

function revisarFechaInicio() {
    var fechaInicio = document.getElementById("fechaInicio");
    var hoy = new Date();
    var fechaUsuario = new Date(fechaInicio.value);
    if(fechaInicio.value==="")
        return false;
        else {
        if(hoy>fechaUsuario){
            if(hoy.getDate()==fechaUsuario.getDate())
                return true;
            else
                return false;
            }
        else
            return true;
        }
}

function revisarFechaFin() {
    var fechaInicio = document.getElementById("fechaInicio");
    var fechaFin = document.getElementById("fechaFin");
    var hoy = new Date();
    var fechaUsuario = new Date(fechaFin.value);
    if(fechaFin.value==="")
        return false;
        else {
        if(hoy>fechaUsuario){
            if(hoy.getDate()==fechaUsuario.getDate()
                    && fechaFin.value>fechaInicio.value)
                return true;
            else
                return false;
            }
        else if(fechaFin.value<=fechaInicio.value)
            return false;
        else
                return true;
        }
}
     

function revisar() {
    document.getElementById("btnBuscar").addEventListener("click", revisionGeneral, false);

    var huespedes = document.getElementById("numHuespedes");
    huespedes.oninput = function() {
        if(!revisarHuespedes()){
            huespedes.className='error';
        } else {
            huespedes.className='cajasDatos';
        }
    }
    var fechaInicio = document.getElementById("fechaInicio");
    fechaInicio.oninput = function() {
        if(revisarFechaInicio())
            fechaInicio.className='cajasDatos';
        else
            fechaInicio.className='error';
    }
    var fechaFin = document.getElementById("fechaFin");
    fechaFin.oninput = function() {
        if(revisarFechaFin())
            fechaFin.className='cajasDatos';
        else
            fechaFin.className='error';
    }
}