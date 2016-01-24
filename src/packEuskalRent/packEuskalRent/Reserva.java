/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package packEuskalRent;

import java.util.Date;

/**
 *
 * @author BEEP
 */
public class Reserva {

    private int idReserva;
    private int idApartamento;
    private String correoUsuario;
    private Date fechaInicio;
    private Date fechaFin;
    private String estadoReserva;
    private String tipoCancelacion;
    private float costeReserva;
    
    public void setTipoCancelacion(String tipoCancelacion){
        this.tipoCancelacion=tipoCancelacion;

    }
    public String getTipoCancelacion(){
    return this.tipoCancelacion;
    }
     public void setCosteReserva(Float coste){
     this.costeReserva= coste;
     }
     public float getCosteReserva(){
     return this.costeReserva;
     }
    
     public void setEstado(String estado){
         this.estadoReserva =estado;
        }
    public void setEstado(int num){
    if(num == 0)
        estadoReserva="Reservada";
    if(num ==1 )
        estadoReserva="En curso";
    if(num ==2)
        estadoReserva= "Completada";
    
    }
    
    public String getEstado(){
    return this.estadoReserva;
    }
    
    public void setIdReserva(int idReserva) {
        this.idReserva = idReserva;
    }

    public int getIdReserva() {
        return this.idReserva;
    }
      public void setIdApartamento(int idApartamento) {
        this.idApartamento = idApartamento;
    }

    public int getIdApartamento() {
        return this.idApartamento;
    }

    public void setCorreoUsuario(String correo) {
        this.correoUsuario = correo;
    }

    public String getCorreoUsuario() {
        return this.correoUsuario;
    }

    public void setFechaInicio(Date fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public void setFechaFin(Date fechaFin) {
        this.fechaFin = fechaFin;
    }

    public Date getFechaInicio() {
        return this.fechaInicio;
    }

    public Date getFechaFin() {
        return this.fechaFin;
    }
}
