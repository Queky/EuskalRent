/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package packEuskalRent;

/**
 *
 * @author Eneko
 */
public class Propiedad {

    private String barrio;
    private String tipoPropiedad;
    private Integer numHuespedes;
    private String direccion;
    private float precioNoche = 0;
    private String politicaCancelacion;
    private String correoUsuario;
    private String fechaDisponible;
    private int isApartamento;

    public Propiedad() {
    }

    public int getIdApartamento() {
        return this.isApartamento;
    }

    public void setIdApartamento(int idApartamento) {
        this.isApartamento = idApartamento;
    }

    public String getFechaDisponible() {
        return this.fechaDisponible;
    }

    public void setFechaDisponible(String fechaDisponible) {
        this.fechaDisponible = fechaDisponible;
    }

    public String getBarrio() {
        return this.barrio;
    }

    public void setBarrio(String barrio) {
        this.barrio = barrio;
    }

    public String getTipoPropiedad() {
        return this.tipoPropiedad;
    }

    public void setTipoPropieedad(String tipoPropiedad) {
        this.tipoPropiedad = tipoPropiedad;
    }

    public Integer getNumHuespedes() {
        return this.numHuespedes;
    }

    public void setNumHuespedes(Integer numHuespedes) {
        this.numHuespedes = numHuespedes;
    }

    public String getDireccion() {
        return this.direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public float getPrecioNoche() {
        return this.precioNoche;
    }

    public void setPrecioNoche(float precioNoche) {
        this.precioNoche = precioNoche;
    }

    public String getPoliticaDeCancelacion() {
        return this.politicaCancelacion;
    }

    public void setPoliticaDeCancelacion(String politicaCancelacion) {
        this.politicaCancelacion = politicaCancelacion;
    }

    public String getCorreousuario() {
        return this.correoUsuario;
    }

    public void setCorreoUsuario(String correoUsuario) {
        this.correoUsuario = correoUsuario;
    }

    public int calcularNumeroDeDias(String fechaInicio, String fechaFinal) {

        char a = fechaInicio.charAt(fechaInicio.length() - 2);
        char b = fechaInicio.charAt(fechaInicio.length() - 1);

        String primerDia = "";
        primerDia = primerDia + a;
        primerDia = primerDia + b;

        char c = fechaFinal.charAt(fechaFinal.length() - 2);
        char d = fechaFinal.charAt(fechaFinal.length() - 1);

        String ultimoDia = "";
        ultimoDia = ultimoDia + c;
        ultimoDia = ultimoDia + d;

        char mes1 = fechaInicio.charAt(fechaInicio.length() - 5);
        char mes2 = fechaInicio.charAt(fechaInicio.length() - 4);
        String primerMes = "";
        primerMes = primerMes + mes1;
        primerMes = primerMes + mes2;

        char mes3 = fechaFinal.charAt(fechaFinal.length() - 5);
        char mes4 = fechaFinal.charAt(fechaFinal.length() - 4);
        String segundoMes = "";
        segundoMes = segundoMes + mes3;
        segundoMes = segundoMes + mes4;
        int dia1 = Integer.parseInt(primerDia);
        int dia2 = Integer.parseInt(ultimoDia);
        int elMesPrimero = Integer.parseInt(primerMes);
        int elMesSegundo = Integer.parseInt(segundoMes);
        int resultado = 0;
        System.out.println(elMesPrimero);
         System.out.println(elMesSegundo);
        if (elMesPrimero == elMesSegundo) {
            resultado = dia2 - dia1;
        } else {
            if (elMesSegundo - elMesPrimero == 1) {
                dia1 = (dia1 - 31) * (-1);
                resultado = dia2 - dia1;

            } 
                if( elMesPrimero==1 && elMesSegundo>2){
                dia1 = (dia1 - 31) * (-1);
                System.out.println(dia1);
                if(elMesSegundo%2==0 && elMesSegundo<7){
                    dia2 =(dia2-30)*(-1);
                    System.out.println(dia2);
                int numMeses = elMesSegundo - 2;
                int totalDias = (numMeses*31)-(numMeses/2);
                resultado=dia1+29+totalDias-dia2;
                }
                if(elMesSegundo%2!=0 && elMesSegundo<7){
                     dia2 =(dia2-31)*(-1);
                     System.out.println(dia2);
                int numMeses = (elMesPrimero+elMesSegundo)-3;
                System.out.println(numMeses);
                int totaldias= (numMeses*31)-(numMeses/3);
                System.out.println(totaldias);
                resultado = dia1 +29+ totaldias-dia2;
                }
                }if( elMesPrimero==2){
                dia1 = (dia1 - 29) * (-1);
                
                if(elMesSegundo%2==0 && elMesSegundo<7){
                dia2 =(dia2-31)*(-1);
                int numMeses = elMesSegundo - 2;
                int totalDias = (numMeses*31)-(numMeses/2);
                resultado=dia1+totalDias-dia2;
                }
                if(elMesSegundo%2!=0 && elMesSegundo<7){
                    dia2 =(dia2-30)*(-1);
                int numMeses = (elMesPrimero+elMesSegundo)-3;
                int totaldias= (numMeses*31)-(numMeses/3);
                resultado = dia1 + totaldias-dia2;
                }
            
             
                    
                }
            }
        
       
        return resultado;
    }
}
    