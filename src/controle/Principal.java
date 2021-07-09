package controle;
import java.awt.BorderLayout;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.lang.reflect.InvocationTargetException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.border.EmptyBorder;

import controle.Telas.Cadastro.CadastroGenerico;
import modelo.Aluno;
import modelo.Curso;
import modelo.Disciplina;
import modelo.Escolaridade;
import modelo.MatrizCurricular;
import modelo.Professor;

public class Principal {

	public static void main(String[] args) {
		iniciarComponentes();
	}
	
	public static void iniciarComponentes() {
		JFrame framePrincipal = new JFrame("Sistema de Controle Acadêmico");
		
		JMenuBar menuPrincipal  = new JMenuBar();
		menuPrincipal.setVisible(true);
		framePrincipal.setJMenuBar(menuPrincipal);
		
		JMenu menuCadastros = new JMenu("Cadastros");
		menuPrincipal.add(menuCadastros);
		
		JMenuItem itemMenuAlunos = new JMenuItem("Alunos");
		menuCadastros.add(itemMenuAlunos);
		
		JMenuItem itemMenuCursos = new JMenuItem("Cursos");
		menuCadastros.add(itemMenuCursos);
		
		JMenuItem itemMenuDisciplina = new JMenuItem("Disciplina");
		menuCadastros.add(itemMenuDisciplina);
		
		JMenuItem itemMenuMatrizCurricular = new JMenuItem("Matriz Curricular");
		menuCadastros.add(itemMenuMatrizCurricular);
		
		JMenuItem itemMenuProfessor = new JMenuItem("Professor");
		menuCadastros.add(itemMenuProfessor);
		
		JMenu menuSair = new JMenu("Sair");
		menuPrincipal.add(menuSair);
		
		JMenuItem itemMenuSair = new JMenuItem("Sair");
		menuSair.add(itemMenuSair);
		
		menuSair.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				if(e.getClickCount() == 2){
					framePrincipal.dispose();
				}
        }});
	
		
		Class localDateClass = LocalDate.class;
		Class stringClass = String.class;
		Class intClass = int.class;
		Class doubleClass = Double.class;
		Class listClass = java.util.List.class;
		Class escolaridadeClass = Escolaridade.class;
		
		//---------------------------------------Alunos----------------------------------------//
		ArrayList<Aluno> alunos = new ArrayList<Aluno>();
		Aluno aluno = new Aluno();
		alunos.add(aluno);

		String[][] getMethodsAluno = new String[][] {{"getNome","String.class"},{"getCpf","String.class"},{"getDataNascimento","LocalDate.class"},{"",""},{"",""}};			
		String[][] tableHeaderAluno = new String [][] {{"Nome do Aluno","600"},{"CPF","100"},{"Nascimento","100"},{"","100"},{"","100"}};

		Class[] classConstructorAluno = new Class[] {stringClass, stringClass, localDateClass};
		String classForNameAluno = "modelo.Aluno";
		
		ArrayList<JComboBox> boxesAluno = new ArrayList<JComboBox>();
		
		itemMenuAlunos.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					 CadastroGenerico.telaCadastroGenerico("Cadastro de Alunos",alunos,tableHeaderAluno,getMethodsAluno,classConstructorAluno, classForNameAluno, boxesAluno, null, null, null );
				} catch (NoSuchMethodException | SecurityException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (IllegalAccessException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (IllegalArgumentException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (InvocationTargetException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (ClassNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}			
		});
		
		//------------------------------Disciplinas---------------------------------------------------------------//

		ArrayList<Disciplina> disciplinas = new ArrayList<Disciplina>();
		Disciplina disciplina = new Disciplina();
		disciplinas.add(disciplina);
		String[][] getMethodsDisciplina = new String[][] {{"getNomeDisciplina","String.class"},{"getNumeroHoras","int.class"},{"",""},{"",""}};
		String[][] tableHeaderDisciplina = new String [][] {{"Disciplina","600"},{"N° Horas","100"},{"","100"},{"","100"}};
		
		Class[] classConstructorDisciplina = new Class[] {stringClass, intClass};
		String classForNameDisciplina = "modelo.Disciplina";
		
		//ArrayList<JComboBox> boxesDisciplina = new ArrayList<JComboBox>();
		
		itemMenuDisciplina.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					 CadastroGenerico.telaCadastroGenerico("Cadastro de Disciplinas",disciplinas,tableHeaderDisciplina, getMethodsDisciplina, classConstructorDisciplina, classForNameDisciplina, null, null, null, null  );
				} catch (NoSuchMethodException | SecurityException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (IllegalAccessException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (IllegalArgumentException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (InvocationTargetException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (ClassNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}			
		});
		
		//------------------------------Cursos---------------------------------------------------------------//

		ArrayList<Curso> cursos = new ArrayList<Curso>();
		Curso curso = new Curso();
		cursos.add(curso);
		String[][] getMethodsCurso = new String[][] {{"getNomeCurso","String.class"},{"",""},{"",""}};
		String[][] tableHeaderCurso = new String [][] {{"Curso","600"},{"","100"},{"","100"}};
				
		Class[] classConstructorCurso = new Class[] {stringClass};
		String classForNameCurso = "modelo.Curso";
		
		ArrayList<JComboBox> boxesCursos = new ArrayList<JComboBox>();

				
		itemMenuCursos.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					CadastroGenerico.telaCadastroGenerico("Cadastro de Cursos",cursos,tableHeaderCurso, getMethodsCurso, classConstructorCurso, classForNameCurso, boxesCursos, null, null, null );
				} catch (NoSuchMethodException | SecurityException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (IllegalAccessException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (IllegalArgumentException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (InvocationTargetException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (ClassNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}			
		});
		
		
		//------------------------------Matriz Curricular---------------------------------------------------------------//

				ArrayList<MatrizCurricular> matrizesCurricular = new ArrayList<MatrizCurricular>();
				MatrizCurricular matrizCurricular = new MatrizCurricular();			
				
				ArrayList<Disciplina> disciplinasDaGrade = new ArrayList<Disciplina>();
				disciplinasDaGrade.add(new Disciplina());
				
				
				matrizCurricular.setDisciplinas(disciplinasDaGrade);			
				
				matrizesCurricular.add(matrizCurricular);
				matrizesCurricular.get(0).setDisciplinas(disciplinasDaGrade);
				
				String[][] getMethodsMatrizCurricular = new String[][] {{"getNomeMatrizCurricular","String.class"},{"",""},{"",""}};
				String[][] tableHeaderMatrizCurricular = new String [][] {{"Nome da Matriz","600"},{"","100"},{"","100"}};
						
				Class[] classConstructorMatrizCurricular = new Class[] {stringClass, listClass};
				String classForNameMatrizCurricular = "modelo.MatrizCurricular";
				
				
		
				
				itemMenuMatrizCurricular.addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {
						Vector namesDisciplina = new Vector();
						int i=0;
						for (Disciplina discip: disciplinas) {
							namesDisciplina.addElement(discip.getNomeDisciplina());
						}
						JComboBox comboBoxDisciplinas = new JComboBox(namesDisciplina);
						comboBoxDisciplinas.setName("modelo.Disciplina");
						
						ArrayList<JComboBox> boxesMatrizCurricular = new ArrayList<JComboBox>();
						boxesMatrizCurricular.add(comboBoxDisciplinas);
											
						Class<Disciplina>[] classConstructorBoxMatrizCurricular = new Class[] {stringClass,intClass};
						String[][] getMethodsBoxDisciplina = new String[][] {{"getNomeDisciplina","String.class"},{"getDisciplinas","java.util.List.class"}};
						String[] setMethodsBoxDisciplina = new String[] {"setDisciplinas"};
						
						try {
							CadastroGenerico.telaCadastroGenerico("Cadastro de Matrizes Curricular",matrizesCurricular,tableHeaderMatrizCurricular, getMethodsMatrizCurricular, classConstructorMatrizCurricular, classForNameMatrizCurricular, boxesMatrizCurricular, classConstructorBoxMatrizCurricular, getMethodsBoxDisciplina, setMethodsBoxDisciplina );
						} catch (NoSuchMethodException | SecurityException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						} catch (IllegalAccessException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						} catch (IllegalArgumentException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						} catch (InvocationTargetException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						} catch (ClassNotFoundException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
					}			
				});
				
		
				//------------------------------Professor---------------------------------------------------------------//

				ArrayList<Professor> professores = new ArrayList<Professor>();
				Professor professor = new Professor();	
				
				
				ArrayList<Disciplina> disciplinasProfessor = new ArrayList<Disciplina>();
				disciplinasProfessor.add(new Disciplina());
				
				
				//professor.setDisciplinas(disciplinasProfessor);			
				
				professores.add(professor);
				//professores.get(0).setDisciplinas(disciplinasProfessor);
				
				String[][] getMethodsProfessor = new String[][] {{"getNome","String.class"},{"getCpf","String.class"},{"getDataNascimento","LocalDate.class"},{"getSalario","Double.class"},{"getDataAdmissao","LocalDate.class"},{"getEscolaridade","Escolaridade.class"},{"",""},{"",""}};
				String[][] tableHeaderProfessor = new String [][] {{"Nome","400"},{"CPF","100"},{"Nascimento","100"},{"Salário","100"},{"Admissão","100"},{"Escolaridade","130"},{"","90"},{"","90"}};
						
				Class[] classConstructorProfessor = new Class[] {stringClass, stringClass, localDateClass, doubleClass, localDateClass, escolaridadeClass, listClass};
				String classForNameProfessor = "modelo.Professor";
				
				
		
				
				itemMenuProfessor.addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {
						Vector namesDisciplina = new Vector();
						int i=0;
						for (Disciplina discip: disciplinas) {
							namesDisciplina.addElement(discip.getNomeDisciplina());
						}
						JComboBox comboBoxDisciplinas = new JComboBox(namesDisciplina);
						comboBoxDisciplinas.setName("modelo.Disciplina");
						
						ArrayList<JComboBox> boxesProfessor = new ArrayList<JComboBox>();
						boxesProfessor.add(comboBoxDisciplinas);
											
						Class<Disciplina>[] classConstructorBoxProfessor = new Class[] {stringClass,intClass};
						String[][] getMethodsBoxDisciplina = new String[][] {{"getNomeDisciplina","String.class"},{"getDisciplinas","java.util.List.class"}};
						String[] setMethodsBoxDisciplina = new String[] {"setDisciplinas"};
						
						try {
							CadastroGenerico.telaCadastroGenerico("Cadastro de Professores",professores,tableHeaderProfessor, getMethodsProfessor, classConstructorProfessor, classForNameProfessor, boxesProfessor, classConstructorBoxProfessor, getMethodsBoxDisciplina, setMethodsBoxDisciplina );
						} catch (NoSuchMethodException | SecurityException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						} catch (IllegalAccessException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						} catch (IllegalArgumentException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						} catch (InvocationTargetException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						} catch (ClassNotFoundException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
					}			
				});
				
		itemMenuSair.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				framePrincipal.dispose();
			}			
		});
		framePrincipal.setLocationRelativeTo(null);
		framePrincipal.setExtendedState(JFrame.MAXIMIZED_BOTH); 
		framePrincipal.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		framePrincipal.pack();
		framePrincipal.setVisible(true);
	}
	

}
