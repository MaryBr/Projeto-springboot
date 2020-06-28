package br.com.erudio.util;


public class CalculadoraUtil {

	public static Double convertToDouble(String strNum) {
		if (strNum==null) {
			return 0.0;
		}
		else if(isNumerico(strNum)){
			return 	Double.parseDouble(strNum);
		}
		return 0.0;
	}

	public static boolean isNumerico(String strNum) {
		if (strNum==null) {
			return false;
		}
		String numero = strNum.replace(",", ".");
		
		return numero.matches("[+-]?[0-9]*\\.?[0-9]+");
	}

}
