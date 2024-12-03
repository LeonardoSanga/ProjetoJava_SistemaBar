package projetoFinalLP2_BackEnd;

public class Titanic extends Filme {
	@Override
	public void apresentaFilme() {
		System.out.println("Titanic | Gênero: " + this.getGenero() + " | Diretor: " + this.getDiretor() + " | Classificação Indicativa: " + this.getClassificacaoIndicativa() + "\n");
	}
}
