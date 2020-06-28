package br.com.erudio.controller;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.erudio.exception.UnsuportedMathOperationException;

@RestController
public class MathController {
	
	@RequestMapping(value="/soma/{num1}/{num2}", method=RequestMethod.GET)
	public Double soma (@PathVariable("num1") String num1, @PathVariable("num2") String num2) throws Exception {
		
		if (!isNumerico(num1) || !isNumerico(num2)) {
			throw new UnsuportedMathOperationException("Insira um valor numérico: ");
		}
		
		Double soma =  convertToDouble(num1)+convertToDouble(num2);
		return soma;
	}

	private Double convertToDouble(String strNum) {
		if (strNum==null) {
			return 0.0;
		}
		else if(isNumerico(strNum)){
			return 	Double.parseDouble(strNum);
		}
		return 0.0;
	}

	private boolean isNumerico(String strNum) {
		if (strNum==null) {
			return false;
		}
		String numero = strNum.replace(",", ".");
		
		return numero.matches("[+-]?[0-9]*\\.?[0-9]+");
	}

}
