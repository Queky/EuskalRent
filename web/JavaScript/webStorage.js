function clickGuardarRA(){

    var barrio = document.getElementById("barrio").value;
    var tipoApartamento = document.getElementById("tipoProp").value;
    var numHuespedes = document.getElementById("numHuespedes").value;
    
    var json = {"barrio":barrio,"tipoApartamento":tipoApartamento,"numHuespedes":numHuespedes};
    
    var datosLS = JSON.stringify(json);
    localStorage.setItem("RegistroApartamento",datosLS);
}

function clickGuardarMA() {
    var precio = document.getElementById("precio").value;
    var politica = document.getElementById("politica").value;
    
    var json = {"precio":precio,"politica":politica};

    var datosLS = JSON.stringify(json);
    localStorage.setItem("ModificacionApartamento",datosLS);
}

/*
var datos = JSON.parse(localStorage.getItem('RegistroApartamento'));

function getDatosRegProp() {
    //var barrioRegistrado = datos.barrio;
    //var tipoApartReg = datos.tipoProp;
    //var numHueReg = datos.numHuespedes;
}
*/




