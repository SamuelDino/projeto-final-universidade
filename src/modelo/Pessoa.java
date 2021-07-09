package modelo;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public abstract class Pessoa {
	private String nome;
	private String cpf;
	private LocalDate dataNascimento;
	
	public Pessoa() {
	}

	public Pessoa(String nome, String cpf, LocalDate dataNascimento) {
		this.cpf = cpf;
		this.nome = nome;
		this.dataNascimento = dataNascimento;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public LocalDate getDataNascimento() {
		//DateTimeFormatter formatDate = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		return this.dataNascimento;
	}

	public void setDataNascimento(LocalDate dataNascimento) {
		this.dataNascimento = dataNascimento;
	}
	
}
