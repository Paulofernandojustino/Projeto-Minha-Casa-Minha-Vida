package br.com.droid.factory;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import com.mysql.jdbc.Driver;
import com.prgguru.jersey.Constants;


public abstract class ConnectionFactory {
    


    public Connection getConnection() {
     Connection con = null;
     try {
         Class.forName(Constants.dbClass);
         con = DriverManager.getConnection(Constants.dbUrl, Constants.dbUser, Constants.dbPwd);
     } catch (Exception e) {
         System.out.println("Erro ao criar conexao.");
         e.printStackTrace();
     }
     return con;
    }

    public void closeConnection(Connection conn, Statement stmt, ResultSet rs) {
     try {
         close(conn, stmt, rs);
     } catch (Exception e) {
         System.out.println("Erro ao fechar conexao.");
         e.printStackTrace();
     }
    }

    public void closeConnection(Connection conn, Statement stmt) {
     try {
         close(conn, stmt, null);
     } catch (Exception e) {
         System.out.println("Erro ao fechar conexao.");
         e.printStackTrace();
     }
    }

    public void closeConnection(Connection conn) {
     try {
         close(conn, null, null);
     } catch (Exception e) {
         System.out.println("Erro ao fechar conexao.");
         e.printStackTrace();
     }
    }

    private void close(Connection conn, Statement stmt, ResultSet rs) {

     try {
         if (rs != null) {
             rs.close();
         }
         if (stmt != null) {
             stmt.close();
         }
         if (conn != null) {
             conn.close();
         }
     } catch (Exception e) {
         System.out.println("Erro ao fechar conexao.");
         e.printStackTrace();
     }
    }
}