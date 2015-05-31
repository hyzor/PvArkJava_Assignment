package com.MyPackage.OLD;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Jesper
 */
public class SqlBean {
    private Connection conn;
    private final String DB_URL;
    private final String SQL_USERNAME;
    private final String SQL_PASSWORD;

    SqlBean(String SQL_DB_URL, String SQL_USERNAME, String SQL_PASSWORD) {
        this.DB_URL = SQL_DB_URL;
        this.SQL_USERNAME = SQL_USERNAME;
        this.SQL_PASSWORD = SQL_PASSWORD;
    }
    
    public boolean connect() {
        boolean isConnected = true;
        
        try { 
            conn = DriverManager.getConnection(DB_URL, SQL_USERNAME, SQL_PASSWORD);
        } catch (SQLException ex) {
            Logger.getLogger(SqlBean.class.getName()).log(Level.SEVERE, null, ex);
            isConnected = false;
        }
        
        return isConnected;
    }
   
    public Connection getConnection() {
        if (conn == null) {
            connect();
        }
        
        return conn;
    }
    
    public void setConnection(Connection conn) {
        this.conn = conn;
    }
}
