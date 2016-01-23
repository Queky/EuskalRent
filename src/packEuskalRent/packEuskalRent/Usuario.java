package packEuskalRent;

import java.util.ArrayList;

public class Usuario {

    private ArrayList<Propiedad> propiedad = new ArrayList<>();
    private String nombre;
    private String apellido;
    private String contraseña;
    private String correo;
    private Integer numTelefono;
    private String direccion;
    private boolean estaLogueado;
    private String numSesion;
    private float saldo;
    private ArrayList<Reserva> reserva = new ArrayList<>();

    public Usuario() {

    }

    public void setSaldo(float Saldo) {
        this.saldo = saldo;
    }

    public float getSaldo() {
        return this.saldo;
    }

    public void addPropiedades(Propiedad propiedad) {
        this.propiedad.add(propiedad);
    }

    public void eliminarActualizado(String direccion) {
        for (Propiedad p : propiedad) {
            if (p.getDireccion().equals(direccion)) {
                propiedad.remove(p);
            }
        }

    }

    public void setPropiedades(ArrayList<Propiedad> propiedad) {
        for (Propiedad p : propiedad) {
            this.propiedad.add(p);
        }
    }

    public ArrayList<Propiedad> getPropiedad() {
        return this.propiedad;
    }

    public String getNombre() {
        return this.nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return this.apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getContraseña() {
        return this.contraseña;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }

    public String getCorreo() {
        return this.correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public Integer getNumTelefono() {
        return this.numTelefono;
    }

    public void setNumTelefono(Integer numTelefono) {
        this.numTelefono = numTelefono;
    }

    public String getDireccion() {
        return this.direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public void setNumSesion(String numSesion) {
        this.numSesion = numSesion;
    }

    public String getNumSesion() {
        return this.numSesion;
    }

    public void loguearse() {
        this.estaLogueado = true;
    }

    public void cerrarSesion() {
        this.estaLogueado = false;
    }

    public boolean estaLogueado() {
        return this.estaLogueado;
    }

    public boolean tienePropiedad() {
        boolean tienePropiedad = false;
        ConexionBD CB = ConexionBD.getConexionConBBDD();
        if (CB.tienePropiedad(correo)) {
            tienePropiedad = true;
        }
        return tienePropiedad;
    }

    public boolean tieneReserva() {
        boolean tieneReserva = false;
        if (!reserva.isEmpty()) {
            tieneReserva = true;
        }
        return tieneReserva;
    }

    public void setReservas(ArrayList<Reserva> reservas) {
        for (Reserva r : reservas) {
            reserva.add(r);
        }
    }

    public ArrayList getReservas() {
        return this.reserva;
    }
}
