package packEuskalRent;

public class Usuario {


    private Propiedad propiedad;
    private String nombre;
    private String apellido;
    private String contraseña;
    private String correo;
    private Integer numTelefono;
    private String direccion;
    private boolean estaLogueado;
    private String numSesion;
    public Usuario() {
        
    }

    public void asignarPropiedad(Propiedad propiedad){
        this.propiedad = propiedad;
    }
    
    public Propiedad getPropiedad(){
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
    public void setNumSesion(String numSesion){
        this.numSesion = numSesion;
    }
    
    public String getNumSesion(){
        return this.numSesion;
    }
    
    public void loguearse(){
        this.estaLogueado =true;
    }
    public void cerrarSesion(){
        this.estaLogueado =false;
    }
    
    public boolean estaLogueado(){
        return this.estaLogueado;
    }
   
    public boolean tienePropiedad(){
    boolean tienePropiedad = false;
    if(this.propiedad != null){
        tienePropiedad =true;
                }
    return tienePropiedad;
    }
}
