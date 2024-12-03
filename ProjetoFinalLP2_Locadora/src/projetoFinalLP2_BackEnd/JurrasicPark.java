package projetoFinalLP2_BackEnd;

public class JurrasicPark extends Filme {
	@Override
	public void apresentaFilme() {
		System.out.println("Jurassic Park | Gênero: " + this.getGenero() + " | Diretor: " + this.getDiretor() + " | Classificação Indicativa: " + this.getClassificacaoIndicativa() + "\n");
	}
}
