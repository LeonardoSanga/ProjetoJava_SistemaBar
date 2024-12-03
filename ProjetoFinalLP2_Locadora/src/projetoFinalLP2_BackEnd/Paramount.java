package projetoFinalLP2_BackEnd;

public class Paramount extends Produtora {
	@Override
	public Filme geraFilme(String nomeFilme) {
		if(nomeFilme.equalsIgnoreCase("Forrest Gump")) {
			return new ForrestGump();
		} else if(nomeFilme.equalsIgnoreCase("Titanic")) {
			return new Titanic();
		} else if(nomeFilme.equalsIgnoreCase("O Poderoso Chefão")) {
			return new PoderosoChefao();
		}
		return null;
	}
}
