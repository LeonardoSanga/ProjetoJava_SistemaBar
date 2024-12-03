package projetoFinalLP2_BackEnd;

public class Matrix extends Filme {
	@Override
	public void apresentaFilme() {
		System.out.println("Matrix | Gênero: " + this.getGenero() + " | Diretor: " + this.getDiretor() + " | Classificação Indicativa: " + this.getClassificacaoIndicativa() + "\n");
	}
}
