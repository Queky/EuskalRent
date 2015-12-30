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
     
        String correo = (String)request.getParameter("email");
        String contraseña = (String)request.getParameter("contraseña");
        System.out.println(correo);
        System.out.println(contraseña);
        ConexionBD CB = ConexionBD.getConexionConBBDD();
        boolean existeEmail = CB.estaRegistrado(correo);
        boolean coincideContraseñaEmail = CB.coincideContraseñaEmail(correo, contraseña);
        if (existeEmail) {
            System.out.println("el email existe");
            if (coincideContraseñaEmail) {
                System.out.println("coinciden");
                response.sendRedirect("./JSP/PaginaBusquedas.jsp");
            } else {
                System.out.println("no la contraseña");
                response.sendRedirect("./JSP/PaginaAcceder.jsp");
            }
        } else {
            System.out.println("no pilla na");
            response.sendRedirect("./JSP/PaginaAcceder.jsp");
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
