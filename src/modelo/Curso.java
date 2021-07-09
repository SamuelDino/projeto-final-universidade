package modelo;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Curso {
	private static Integer codigoProximoCurso=70001;
	private final Integer codigoCurso;
	private String nomeCurso;
	private Integer codigoMatrizCurricular;
	private List<Integer> codigosTurmas = new ArrayList<>();
	
	public Curso() {
		this.codigoCurso = codigoProximoCurso++;
	}
	
	public Curso(String nomeCurso, Integer codigoMatrizCurricular) {
		this.codigoCurso = codigoProximoCurso++;
		this.nomeCurso = nomeCurso;
		this.codigoMatrizCurricular = codigoMatrizCurricular;
	}

	public String getNomeCurso() {
		return nomeCurso;
	}

	public void setNomeCurso(String nomeCurso) {
		this.nomeCurso = nomeCurso;
	}

	public Integer getCodigoMatrizCurricular() {
		return codigoMatrizCurricular;
	}

	public void setMatrizCurricular(Integer codigoMatrizCurricular) {
		this.codigoMatrizCurricular = codigoMatrizCurricular;
	}

	public List<Integer> getTurmas() {
		return codigosTurmas;
	}

	public void addTurma(Integer codigoTurma) {
		this.codigosTurmas.add(codigoTurma);
	}
	
	public void listar(Curso curso, List<Turma> turmas) {		
		System.out.println("Curso: "+curso.getNomeCurso());
		for (Integer codTurma: curso.getTurmas()) {
			for (Turma turma: turmas) {
				if (turma.getCodigoDaTurma()==codTurma) {
					System.out.println("Turma: "+turma.getCodigoDaTurma()+" - "+turma.getNomeDaTurma()
										+", Vagas: "+turma.getNUMERO_MAXIMO_DE_ALUNOS()
										+", Matriculados: "+turma.getAlunos().size()
										+", Total Aulas: "+turma.getNumeroAulasDaTurma());
					break;
				}
			}
		}
		System.out.println("");
	}

}
