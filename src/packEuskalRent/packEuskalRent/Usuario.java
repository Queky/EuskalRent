
package packEuskalRent;

import java.util.*;
import java.io.*;
import java.lang.*;

public class Usuario {

private String nombre;
private String apellido;
private String contraseña;
private String correo;
private Integer numTelefono;
private String direccion;

public Usuario(){
    super();
}

public String getNombre(){
    return this.nombre;
}

public void setNombre(String nombre){
    this.nombre=nombre;
}

public String getApellido(){
    return this.apellido;
}

public void setApellido(String apellido){
    this.apellido = apellido;
}

public String getContraseña(){
    return this.contraseña;
}

public void setContraseña(String contraseña){
    this.contraseña= contraseña;
}

public String getCorreo(){
    return this.correo;
}

public void setCorreo(String correo){
    this.correo = correo;
}

public Integer getNumTelefono(){
    return this.numTelefono;
}

public void setNumTelefono(Integer numTelefono){
    this.numTelefono = numTelefono;
}

}