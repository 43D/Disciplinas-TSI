package br.edu.utfpr.td.tsi.parallelogramArea;

import br.edu.utfpr.td.tsi.Util;

public class Main {

	public static void main(String[] args) {
		
		Parallelogram parallelogram = new Parallelogram();
		
		Util.imprimirTexto("Digite o valor da base:");
		parallelogram.setBase(Util.nextFloat());
		
		Util.imprimirTexto("Digite o valor da altura:");
		parallelogram.setHeight(Util.nextFloat());
		
		Util.imprimirTexto("----------------------");
		Util.imprimirTexto("Área do paralelogramo: " + parallelogram.getArea());
		
		Util.done();
	}

}
