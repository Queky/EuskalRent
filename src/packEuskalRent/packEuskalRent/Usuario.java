package packEuskalRent;

public class Usuario {

    private static Usuario mUsuario;
    private String nombre;
    private String apellido;
    private String contraseña;
    private String correo;
    private Integer numTelefono;
    private String direccion;

    private Usuario() {

    }

    public static Usuario getUsuario() {
        if (mUsuario == null) {
            mUsuario = new Usuario();
        }

        return mUsuario;

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

}
