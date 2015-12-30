package packEuskalRent;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import packEuskalRent.ConexionBD;

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
        
        String correo = (String) request.getParameter("email");
        s.setAttribute("correoUsuario", correo);
        String contraseña = (String) request.getSession().getAttribute("nombreUsuario");
        String nombre = (String) request.getParameter("nombre");
        s.setAttribute("nombreUsuario", nombre);
        String apellido = (String) request.getParameter("apellidos");
        s.setAttribute("apellidosUsuario", apellido);
        Integer numTelefono =Integer.parseInt(request.getParameter("telefono"));
        s.setAttribute("telefonoUsuario", numTelefono);
        String direccion =(String) request.getParameter("direccion");
        ConexionBD BD = ConexionBD.getConexionConBBDD();
        if (direccion==null){
            BD.anyadirDatosUsuario(nombre, apellido, correo, contraseña, numTelefono);
        }else{
            BD.anyadirDatosUsuario(nombre, apellido, correo, contraseña, numTelefono, direccion);
        }
        
        
   /*
        ConexionBD CB = ConexionBD.getConexionConBBDD();
        CB.anyadirDatosUsuario(nombre, apellido, correo);
     */   
     response.sendRedirect("./JSP/PaginaInicio.jsp");
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