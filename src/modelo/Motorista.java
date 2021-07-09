package modelo;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class Motorista extends Funcionario{
	private CarteiraNacionalDeHabilitacao cnh;

	public Motorista() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Motorista(String nome, String cpf, LocalDate dataNascimento, Integer codigoCargo, LocalDate dataAdmissao, CarteiraNacionalDeHabilitacao cnh) {
		super(nome, cpf, dataNascimento, codigoCargo, dataAdmissao);
		this.cnh = cnh;
	}

	public CategoriaCNH getCategoriaCNH() {
		return this.cnh.getCategoriaCNH();
	}

	@Override
	public String toString(List<Cargo> cargos) {
		return super.toString(cargos) + ", CNH: " + cnh.getNumeroCNH() 
				+ ", Validade: "+cnh.getValidadeCNH().format(DateTimeFormatter.ofPattern("dd/MM/yyyy"))
				+ ", Categoria: "+ cnh.getCategoriaCNH();
	}
		
}
