/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package packEuskalRent;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
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
        HttpSession s = request.getSession(true);
        Propiedad propiedad =(Propiedad) s.getAttribute("Propiedad");
        Usuario usuario=(Usuario)s.getAttribute("Usuario");
   
         String fechaInicio1=(String) s.getAttribute("fechaInicio");
         String fechaFin2 =(String)  s.getAttribute("fechaFin"); 
        float coste = (float)s.getAttribute("Coste");
        System.out.println(coste);
        ConexionBD BD = ConexionBD.getConexionConBBDD();
        float saldoUsuario =BD.ObtenerSaldoUsuario(usuario.getCorreo());
        BD.sumarSaldoUsuario(propiedad.getCorreousuario(), coste, BD.ObtenerSaldoUsuario(BD.recibirDartosUsuario(propiedad.getCorreousuario()).getCorreo()));
        BD.restarSaldoUsuario(usuario.getCorreo(), coste,saldoUsuario);
        BD.anyadirReserva(usuario.getCorreo(), propiedad.getIdApartamento(), fechaInicio1,fechaFin2);
        response.sendRedirect("Inicio");
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
