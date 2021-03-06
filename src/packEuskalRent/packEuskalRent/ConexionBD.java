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

    public boolean tienePropiedad(String correo) {
        crearConexion();
        Statement st;
        String resul;
        boolean encontrado = false;
        try {
            st = con.createStatement();
            ResultSet rs = st.executeQuery("select idEmail from apartamento where idEmail='" + correo + "';");
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

    public Usuario recibirDartosUsuario(String correo) {
        Usuario usuario = new Usuario();
        crearConexion();
        Statement st;

        try {
            st = con.createStatement();
            ResultSet rs = st.executeQuery("select * from usuario where idEmail='" + correo + "';");
            while (rs.next()) {

                usuario.setCorreo(rs.getString("idEmail"));
                usuario.setContraseña(rs.getString("contraseña"));
                usuario.setNombre(rs.getString("Nombre"));
                usuario.setApellido(rs.getString("Apellido"));
                usuario.setNumTelefono(rs.getInt("NumeroTelefono"));
                usuario.setDireccion(rs.getString("Direccion"));
                usuario.setPropiedades(recibirDartosPropiedad(correo));
                usuario.setReservas(recibirDatosReservas(correo));
                usuario.setSaldo(ObtenerSaldoUsuario(correo));
            }
        } catch (SQLException e) {
            e.printStackTrace();

        }
        cerrarConexion();
        return usuario;

    }

    public void anyadirDatosPrpiedad(String Barrio, String tipoPropiedad, float precioNoche, Integer numHuespedes, String correo, String direccion, String tipoCancelacion, String fechaDisponible) {

        crearConexion();
        Statement st;
        try {
            st = con.createStatement();
            st.executeUpdate("INSERT INTO `euskalrent03`.`apartamento` (`Barrio`,`TipoPropiedad`,`Tarifa`,`NumeroHuespedes`,`idEmail`,`Direccion`,`TipoCancelacion`,`fechaDisponibilidad`)"
                    + " VALUES ('" + Barrio + "','" + tipoPropiedad + "','" + precioNoche + "','" + numHuespedes + "','" + correo + "','" + direccion + "','" + tipoCancelacion + "','" + fechaDisponible + "');");
        } catch (SQLException e) {

            e.printStackTrace();
        }
        cerrarConexion();
    }

    public ArrayList<Propiedad> recibirDartosPropiedad(String correo) {
        ArrayList<Propiedad> propiedades = new ArrayList<>();
        crearConexion();
        Statement st;

        try {
            st = con.createStatement();
            ResultSet rs = st.executeQuery("select * from apartamento where idEmail='" + correo + "';");
            while (rs.next()) {
                Propiedad propiedad = new Propiedad();
                propiedad.setBarrio(rs.getString("Barrio"));
                propiedad.setCorreoUsuario(rs.getString("idEmail"));
                propiedad.setDireccion(rs.getString("Direccion"));
                propiedad.setNumHuespedes(rs.getInt("NumeroHuespedes"));
                propiedad.setPoliticaDeCancelacion(rs.getString("TipoCancelacion"));
                propiedad.setPrecioNoche(rs.getFloat("Tarifa"));
                propiedad.setTipoPropieedad(rs.getString("TipoPropiedad"));
                propiedad.setIdApartamento(rs.getInt("idApartamento"));
                propiedades.add(propiedad);
            }
        } catch (SQLException e) {
            e.printStackTrace();

        }
        cerrarConexion();
        return propiedades;

    }

    public Propiedad recibirDartosPropiedad(int idApartamento) {
        Propiedad propiedad = new Propiedad();
        crearConexion();
        Statement st;

        try {
            st = con.createStatement();
            ResultSet rs = st.executeQuery("select * from apartamento where idApartamento='" + idApartamento + "';");
            while (rs.next()) {
                
                propiedad.setIdApartamento(rs.getInt("idApartamento"));
                propiedad.setBarrio(rs.getString("Barrio"));
                propiedad.setCorreoUsuario(rs.getString("idEmail"));
                propiedad.setDireccion(rs.getString("Direccion"));
                propiedad.setNumHuespedes(rs.getInt("NumeroHuespedes"));
                propiedad.setPoliticaDeCancelacion(rs.getString("TipoCancelacion"));
                propiedad.setPrecioNoche(rs.getFloat("Tarifa"));
                propiedad.setTipoPropieedad(rs.getString("TipoPropiedad"));
                propiedad.setFechaDisponible(rs.getString("fechaDisponibilidad"));
                

            }
        } catch (SQLException e) {
            e.printStackTrace();

        }
        cerrarConexion();
        return propiedad;

    }
     public Propiedad recibirDartosPropiedadDireccion(String direccion) {
        Propiedad propiedad = new Propiedad();
        crearConexion();
        Statement st;

        try {
            st = con.createStatement();
            ResultSet rs = st.executeQuery("select * from apartamento where Direccion='" + direccion + "';");
            while (rs.next()) {
                
                propiedad.setIdApartamento(rs.getInt("idApartamento"));
                propiedad.setBarrio(rs.getString("Barrio"));
                propiedad.setCorreoUsuario(rs.getString("idEmail"));
                propiedad.setDireccion(rs.getString("Direccion"));
                propiedad.setNumHuespedes(rs.getInt("NumeroHuespedes"));
                propiedad.setPoliticaDeCancelacion(rs.getString("TipoCancelacion"));
                propiedad.setPrecioNoche(rs.getFloat("Tarifa"));
                propiedad.setTipoPropieedad(rs.getString("TipoPropiedad"));
                

            }
        } catch (SQLException e) {
            e.printStackTrace();

        }
        cerrarConexion();
        return propiedad;

    }

    public int getIdApartamentoBD(String correo) {
        int idApartamento = 0;
        crearConexion();
        Statement st;

        try {
            st = con.createStatement();
            ResultSet rs = st.executeQuery("select idApartamento from apartamento where idEmail='" + correo + "';");
            while (rs.next()) {
                idApartamento = rs.getInt("idApartamento");

            }
        } catch (SQLException e) {
            e.printStackTrace();

        }
        cerrarConexion();
        return idApartamento;

    }

    public void actualizarIdApartamentoUsuarioBD(String correo) {
        int idApartamento = mConexionBD.getIdApartamentoBD(correo);
        crearConexion();
        Statement st;

        try {
            st = con.createStatement();
            st.executeUpdate("UPDATE `euskalrent03`.`usuario` SET `IdApartamento`='" + idApartamento + "' WHERE idEmail='" + correo + "';");

        } catch (SQLException e) {
            e.printStackTrace();

        }
        cerrarConexion();

    }

    public void actualizarNombreUsuario(String correo, String nombre) {
        crearConexion();
        Statement st;

        try {
            st = con.createStatement();
            st.executeUpdate("UPDATE `euskalrent03`.`usuario` SET `Nombre`='" + nombre + "' WHERE idEmail='" + correo + "';");

        } catch (SQLException e) {
            e.printStackTrace();

        }
        cerrarConexion();
    }

    public void actualizarApellidosUsuario(String correo, String apellido) {
        crearConexion();
        Statement st;

        try {
            st = con.createStatement();
            st.executeUpdate("UPDATE `euskalrent03`.`usuario` SET `Apellido`='" + apellido + "' WHERE idEmail='" + correo + "';");

        } catch (SQLException e) {
            e.printStackTrace();

        }
        cerrarConexion();
    }

    public void actualizarNumTelefonoUsuario(String correo, Integer numTelefono) {
        crearConexion();
        Statement st;

        try {
            st = con.createStatement();
            st.executeUpdate("UPDATE `euskalrent03`.`usuario` SET `NumeroTelefono`='" + numTelefono + "' WHERE idEmail='" + correo + "';");

        } catch (SQLException e) {
            e.printStackTrace();

        }
        cerrarConexion();
    }

    public void actualizarDireccionUsuario(String correo, String direccion) {
        crearConexion();
        Statement st;

        try {
            st = con.createStatement();
            st.executeUpdate("UPDATE `euskalrent03`.`usuario` SET `Direccion`='" + direccion + "' WHERE idEmail='" + correo + "';");

        } catch (SQLException e) {
            e.printStackTrace();

        }
        cerrarConexion();
    }

    public void actualizarTipoPropiedad(String correo, String tipoPropiedad) {
        crearConexion();
        Statement st;

        try {
            st = con.createStatement();
            st.executeUpdate("UPDATE `euskalrent03`.`apartamento` SET `TipoPropiedad`='" + tipoPropiedad + "' WHERE idEmail='" + correo + "';");

        } catch (SQLException e) {
            e.printStackTrace();

        }
        cerrarConexion();
    }

    public void actualizarNumeroHuespedesPropiedad(String correo, int numHuespedes) {
        crearConexion();
        Statement st;

        try {
            st = con.createStatement();
            st.executeUpdate("UPDATE `euskalrent03`.`apartamento` SET `NumeroHuespedes`='" + numHuespedes + "' WHERE idEmail='" + correo + "';");

        } catch (SQLException e) {
            e.printStackTrace();

        }
        cerrarConexion();
    }

    public void actualizarBarrioPropiedad(String correo, String barrio) {
        crearConexion();
        Statement st;

        try {
            st = con.createStatement();
            st.executeUpdate("UPDATE `euskalrent03`.`apartamento` SET `Barrio`='" + barrio + "' WHERE idEmail='" + correo + "';");

        } catch (SQLException e) {
            e.printStackTrace();

        }
        cerrarConexion();
    }

    public void actualizarDireccionPropiedad(String correo, String direccion) {
        crearConexion();
        Statement st;

        try {
            st = con.createStatement();
            st.executeUpdate("UPDATE `euskalrent03`.`apartamento` SET `Direccion`='" + direccion + "' WHERE idEmail='" + correo + "';");

        } catch (SQLException e) {
            e.printStackTrace();

        }
        cerrarConexion();
    }

    public void actualizarTarifaPropiedad(String correo, float precioNoche) {
        crearConexion();
        Statement st;

        try {
            st = con.createStatement();
            st.executeUpdate("UPDATE `euskalrent03`.`apartamento` SET `Tarifa`='" + precioNoche + "' WHERE idEmail='" + correo + "';");

        } catch (SQLException e) {
            e.printStackTrace();

        }
        cerrarConexion();
    }

    public void actualizarTipoCancelacionPropiedad(String correo, String tipoCancelacion) {
        crearConexion();
        Statement st;

        try {
            st = con.createStatement();
            st.executeUpdate("UPDATE `euskalrent03`.`apartamento` SET `TipoCancelacion`='" + tipoCancelacion + "' WHERE idEmail='" + correo + "';");

        } catch (SQLException e) {
            e.printStackTrace();

        }
        cerrarConexion();
    }

    public void actualizarFechaDisponiblePropiedad(String correo, String fechaDisponible) {
        crearConexion();
        Statement st;

        try {
            st = con.createStatement();
            st.executeUpdate("UPDATE `euskalrent03`.`apartamento` SET `fechaDisponibilidad`='" + fechaDisponible + "' WHERE idEmail='" + correo + "';");

        } catch (SQLException e) {
            e.printStackTrace();

        }
        cerrarConexion();
    }

    public void agregarSalgoUsuario(String correo) {
        crearConexion();
        float saldo = 1000;
        Statement st;
        try {
            st = con.createStatement();
            st.executeUpdate("INSERT INTO `euskalrent03`.`cuentabancaria` (`idEmail`,`Saldo`)"
                    + " VALUES ('" + correo + "','" + saldo + "');");
        } catch (SQLException e) {

            e.printStackTrace();
        }
        cerrarConexion();

    }

    public boolean restarSaldoUsuario(String correo, float cantidad, float saldoInicial) {
        crearConexion();
        Statement st;
        float saldoFinal = saldoInicial - cantidad;
        try {
            st = con.createStatement();
            st.executeUpdate("UPDATE `euskalrent03`.`cuentaBancaria` SET `Saldo`='" + saldoFinal + "' WHERE idEmail='" + correo + "';");

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }

        cerrarConexion();
        return true;
    }

    public float ObtenerSaldoUsuario(String correo) {
        crearConexion();
        Statement st;
        float saldo = 0;
        try {
            st = con.createStatement();
            ResultSet rs = st.executeQuery("select Saldo from cuentabancaria where idEmail='" + correo + "';");
            while (rs.next()) {
                saldo = rs.getFloat("Saldo");

            }
        } catch (SQLException e) {
            e.printStackTrace();

        }
        cerrarConexion();
        System.out.println(saldo);
        return saldo;
    }

    public void anyadirReserva(String correo, int idApartamento, String fechaInicio, String fechaFin,String tipoCancelacion,Float coste) {
        
        crearConexion();
        Statement st;
        try {
            st = con.createStatement();
            st.executeUpdate("INSERT INTO `euskalrent03`.`reserva` (`idEmail`,`idApartamento`,`FechaInicio`,`FechaFinal`,`tipoCancelacion`,`CosteReserva`)"
                    + " VALUES ('" + correo + "','" + idApartamento + "','" + fechaInicio + "','" + fechaFin + "','" + tipoCancelacion + "','" + coste + "');");
        } catch (SQLException e) {

            e.printStackTrace();
        }
        cerrarConexion();
    }

    public void sumarSaldoUsuario(String correo, float cantidad, float saldoInicial) {
        crearConexion();
        Statement st;
        float saldoFinal = saldoInicial + cantidad;
        try {
            st = con.createStatement();
            st.executeUpdate("UPDATE `euskalrent03`.`cuentaBancaria` SET `Saldo`='" + saldoFinal + "' WHERE idEmail='" + correo + "';");

        } catch (SQLException e) {
            e.printStackTrace();

        }

    }

    public ArrayList<Reserva> recibirDatosReservas(String correo) {
        ArrayList<Reserva> reservas = new ArrayList<>();
        crearConexion();
        Statement st;

        try {
            st = con.createStatement();
            ResultSet rs = st.executeQuery("select * from reserva where idEmail='" + correo + "';");
            while (rs.next()) {
                Reserva reserva = new Reserva();
                reserva.setCorreoUsuario(correo);
                reserva.setIdReserva(rs.getInt("idReserva"));
                reserva.setFechaInicio(rs.getDate("FechaInicio"));
                reserva.setFechaFin(rs.getDate("FechaFinal"));
                reserva.setIdApartamento(rs.getInt("idApartamento"));
                reserva.setEstado(rs.getString("EstadoReserva"));
                reserva.setCosteReserva(rs.getFloat("CosteReserva"));
                reserva.setTipoCancelacion(rs.getString("tipoCancelacion"));
                reservas.add(reserva);
            }
        } catch (SQLException e) {
            e.printStackTrace();

        }
        cerrarConexion();
        return reservas;

    }

    public boolean tieneReservas(String correo) {
        crearConexion();
        Statement st;
        String resul;
        boolean encontrado = false;
        try {
            st = con.createStatement();
            ResultSet rs = st.executeQuery("select idEmail from reserva where idEmail='" + correo + "';");
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
    public void eliminarApartamento(int idApartamento){
          crearConexion();
        Statement st;

        try {
            st = con.createStatement();
            st.executeUpdate("DELETE FROM `euskalrent03`.`apartamento` WHERE `IdApartamento`='"+idApartamento+"';");

        } catch (SQLException e) {
            e.printStackTrace();

        }
        cerrarConexion();
    }
    
     public void cancelarReserva(int idReserva){
          crearConexion();
        Statement st;

        try {
            st = con.createStatement();
            st.executeUpdate("DELETE FROM `euskalrent03`.`reserva` WHERE `IdReserva`='"+idReserva+"';");

        } catch (SQLException e) {
            e.printStackTrace();

        }
        cerrarConexion();
    }
   public Reserva recibirDatosReserba(int idReserva) {
        Reserva reserva=new Reserva();
        crearConexion();
        Statement st;

        try {
            st = con.createStatement();
            ResultSet rs = st.executeQuery("select * from reserva where idReserva='" + idReserva + "';");
            while (rs.next()) {
                
                reserva.setCorreoUsuario(rs.getString("idEmail"));
                reserva.setEstado(rs.getString("EstadoReserva"));
                reserva.setIdReserva(idReserva);
                reserva.setFechaInicio(rs.getDate("FechaInicio"));
                reserva.setFechaFin(rs.getDate("FechaFinal"));
                reserva.setIdApartamento(rs.getInt("idApartamento"));
                 reserva.setCosteReserva(rs.getFloat("CosteReserva"));
                reserva.setTipoCancelacion(rs.getString("tipoCancelacion"));
                
                

            }
        } catch (SQLException e) {
            e.printStackTrace();

        }
        cerrarConexion();
        return reserva;

    }
   
    public void actualizarEstadoReserva(int idReserva,String estado) {
        crearConexion();
        Statement st;

        try {
            st = con.createStatement();
            st.executeUpdate("UPDATE `euskalrent03`.`reserva` SET `EstadoReserva`='" + estado + "' WHERE idReserva='" + idReserva + "';");

        } catch (SQLException e) {
            e.printStackTrace();

        }
        cerrarConexion();
    }
    }
    

