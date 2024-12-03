package projetoFinalLP2_BackEnd;

public class BladeRunner extends Filme {
	@Override
	public void apresentaFilme() {
		System.out.println("Blade Runner | Gênero: " + this.getGenero() + " | Diretor: " + this.getDiretor() + " | Classificação Indicativa: " + this.getClassificacaoIndicativa() + "\n");
	}
}