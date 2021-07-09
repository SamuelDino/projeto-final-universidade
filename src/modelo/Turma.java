package modelo;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Turma implements Comparable<Turma>{
	private static Integer codigoProximaTurma = 60001; 
	private final Integer codigoDaTurma;
	private String nomeDaTurma;
	private LocalDate dataInicial;
	private LocalDate dataFinal;
	private List<Integer> codigosProfessores = new ArrayList<>();
	private List<Integer> codigosAlunos = new ArrayList<>();
	private List<Integer> codigosAulas = new ArrayList<>();
	private final Integer NUMERO_MAXIMO_DE_ALUNOS;
	private boolean formados=false;
	
	public Turma(String nomeDaTurma, LocalDate dataInicial, LocalDate dataFinal, Integer numeroMaximoDeAlunos) {
		this.codigoDaTurma = codigoProximaTurma++;
		this.NUMERO_MAXIMO_DE_ALUNOS = numeroMaximoDeAlunos;
		this.nomeDaTurma = nomeDaTurma;
		this.dataInicial = dataInicial;
		this.dataFinal = dataFinal;
	}

	public String getNomeDaTurma() {
		return nomeDaTurma;
	}
	
	public static String nomeDaTurma(List<Turma> turmas, Integer codTurma) {
		for (Turma turma: turmas) {
			if (turma.getCodigoDaTurma()==codTurma) {
				return turma.getNomeDaTurma();
			}
		}
		return "";
	}
	
	public static Integer numeroAulas(List<Turma> turmas, Integer codTurma) {
		for (Turma turma: turmas) {
			if (turma.codigoDaTurma == codTurma) {
				return turma.getNumeroAulasDaTurma();
			}
		}
		return -1;
	}

	public void setNomeDaTurma(String nomeDaTurma) {
		this.nomeDaTurma = nomeDaTurma;
	}

	public LocalDate getDataInicial() {
		return dataInicial;
	}

	public void setDataInicial(LocalDate dataInicial) {
		this.dataInicial = dataInicial;
	}

	public LocalDate getDataFinal() {
		return dataFinal;
	}

	public void setDataFinal(LocalDate dataFinal) {
		this.dataFinal = dataFinal;
	}

	public List<Integer> getProfessores() {
		return codigosProfessores;
	}

	public void addProfessor(Integer codigoProfessor) {
		this.codigosProfessores.add(codigoProfessor);
	}

	public List<Integer> getAlunos() {
		return codigosAlunos;
	}

	public void addAluno(Integer codigoAluno) {
		this.codigosAlunos.add(codigoAluno);
	}

	public Integer getCodigoDaTurma() {
		return codigoDaTurma;
	}

	public Integer getNumeroAulasDaTurma() {
		return this.codigosAulas.size();
	}

	public void addAula(Integer codigoAula) {
		this.codigosAulas.add(codigoAula);
	}

	public Integer getNUMERO_MAXIMO_DE_ALUNOS() {
		return NUMERO_MAXIMO_DE_ALUNOS;
	}
	


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((codigoDaTurma == null) ? 0 : codigoDaTurma.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Turma other = (Turma) obj;
		if (codigoDaTurma == null) {
			if (other.codigoDaTurma != null)
				return false;
		} else if (!codigoDaTurma.equals(other.codigoDaTurma))
			return false;
		return true;
	}

	@Override
	public int compareTo(Turma other) {	
		return this.codigoDaTurma.compareTo(other.codigoDaTurma);
	}

	public  void listar(Turma turma, List<Curso> cursos, List<Professor> professores, List<MatrizCurricular> matrizesCurriculares) {
		System.out.println(toString());
		System.out.println("Total Vagas: "+turma.getNUMERO_MAXIMO_DE_ALUNOS()+", Matriculados: "+turma.getAlunos().size()
							+ ", Total Aulas: "+ turma.getNumeroAulasDaTurma());
		System.out.println("----- Professores Responsáveis -----");
		for(Integer codigoProfessor: turma.getProfessores()) {
			for (Professor professor: professores) { 
				if (codigoProfessor == professor.getCodigoFuncionario()) {
					System.out.println("Professor: "+professor.getNome());
					break;
				}
			}
		}
		
		for (Curso curso: cursos) {
			if (curso.getTurmas().contains(turma.getCodigoDaTurma())) {
				for(MatrizCurricular matrizCurricular: matrizesCurriculares) {
					if (matrizCurricular.getCodigoMatrizCurricular() == curso.getCodigoMatrizCurricular()) {
						matrizCurricular.listar();
						break;
					}
				}
				break;
			}
		}
		
		System.out.println("");
	}
	
	
	@Override
	public String toString() {
		return "Codigo: "+getCodigoDaTurma()+" - "+getNomeDaTurma();
	}
	
	
}
