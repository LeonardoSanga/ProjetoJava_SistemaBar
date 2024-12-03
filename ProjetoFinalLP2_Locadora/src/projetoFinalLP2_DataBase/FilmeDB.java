package projetoFinalLP2_DataBase;

import java.sql.*;
import java.text.SimpleDateFormat;

import projetoFinalLP2_BackEnd.Filme;

public class FilmeDB {
	private ResultSet rs = null;
    
    private Statement stmt = null;
	
	public boolean inserirFilme(Filme filme) {
        try {
            ConexaoDB.ConnectDB();
            
            stmt = ConexaoDB.con.createStatement();
            
            String comando = "Insert into FILME (nome, genero, produtora, diretor, classficacao_indicativa, disponivel) values ( "
                    + "'" + filme.getNome() + "', "
                    + "'" + filme.getGenero() + "', "
                    + "'" + filme.getProdutora() + "', "
                    + "'" + filme.getDiretor() + "', "
                    + filme.getClassificacaoIndicativa() + ", "
                    + filme.isDisponivel() + ") ";
            
           
            
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
	
	public boolean alterarFilme(Filme filme) {
	    try {
	        ConexaoDB.ConnectDB();
	        
	        stmt = ConexaoDB.con.createStatement();
	        
	        String comando = "UPDATE filme SET "
	                + "nome = '" + filme.getNome() + "', "
	                + "genero = '" + filme.getGenero() + "', "
	                + "produtora = '" + filme.getProdutora() + "', "
	                + "diretor = '" + filme.getDiretor() + "', "
	                + "classficacao_indicativa = " + filme.getClassificacaoIndicativa() + ", "
	                + "disponivel = " + filme.isDisponivel()  
	                + " WHERE codigo_filme = " + filme.getCodigo_filme();
	        
	        //System.out.println("Comando SQL: " + comando); 
	        
	        stmt.executeUpdate(comando.toUpperCase());
	        
	        ConexaoDB.con.commit();
	        
	        stmt.close();
	        
	        return true;
	    } catch (Exception e) {
	        System.out.println("Erro ao atualizar o filme: " + e.getMessage());
	        return false;
	    } finally {
	        ConexaoDB.CloseDB();
	    }
	}
	
	public ResultSet consultarFilme(Filme filme, int opcao) {
        try {
        	ConexaoDB.ConnectDB();
            
            stmt = ConexaoDB.con.createStatement();
            
            String comando = "";
            
            switch(opcao) {
                case 1:
                	comando = "Select f.codigo_filme, f.nome, f.genero, f.produtora, f.diretor, f.classficacao_indicativa, f.disponivel " +
                            "from filme f"
                            + " order by f.nome";
                break;
                case 2:
                	comando = "Select f.codigo_filme, f.nome, f.genero, f.produtora, f.diretor, f.classficacao_indicativa, f.disponivel " +
                            "from filme f " +
                			"where f.nome = '" + filme.getNome() + "';";
                break;
                case 3:
                	comando = "Select f.nome " +
                            "from filme f " +
                			"where f.codigo_filme = '" + filme.getCodigo_filme() + "';";
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
