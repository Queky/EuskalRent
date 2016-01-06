/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package packEuskalRent;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author BEEP
 */
@WebServlet(name = "Reserva", urlPatterns = {"/Reserva"})
public class GestionReservas extends HttpServlet {

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
        Sesion sesion = Sesion.getSesion();
        Usuario usuario = new Usuario();
        String correo = (String) request.getParameter("email");
        String nombre = (String) request.getParameter("nombre");
        String apellido = (String) request.getParameter("apellidos");
        String contraseña = (String) request.getParameter("contraseña");
        System.out.println(contraseña);

        usuario.setNombre(nombre);
        usuario.setApellido(apellido);
        usuario.setCorreo(correo);
        usuario.setContraseña(contraseña);
        usuario.setNumSesion(s.getId());
        ConexionBD BD = ConexionBD.getConexionConBBDD();
        if (!BD.estaRegistrado(correo)) {
            if (!sesion.acceso()) {
                Usuario usuarioQueyaEsta = (Usuario) s.getAttribute("Usuario");
                if (usuarioQueyaEsta != null) {
                    if (!usuario.getNumSesion().equals(usuarioQueyaEsta.getNumSesion())) {
                        sesion.reniciarSesion();
                        sesion.acceso();
                        s.setAttribute("Usuario", usuario);
                        response.sendRedirect("PaginaModificacionUsuario");
                    } else {
                        response.sendRedirect("PaginaCSe");
                    }
                } else {
                    s.setAttribute("Usuario", usuario);
                    response.sendRedirect("PaginaModificacionUsuario");
                }
            } else {
                s.setAttribute("Usuario", usuario);

                response.sendRedirect("PaginaModificacionUsuario");
            }
        }else{
             response.sendRedirect("Registro");
          
        }}

        /**
         * Returns a short description of the servlet.
         *
         * @return a String containing servlet description
         */
        @Override
        public String getServletInfo
        
            () {
        return "Short description";
        }// </editor-fold>

    }
