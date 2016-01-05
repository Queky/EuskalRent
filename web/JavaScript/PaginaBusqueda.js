/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
window.onload=revisar;

function comprobar(){
    var hayUno = false;
    var rad = document.getElementsByName("idApartamento");
    for (var i = 0; i < rad.length; i++) {
        if (rad[i].checked)
            hayUno= true;
    }
    if(hayUno)
        document.getElementById("formApart").submit();
}

function revisar(){
    document.getElementById("btnApart").addEventListener("click", comprobar, false);
    $('#idA tr.subrayados').click(function (){
        //$(this).css("background", "#ffffff");
        $(this).find('td input:radio').prop('checked', true);
        //$(this).css("background", "#99ccff");
        $(this).addClass('subrayarFila').siblings().removeClass('subrayarFila');
    });
}