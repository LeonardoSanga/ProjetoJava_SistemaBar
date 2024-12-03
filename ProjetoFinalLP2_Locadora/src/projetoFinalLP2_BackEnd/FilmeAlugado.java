package projetoFinalLP2_BackEnd;

public class FilmeAlugado {
	private int codigo_filme;
	private int codigo_cliente;
	private String nomeFilme;
	private String nomeCliente;
	private String dataAluga;
	private String dataDevolve;
	
	public int getCodigo_filme() {
		return codigo_filme;
	}

	public void setCodigo_filme(int codigo_filme) {
		this.codigo_filme = codigo_filme;
	}

	public int getCodigo_cliente() {
		return codigo_cliente;
	}

	public void setCodigo_cliente(int codigo_cliente) {
		this.codigo_cliente = codigo_cliente;
	}
	
	public String getNomeFilme() {
		return nomeFilme;
	}
	
	public void setNomeFilme(String nomeFilme) {
		this.nomeFilme = nomeFilme;
	}
	
	public String getNomeCliente() {
		return nomeCliente;
	}
	
	public void setNomeCliente(String nomeCliente) {
		this.nomeCliente = nomeCliente;
	}
	
	public String getDataAluga() {
		return dataAluga;
	}
	
	public void setDataAluga(String dataAluga) {
		this.dataAluga = dataAluga;
	}
	
	public String getDataDevolve() {
		return dataDevolve;
	}
	
	public void setDataDevolve(String dataDevolve) {
		this.dataDevolve = dataDevolve;
	}
}