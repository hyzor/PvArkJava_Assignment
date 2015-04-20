package com.MyPackage;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLDataException;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.jsp.HttpJspPage;
import javax.sql.DataSource;

/**
 *
 * @author Jesper
 */
@WebServlet(urlPatterns = {"/NewServlet"})
public abstract class NewServlet extends HttpServlet implements HttpJspPage {

    InitialContext ctx = null;
    DataSource ds = null;
    protected Connection conn = null;
    Statement statement = null;
    ResultSet rs = null;
    SqlBean sqlBean = null;

    //static final String JDBC_DRIVER="org.hsqldb.jdbc.JDBCDriver";
    static final String DB_URL="jdbc:derby://localhost:1527/ourDatabase";
    
    String sql = "SELECT * FROM APP.USERS";

    /*
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected final void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet NewServlet</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet NewServlet at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    @Override
    public final void init(ServletConfig config) throws ServletException {
        super.init(config);
        try {
            System.out.println("Connecting to database...");
            ctx = new InitialContext();
            //ds = (DataSource) ctx.lookup("java:comp/env/jdbc/hsqldb");
            //conn = ds.getConnection();
            Class.forName("org.apache.derby.jdbc.ClientDriver").newInstance();
            conn = DriverManager.getConnection(DB_URL, "test", "tgdas"); 
            
            System.out.println("Connected!");
            //ps = conn.cr(sql);
            //statement = conn.createStatement();
            //rs = statement.executeQuery(sql);
            
            sqlBean = new SqlBean();
            sqlBean.setConnection(conn);
        } catch (SQLException sqle) {
            System.out.println("SQLException: " + sqle.getMessage());
        } catch (NamingException ne) {
            System.out.println("NamingException: " + ne.getMessage());
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(NewServlet.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            Logger.getLogger(NewServlet.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(NewServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        jspInit();
    }

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
        
        jspDestroy();
        super.destroy();
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
    protected final void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //SqlBean sqlBean = new SqlBean();
        //sqlBean.setConnection(conn);
        


        RequestDispatcher rd = request.getRequestDispatcher("loginPage.jsp");
        request.setAttribute("sqlBean", sqlBean);
        //request.setAttribute("conn", conn);
        rd.forward(request, response);
        //processRequest(request, response);
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
    protected final void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public final String getServletInfo() {
        return "Short description";
    }// </editor-fold>
    
       /**
   * Called when the JSP is loaded.
   * By default does nothing.
   */
    @Override
   public void jspInit() {}

   /**
   * Called when the JSP is unloaded.
   * By default does nothing.
   */
    @Override
   public void jspDestroy() {}

   /**
   * Invokes the JSP's _jspService method.
   */
    @Override
   public final void service(
         HttpServletRequest request,
         HttpServletResponse response)
      throws ServletException, IOException
   {
      _jspService(request, response);
   }

   /**
   * Handles a service request.
   */
    @Override
   public abstract void _jspService(
         HttpServletRequest request,
         HttpServletResponse response)
      throws ServletException, IOException;

}
