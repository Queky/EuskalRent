/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

function guardarJSon() {
    var barrio = document.getElementById("barrio").value;
    var huespedes = document.getElementById("numHuespedes").value;
    var fechaInicio = document.getElementById("fechaInicio").value;
    var fechaFin = document.getElementById("fechaFin").value;
    
    var json = {"barrio":barrio,"huespedes":huespedes, "fechaInicio": fechaInicio,
        "fechaFin": fechaFin};
    
    var datosLocal = JSON.stringify(json);
    localStorage.setItem("BusquedaApartamento",datosLocal);
}