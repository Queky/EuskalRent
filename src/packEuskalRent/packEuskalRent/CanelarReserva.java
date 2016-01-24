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
@WebServlet(name = "CanelarReserva", urlPatterns = {"/CanelarReserva"})
public class CanelarReserva extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession s = request.getSession();
     
        
        ConexionBD conexionBD =ConexionBD.getConexionConBBDD();
        Usuario usuario = (Usuario) s.getAttribute("Usuario");
        Reserva reserva =(Reserva)s.getAttribute("Reserva");
        conexionBD.cancelarReserva(reserva.getIdReserva());
        if(reserva.getTipoCancelacion().equals("Flexible")){
            float importe = (reserva.getCosteReserva()*30)/100;
         conexionBD.restarSaldoUsuario(conexionBD.recibirDartosPropiedad(reserva.getIdApartamento()).getCorreousuario(), importe, conexionBD.ObtenerSaldoUsuario(conexionBD.recibirDartosUsuario(conexionBD.recibirDartosPropiedad(reserva.getIdApartamento()).getCorreousuario()).getCorreo()));
         conexionBD.sumarSaldoUsuario(usuario.getCorreo(),importe,conexionBD.ObtenerSaldoUsuario(usuario.getCorreo()));
        }
        usuario.eliminarReserva(reserva.getIdReserva());
        response.sendRedirect("Inicio");
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
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
