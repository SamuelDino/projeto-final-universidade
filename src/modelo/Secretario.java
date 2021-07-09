package modelo;

import java.time.LocalDate;

public class Secretario extends Funcionario{

	public Secretario() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Secretario(String nome, String cpf, LocalDate dataNascimento, Integer codigoCargo, LocalDate dataAdmissao) {
		super(nome, cpf, dataNascimento, codigoCargo, dataAdmissao);
		// TODO Auto-generated constructor stub
	}
	
}
