window.addEventListener('load', inicio, false);

    function inicio() {
        document.getElementById('Caja').addEventListener('dragover', permitirDrop, false);    
        document.getElementById('Caja').addEventListener('drop', drop, false);
    }
    
    function drop(ev)
    {
        ev.preventDefault();
        var arch=new FileReader();
        arch.addEventListener('load',leer,false);
        arch.readAsDataURL(ev.dataTransfer.files[0]); 
    }      
    
    function permitirDrop(ev)
    {
        ev.preventDefault();
    }    
    
    function leer(ev) {
        document.getElementById('Caja').style.backgroundImage="url('" + ev.target.result + "')";
    }
    
    
        
  