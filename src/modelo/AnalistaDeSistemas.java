package modelo;

import java.time.LocalDate;
import java.util.List;

public class AnalistaDeSistemas extends Funcionario{
	public LinguagemDeProgramacao linguagemDeProgramacao;
	public IdeFavorita ideFavorita;
	
	
	public AnalistaDeSistemas() {
		super();
		// TODO Auto-generated constructor stub
	}
	public AnalistaDeSistemas(String nome, String cpf, LocalDate dataNascimento, Integer codigoCargo, LocalDate dataAdmissao,
			LinguagemDeProgramacao linguagemDeProgramacao, IdeFavorita ideFavorita) {
		super(nome, cpf, dataNascimento, codigoCargo, dataAdmissao);
		this.linguagemDeProgramacao = linguagemDeProgramacao;
		this.ideFavorita = ideFavorita;
	}
	public LinguagemDeProgramacao getLinguagemDeProgramacao() {
		return linguagemDeProgramacao;
	}
	public void setLinguagemDeProgramacao(LinguagemDeProgramacao linguagemDeProgramacao) {
		this.linguagemDeProgramacao = linguagemDeProgramacao;
	}
	public IdeFavorita getIdeFavorita() {
		return ideFavorita;
	}
	public void setIdeFavorita(IdeFavorita ideFavorita) {
		this.ideFavorita = ideFavorita;
	}
	


	public String toString(List<Cargo> cargos) {
		return super.toString(cargos) +" Linguagem de Progamação: "+getLinguagemDeProgramacao().getNomeDaLinguagemDeProgramacao()
				+" IDE Favorita: "+getIdeFavorita().getNomeDaIdeFavorita();
	}
	
	
}
