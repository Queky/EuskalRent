window.onload = revisar;

function revisionGeneral () {
    var correcto = true;
    if(!revisarPrecio()){
        var precio = document.getElementById("precio");
        precio.className='error';
        correcto=false;
    }
    if(!revisarFoto()){
        var foto = document.getElementById("caja");
        foto.className='error';
        correcto=false;
    }
    if(correcto)
        document.getElementById("formModProp").submit();
        
}

function revisarPrecio() {
    var precio = document.getElementById("precio");
    if(precio.value<1 || precio.value==="")
        return false;
    else
        return true;
}

function revisarFoto() {
    var foto = document.getElementById("caja");
    if(foto.value==="")
        return false;
    else
        return true;
}

function revisar() {
    document.getElementById("btnValMP").addEventListener("click", revisionGeneral, false);

    var precio = document.getElementById("precio");
    precio.oninput = function() {
        if(!revisarPrecio()){
            precio.className='error';
        } else {
            precio.className='cajasDatos';
        }
    }
    var foto = document.getElementById("caja");
    foto.oninput = function() {
        if(!revisarFoto()){
            foto.className='error';
        } else {
            foto.className='cajasDatos';
        }
    }
}


