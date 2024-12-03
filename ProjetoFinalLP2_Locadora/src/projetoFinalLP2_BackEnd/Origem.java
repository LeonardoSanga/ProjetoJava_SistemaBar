package projetoFinalLP2_BackEnd;

public class Origem extends Filme {
	@Override
	public void apresentaFilme() {
		System.out.println("A Origem | Gênero: " + this.getGenero() + " | Diretor: " + this.getDiretor() + " | Classificação Indicativa: " + this.getClassificacaoIndicativa() + "\n");
	}
}
