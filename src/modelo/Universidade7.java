package modelo;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class Universidade7 implements Universidade{
	
	private String nomeDaUniversidade;
	private List<Cargo> cargos = new ArrayList<>();
	private List<Funcionario> funcionarios= new ArrayList<>();
	private List<Aluno> alunos = new ArrayList<>();
	private List<Curso> cursos = new ArrayList<>();
	private List<Disciplina> disciplinas = new ArrayList<>();
	private List<MatrizCurricular> matrizesCurriculares = new ArrayList<>();
	private List<Matricula> matriculas = new ArrayList<>();
	private List<Turma> turmas = new ArrayList<>();
	private List<Aula> aulas = new ArrayList<>();
	private List<Turma> formados = new ArrayList<>();
	private Map<Integer, Integer> map_codigoTurma_codigoMatricula = new TreeMap<>(); 
	
		
	public Universidade7(String nomeDaUniversidade) {
		this.nomeDaUniversidade = nomeDaUniversidade;
	}

	public String getNomeDaUniversidade() {
		return nomeDaUniversidade;
	}

	public void setNomeDaUniversidade(String nomeDaUniversidade) {
		this.nomeDaUniversidade = nomeDaUniversidade;
	}
	
	

	public List<Cargo> getCargos() {
		return cargos;
	}
	
	public Cargo getCargo(TipoFuncionario tipoFuncionariio) {
		for (Cargo c: getCargos()) {
			if (c.getCodigoCargo()==tipoFuncionariio.ordinal()) {
				return c;
			}
		}
		return null;
		
	}

	public void addCargo(Cargo cargo) {
		this.cargos.add(cargo);
	}

	public List<Funcionario> getFuncionarios() {
		return funcionarios;
	}

	public void addFuncionario(Funcionario funcionario) {
		this.funcionarios.add(funcionario);
	}

	public List<Aluno> getAlunos() {
		return alunos;
	}

	public void addAluno(Aluno aluno) {
		this.alunos.add(aluno);
	}

	public List<Curso> getCursos() {
		return cursos;
	}

	public void addCurso(Curso curso) {
		this.cursos.add(curso);
	}

	public List<Disciplina> getDisciplinas() {
		return disciplinas;
	}

	public void addDisciplina(Disciplina disciplina) {
		this.disciplinas.add(disciplina);
	}

	public List<MatrizCurricular> getMatrizesCurriculares() {
		return matrizesCurriculares;
	}

	public void addMatrizCurricular(MatrizCurricular matrizCurricular) {
		this.matrizesCurriculares.add(matrizCurricular);
	}

	public List<Matricula> getMatriculas() {
		return matriculas;
	}

	public void addMatricula(Matricula matricula) {
		this.matriculas.add(matricula);
	}

	public List<Turma> getTurmas() {
		return turmas;
	}

	public void addTurma(Turma turma) {
		this.turmas.add(turma);
	}

	public List<Aula> getAulas() {
		return aulas;
	}

	public void addAula(Aula aula) {
		this.aulas.add(aula);
	}

	public List<Turma> getFormados() {
		return formados;
	}

	public void addFormados(Turma formados) {
		this.formados.add(formados);
	}

	public static List<Funcionario> contratar(List<Funcionario> funcionarios) {
		// TODO Auto-generated method stub
		return null;
	}

	public static List<Curso> criarCurso(List<Curso> cursos) {
		// TODO Auto-generated method stub
		return cursos;
	}

	public static List<MatrizCurricular> criarMatrizCurricular(List<MatrizCurricular> matrizesCurriculares) {
		// TODO Auto-generated method stub
		return matrizesCurriculares;
	}

	public  void matricular(List<Matricula> matriculas, Aluno aluno, Turma turma) {
		if (turma.getAlunos().size()<turma.getNUMERO_MAXIMO_DE_ALUNOS()) {
			// verifica se já existe uma matricula do aluno na turma
			if (!(this.map_codigoTurma_codigoMatricula.get(turma.getCodigoDaTurma())==aluno.getCodigoMatriculaAtiva(matriculas, turma))) {
				Matricula novaMatricula = new Matricula(aluno.getCodigoAluno(), turma.getCodigoDaTurma());
				this.matriculas.add(novaMatricula);
				if (!(this.alunos.contains(aluno))){
					this.alunos.add(aluno);
				}
				aluno.addMatricula(novaMatricula.getCodigoMatricula());
				if (!(this.turmas.contains(turma))) {
					this.turmas.add(turma);
				}			
				turma.addAluno(aluno.getCodigoAluno());		
				map_codigoTurma_codigoMatricula.put(novaMatricula.getCodigoTurma(), novaMatricula.getCodigoMatricula());
			}
			else {
				System.out.println("Aluno(a): "+aluno+" já está matriculado(a) na turma: "+turma);
			}
		}
		else {
			System.out.println("Turma completa com "+turma.getNUMERO_MAXIMO_DE_ALUNOS()+" alunos - Aluno(a): "+ aluno + ", deve ser matriculado(a) em outra turma..");
		}

	}

	public static List<Turma> criarTurma(List<Turma> turmas) {
		// TODO Auto-generated method stub
		return turmas;
	}

	public  void terAula(List<Turma> turmas, List<Professor> professores, Aula aula, List<Aluno> alunos) {
		aula.chamada(turmas,professores,alunos);
		this.aulas.add(aula);
	
	}

	public static List<Turma> terFormatura(List<Turma> formados) {
		// TODO Auto-generated method stub
		return formados;
	}


	
	public List<Professor> getListaDeProfessores(Universidade7 uni7){
		// ---------- cria e popula uma lista com os professores da universidade ---------//
		List<Professor> professores = new ArrayList<>();
		int i;
		for (i=0;i<uni7.getFuncionarios().size();i++) {
			if(uni7.getFuncionarios().get(i).getCodigoCargo()==TipoFuncionario.PROFESSOR.ordinal()) {
				professores.add((Professor)uni7.getFuncionarios().get(i));
			}
		}
		return professores;
	}
	
	public <T> void listar(List<T> obj) {
		for(T o: obj) {
			System.out.println(o);
		}
	}
	
	public void listarFuncionario(List<Funcionario> funcionarios, List<Cargo> cargos) {
		for (Funcionario funcionario: funcionarios) {
			System.out.println(funcionario.toString(cargos));
		}
	}
	
	public void listarProfessor(List<Professor> professores, List<Cargo> cargos, List<Disciplina> disciplinas) {
		for (Professor professor: professores) {
			System.out.println(professor.toString(cargos));
			professor.listarDisciplinas(disciplinas);
		}
	}
	
	public void listarAluno(List<Aluno> alunos, List<Matricula> matriculas, List<Aula> aulas, List<Turma> turmas) {
		for(Aluno aluno: alunos) {
			aluno.listar(matriculas, aulas, turmas);
			System.out.println("");
		}
	}
	
	public void listarTurma(List<Turma> turmas, List<Curso> cursos, List<Professor> professores, List<MatrizCurricular> matrizesCurriculares) {
		for(Turma turma: turmas) {
			turma.listar(turma, cursos, professores, matrizesCurriculares);
		}
	}
	
	public void listarCurso(List<Curso> cursos, List<Turma> turmas) {
		for(Curso curso: cursos) {
			curso.listar(curso, turmas);
		}
	}
}
