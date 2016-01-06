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
@WebServlet(name = "seleccionBusqueda", urlPatterns = {"/seleccionBusqueda"})
public class seleccionBusqueda extends HttpServlet {

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
        ConexionBD CB = ConexionBD.getConexionConBBDD();
        
        int idApartamento = Integer.parseInt(request.getParameter("idApartamento"));
        Propiedad propiedad = CB.recibirDartosPropiedad(idApartamento);
        s.setAttribute("Propiedad", propiedad);
        if(s.getAttribute("Usuario")!=null)
        response.sendRedirect("ApartamentoElegido");
        else{
        response.sendRedirect("Acceso");
        }

    }

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