package br.edu.utfpr.td.tsi.power;

import br.edu.utfpr.td.tsi.Util;

public class Main {

	private static double base;
	private static double power;
	private static double result;
	
	public static void main(String[] args) {
		
		do {
			Util.imprimirTexto("Digite o número a ser potenciado: ");
			base = Util.nextDouble();
			Util.imprimirTexto("Digite a potência desejada: ");
			power = Util.nextDouble();
			
			if (!(base == 0 && power <= 0)) {
				break;
			}
			Util.imprimirTexto("Entrada inválida!!");
		}
		while(true);
		
		calculatePower();
		
		Util.imprimirTexto("------------");
		System.out.format("%.0f elevado a %.0f : %f", base, power, result);
		
	}
	
	public static void calculatePower() {
		result = Math.pow(base, power);
		
		if (isNegative(base)) {
			result = -Math.abs(result);
		}
	}
	
	public static boolean isNegative(double number) {
		if(number < 0) {
			return true;
		}
		return false;
	}
	
}
