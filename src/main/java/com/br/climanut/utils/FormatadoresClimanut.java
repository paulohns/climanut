package com.br.climanut.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.text.MaskFormatter;

public class FormatadoresClimanut {

	public static String formatarCpfCnpj(String campo){
		
		//para relatorio
		//C.N.P.J.: 11.401.442/0001-66 | IE: 256003114 | IM:32240
		
		String idFederal = null;
		if(campo != null){
			if(campo.length() > 11){
				idFederal = format("##.###.###/####-##", campo);
			} else {
				idFederal = format("###.###.###-##", campo);
			}
		}
		return idFederal;
	}
	
	public static String formatarTelefone(String campo){
		String str = " Tel: ";
		if(campo != null){
			str = str + format("(##)###########", campo);
		}
		return str;
	}
	
	public static String formatarReg(String campo){
		String str = " Reg. ";
		
		if(campo != null){
			str = str + format("#########-#", campo);
		}
		return str;
	}
	
	public static String formatarArt(String campo){
		String str = " ART. ";
		
		if(campo != null){
			str = str + format("#########-#", campo);
		}
		return str;
	}
	
	public static String formataData(String data) throws ParseException{
		String retorno = "";
		if(data != null){
			if(data.length() > 10){
				data = data.substring(0,10);
			}
			
			Date dataRel = new SimpleDateFormat("yyyy-MM-dd").parse(data);  
			retorno = new SimpleDateFormat("dd/MM/yyyy").format(dataRel);
		}
		return retorno;
	}
	
	
	private static String format(String pattern, Object value) {
        MaskFormatter mask;
        try {
            mask = new MaskFormatter(pattern);
            mask.setValueContainsLiteralCharacters(false);
            return mask.valueToString(value);
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
    }
	
}
