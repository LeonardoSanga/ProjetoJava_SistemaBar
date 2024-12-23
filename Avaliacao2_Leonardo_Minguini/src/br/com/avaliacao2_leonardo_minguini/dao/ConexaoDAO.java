/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.avaliacao2_leonardo_minguini.dao;

import java.sql.*;

/**
 *
 * @author gabri
 */
public class ConexaoDAO {
    public static Connection con = null;
    
    public ConexaoDAO() {
        
    }
    
    public static void ConnectDB() {
        
        try {
            String dsn = "Avaliacao2_Leonardo_Minguini";
            String user = "postgres";
            String senha = "Leo123Leo!";
        
            DriverManager.registerDriver(new org.postgresql.Driver());
        
            String url = "jdbc:postgresql://localhost:5432/" + dsn;
        
            con = DriverManager.getConnection(url, user, senha);
        
            con.setAutoCommit(false);
            if(con == null) {
                System.out.println("erro ao abrir o banco");
            }
        }
        
        catch (Exception e) {
            System.out.println("Problema ao abrir o banco de dados!" + 
                    e.getMessage());
        }
    }
    
    public static void CloseDB() {
        try {
            con.close();
        }
        
        catch(Exception e ) {
            System.out.println("Problema ao fechar a base de dados!" + 
                    e.getMessage());
        }
    }
}
