package controle;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import modelo.*;

public class AdministraUniversidade extends Universidade7{


	public AdministraUniversidade(String nomeDaUniversidade) {
		super(nomeDaUniversidade);
		// TODO Auto-generated constructor stub
	}

	public static void adm(Universidade7 uni7) {
		
		// -------------------------- Cargos da Universidade ---------------------------- //
		uni7.addCargo(new Cargo(TipoFuncionario.ANALISTA_DE_SISTEMAS.ordinal(), 10000.00));
		uni7.addCargo(new Cargo(TipoFuncionario.MOTORISTA.ordinal(), 2500.00));
		uni7.addCargo(new Cargo(TipoFuncionario.PROFESSOR.ordinal(), 15000.00));
		uni7.addCargo(new Cargo(TipoFuncionario.SECRETARIO.ordinal(), 3000.00));
		uni7.addCargo(new Cargo(TipoFuncionario.TESOUREIRO.ordinal(), 5000.00));
		// observar que pode causar inconsistencia no cadastro caso algum tipo seja excluido ou mudado de ordem...
		
		System.out.println("--------------- Relatorio de Cargos -------------------");
		uni7.listar(uni7.getCargos());
		System.out.println("");
		
		// ------------- Inicializa algumas Datas para preenchimento dos cadastros ---------------//
		DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		LocalDate dataAdmissao = LocalDate.parse("01/01/2000", dateFormat);
		LocalDate dataNascimento = LocalDate.parse("01/01/1970", dateFormat);
		LocalDate dataValidade = LocalDate.parse("31/12/2025", dateFormat);
		LocalDate dataInicialTurma = LocalDate.parse("01/01/2020", dateFormat);
		LocalDate dataFinalTurma = LocalDate.parse("30/06/2023", dateFormat);
		
		// ------------------------------------ Funcionarios ------------------------------------//
		uni7.addFuncionario(new AnalistaDeSistemas("JOAO  ", "44455566677", dataNascimento, uni7.getCargo(TipoFuncionario.ANALISTA_DE_SISTEMAS).getCodigoCargo(), 
													dataAdmissao, new LinguagemDeProgramacao("Java"), new IdeFavorita("Eclipse")));	

		uni7.addFuncionario(new Motorista("JOSÉ  ", "55566677789", dataNascimento.plusDays(30), uni7.getCargo(TipoFuncionario.MOTORISTA).getCodigoCargo(), 
										   dataAdmissao.minusDays(30), new CarteiraNacionalDeHabilitacao("123456789-0", CategoriaCNH.D, dataValidade)));
		
		uni7.addFuncionario(new Secretario("MARIA ", "66677788890", dataNascimento.plusDays(60), uni7.getCargo(TipoFuncionario.SECRETARIO).getCodigoCargo(), dataAdmissao.minusDays(60)));
		
		uni7.addFuncionario(new Tesoureiro("GASTÃO", "77788899901", dataNascimento.plusDays(90), uni7.getCargo(TipoFuncionario.TESOUREIRO).getCodigoCargo(), dataAdmissao.minusDays(90)));
			
		// -------------------------Disciplinas --------------------------- //
		uni7.addDisciplina(new Disciplina("ORIENTAÇAO A OBJETOS       ",80));
		uni7.addDisciplina(new Disciplina("ESTRUTURA DE DADOS         ",80));
		uni7.addDisciplina(new Disciplina("PROGRAMACAO                ",80));
		uni7.addDisciplina(new Disciplina("REDES DE COMPUTADORES      ",80));
		uni7.addDisciplina(new Disciplina("MATEMATICA                 ",80));
		uni7.addDisciplina(new Disciplina("UML                        ",80));
		uni7.addDisciplina(new Disciplina("ARQUITETURA DE COMPUTADORES",80));
		uni7.addDisciplina(new Disciplina("ENGENHARIA DE SOFTWARE     ",80));
		uni7.addDisciplina(new Disciplina("HISTORIA                   ",80));
		uni7.addDisciplina(new Disciplina("PORTUGUES                  ",80));
		uni7.addDisciplina(new Disciplina("FISICA                     ",80));
		uni7.addDisciplina(new Disciplina("CALCULO I                  ",80));
		
		System.out.println("--------------- Relatorio de Disciplinas -------------------");
		uni7.listar(uni7.getDisciplinas());
		System.out.println("");
		
		// ------------------------ Professores e Disciplinas dos Professores ---------------------- //
		Professor alex = new Professor("ALEX  ", "88899900012", dataNascimento.plusDays(120), uni7.getCargo(TipoFuncionario.PROFESSOR).getCodigoCargo(), dataAdmissao.minusDays(120), new Escolaridade("DOUTORADO"));
		alex.addDisciplina(uni7.getDisciplinas().get(0).getCodigoDisciplina());
		alex.addDisciplina(uni7.getDisciplinas().get(1).getCodigoDisciplina());
		alex.addDisciplina(uni7.getDisciplinas().get(2).getCodigoDisciplina());
		alex.addDisciplina(uni7.getDisciplinas().get(3).getCodigoDisciplina());		
		uni7.addFuncionario(alex);
		
		Professor marum = new Professor("MARUM ", "88899900012", dataNascimento.plusDays(150), uni7.getCargo(TipoFuncionario.PROFESSOR).getCodigoCargo(), dataAdmissao.minusDays(150), new Escolaridade("DOUTORADO"));
		marum.addDisciplina(uni7.getDisciplinas().get(4).getCodigoDisciplina());
		marum.addDisciplina(uni7.getDisciplinas().get(5).getCodigoDisciplina());
		marum.addDisciplina(uni7.getDisciplinas().get(6).getCodigoDisciplina());
		marum.addDisciplina(uni7.getDisciplinas().get(7).getCodigoDisciplina());
		uni7.addFuncionario(marum);
		
		System.out.println("--------------- Relatorio de Funcionarios -------------------");
		uni7.listarFuncionario(uni7.getFuncionarios(), uni7.getCargos());
		System.out.println("");
		
		// ------------------------------------- Alunos -----------------------------------------//
		Aluno mateus   = new Aluno("MATEUS  ", "25489535712", dataNascimento.plusDays(180));
		Aluno marcos   = new Aluno("MARCOS  ", "25489535713", dataNascimento.plusDays(210));
		Aluno lucas    = new Aluno("LUCAS   ", "25489535714", dataNascimento.plusDays(240));
		Aluno ana      = new Aluno("ANA     ", "25489535715", dataNascimento.plusDays(270));
		Aluno ester    = new Aluno("ESTER   ", "25489535716", dataNascimento.plusDays(300));
		Aluno priscila = new Aluno("PRISCILA", "25489535717", dataNascimento.plusDays(330));
		Aluno marta    = new Aluno("MARTA   ", "25489535818", dataNascimento.plusDays(360));
		Aluno samuel   = new Aluno("SAMUEL  ", "25489535818", dataNascimento.plusDays(390));
		Aluno juarez   = new Aluno("JUAREZ  ", "25489535212", dataNascimento.plusDays(420));
		Aluno daniel   = new Aluno("DANIEL  ", "25489535212", dataNascimento.plusDays(420));
		
		
		// ------------------------------Matriz Curricular -----------------------------//
		MatrizCurricular matrizAds = new MatrizCurricular("Análise e Desenvolvimento de Sistemas - EAD");
		matrizAds.addDisciplina(uni7.getDisciplinas().get(0));
		matrizAds.addDisciplina(uni7.getDisciplinas().get(1));
		matrizAds.addDisciplina(uni7.getDisciplinas().get(2));
		matrizAds.addDisciplina(uni7.getDisciplinas().get(3));
		matrizAds.addDisciplina(uni7.getDisciplinas().get(4));
		matrizAds.addDisciplina(uni7.getDisciplinas().get(5));
		matrizAds.addDisciplina(uni7.getDisciplinas().get(6));
		matrizAds.addDisciplina(uni7.getDisciplinas().get(7));
		uni7.addMatrizCurricular(matrizAds);
		
		System.out.println("--------------- Relatorio de Matrizes Curriculares -------------------");
		uni7.listar(uni7.getMatrizesCurriculares());
		System.out.println("");
		
		// ---------------------------------- Curso --------------------------------//
		Curso aDs = new Curso("Análise e Desemvolvimento de Sistemas", matrizAds.getCodigoMatrizCurricular());
		uni7.addCurso(aDs);
				
		// ------------------------------------- Turma ------------------------------ //
		Turma turmaAdsEad = new Turma("ADS EAD - 2001      ", dataInicialTurma, dataFinalTurma, 5);  // turma com máximo de 5 alunos
		turmaAdsEad.addProfessor(alex.getCodigoFuncionario());
		turmaAdsEad.addProfessor(marum.getCodigoFuncionario());	
		aDs.addTurma(turmaAdsEad.getCodigoDaTurma());
		
		Turma turmaAdsPresencial = new Turma("ADS Presencial- 2001", dataInicialTurma.plusDays(180), dataFinalTurma.plusDays(665), 30);  // turma com máximo de 30 alunos
		turmaAdsPresencial.addProfessor(alex.getCodigoFuncionario());
		aDs.addTurma(turmaAdsPresencial.getCodigoDaTurma());
						
		// --------------------- Matricular Alunos --------------------- //
		uni7.matricular(uni7.getMatriculas(), priscila, turmaAdsEad);
		System.out.println("Tenta matricular o aluno novamente na mesma turma.");
		uni7.matricular(uni7.getMatriculas(), priscila, turmaAdsEad);  // tenta matricular o aluno novamente na mesma turma
		System.out.println("");
		uni7.matricular(uni7.getMatriculas(), ana, turmaAdsEad);
		uni7.matricular(uni7.getMatriculas(), mateus, turmaAdsEad);
		uni7.matricular(uni7.getMatriculas(), lucas, turmaAdsEad);
		uni7.matricular(uni7.getMatriculas(), ester, turmaAdsEad);
		System.out.println("Tenta matricular o 6 aluno na turma de no máximo 5 alunos.");
		uni7.matricular(uni7.getMatriculas(), marcos, turmaAdsEad);  // tenta matricular o 6 aluno na turma de no máximo 5 alunos
		System.out.println("");
		uni7.matricular(uni7.getMatriculas(), marcos, turmaAdsPresencial);
		uni7.matricular(uni7.getMatriculas(), marta, turmaAdsPresencial);
		uni7.matricular(uni7.getMatriculas(), samuel, turmaAdsPresencial);
		uni7.matricular(uni7.getMatriculas(), juarez, turmaAdsPresencial);
		uni7.matricular(uni7.getMatriculas(), daniel, turmaAdsPresencial);
		uni7.matricular(uni7.getMatriculas(), ana, turmaAdsPresencial);  // aluna matriculada em duas turmas
		
		System.out.println("--------------- Relatorio de Alunos - Antes de Terem Aulas -------------------");
		uni7.listar(uni7.getAlunos());
		System.out.println("");
		
		//------------------------------------- Aulas -------------------------------- //				
		Aula aulaInauguralEad = new Aula(turmaAdsEad.getCodigoDaTurma(), uni7.getDisciplinas().get(0).getCodigoDisciplina(), marum.getCodigoFuncionario());
		uni7.terAula(uni7.getTurmas(), uni7.getListaDeProfessores(uni7) , aulaInauguralEad, uni7.getAlunos());
		
		Aula aula2Ead = new Aula(turmaAdsEad.getCodigoDaTurma(), uni7.getDisciplinas().get(0).getCodigoDisciplina(), marum.getCodigoFuncionario());
		uni7.terAula(uni7.getTurmas(), uni7.getListaDeProfessores(uni7) , aula2Ead, uni7.getAlunos());
		
		Aula aulaInauguralPresencial = new Aula(turmaAdsPresencial.getCodigoDaTurma(), uni7.getDisciplinas().get(0).getCodigoDisciplina(), alex.getCodigoFuncionario());
		uni7.terAula(uni7.getTurmas(), uni7.getListaDeProfessores(uni7), aulaInauguralPresencial, uni7.getAlunos());
		
		System.out.println("--------------- Relatorio de Alunos  - Após terem aulas-------------------");
		//uni7.listar(uni7.getAlunos());
		uni7.listarAluno(uni7.getAlunos(), uni7.getMatriculas(), uni7.getAulas(), uni7.getTurmas());
		System.out.println("");
		
		System.out.println("--------------- Relatorio de Professores  - Após darem aulas-------------------");
		uni7.listarProfessor(uni7.getListaDeProfessores(uni7), uni7.getCargos(), uni7.getDisciplinas());
		System.out.println("");
		
		
		System.out.println("--------------- Relatorio de Turmas -------------------");
		uni7.listarTurma(uni7.getTurmas(), uni7.getCursos(), uni7.getListaDeProfessores(uni7), uni7.getMatrizesCurriculares());
		System.out.println("");
		
		System.out.println("--------------- Relatorio de Cursos -------------------");
		uni7.listarCurso(uni7.getCursos(), uni7.getTurmas());
		System.out.println("");
		
	}

}
