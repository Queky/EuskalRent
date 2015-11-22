/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
function revisar(elemento) {
    if (elemento.value===""){
	    
    } else {
	    elemento.className='LELE';
            alert("aqui");
    }}
function processFiles(files) {
var file = files[0];
var reader = new FileReader();
reader.onload = function (e) {
    
// Cuando éste evento se dispara, los datos están ya disponibles.
// Se trata de copiarlos a una área <div> en la página.
var output = document.getElementById("fileOutput"); 
fileOutput.style.backgroundImage= "url('" + e.target.result + "')";
};

reader.readAsDataURL(file);


}

// ---------------------------------------
var dropBox;

window.onload = function() {
dropBox = document.getElementById("fileOutput");
dropBox.ondragenter = ignoreDrag;
dropBox.ondragover = ignoreDrag;
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
// ----------------------------------------
