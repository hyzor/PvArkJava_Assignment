/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.MyPackage.OLD;

import com.MyPackage.OLD.LoginCheckServlet;
import com.MyPackage.OLD.SqlBean;
import com.MyPackage.OLD.MainServlet;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author hyzor
 */
public class UserRegistrationServlet extends HttpServlet {

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
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet UserRegistrationServlet</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet UserRegistrationServlet at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    protected void processRequest_Post(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String email = request.getParameter("email");

        //SqlBean sqlBean = (SqlBean) request.getSession().getAttribute("sqlBean");
        
        SqlBean sqlBean = MainServlet.getSqlBean(request);

        // Try to fetch user from SQL database
        String sql = "SELECT Username FROM " + MainServlet.SQL_USERTABLE 
                + " WHERE Username=" + "'" + username + "'";
        Statement statement;
        ResultSet rs = null;
        try {
            statement = sqlBean.getConnection().createStatement();
            rs = statement.executeQuery(sql);
        } catch (SQLException ex) {
            Logger.getLogger(LoginCheckServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        boolean userFound = false;
        
        try {
            // User already exists!
            if (rs.next()) {
                userFound = true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(UserRegistrationServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        // User was found, registration failed
        if (userFound) {
            response.sendRedirect("error.jsp");
        } else {
            try {
                statement = sqlBean.getConnection().createStatement();
                sql = "INSERT INTO " + MainServlet.SQL_USERTABLE
                        + " (" + MainServlet.SQL_USERTABLE_USERNAME + ", " 
                        + MainServlet.SQL_USERTABLE_PASSWORD + ", " +
                        MainServlet.SQL_USERTABLE_EMAIL + ") VALUES ("
                        + "'" + username + "', '" + password + "'"
                        + ", "  + "'" + email + "')";
                statement.executeUpdate(sql);
            } catch (SQLException ex) {
                Logger.getLogger(UserRegistrationServlet.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            response.sendRedirect("userRegistrationSuccessPage.jsp");
        }
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
        processRequest_Post(request, response);
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
