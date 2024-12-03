package projetoFinalLP2_BackEnd;

import projetoFinalLP2_DataBase.ClienteDB;
import projetoFinalLP2_DataBase.FilmeAlugadoDB;
import projetoFinalLP2_DataBase.FilmeDB;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;

public class Locadora {
	private static Locadora instanciaUnicaLocadora;
	
	FilmeDB filmeDB;
	ClienteDB clienteDB;
	
	ResultSet rs = null;
	
	private Locadora() {
		filmeDB = new FilmeDB();
		clienteDB = new ClienteDB();
	}
	
	public static Locadora getInstance() {
		if(instanciaUnicaLocadora == null) {
			instanciaUnicaLocadora = new Locadora();
		}
		
		return instanciaUnicaLocadora;
	}
	
	public boolean alugar(Filme filme, Cliente cliente, String dtaAlug, String dtaDevolv) {
		FilmeAlugadoDB filmeAlugDB = null;
		if(filme != null && cliente != null) {
			
			if(cliente.getIdade() < filme.getClassificacaoIndicativa()) {
				System.out.println("O Cliente tem idade inferior à classificação indicativa do filme\n");
				return false;
			}
			
			if(filme.isDisponivel()) {
				
				filme.setDisponivel(false);
				
				FilmeAlugado filmeAlug = new FilmeAlugado();
				filmeAlug.setCodigo_filme(filme.getCodigo_filme());
				filmeAlug.setCodigo_cliente(cliente.getCodigo_cliente());
				filmeAlug.setNomeFilme(filme.getNome());
				filmeAlug.setNomeCliente(cliente.getNome());
				filmeAlug.setDataAluga(dtaAlug);
				filmeAlug.setDataDevolve(dtaDevolv);
				
				filmeAlugDB = new FilmeAlugadoDB();
				filmeAlugDB.inserirFilmeAlugado(filmeAlug);
				
				try {
					
					rs = filmeDB.consultarFilme(filme, 2); 
					Filme filmeAlugar;
					
					rs.next();
					
					//System.out.println(rs.getString("nome"));
					
					if(rs.getString("nome").equalsIgnoreCase("Matrix") || rs.getString("nome").equalsIgnoreCase("A Origem") || rs.getString("nome").equalsIgnoreCase("Blade Runner")) {
						Produtora warner = new WarnerBros();
						filmeAlugar = warner.geraFilme(rs.getString("nome"));
					} else if(rs.getString("nome").equalsIgnoreCase("Jurassic Park") || rs.getString("nome").equalsIgnoreCase("Gladiador") || rs.getString("nome").equalsIgnoreCase("Psicose")) {
						Produtora universal = new Universal();
						filmeAlugar = universal.geraFilme(rs.getString("nome"));
					} else {
						Produtora paramount = new Paramount();
						filmeAlugar = paramount.geraFilme(rs.getString("nome"));
					}
					
					filmeAlugar.setCodigo_filme(rs.getInt("codigo_filme"));
					filmeAlugar.setNome(rs.getString("nome"));
					filmeAlugar.setGenero(rs.getString("genero"));
					filmeAlugar.setProdutora(rs.getString("genero"));
					filmeAlugar.setDiretor(rs.getString("genero"));
					filmeAlugar.setClassificacaoIndicativa(rs.getInt("classficacao_indicativa"));	
					filmeAlugar.setDisponivel(false);
					
	        		filmeDB.alterarFilme(filmeAlugar);
					
					return true;
					
		           
		        } catch (SQLException e) {
		            System.out.println("Erro ao consultar filme: " + e.getMessage());
		        }
				
				
			}
		}
		
		if (rs != null && filmeDB != null && filmeAlugDB != null) {
            try {
                rs.close();
                filmeDB.CloseDB();
                filmeAlugDB.CloseDB();
            } catch (SQLException e) {
                System.out.println("Erro ao fechar ResultSet: " + e.getMessage());
            }
        }
		
		return false;
		
	}
	
	public boolean devolver(String nomeFilme, String nomeCliente, String dataAtual, String produtora) {
		Filme filmeDevolver = null;
		
		System.out.println("OI" + nomeFilme + "Oi");
		
		if(nomeFilme.equals("") || nomeCliente.equals("")) {
			return false;
		}
		
		
		if(produtora.equalsIgnoreCase("Warner Bros")) {
			Produtora warner = new WarnerBros();
			
			filmeDevolver = warner.geraFilme(nomeFilme);
			filmeDevolver = buscarFilme(nomeFilme);
			filmeDevolver.setDisponivel(true);
			
		} else if(produtora.equalsIgnoreCase("Universal")) {
			Produtora universal = new Universal();
			
			filmeDevolver = universal.geraFilme(nomeFilme);
			filmeDevolver = buscarFilme(nomeFilme);
			filmeDevolver.setDisponivel(true);
	    } else if(produtora.equalsIgnoreCase("Paramount")) {
	    	Produtora paramount = new Paramount();
			
	    	filmeDevolver = paramount.geraFilme(nomeFilme);
	    	filmeDevolver = buscarFilme(nomeFilme);
	    	filmeDevolver.setDisponivel(true);
	    }
		
		filmeDevolver.setNome(nomeFilme);
		rs = filmeDB.consultarFilme(filmeDevolver, 2); 
		
		try {
			while(rs.next()) {
				if(rs.getString("nome").equalsIgnoreCase(nomeFilme)) {
					filmeDevolver.setCodigo_filme(rs.getInt("codigo_filme"));
					filmeDevolver.setNome(rs.getString("nome"));
					filmeDevolver.setGenero(rs.getString("genero"));
					filmeDevolver.setProdutora(rs.getString("produtora"));
					filmeDevolver.setDiretor(rs.getString("diretor"));
					filmeDevolver.setClassificacaoIndicativa(rs.getInt("classficacao_indicativa"));	
					
					filmeDevolver.setDisponivel(true);
					filmeDB.alterarFilme(filmeDevolver);
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		FilmeAlugadoDB filmeAlugDB = new FilmeAlugadoDB();
		ResultSet rs2 = filmeAlugDB.consultarFilmeAlugado(null, 2);
		
		try {
			while(rs2.next()) {
					
					rs.next();
					if(rs2.getString("nome_filme").equalsIgnoreCase(nomeFilme) && rs2.getString("nome_cliente").equalsIgnoreCase(nomeCliente)) {
						//listaFilmesAlugados.remove(filme);
						FilmeAlugado filmeAlugado = new FilmeAlugado();
						filmeAlugado.setCodigo_filme(rs2.getInt("codigo_filme"));
						filmeAlugado.setCodigo_cliente(rs2.getInt("codigo_cliente"));
						filmeAlugDB.excluirFilmeAlugado(filmeAlugado);
						
						return true;
					}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		if (rs != null) {
            try {
                rs.close();
                filmeDB.CloseDB();
            } catch (SQLException e) {
                System.out.println("Erro ao fechar ResultSet: " + e.getMessage());
            }
        }
		
		return false;
	}
	
	public Filme buscarFilme(String nomeFilme) {
		
		Filme filmeConsultar;
		
		if(nomeFilme.equalsIgnoreCase("Matrix") || nomeFilme.equalsIgnoreCase("A Origem") || nomeFilme.equalsIgnoreCase("Blade Runner")) {
			Produtora warner = new WarnerBros();
			filmeConsultar = warner.geraFilme(nomeFilme);
		} else if(nomeFilme.equalsIgnoreCase("Jurassic Park") || nomeFilme.equalsIgnoreCase("Gladiador") || nomeFilme.equalsIgnoreCase("Psicose")) {
			Produtora universal = new Universal();
			filmeConsultar = universal.geraFilme(nomeFilme);
		} else {
			Produtora paramount = new Paramount();
			filmeConsultar = paramount.geraFilme(nomeFilme);
		}
		
		
		rs = filmeDB.consultarFilme(filmeConsultar, 1);
		
		for(int i = 0; i < 9; i++) {
			try {
				
				rs.next();
	            
				if(nomeFilme.equalsIgnoreCase(rs.getString("nome"))) {
					System.out.printf("\nNome: %s | ", rs.getString("nome"));
					if(rs.getBoolean("disponivel")) {
						System.out.printf("disponível\n");
					} else {
						System.out.printf("indisponível\n");
					}
					
					filmeConsultar.setCodigo_filme(rs.getInt("codigo_filme"));
					filmeConsultar.setNome(rs.getString("nome"));
					filmeConsultar.setGenero(rs.getString("genero"));
					filmeConsultar.setProdutora(rs.getString("produtora"));
					filmeConsultar.setDiretor(rs.getString("diretor"));
					filmeConsultar.setClassificacaoIndicativa(rs.getInt("classficacao_indicativa"));
					filmeConsultar.setDisponivel(rs.getBoolean("disponivel"));
					return filmeConsultar;
				}
	            
				
	           
	        } catch (SQLException e) {
	            System.out.println("Erro ao consultar fornecedor: " + e.getMessage());
	        }
			
			
		}
		
		if (rs != null) {
            try {
                rs.close();
                filmeDB.CloseDB();
            } catch (SQLException e) {
                System.out.println("Erro ao fechar ResultSet: " + e.getMessage());
            }
        }
		
		return null;
	}
	
	public Cliente buscarCliente(String nomeCliente) {
		Cliente cliente = new Cliente();
		cliente.setNome(nomeCliente);
		rs = clienteDB.consultarCliente(cliente, 2);
		try {
			rs.next();
			if(rs.getString("nome").equalsIgnoreCase(nomeCliente)) {
				cliente.setCodigo_cliente(rs.getInt("codigo_cliente"));
				cliente.setNome(rs.getString("nome"));
				cliente.setIdade(rs.getInt("idade"));
				return cliente;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		if (rs != null) {
            try {
                rs.close();
                clienteDB.CloseDB();
            } catch (SQLException e) {
                System.out.println("Erro ao fechar ResultSet: " + e.getMessage());
            }
        }
		
		
		return null;
	}
	
	public ResultSet listarFilmes() {
		Filme filme = null;
		rs = filmeDB.consultarFilme(filme, 1);		
		
		return rs;
	}
	
	public ResultSet listarFilmesAlugados() {
		
		FilmeAlugadoDB filmeAlugDB = new FilmeAlugadoDB();
		rs = filmeAlugDB.consultarFilmeAlugado(null, 2);
		
		return rs;
		
		
	}
	
	public ResultSet listarClientes() {
		
		Cliente cliente = null;
		
		rs = clienteDB.consultarCliente(cliente, 1);
		
		return rs;
	}
	
	

}
