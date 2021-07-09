package modelo;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

public class Professor extends Funcionario{
	
	private Escolaridade escolaridade;
	private List<Integer> codigosDasDisciplinasDoProfessor = new ArrayList<>();
	private List<Integer> codigosDasAulasDoProfessor = new ArrayList<>();
	
	public Professor() {
		super();
	}

	public Professor(String nome, String cpf, LocalDate dataNascimento,Integer codigoCargo , LocalDate dataAdmissao, Escolaridade escolaridade) {
		super(nome, cpf, dataNascimento, codigoCargo , dataAdmissao);
		this.escolaridade = escolaridade;
	}
	
	public Escolaridade getEscolaridade() {
		return escolaridade;
	}

	public void setEscolaridade(Escolaridade escolaridade) {
		this.escolaridade = escolaridade;
	}

	public List<Integer> getDisciplinas() {
		return codigosDasDisciplinasDoProfessor;
	}

	public void addDisciplina(Integer codigoDisciplina) {
		this.codigosDasDisciplinasDoProfessor.add(codigoDisciplina);
	}
	
	public Integer getNumeroDeAulasDadas() {
		return this.codigosDasAulasDoProfessor.size();
	}

	public void addAula(Integer codigoAula) {
		this.codigosDasAulasDoProfessor.add(codigoAula);
		
	}

	
	public Double calcularSalario(List<Cargo> cargos) {
		for(Cargo cargo: cargos) {
			if (this.getCodigoCargo()==cargo.getCodigoCargo()) {
				return super.calcularSalario(cargos) + ((getNumeroDeAulasDadas()*cargo.getSalarioCargo()*0.01));
			}
		}
		return 0.0;
	}

	public void listarDisciplinas(List<Disciplina> disciplinas) {
		System.out.println("---- Disciplinas do Professor ----");
		for(Integer codigoDisciplina: this.codigosDasDisciplinasDoProfessor) {
			for(Disciplina d: disciplinas) {
				if (codigoDisciplina==d.getCodigoDisciplina()) {
					System.out.println("     "+d.getNomeDisciplina());
					break;
				}
			}
		}
		System.out.println("----------------------------------");
	}

	public String toString(List<Cargo> cargos) {
		return  "Código: "+ getCodigoFuncionario() + ", Nome: "+ getNome() + ", cpf: " + getCpf() 
		+ ", Nascimento: " + getDataNascimento().format(DateTimeFormatter.ofPattern("dd/MM/yyyy"))
		+", Cargo: "+TipoFuncionario.nomeTipoFuncionario(this.getCodigoCargo())
		+ ", Admissão: " + getDataAdmissao().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")) 
		+ ", Faltas: " + getNumeroDiasFaltas() + ", Numero de Aulas: "+getNumeroDeAulasDadas()
		+ ", "+escolaridade + ", Salário: " + calcularSalario(cargos);
	}

	
	
}
