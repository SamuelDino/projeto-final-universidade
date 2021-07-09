package modelo;

import java.util.List;

public interface Universidade {

	public static List<Funcionario> contratar(List<Funcionario> funcionarios) {
		return funcionarios;
	}
	
	public static List<Curso> criarCurso(List<Curso> cursos) {
		return cursos;
	}
	
	public static List<MatrizCurricular> criarMatrizCurricular(List<MatrizCurricular> matrizesCurriculares) {
		return matrizesCurriculares;
	}
	
	public static void matricular(Aluno aluno, Turma turma) {
	}
	
	public static List<Turma> criarTurma(List<Turma> turmas) {
		return turmas;
	}
	
	public static List<Aula> terAula(List<Aula> aulas) {
		return aulas;
	}
	
	public static List<Turma> terFormatura(List<Turma> formados) {
		return formados;
	}
}
