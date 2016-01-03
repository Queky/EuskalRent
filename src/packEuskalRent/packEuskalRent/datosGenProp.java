package packEuskalRent;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Eneko
 */
public class datosGenProp extends HttpServlet {

  
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
        
        Propiedad propiedad = Propiedad.getPropiedad();
        String barrio = (String) request.getParameter("barrio");
        String tipoPropiedad = (String) request.getParameter("tipoProp");
        Integer numHuespedes = Integer.parseInt(request.getParameter("numHuespedes"));
        propiedad.setBarrio(barrio);
        propiedad.setTipoPropieedad(tipoPropiedad);
        propiedad.setNumHuespedes(numHuespedes);

     response.sendRedirect("PaginaMP");
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


