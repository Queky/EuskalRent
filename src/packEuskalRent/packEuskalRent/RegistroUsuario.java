/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package packEuskalRent;


import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.sql.*;


public class RegistroUsuario extends HttpServlet {
  
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
        
        String correo = (String) request.getParameter("email");
        s.setAttribute("correoUsuario", correo);
        String nombre = (String) request.getParameter("nombre");
        s.setAttribute("nombreUsuario", nombre);
        String apellido = (String) request.getParameter("apellidos");
        s.setAttribute("apellidosUsuario", apellido);
        String contraseña = (String) request.getParameter("contraseña");
        s.setAttribute("apellidosUsuario", apellido);
   /*
        ConexionBD CB = ConexionBD.getConexionConBBDD();
        CB.anyadirDatosUsuario(nombre, apellido, correo);
     */   
     response.sendRedirect("./JSP/PaginaModificacionUsuario.jsp");
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
