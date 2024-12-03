package projetoFinalLP2_DataBase;

import java.sql.*;
import java.text.SimpleDateFormat;

import projetoFinalLP2_BackEnd.FilmeAlugado;

public class FilmeAlugadoDB {
	private ResultSet rs = null;
    
    private Statement stmt = null;
	
	public boolean inserirFilmeAlugado(FilmeAlugado filmeAlu) {
        try {
            ConexaoDB.ConnectDB();
            
            stmt = ConexaoDB.con.createStatement();
            
            String comando = "Insert into clienteAlugaFilme (codigo_filme, codigo_cliente, data_aluga, data_devolve) values ( "
                    + filmeAlu.getCodigo_filme() + ", "
                    + filmeAlu.getCodigo_cliente() + ", "
                    + "'" + filmeAlu.getDataAluga() + "', "
                    + "'" + filmeAlu.getDataDevolve() + "')";
           
            
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
	
	public boolean excluirFilmeAlugado(FilmeAlugado filmeAlu) {
        try {
        	ConexaoDB.ConnectDB();
            
            stmt = ConexaoDB.con.createStatement();
            
            String comando = "Delete from clienteAlugaFilme where codigo_filme = "
                    + filmeAlu.getCodigo_filme()
                    + " and codigo_cliente = " + filmeAlu.getCodigo_cliente();
            
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
	
	public ResultSet consultarFilmeAlugado(FilmeAlugado filmeAlu, int opcao) {
        try {
        	ConexaoDB.ConnectDB();
            
            stmt = ConexaoDB.con.createStatement();
            
            String comando = "";
            
            
            switch(opcao) {
            case 1:
            	comando = "SELECT c.nome, f.nome, caf.data_aluga, caf.data_devolve FROM ClienteAlugaFilme caf"
                   		+ "	INNER JOIN Filme f"
                   		+ "	ON caf.codigo_filme = f." + filmeAlu.getCodigo_filme()
                   		+ "	INNER JOIN Cliente c"
                   		+ "	ON caf.codigo_cliente = c." + filmeAlu.getCodigo_cliente();
            	break;
            case 2:
            	comando = "SELECT f.nome AS nome_filme, c.nome AS nome_cliente, caf.codigo_filme, caf.codigo_cliente FROM ClienteAlugaFilme caf"
            			+ " INNER JOIN Filme f"
            			+ " ON caf.codigo_filme = f.codigo_filme"
            			+ " INNER JOIN Cliente c"
            			+ " ON caf.codigo_cliente = c.codigo_cliente";
            	break;
            }
            
           
           
           //System.out.println(comando);
            
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
