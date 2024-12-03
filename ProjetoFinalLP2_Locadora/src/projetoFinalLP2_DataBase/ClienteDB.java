package projetoFinalLP2_DataBase;

import java.sql.*;
import java.text.SimpleDateFormat;

import projetoFinalLP2_BackEnd.Cliente;

public class ClienteDB {
	private ResultSet rs = null;
    
    private Statement stmt = null;
	
	public boolean inserirCliente(Cliente cliente) {
        try {
            ConexaoDB.ConnectDB();
            
            stmt = ConexaoDB.con.createStatement();
            
            String comando = "Insert into CLIENTE (nome, idade) values ( "
                    + "'" + cliente.getNome() + "', "
                    + cliente.getIdade() + ") ";
            
           
            
            stmt.execute(comando.toUpperCase());
            
            ConexaoDB.con.commit();
            
            stmt.close();
            
            return true;
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }
        finally {
        	ConexaoDB.CloseDB();
        }
    }
	
	public ResultSet consultarCliente(Cliente cliente, int opcao) {
        try {
        	ConexaoDB.ConnectDB();
            
            stmt = ConexaoDB.con.createStatement();
            
            String comando = "";
            
            switch(opcao) {
                case 1:
                	comando = "Select c.codigo_cliente, c.nome, c.idade " +
                            "from cliente c"
                            + " order by c.nome";
                break;
                case 2:
                	comando = "Select c.codigo_cliente, c.nome, c.idade " +
                            "from cliente c " +
                			"where c.nome = '" + cliente.getNome() + "';";
                break;
                case 3:
                	comando = "Select c.nome " +
                            "from cliente c " +
                			"where c.codigo_cliente = '" + cliente.getCodigo_cliente() + "';";
                break;
                    
            }
            
            rs = stmt.executeQuery(comando.toUpperCase());
            return rs;
        }
        catch(Exception e) {
            System.out.println(e.getMessage());
            return rs;
        }
    }
	
	public void CloseDB() {
        ConexaoDB.CloseDB();
    }
    
}
