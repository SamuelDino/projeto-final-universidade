package modelo;

public class Matricula {
	private static Integer codigoProximaMatricula = 50001;
	private final Integer codigoMatricula;
	private Integer codigoAluno;
	private Integer codigoTurma;
	private boolean ativa;
	
	public Matricula(Integer codigoAluno, Integer codigoTurma) {
		this.codigoMatricula = codigoProximaMatricula++;
		this.codigoAluno = codigoAluno;
		this.codigoTurma = codigoTurma;
		this.ativa = true;
	}

	public Integer getCodigoAluno() {
		return codigoAluno;
	}

	public Integer getCodigoTurma() {
		return codigoTurma;
	}

	public void setCodigoTurma(Integer codigoTurma) {
		this.codigoTurma = codigoTurma;
	}

	public boolean isAtiva() {
		return ativa;
	}

	public void setAtiva(boolean ativa) {
		this.ativa = ativa;
	}

	public Integer getCodigoMatricula() {
		return codigoMatricula;
	}
	
}
