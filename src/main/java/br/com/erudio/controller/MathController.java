package br.com.erudio.controller;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.erudio.exception.UnsuportedMathOperationException;
import br.com.erudio.util.CalculadoraUtil;

@RestController
public class MathController extends CalculadoraUtil{
	
	
	@RequestMapping(value="/soma/{num1}/{num2}", method=RequestMethod.GET)
	public Double soma (@PathVariable("num1") String num1, @PathVariable("num2") String num2) throws Exception {
		
		if (!CalculadoraUtil.isNumerico(num1) || !CalculadoraUtil.isNumerico(num2)) {
			throw new UnsuportedMathOperationException("Insira um valor numérico: ");
		}
		
		Double soma =  CalculadoraUtil.convertToDouble(num1)+CalculadoraUtil.convertToDouble(num2);
		return soma;
	}

	@RequestMapping(value="/subtracao/{num1}/{num2}", method=RequestMethod.GET)
	public Double subtracao (@PathVariable("num1") String num1, @PathVariable("num2") String num2) throws Exception {
		
		if (!CalculadoraUtil.isNumerico(num1) || !CalculadoraUtil.isNumerico(num2)) {
			throw new UnsuportedMathOperationException("Insira um valor numérico: ");
		}
		
		Double subtracao =  convertToDouble(num1)-convertToDouble(num2);
		return subtracao;
	}
	@RequestMapping(value="/multiplicacao/{num1}/{num2}", method=RequestMethod.GET)
	public Double multiplicacao (@PathVariable("num1") String num1, @PathVariable("num2") String num2) throws Exception {
		
		if (!CalculadoraUtil.isNumerico(num1) || !CalculadoraUtil.isNumerico(num2)) {
			throw new UnsuportedMathOperationException("Insira um valor numérico: ");
		}
		
		Double multiplicacao =  CalculadoraUtil.convertToDouble(num1)*CalculadoraUtil.convertToDouble(num2);
		return multiplicacao;
	}
	
	@RequestMapping(value="/divisao/{num1}/{num2}", method=RequestMethod.GET)
	public Double divisao (@PathVariable("num1") String num1, @PathVariable("num2") String num2) throws Exception {
		
		if(num2.equals("0")) {
			throw new UnsuportedMathOperationException("Insira um valor numérico diferente de 0: ");
		}
		else if (!CalculadoraUtil.isNumerico(num1) || !CalculadoraUtil.isNumerico(num2)) {
			throw new UnsuportedMathOperationException("Insira um valor numérico: ");
		}
		
		Double divisao =  convertToDouble(num1)/CalculadoraUtil.convertToDouble(num2);
		return divisao;
	}
	
	@RequestMapping(value="/media/{num1}/{num2}", method=RequestMethod.GET)
	public Double media (@PathVariable("num1") String num1, @PathVariable("num2") String num2) throws Exception {
		
		if (!CalculadoraUtil.isNumerico(num1) || !isNumerico(num2)) {
			throw new UnsuportedMathOperationException("Insira um valor numérico: ");
		}
					
		Double media =  (CalculadoraUtil.convertToDouble(num1)+CalculadoraUtil.convertToDouble(num2))/2;
		return media;
	}
	
	@RequestMapping(value="/raiz/{num1}", method=RequestMethod.GET)
	public Double raiz (@PathVariable("num1") String num1) throws Exception {
		
		if (!CalculadoraUtil.isNumerico(num1)) {
			throw new UnsuportedMathOperationException("Insira um valor numérico: ");
		}
					
		return   Math.sqrt(CalculadoraUtil.convertToDouble(num1));
	}		
}
