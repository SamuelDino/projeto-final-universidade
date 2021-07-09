package modelo;

public class Disciplina {
	
	private static Integer codigoProximaDisciplina=30001;
	private final Integer codigoDisciplina;
	private String nomeDisciplina;
	private int numeroHoras;
	
	public Disciplina() {
		this.codigoDisciplina = codigoProximaDisciplina++;
	}

	public Disciplina(String nomeDisciplina, int numeroHoras) {
		this.codigoDisciplina = codigoProximaDisciplina++;
		this.nomeDisciplina = nomeDisciplina;
		this.numeroHoras = numeroHoras;
	}
		
	public Integer getCodigoDisciplina() {
		return codigoDisciplina;
	}

	public String getNomeDisciplina() {
		return nomeDisciplina;
	}

	public void setNomeDisciplina(String nomeDisciplina) {
		this.nomeDisciplina = nomeDisciplina;
	}

	public int getNumeroHoras() {
		return numeroHoras;
	}

	public void setNumeroHoras(int numeroHoras) {
		this.numeroHoras = numeroHoras;
	}

	@Override
	public String toString() {
		return "Código: " + codigoDisciplina + ", Disciplina: " + nomeDisciplina
				+ ", Horas: " + numeroHoras;
	}
	
}
