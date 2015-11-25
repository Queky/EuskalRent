window.onload = revisar;

function revisionGeneral () {
    var correcto = true;
    if(!revisarHuespedes()){
        var huespedes = document.getElementById("numHuespedes");
        huespedes.className='error';
        correcto=false;
    }
    if(correcto)
        document.getElementById("formProp").submit();
        
}

function revisarHuespedes() {
    var huespedes = document.getElementById("numHuespedes");
    var exp = /[1-9]/;
    if(huespedes.value>10 || !exp.test(huespedes.value) || huespedes==="")
        return false;
    else
        return true;
}

function revisar() {
    document.getElementById("btnValRP").addEventListener("click", revisionGeneral, false);

    var huespedes = document.getElementById("numHuespedes");
    huespedes.oninput = function() {
        if(!revisarHuespedes()){
            huespedes.className='error';
        } else {
            huespedes.className='cajasDatos';
        }
    }
}
   