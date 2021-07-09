package modelo;

import java.util.ArrayList;

public enum TipoFuncionario {
	SECRETARIO, 
	TESOUREIRO, 
	PROFESSOR, 
	ANALISTA_DE_SISTEMAS, 
	MOTORISTA;
	
	public static String nomeTipoFuncionario(Integer codigoTipoFuncionario) {
		int i;
		for (i=0;i<TipoFuncionario.values().length;i++) {
			if (TipoFuncionario.values()[i].ordinal()==codigoTipoFuncionario) {
				return TipoFuncionario.values()[i].name();
			}
		}
		return "";
	}
}
