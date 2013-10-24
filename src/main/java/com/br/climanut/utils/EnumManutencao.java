package com.br.climanut.utils;

public enum EnumManutencao {

	SEMESTRAL(0),TRIMESTRAL(1); 
	
	public int periodicidade; 
	
	private EnumManutencao(int valor) {
		periodicidade = valor; 
	}
	
	public static String getPeriodicidade(int valor){
		String campo = "";
    	
    	if(EnumManutencao.SEMESTRAL.periodicidade == valor){
    		System.out.println(EnumManutencao.SEMESTRAL);
    		campo = EnumManutencao.SEMESTRAL.toString().toLowerCase();
    	} else if(EnumManutencao.TRIMESTRAL.periodicidade == valor){
    		System.out.println(EnumManutencao.TRIMESTRAL);
    		campo = EnumManutencao.TRIMESTRAL.toString().toLowerCase();
    	}
		
		
		return campo;
	}

}
