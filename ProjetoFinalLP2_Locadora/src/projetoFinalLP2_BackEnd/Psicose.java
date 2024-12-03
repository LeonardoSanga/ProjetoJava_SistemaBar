package projetoFinalLP2_BackEnd;

public class Psicose extends Filme {
	@Override
	public void apresentaFilme() {
		System.out.println("Psicose | Gênero: " + this.getGenero() + " | Diretor: " + this.getDiretor() + " | Classificação Indicativa: " + this.getClassificacaoIndicativa() + "\n");
	}
}
