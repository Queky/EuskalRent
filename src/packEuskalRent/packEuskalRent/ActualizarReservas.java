/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package packEuskalRent;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Date;
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
@WebServlet(name = "ActualizarReservas", urlPatterns = {"/ActualizarReservas"})
public class ActualizarReservas extends HttpServlet {

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
        
        ArrayList<Reserva>  reservas = conexionBD.recibirDatosReservas(usuario.getCorreo());
        Date fechaHoy = new Date();
        for(int i =0; i<reservas.size();i++){
            if(fechaHoy.equals(reservas.get(i).getFechaInicio())||
                    (fechaHoy.after(reservas.get(i).getFechaInicio())&& fechaHoy.before(reservas.get(i).getFechaFin()))
                    || fechaHoy.equals(reservas.get(i).getFechaFin())){
            reservas.get(i).setEstado(1);
            conexionBD.actualizarEstadoReserva(reservas.get(i).getIdReserva(),reservas.get(i).getEstado());
            
            }
            else if(fechaHoy.after(reservas.get(i).getFechaFin())){
            reservas.get(i).setEstado(2);
            conexionBD.actualizarEstadoReserva(reservas.get(i).getIdReserva(),reservas.get(i).getEstado());
            float importe = (reservas.get(i).getCosteReserva()*70)/100;
             conexionBD.sumarSaldoUsuario(conexionBD.recibirDartosPropiedad(reservas.get(i).getIdApartamento()).getCorreousuario(), importe, conexionBD.ObtenerSaldoUsuario(conexionBD.recibirDartosUsuario(conexionBD.recibirDartosPropiedad(reservas.get(i).getIdApartamento()).getCorreousuario()).getCorreo()));
             conexionBD.restarSaldoUsuario(usuario.getCorreo(),importe,conexionBD.ObtenerSaldoUsuario(usuario.getCorreo()));
            }else{
             reservas.get(i).setEstado(0);
             
            conexionBD.actualizarEstadoReserva(reservas.get(i).getIdReserva(),reservas.get(i).getEstado());
            }
            
        
        }
        response.sendRedirect("PaginaRU");
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
