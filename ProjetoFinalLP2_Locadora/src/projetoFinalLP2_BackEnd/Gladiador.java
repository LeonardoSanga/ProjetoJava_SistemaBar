package projetoFinalLP2_BackEnd;

public class Gladiador extends Filme {
	@Override
	public void apresentaFilme() {
		System.out.println("Gladiador | Gênero: " + this.getGenero() + " | Diretor: " + this.getDiretor() + " | Classificação Indicativa: " + this.getClassificacaoIndicativa() + "\n");
	}
}
