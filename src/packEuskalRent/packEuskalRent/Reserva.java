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
