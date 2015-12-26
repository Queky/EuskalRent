/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package packEuskalRent;


import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.sql.*;


public class RegistroUsuario extends HttpServlet {
    
    private Connection con;
    private Statement set;
    private ResultSet rs;
    String cad;

    
    public void init(ServletConfig cfg) throws ServletException {
        String sURL = "jdbc:mysql://localhost/euscalrent03";
        super.init(cfg);
        String userName = "root";
        String password = "root";
        try {
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            con = DriverManager.getConnection(sURL, userName, password);
            System.out.println("Se ha conectado");
        } catch (Exception e) {
            System.out.println("No se ha conectado");
        }
    }

  
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
       /* 
        String nombre = (String) request.getParameter("nombre");
        s.setAttribute("nombreUsuario", nombre);
        String apellido = (String) request.getParameter("apellidos");
        s.setAttribute("apellidoUsuario", apellido);*/
        String correo = (String) request.getParameter("email");
        s.setAttribute("correoUsuario", correo);
       
        /*
        Usuario usuario = (Usuario) request.getSession().getAttribute("usuario1");
        String nombre = usuario.getNombre();
        String apellido = usuario.getApellido();
        String correo = usuario.getCorreo();
        */
        Statement st;
     try {
			st = con.createStatement();
			st.executeUpdate("INSERT INTO usuario (idEmail)"
                                + " VALUES ('"+correo+"');");
                          rs.close();
                         st.close();
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
    
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
