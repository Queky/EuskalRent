package packEuskalRent;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import com.sun.org.apache.xml.internal.security.utils.Base64;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.apache.tomcat.util.http.fileupload.FileUtils;
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
        Propiedad propiedad = Propiedad.getPropiedad();

        String direccion = (String) request.getParameter("Direccion");
        float precioNoche = Float.parseFloat(request.getParameter("Precio"));
        String tipoCancelacion= (String) request.getParameter("Politica");

        String ap;
        FileInputStream iS = new FileInputStream(request.getParameter("Caja"));
        byte[] bytes = new byte[(int)request.getParameter("Caja").length()];
        iS.read(bytes);
        ap = Base64.encode(bytes);
        
        propiedad.setDireccion(direccion);
        propiedad.setPrecioNoche(precioNoche);
        propiedad.setPoliticaDeCancelacion(tipoCancelacion);
        Usuario usuario = Usuario.getUsuario();
        usuario.asignarPropiedad(propiedad);
        propiedad.setCorreoUsuario(usuario.getCorreo());
        ConexionBD BD = ConexionBD.getConexionConBBDD();
        BD.anyadirDatosPrpiedad(propiedad.getBarrio(), propiedad.getTipoPropiedad(), precioNoche, propiedad.getNumHuespedes(), usuario.getCorreo(), direccion,tipoCancelacion, ap);
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
