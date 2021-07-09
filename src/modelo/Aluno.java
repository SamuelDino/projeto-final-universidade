package modelo;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Aluno extends Pessoa {
	private static Integer proximoCodigoAluno=1001;
	private final Integer codigoAluno;
	private List<Integer> codigosMatriculas = new ArrayList<>();
	private List<Integer> codigosAulas = new ArrayList<>();
	
	public Aluno() {
		this.codigoAluno = proximoCodigoAluno++;
	}
	public Aluno(String nome, String cpf,LocalDate dataNascimento) {
		super(nome , cpf, dataNascimento);
		this.codigoAluno = proximoCodigoAluno++;
	}
	
	public Integer getCodigoMatriculaAtiva(List<Matricula> matriculas, Turma turma) {
		for(Integer codigoMatricula: this.codigosMatriculas) {
			int i;
			for (i=0;i<matriculas.size();i++) { // Verifica se o aluno tem mais de uma matricula ativa e retorna a ativa para turma passada como parametro
				if ((codigoMatricula == matriculas.get(i).getCodigoMatricula()) && (matriculas.get(i).getCodigoTurma()==turma.getCodigoDaTurma()) && ( matriculas.get(i).isAtiva())){
					return codigoMatricula;
				}
			}
		}
		return 0;
	}
	
	public Integer getCodigoAluno() {
		return codigoAluno;
	}
	
	public void addMatricula(Integer codigoMatricula) {
		this.codigosMatriculas.add(codigoMatricula);
	}
	
	public void addAula(Integer codigoAula) {
		this.codigosAulas.add(codigoAula);
	}
	
	
	public List<Integer> getCodigosMatriculas() {
		return codigosMatriculas;
	}

	public List<Integer> getCodigosAulas() {
		return codigosAulas;
	}

	public void listar(List<Matricula> matriculas, List<Aula> aulas, List<Turma> turmas) {
		System.out.println(toString());
		for (Integer codMatricula: getCodigosMatriculas()) {
			for(Matricula matricula: matriculas) {
				if (codMatricula == matricula.getCodigoMatricula()) {
					int presenca = Aula.getNumeroDeAulasDoAlunoPorTurma(codigoAluno, matricula.getCodigoTurma(), aulas);
					int totalAulasDaTurma = Turma.numeroAulas(turmas, matricula.getCodigoTurma()); 
					System.out.println("Matricula: "+codMatricula + ", Turma: "+matricula.getCodigoTurma() 
										+ " - "+ Turma.nomeDaTurma(turmas, matricula.getCodigoTurma())
										+ ", Aulas: " +  totalAulasDaTurma
										+ ", Presença(s): "+ presenca
										+ ", Falta(s): " + (totalAulasDaTurma - presenca));
					break;
				}
			}
		}
	}
	
	@Override
	public String toString() {
		return "Código: " + codigoAluno + ", Nome: "+getNome() ;
				
	}
	
	
}
