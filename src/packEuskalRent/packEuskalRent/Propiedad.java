/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package packEuskalRent;

 import java.util.Date;

/**
 *
 * @author Eneko
 */
public class Propiedad {

    private String barrio;
    private String tipoPropiedad;
    private Integer numHuespedes;
    private String direccion;
    private float precioNoche = 1;
    private String politicaCancelacion;
    private String correoUsuario;
    private String fechaDisponible;
    private int idApartamento;

    public Propiedad() {
    }

    public int getIdApartamento() {
        return this.idApartamento;
    }

    public void setIdApartamento(int idApartamento) {
        this.idApartamento = idApartamento;
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

    public float calcularNumeroDeDias(Date fechaInicio, Date fechaFinal) {
    float diferencia = fechaFinal.getTime()-fechaInicio.getTime();
    System.out.println("Diferencias en dias: " +diferencia/(3600000*24));
       
    float resul = diferencia/(3600000*24);
     
        return resul ;
    }
}
    