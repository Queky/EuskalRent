/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

function clickGuardarJSON(){
    
    var correo = document.getElementById("correo").value;
    var nombre = document.getElementById("nombre").value;
    var apellidos = document.getElementById("apellidos").value;
    var contraseña = document.getElementById("contraseña").value;
    
    var json = {"correo":correo,"nombre":nombre,"apellidos":apellidos,"contraseña":contraseña};
    
    var datosLS = JSON.stringify(json);
    localStorage.setItem("RegistroApartamento",datosLS);
}


function revisar(elemento) {
    if (elemento.value===""){
	    elemento.className='error';
    } else {
	    elemento.className='form-input';
    }

}
function revisaremail(elemento) {
    if (elemento.value!==""){
        var dato = elemento.value;
        var expresion = /^([a-zA-Z0-9_.-])+@(([a-zA-z0-9-])+.)+([a-zA-Z0-9-]{2,4})+$/;
        if (!expresion.test(dato)) {
            elemento.className='error';
        } else {
        elemento.className='form-input';
        }
    }
}
function revisarNombreApellidos(elemento) {
    if (elemento.value!==""){
        var dato = elemento.value;
        var expresion = /[A-Za-z]{3,}/;
        if (!expresion.test(dato)) {
            elemento.className='error';
        } else {
        elemento.className='form-input';
        }
    }
}