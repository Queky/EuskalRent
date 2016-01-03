package packEuskalRent;

import java.sql.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

//Diseño responsive para la conexion con la base de datos
public class ConexionBD {

    private static ConexionBD mConexionBD;
    private Connection con;

    ConexionBD() {
    }

    public static ConexionBD getConexionConBBDD() {
        if (mConexionBD == null) {
            mConexionBD = new ConexionBD();
        }

        return mConexionBD;

    }

    private void crearConexion() {
        //Cargamos el Driver
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e1) {
        };
        //Establecemos Conexion
        try {
            String sURL = "jdbc:mysql://localhost/euskalrent03";
            String userName = "root";
            String password = "root";
            con = DriverManager.getConnection(sURL, userName, password);
            System.out.println("Conexion creada");
        } catch (SQLException e5) {
            System.out.println(e5.toString());
        }
    }

    private void cerrarConexion() {
        try {
            con.close();
            System.out.println("Conexion cerrada");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void anyadirDatosUsuario(String nombre, String apellido, String correo, String contraseña, Integer numTelefono) {
        crearConexion();
        Statement st;
        try {
            st = con.createStatement();
            st.executeUpdate("INSERT INTO `euskalrent03`.`usuario` (`Nombre`,`Apellido`,`idEmail`,`Contraseña`,`NumeroTelefono`)"
                    + " VALUES ('" + nombre + "','" + apellido + "','" + correo + "','" + contraseña + "','" + numTelefono + "');");
        } catch (SQLException e) {

            e.printStackTrace();
        }
        cerrarConexion();
    }

    public void anyadirDatosUsuario(String nombre, String apellido, String correo, String contraseña, Integer numTelefono, String direccion) {
        crearConexion();
        Statement st;
        try {
            st = con.createStatement();
            st.executeUpdate("INSERT INTO `euskalrent03`.`usuario` (`Nombre`,`Apellido`,`idEmail`,`Contraseña`,`NumeroTelefono`,`Direccion`)"
                    + " VALUES ('" + nombre + "','" + apellido + "','" + correo + "','" + contraseña + "','" + numTelefono + "','" + direccion + "');");
        } catch (SQLException e) {

            e.printStackTrace();
        }
        cerrarConexion();
    }

    public boolean estaRegistrado(String correo) {
        crearConexion();
        Statement st;
        String resul;
        boolean encontrado = false;
        try {
            st = con.createStatement();
            ResultSet rs = st.executeQuery("select idEmail from usuario where idEmail='" + correo + "';");
            while (rs.next()) {
                resul = rs.getString("idEmail");
                if (resul.equalsIgnoreCase(correo)) {
                    encontrado = true;
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();

        }
         cerrarConexion();
        return encontrado;
    }

    public boolean coincideContraseñaEmail(String correo, String contraseña) {
        crearConexion();
        Statement st;
        
        boolean coinciden = false;
        try {
            st = con.createStatement();
            ResultSet rs = st.executeQuery("select idEmail, contraseña from usuario where idEmail='" + correo + "' and contraseña='" + contraseña + "';");
            while (rs.next()) {
               String contr = rs.getString("contraseña");
               String ema = rs.getString("idEmail");
                
                if (contr.equalsIgnoreCase(contraseña) && ema.equalsIgnoreCase(correo)) {
                    coinciden = true;
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();

        }
         cerrarConexion();
        return coinciden;
    }
}
