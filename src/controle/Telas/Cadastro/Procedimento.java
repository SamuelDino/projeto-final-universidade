package controle.Telas.Cadastro;

import javax.swing.JButton;
import javax.swing.JComboBox;

public enum Procedimento {
	Incluir, Excluir, Alterer, Editar, Voltar, Executado;

	@Override
	public String toString() {
		return super.toString();
	}
	
	
	public static JButton getButton(String procedimento) {
		JButton button = new JButton(procedimento);
        button.setName(procedimento);
		return button;
		
	}
	

}
