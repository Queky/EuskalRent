/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package packEuskalRent;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author inakisanchez
 */
public class Login extends HttpServlet {

    private String baseDeDatos;
    private Connection conexion;
    private ResultSet rs;
    private Statement set;

    public void init(ServletConfig cfg) throws ServletException {
        super.init(cfg);
        try {
            Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
            baseDeDatos = "jdbc:odbc:gasteizcar";
            conexion = DriverManager.getConnection(baseDeDatos);
            set = conexion.createStatement();
        } catch (Exception e) {
            throw new ServletException(e.getMessage());
        }
    }
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doPost(request, response);
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
        
        HttpSession s = request.getSession(true);
        String correoUsuario = (String) request.getAttribute("email");
        String password = (String) request.getAttribute("contraseña");
        
        try {
            rs = set.executeQuery("SELECT password FROM Usuario WHERE correoElectronico ='" + correoUsuario + "'");
            if(rs!=null){
                s.setAttribute("correoUsuario", correoUsuario);
                s.setAttribute("password", password);
                s.setAttribute("logueado", "logueado");
            }
        } catch (SQLException ex) {
            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
        }

        
        response.sendRedirect("PaginaInicio");
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
