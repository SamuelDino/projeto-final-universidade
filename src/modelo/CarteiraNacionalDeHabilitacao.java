package modelo;

import java.time.LocalDate;

public class CarteiraNacionalDeHabilitacao {
	private String numeroCNH;
	private CategoriaCNH categoriaCNH;
	private LocalDate validadeCNH;
	
	public CarteiraNacionalDeHabilitacao(String numeroCNH, CategoriaCNH categoriaCNH, LocalDate validadeCNH) {
		this.numeroCNH = numeroCNH;
		this.categoriaCNH = categoriaCNH;
		this.validadeCNH = validadeCNH;
	}

	public String getNumeroCNH() {
		return numeroCNH;
	}

	public void setNumeroCNH(String numeroCNH) {
		this.numeroCNH = numeroCNH;
	}

	public CategoriaCNH getCategoriaCNH() {
		return categoriaCNH;
	}

	public void setCategoriaCNH(CategoriaCNH categoriaCNH) {
		this.categoriaCNH = categoriaCNH;
	}

	public LocalDate getValidadeCNH() {
		return validadeCNH;
	}

	public void setValidadeCNH(LocalDate validadeCNH) {
		this.validadeCNH = validadeCNH;
	}
	
	
}
