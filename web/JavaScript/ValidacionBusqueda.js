/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
window.onload = function() {
    // Comprobacion numero de huespedes
    var huespedes = document.getElementById("numHuespedes");
    var exp = /[1-9]/;
    huespedes.oninput = function() {
        if(this.value>10 || !exp.test(this.value)){
            huespedes.className='error';
        } else {
            huespedes.className='cajasDatos';
        }
    }
    
    var fechaInicio = document.getElementById("fechaInicio");
    fechaInicio.oninput = function() {
        var hoy = new Date();
        hoy.getDate();
        var fechaUsuario = new Date(fechaInicio.value);
        if(hoy>fechaUsuario){
            if(hoy.getDate()==fechaUsuario.getDate())
                fechaInicio.className='cajasDatos';
            else
                fechaInicio.className='error';
        } else {
            fechaInicio.className='cajasDatos';
        }
    }
    
    var fechaFin = document.getElementById("fechaFin");
    fechaFin.oninput = function() {
        var hoy = new Date();
        hoy.getDate();
        var fechaUsuario = new Date(fechaFin.value);
        if(hoy>fechaUsuario){
            if(hoy.getDate()==fechaUsuario.getDate())
                fechaFin.className='cajasDatos';
            else
                fechaFin.className='error';
        } else {
            fechaFin.className='cajasDatos';
        }
    }
}

