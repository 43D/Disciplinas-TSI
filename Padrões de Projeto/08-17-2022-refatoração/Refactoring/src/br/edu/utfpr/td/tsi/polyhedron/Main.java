package br.edu.utfpr.td.tsi.polyhedron;

import br.edu.utfpr.td.tsi.Util;

public class Main {

	public static void main(String[] args) {
		int vertice;
		int edge;
		
		do {
			Util.imprimirTexto("Digite o número de vértices do poliedro [4-6-8-12-20]: ");
			vertice = Util.nextInt();
		}
		while(!Polyhedron.isContainsVertice(vertice));
		
		do {
			Util.imprimirTexto("Digite o número de arestas do poliedro [6-12-30]: ");
			edge = Util.nextInt();
		}
		while(!Polyhedron.isContainsEdge(edge));
		
		String[] polyhedronInformation = Polyhedron.getPolydronInfomartion(vertice, edge);
		
		Util.imprimirTexto("-------------------");
		
		if (polyhedronInformation[0].equals("true")) {
			System.out.format("%s: %s faces %n", polyhedronInformation[1], polyhedronInformation[5]);
			System.out.format("Forma da face: %s", polyhedronInformation[2]);
		}else {
			Util.imprimirTexto("Os dados não indicam nenhum poliedro regular.");
		}
	}

}
