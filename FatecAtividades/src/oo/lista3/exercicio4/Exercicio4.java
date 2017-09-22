package oo.lista3.exercicio4;

import java.util.Scanner;

final class Exercicio4 {
	private static Scanner scan;
	public static void main(String[] args) {
		scan = new Scanner(System.in);
		int opcao;
		boolean funciona = true;
		do {
			opcao = imprimirOpcoes();
			switch(opcao) {
			case 1:
				if(multiplo()) {
					System.out.println("\nÉ multiplo!\n");
				}else {
					System.out.println("\nNão é multiplo!\n");
				}
				break;
			case 2:
				funciona = false;
				break;
			}
		}while(funciona);
		System.out.println("Programa finalizado!");
	}
	
	private static int imprimirOpcoes() {
		System.out.println("\n1 - Descubrir se o segundo numero é multiplo do primeiro.\n2 - Sair.\n ");
		int opcao = scan.nextInt();
		return opcao;
	}
	
	private static boolean multiplo() {
		int numero1, numero2;
		System.out.println("Digite o primeiro numero: ");
		numero1 = scan.nextInt();
		System.out.println("Digite o segundo numero: ");
		numero2 = scan.nextInt();
		if(numero1 % numero2 == 0) {
			return true;
		}
		return false;
	}
}
