package projetoFinalLP2_BackEnd;

public class WarnerBros extends Produtora {
	@Override
	public Filme geraFilme(String nomeFilme) {
		if(nomeFilme.equalsIgnoreCase("Matrix")) {
			return new Matrix();
		} else if(nomeFilme.equalsIgnoreCase("Blade Runner")) {
			return new BladeRunner();
		} else if(nomeFilme.equalsIgnoreCase("A Origem")) {
			return new Origem();
		}
		return null;
	}
}