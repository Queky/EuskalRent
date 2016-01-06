/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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
function revisarNumeroTelefono(elemento) {
    if (elemento.value!==""){
        var dato = elemento.value;
        var expresion = /^[6|7]{1}([\d]{2}[-]*){3}[\d]{2}$/;
        if(!expresion.test(dato)) {
                elemento.className='error';
        } else {
            elemento.className='form-input';
        }
    }
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
var dropBox;

window.onload = function() {
dropBox = document.getElementById("fileOutput");
dropBox.ondragover = dragOver;
dropBox.ondragleave = dragLeave;
dropBox.ondrop = drop;
}

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

function dragOver() {
    var img = document.getElementById("fileOutput");
    img.className='fileOutput dragOver';
    
    return false;
}

function dragLeave(e) {
    var img = document.getElementById("fileOutput");
    img.className='fileOutput dragLeave';
    return false;
}

function dragDrop(e) {
    var img = document.getElementById("fileOutput");
    img.className='fileOutput dragDrop';
    return false;
}
