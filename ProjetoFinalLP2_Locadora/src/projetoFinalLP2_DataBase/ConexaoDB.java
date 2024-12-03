package projetoFinalLP2_DataBase;

import java.sql.*;

public class ConexaoDB {
	public static Connection con = null;
    
    public ConexaoDB() {
        
    }
    
    public static void ConnectDB() {
        
        try {
            String dsn = "TrabalhoFinalLP2DataBase";
            String user = "postgres";
            String senha = "1234leo";
        
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
