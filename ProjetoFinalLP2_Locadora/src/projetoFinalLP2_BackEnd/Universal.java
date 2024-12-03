package projetoFinalLP2_BackEnd;

public class Universal extends Produtora {
	@Override
	public Filme geraFilme(String nomeFilme) {
		if(nomeFilme.equalsIgnoreCase("Jurassic Park")) {
			return new JurrasicPark();
		} else if(nomeFilme.equalsIgnoreCase("Gladiador")) {
			return new Gladiador();
		} else if(nomeFilme.equalsIgnoreCase("Psicose")) {
			return new Psicose();
		}
		return null;
	}
}
