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
        HttpSession s = request.getSession(true);
        Usuario usuario = (Usuario) s.getAttribute("Usuario");
        Propiedad propiedad = usuario.getPropiedad();
        String barrio = (String) request.getParameter("barrio");
        String tipoPropiedad = (String) request.getParameter("tipoProp");
        Integer numHuespedes = Integer.parseInt(request.getParameter("numHuespedes"));
        String direccion = (String) request.getParameter("Direccion");
        float precioNoche = Float.parseFloat(request.getParameter("Precio"));
        String tipoCancelacion= (String) request.getParameter("Politica");
        propiedad.setBarrio(barrio);
        propiedad.setDireccion(direccion);
        propiedad.setTipoPropieedad(tipoPropiedad);
        propiedad.setNumHuespedes(numHuespedes);
        propiedad.setPrecioNoche(precioNoche);
        propiedad.setPoliticaDeCancelacion(tipoCancelacion);
        propiedad.setCorreoUsuario(usuario.getCorreo());
        usuario.asignarPropiedad(propiedad);
        ConexionBD BD = ConexionBD.getConexionConBBDD();
           Usuario usuarioBD = BD.recibirDartosUsuario(usuario.getCorreo());
        String tarifausuario= String.valueOf(usuario.getPropiedad().getPrecioNoche());
        String tarifausuarioBD= String.valueOf(usuarioBD.getPropiedad().getPrecioNoche());
     
        if(usuario.tienePropiedad()){
            if(!usuario.getPropiedad().getTipoPropiedad().equals(usuarioBD.getPropiedad().getTipoPropiedad()))
                BD.actualizarTipoPropiedad(usuario.getCorreo(), usuario.getPropiedad().getTipoPropiedad());
            if(!usuario.getPropiedad().getNumHuespedes().equals(usuarioBD.getPropiedad().getNumHuespedes()))
                BD.actualizarNumeroHuespedesPropiedad(usuario.getCorreo(), usuario.getPropiedad().getNumHuespedes());
            if(!usuario.getPropiedad().getBarrio().equals(usuarioBD.getPropiedad().getBarrio()))
                BD.actualizarBarrioPropiedad(usuario.getCorreo(), usuario.getPropiedad().getBarrio());
            if(!usuario.getPropiedad().getDireccion().equals(usuarioBD.getPropiedad().getDireccion()))
                BD.actualizarDireccionPropiedad(usuario.getCorreo(), direccion);
            if(!tarifausuario.equals(tarifausuarioBD))
                BD.actualizarTarifaPropiedad(usuario.getCorreo(), precioNoche);
             if(!usuario.getPropiedad().getPoliticaDeCancelacion().equals(usuarioBD.getPropiedad().getPoliticaDeCancelacion()))
                 BD.actualizarTipoCancelacionPropiedad(usuario.getCorreo(), tipoCancelacion);
        }else{
        BD.anyadirDatosPrpiedad(propiedad.getBarrio(), propiedad.getTipoPropiedad(), precioNoche, propiedad.getNumHuespedes(), usuario.getCorreo(), direccion,tipoCancelacion);
        BD.actualizarIdApartamentoUsuarioBD(usuario.getCorreo());
        }

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
