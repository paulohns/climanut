package com.br.climanut.utils;

public enum EnumAtividadeAnvisa {

	SEMESTRAL(0),TRIMESTRAL(1); 
	
	public int periodicidade; 
	
	private EnumAtividadeAnvisa(int valor) {
		periodicidade = valor; 
	}

}
