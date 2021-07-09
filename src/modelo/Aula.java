package modelo;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Aula {
	private static Integer codigoDaProximaAula=20001; 
	private final Integer codigoAula;
	private Integer codigoTurma;
	private List<Integer> codigosAlunosPresentes = new ArrayList<>();
	private Integer codigoDisciplina;
	private Integer codigoProfessor;
	private LocalDate dataAula;
	private LocalDate horario;	
	
	
	public List<Integer> getCodigosAlunosPresentes() {
		return codigosAlunosPresentes;
	}

	public Aula(Integer codigoTurma, Integer codigoDisciplina, Integer codigoProfessor) {
		this.codigoAula = codigoDaProximaAula++;
		this.codigoTurma = codigoTurma;
		this.codigoDisciplina = codigoDisciplina;
		this.codigoProfessor = codigoProfessor;
	}
	
	public static int getNumeroDeAulasDoAlunoPorTurma(Integer codigoAluno, Integer codTurma, List<Aula> aulas) {
		int numeroAulas=0;
		for (Aula aula: aulas) {
			if (aula.codigoTurma==codTurma) {
				numeroAulas += (aula.getCodigosAlunosPresentes().contains(codigoAluno)) ? 1:0;
			}
			
		}
		return numeroAulas;
		
	}


	public void chamada(List<Turma> turmas, List<Professor> professores, List<Aluno> alunos) {
		for (Turma turma: turmas) {
			if (this.codigoTurma==turma.getCodigoDaTurma()) {
				int numeroAlunosTurma = turma.getAlunos().size();
				Random random = new Random();
				int index = random.nextInt(numeroAlunosTurma-1);
				index = (index < 0) ? 0: index;
				int codigoDoAlunoQueFaltou = turma.getAlunos().get(index);
				for (Integer codigoAluno: turma.getAlunos()) {
					if (codigoAluno!=codigoDoAlunoQueFaltou) {
						this.codigosAlunosPresentes.add(codigoAluno);
						for(Aluno aluno: alunos) {
							if (aluno.getCodigoAluno()==codigoAluno) {
								aluno.addAula(this.codigoAula);
							}
						}
						
					} 	
				}
				for (Professor professor: professores) {
					if (this.codigoProfessor==professor.getCodigoFuncionario()) {
						professor.addAula(codigoAula);
					}
				}
				turma.addAula(this.codigoAula);
			break;
			}
			
		}

	}
}
