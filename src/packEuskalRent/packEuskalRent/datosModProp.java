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
import java.sql.Date;
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

        HttpSession s = request.getSession(true);
        Usuario usuario = (Usuario) s.getAttribute("Usuario");
        Propiedad propiedad = new Propiedad();
        String barrio = (String) request.getParameter("barrio");
        String tipoPropiedad = (String) request.getParameter("tipoProp");
        Integer numHuespedes = Integer.parseInt(request.getParameter("numHuespedes"));
        String direccion = (String) request.getParameter("Direccion");
        float precioNoche = Float.parseFloat(request.getParameter("Precio"));
        String tipoCancelacion= (String) request.getParameter("Politica");
        String fechaDisponible = (String)request.getParameter("calendario");
        propiedad.setBarrio(barrio);
           
        String ap=null;
        /*
        FileInputStream iS = new FileInputStream(request.getParameter("Caja"));
        byte[] bytes = new byte[(int)request.getParameter("Caja").length()];
        iS.read(bytes);
        ap = Base64.encode(bytes);
        */
        propiedad.setDireccion(direccion);
        propiedad.setTipoPropieedad(tipoPropiedad);
        propiedad.setNumHuespedes(numHuespedes);
        propiedad.setPrecioNoche(precioNoche);
        propiedad.setPoliticaDeCancelacion(tipoCancelacion);
        propiedad.setCorreoUsuario(usuario.getCorreo());
        propiedad.setFechaDisponible(fechaDisponible);
        
        ConexionBD BD = ConexionBD.getConexionConBBDD();
        Propiedad propiedadBD= BD.recibirDartosPropiedadDireccion(propiedad.getDireccion());
        
        String tarifausuario= String.valueOf(propiedad.getPrecioNoche());
        String tarifausuarioBD= String.valueOf(propiedadBD.getPrecioNoche());
        request.setAttribute("Usuario", propiedad);

        if(usuario.tienePropiedad()&& BD.recibirDartosPropiedadDireccion(propiedad.getDireccion()).getDireccion()!=null){
            if(!propiedad.getTipoPropiedad().equals(propiedadBD.getTipoPropiedad()))
                BD.actualizarTipoPropiedad(usuario.getCorreo(), propiedad.getTipoPropiedad());
            if(!propiedad.getNumHuespedes().equals(propiedadBD.getNumHuespedes()))
                BD.actualizarNumeroHuespedesPropiedad(usuario.getCorreo(), propiedad.getNumHuespedes());
            if(!propiedad.getBarrio().equals(propiedadBD.getBarrio()))
                BD.actualizarBarrioPropiedad(usuario.getCorreo(), propiedad.getBarrio());
            if(!propiedad.getDireccion().equals(propiedadBD.getDireccion()))
                BD.actualizarDireccionPropiedad(usuario.getCorreo(), direccion);
            if(!tarifausuario.equals(tarifausuarioBD))
                BD.actualizarTarifaPropiedad(usuario.getCorreo(), precioNoche);
             if(!propiedad.getPoliticaDeCancelacion().equals(propiedadBD.getPoliticaDeCancelacion()))
                 BD.actualizarTipoCancelacionPropiedad(usuario.getCorreo(), tipoCancelacion);
             if(!propiedad.getFechaDisponible().equals(propiedadBD.getFechaDisponible()))
                 BD.actualizarFechaDisponiblePropiedad(usuario.getCorreo(), fechaDisponible);
        }else{
        BD.anyadirDatosPrpiedad(propiedad.getBarrio(), propiedad.getTipoPropiedad(), precioNoche, propiedad.getNumHuespedes(),usuario.getCorreo(), direccion,tipoCancelacion,fechaDisponible);
        
        }
        usuario.eliminarActualizado(direccion);
        propiedad= BD.recibirDartosPropiedadDireccion(direccion);
     usuario.addPropiedades(propiedad);
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
