package projetoFinalLP2_BackEnd;

public class PoderosoChefao extends Filme {
	@Override
	public void apresentaFilme() {
		System.out.println("O Poderoso Chefão | Gênero: " + this.getGenero() + " | Diretor: " + this.getDiretor() + " | Classificação Indicativa: " + this.getClassificacaoIndicativa() + "\n");
	}
}
