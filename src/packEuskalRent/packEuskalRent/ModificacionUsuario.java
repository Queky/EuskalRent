package packEuskalRent;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import packEuskalRent.ConexionBD;
import java.util.Base64;
import javax.servlet.http.Part;


/**
 *
 * @author BEEP
 */
@WebServlet(urlPatterns = {"/ModificacionUsuario"})
public class ModificacionUsuario extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            doPost(request, response);
        } catch (Exception e) {
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession s = request.getSession(true);
        Usuario usuario = (Usuario) s.getAttribute("Usuario");
        String correo = (String) request.getParameter("email");
        String nombre = (String) request.getParameter("nombre");
        String apellido = (String) request.getParameter("apellidos");
        Integer numTelefono = Integer.parseInt(request.getParameter("telefono"));
        String direccion = (String) request.getParameter("direccion");

        String img= request.getParameter("imagenUser");
        System.out.println("img = "+img);
        
        usuario.setNombre(nombre);
        usuario.setApellido(apellido);
        usuario.setNumTelefono(numTelefono);
        usuario.setCorreo(correo);
        usuario.setDireccion(direccion);
        usuario.loguearse();
        ConexionBD BD = ConexionBD.getConexionConBBDD();
        Usuario usuarioBD = BD.recibirDartosUsuario(correo);

        if (BD.estaRegistrado(correo)) {
            if (!usuario.getNombre().equals(usuarioBD.getNombre())) {
                BD.actualizarNombreUsuario(correo, nombre);
            }
            if (!usuario.getApellido().equals(usuarioBD.getApellido())) {
                BD.actualizarApellidosUsuario(correo, apellido);
            }
            if (!usuario.getNumTelefono().equals(usuarioBD.getNumTelefono())) {
                BD.actualizarNumTelefonoUsuario(correo, numTelefono);
            }
            if (usuario.getDireccion() != null) {
                if (usuarioBD.getDireccion() != null) {
                    if (!usuario.getDireccion().equals(usuarioBD.getDireccion())) {
                        BD.actualizarDireccionUsuario(correo, direccion);
                    }

                } else {
                    BD.actualizarDireccionUsuario(correo, direccion);
                }
            }

        } else {
            if (direccion == null) {
                 BD.anyadirDatosUsuario(nombre, apellido, correo, usuario.getContraseña(), numTelefono);
                 BD.agregarSalgoUsuario(correo);
            } else {
                BD.anyadirDatosUsuario(nombre, apellido, correo, usuario.getContraseña(), numTelefono, direccion, img);
                BD.agregarSalgoUsuario(correo);
            }
            
        }
        s.setAttribute("Usuario", usuario);

        response.sendRedirect("Inicio");
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
