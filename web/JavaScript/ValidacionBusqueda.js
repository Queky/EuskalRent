/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

window.addEventListener("load", inicio, false);

function inicio(){
    document.getElementById("btnBuscar").addEventListener("click", validacion, false);
}

function validacion() {
    var barrio = document.getElementById("barrio").value;
    alert(barrio);
    /* para ejecutar el action definido en el formulario:
     * 
     * document.getElementById("formBusqueda").submit();
    */
}