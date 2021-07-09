package modelo;

public class Escolaridade {
	private String nomeEscolaridade;
	
	public Escolaridade() {
	}

	public Escolaridade(String nomeEscolaridade) {
		this.nomeEscolaridade = nomeEscolaridade;
	}

	public String getNomeEscolaridade() {
		return nomeEscolaridade;
	}

	public void setNomeEscolaridade(String nomeEscolaridade) {
		this.nomeEscolaridade = nomeEscolaridade;
	}

	@Override
	public String toString() {
		return "Escolaridade: " + nomeEscolaridade;
	}
	
}
