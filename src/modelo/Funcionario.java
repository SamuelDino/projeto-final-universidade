package modelo;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

public abstract class Funcionario extends Pessoa {
	private static Integer proximoCodigoFuncionario=40001;
	private final Integer codigoFuncionario;
	private Integer codigoCargo;
	private LocalDate dataAdmissao;
	private Integer numeroDiasFaltas=0;
	
	public Funcionario() {
		super();
		this.codigoFuncionario = proximoCodigoFuncionario++;
	}
	
	public Funcionario(String nome, String cpf, LocalDate dataNascimento,Integer codigoCargo, LocalDate dataAdmissao) {
		super(nome, cpf, dataNascimento);
		this.codigoFuncionario = proximoCodigoFuncionario++;
		this.codigoCargo = codigoCargo;
		this.dataAdmissao = dataAdmissao;
	}
		
	public Integer getCodigoFuncionario() {
		return codigoFuncionario;
	}

	public Integer getCodigoCargo() {
		return codigoCargo;
	}

	public LocalDate getDataAdmissao() {
		return dataAdmissao;
	}

	public void setDataAdmissao(LocalDate dataAdmissao) {
		this.dataAdmissao = dataAdmissao;
	}

	public Double calcularSalario(List<Cargo> cargos) {
		for(Cargo cargo: cargos) {
			if (this.codigoCargo==cargo.getCodigoCargo()) {
				return (double) ((cargo.getSalarioCargo()/30) * (double)(30-this.numeroDiasFaltas));
			}
		}
		return 0.0;
	}
	
	public String toString(List<Cargo> cargos) {
		return  "Código: "+ codigoFuncionario + ", Nome: "+ getNome() + ", cpf: " + getCpf() 
				+ ", Nascimento: " + getDataNascimento().format(DateTimeFormatter.ofPattern("dd/MM/yyyy"))
				+", Cargo: "+TipoFuncionario.nomeTipoFuncionario(this.codigoCargo)
				+ ", Admissão: " + dataAdmissao.format(DateTimeFormatter.ofPattern("dd/MM/yyyy"))
				+ ", Faltas: " + numeroDiasFaltas+ ", Salário: "+calcularSalario(cargos);
	}

	public Integer getNumeroDiasFaltas() {
		return numeroDiasFaltas;
	}
	
}
