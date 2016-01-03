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

    private static Propiedad mPropiedad;
    private String barrio;
    private String tipoPropiedad;
    private Integer numHuespedes;
    private String direccion;
    private float precioNoche;
    private String politicaCancelacion;
    private String correoUsuario;
    private Propiedad() {
    }

    public static Propiedad getPropiedad() {
        if (mPropiedad == null) {
            mPropiedad = new Propiedad();
        }

        return mPropiedad;

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
    public String getCorreousuario(){
        return this.correoUsuario;
    }
    public void setCorreoUsuario(String correoUsuario){
        this.correoUsuario = correoUsuario;
    }
}
