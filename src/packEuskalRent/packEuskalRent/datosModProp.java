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
import javax.servlet.http.HttpSession;

/**
 *
 * @author Eneko
 */
public class datosModProp extends HttpServlet {
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
        Propiedad propiedad = new Propiedad();
        
        String direccion = (String) request.getParameter("Direccion");
        float precioNoche = Float.parseFloat(request.getParameter("Precio"));
        String tipoCancelacion= (String) request.getParameter("Politica");
        
        propiedad.setDireccion(direccion);
        propiedad.setPrecioNoche(precioNoche);
        propiedad.setPoliticaDeCancelacion(tipoCancelacion);
        Usuario usuario =new Usuario();
        usuario.asignarPropiedad(propiedad);
        propiedad.setCorreoUsuario(usuario.getCorreo());
        ConexionBD BD = ConexionBD.getConexionConBBDD();
        BD.anyadirDatosPrpiedad(propiedad.getBarrio(), propiedad.getTipoPropiedad(), precioNoche, propiedad.getNumHuespedes(), usuario.getCorreo(), direccion,tipoCancelacion);
        BD.actualizarIdApartamentoUsuarioBD(usuario.getCorreo());
        
     response.sendRedirect("Inicio");
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
