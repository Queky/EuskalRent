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

    var datosSS = JSON.stringify(json);
    sessionStorage.setItem("ModificacionApartamento",datosSS);
}

var datos = JSON.parse(localStorage.getItem('RegistroApartamento'));

function getDatosRegProp() {
    var barrioRegistrado = datos.barrio;
    var tipoApartReg = datos.tipoProp;
    var numHueReg = datos.numHuespedes;
}

http://samcroft.co.uk/2013/using-localstorage-to-store-json/
http://www.aprenderaprogramar.es/index.php?option=com_content&view=article&id=888:sessionstorage-y-localstorage-javascript-diferencias-guardar-datos-en-cache-y-persistencia-cu01198e&catid=78:tutorial-basico-programador-web-javascript-desde-&Itemid=206

