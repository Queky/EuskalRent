/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
var dropBox;

window.onload = function() {
dropBox = document.getElementById("fileOutput");
dropBox.ondragenter = ignoreDrag;
dropBox.ondragover = ignoreDrag;
dropBox.ondrop = drop;
}




function processFiles(files) {
var file = files[0];
var reader = new FileReader();
reader.onload = function (e) {
    
// Cuando éste evento se dispara, los datos están ya disponibles.
// Se trata de copiarlos a una área <div> en la página.
var output = document.getElementById("fileOutput"); 
fileOutput.style.backgroundImage= "url('" + e.target.result + "')";
fileOutput.style.border="1px solid transparent";

};

reader.readAsDataURL(file);


}

// ---------------------------------------


function ignoreDrag(e) {
e.stopPropagation();
e.preventDefault();
    
}

function drop(e) {
e.stopPropagation();
e.preventDefault();

var data = e.dataTransfer;
var files = data.files;


processFiles(files);

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