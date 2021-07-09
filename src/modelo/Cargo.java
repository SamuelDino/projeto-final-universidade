package modelo;

import java.util.List;

public class Cargo {
	private final Integer codigoCargo;
	private Double salarioCargo=0.00;
	
	public Cargo(Integer codigoCargo, Double salarioCargo) {
		this.codigoCargo = codigoCargo;
		this.salarioCargo = salarioCargo;
	}

	public Integer getCodigoCargo() {
		return codigoCargo;
	}

	public Double getSalarioCargo() {
		return salarioCargo;
	}

	public void setSalarioCargo(Double salarioCargo) {
		this.salarioCargo = salarioCargo;
	}

	@Override
	public String toString() {
		return "Código: " + codigoCargo + ", Cargo: " 
				+ TipoFuncionario.nomeTipoFuncionario(this.codigoCargo) 
				+ ", Salário: " + salarioCargo;
	}


}
