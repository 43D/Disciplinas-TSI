package br.edu.utfpr.td.tsi;

import java.util.Scanner;

public final class Util {
	
	private static Scanner scanner = new Scanner(System.in);
	
	public static void imprimirTexto(String mensagem) {
		System.out.println(mensagem);
	}
	
	public static float nextFloat() {
		float number = scanner.nextFloat();
		return number;
	}
	
	public static double nextDouble() {
		double number = scanner.nextInt();
		return number;
	}
	
	public static int nextInt() {
		int number = scanner.nextInt();
		return number;
	}
	
	public static void done() {
		scanner.close();
	}
}
