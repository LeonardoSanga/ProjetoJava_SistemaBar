package projetoFinalLP2_BackEnd;

public abstract class Filme {
	int codigo_filme;
	public int getCodigo_filme() {
		return codigo_filme;
	}

	public void setCodigo_filme(int codigo_filme) {
		this.codigo_filme = codigo_filme;
	}

	private String nome;
	private String genero;
	private String diretor;
	private int classificacaoIndicativa;
	private String produtora;

	public String getProdutora() {
		return produtora;
	}

	public void setProdutora(String produtora) {
		this.produtora = produtora;
	}

	private boolean disponivel;
	
	public abstract void apresentaFilme();
	
	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public String getGenero() {
		return genero;
	}
	
	public void setGenero(String genero) {
		this.genero = genero;
	}
	
	public String getDiretor() {
		return diretor;
	}
	
	public void setDiretor(String diretor) {
		this.diretor = diretor;
	}
	
	public boolean isDisponivel() {
		return disponivel;
	}
	
	public void setDisponivel(boolean disponivel) {
		this.disponivel = disponivel;
	}
	
	public int getClassificacaoIndicativa() {
		return classificacaoIndicativa;
	}

	public void setClassificacaoIndicativa(int classificacaoIndicativa) {
		this.classificacaoIndicativa = classificacaoIndicativa;
	}
	
}
