package modelo;

import java.util.ArrayList;
import java.util.List;

public class MatrizCurricular{
	
	private static Integer codigoultimaMatrizCurricular = 60001;
	private final int codigoMatrizCurricular;
	private String nomeMatrizCurricular;
	private List<Disciplina> disciplinas = new ArrayList<Disciplina>();
	
	public MatrizCurricular() {;
		this.codigoMatrizCurricular = codigoultimaMatrizCurricular++;
	}
	
	public MatrizCurricular(String nomeMatrizCurricular) {
		this.codigoMatrizCurricular = codigoultimaMatrizCurricular++;
		this.nomeMatrizCurricular = nomeMatrizCurricular;
	}

	public MatrizCurricular(String nomeMatrizCurricular, List<Disciplina> disciplinas) {
		this.codigoMatrizCurricular = codigoultimaMatrizCurricular++;
		this.nomeMatrizCurricular = nomeMatrizCurricular;
		this.disciplinas = disciplinas;
	}


	public int getCodigoMatrizCurricular() {
		return codigoMatrizCurricular;
	}

	public String getNomeMatrizCurricular() {
		return nomeMatrizCurricular;
	}


	public void setNomeMatrizCurricular(String nomeMatrizCurricular) {
		this.nomeMatrizCurricular = nomeMatrizCurricular;
	}


	public List<Disciplina> getDisciplinas() {
		return disciplinas;
	}


	public void setDisciplinas(List<Disciplina> disciplinas) {
		this.disciplinas = disciplinas;
	}

	public void addDisciplina(Disciplina disciplina) {
		this.disciplinas.add(disciplina);
	}
	
	public void listar() {
		System.out.println("Matriz curricular: "+this.getNomeMatrizCurricular());
		for(Disciplina d: this.getDisciplinas()) {
			System.out.println(d.getNomeDisciplina());
		}
	}

	@Override
	public String toString() {
		listar();
		return "";
	}
		
}
