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
@WebServlet(name = "Acceder", urlPatterns = {"/Acceder"})
public class Acceder extends HttpServlet {

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
        boolean prueba = s.isNew();
        System.out.println(prueba);
        System.out.println(s.getId());
        Sesion sesion = Sesion.getSesion();
        String correo = (String) request.getParameter("email");
        String contraseña = (String) request.getParameter("prueba");
        ConexionBD CB = ConexionBD.getConexionConBBDD();
        boolean existeEmail = CB.estaRegistrado(correo);
        boolean coincideContraseñaEmail = CB.coincideContraseñaEmail(correo, contraseña);
        if (existeEmail) {
            System.out.println("el email existe");
            if (coincideContraseñaEmail) {
                System.out.println("coinciden");
                Usuario usuario = CB.recibirDartosUsuario(correo);
                usuario.setNumSesion(s.getId());
                usuario.loguearse();
                System.out.println(prueba);
                if (!sesion.acceso()) {
                    Usuario usuarioQueyaEsta = (Usuario) s.getAttribute("Usuario");
                    if (usuarioQueyaEsta != null) {
                        if (!usuario.getCorreo().equals(usuarioQueyaEsta.getCorreo())) {
                            if (!usuario.getNumSesion().equals(usuarioQueyaEsta.getNumSesion())) {
                                sesion.reniciarSesion();
                                sesion.acceso();
                                s.setAttribute("Usuario", usuario);
                                response.sendRedirect("Inicio");
                            } else {
                                response.sendRedirect("PaginaCSe");
                            }
                        } else {
                            s.setAttribute("Usuario", usuario);
                            response.sendRedirect("Inicio");

                        }
                        
                    } else {
                        s.setAttribute("Usuario", usuario);
                        response.sendRedirect("Inicio");
                    }
                } else {
                    s.setAttribute("Usuario", usuario);
                    response.sendRedirect("Inicio");
                }
            } else {
                System.out.println("no la contraseña");
                
                response.sendRedirect("Acceso");
                
            }
        } else {
            System.out.println("no pilla na");
            response.sendRedirect("Acceso");
        }

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
