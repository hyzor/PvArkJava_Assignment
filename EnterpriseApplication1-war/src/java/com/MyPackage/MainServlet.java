/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.MyPackage;

import static com.MyPackage.MainServlet.SQL_DRIVER;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

/**
 *
 * @author hyzor
 */
public class MainServlet extends HttpServlet {
    
    InitialContext ctx = null;
    DataSource ds = null;
    protected Connection conn = null;
    Statement statement = null;
    ResultSet rs = null;
    static SqlBean sqlBean = null;
    
    // SQL names
    static final String SQL_DB_URL = "jdbc:derby://localhost:1527/MyDatabase";
    static final String SQL_DRIVER = "org.apache.derby.jdbc.ClientDriver";
    static final String SQL_USERNAME = "test";
    static final String SQL_PASSWORD = "test123";
    static final String SQL_USERTABLE = "TEST.USERS";
    static final String SQL_USERTABLE_USERNAME = "Username";
    static final String SQL_USERTABLE_PASSWORD = "Password";
    static final String SQL_USERTABLE_EMAIL = "Email";
    
    public static final SqlBean getSqlBean(HttpServletRequest request) {
        if (sqlBean == null) {
            sqlBean = new SqlBean(SQL_DB_URL, SQL_USERNAME, SQL_PASSWORD);
        }
        
        if (request.getSession().getAttribute("sqlBean") == null) {
            request.getSession().setAttribute("sqlBean", sqlBean);
        }
        
        return sqlBean;
    }
    
    @Override
    public final void init(ServletConfig config) throws ServletException {
        super.init(config);
    }

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
            out.println("<title>Servlet MainServlet2</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet MainServlet2 at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }
    
    protected void processRequest_Get(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        
        try {
            Class.forName(SQL_DRIVER).newInstance();
            
            sqlBean = getSqlBean(request);
            sqlBean.connect();
            
        } catch (ClassNotFoundException ex) {
            System.out.println("ClassNotFoundException: " + ex.getMessage());
        } catch (InstantiationException ex) {
            System.out.println("InstantiationException: " + ex.getMessage());
        } catch (IllegalAccessException ex) {
            System.out.println("IllegalAccessException: " + ex.getMessage());
        }
               
        RequestDispatcher rd;
        
        if (request.getSession().getAttribute("username") == null) {
            rd = request.getRequestDispatcher("loginPage.jsp");
        } else {
            rd = request.getRequestDispatcher("home.jsp");
        }
        
        request.getSession().setAttribute("sqlBean", sqlBean);
        rd.forward(request, response);
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
        processRequest_Get(request, response);
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

    
    @Override
    public final void destroy() {
        try {
            if (rs != null) {
                rs.close();
            }
            if (statement != null) {
                statement.close();
            }
            if (conn != null) {
                conn.close();
            }
            if (ctx != null) {
                ctx.close();
            }
        } catch (SQLException se) {
            System.out.println("SQLException: " + se.getMessage());
        } catch (NamingException ne) {
            System.out.println("NamingException: " + ne.getMessage());
        }
        
        super.destroy();
    }
}
