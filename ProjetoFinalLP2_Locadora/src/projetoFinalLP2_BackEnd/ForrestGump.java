package projetoFinalLP2_BackEnd;

public class ForrestGump extends Filme {
	@Override
	public void apresentaFilme() {
		System.out.println("Forrest Gump | Gênero: " + this.getGenero() + " | Diretor: " + this.getDiretor() + " | Classificação Indicativa: " + this.getClassificacaoIndicativa() + "\n");
	}
}
