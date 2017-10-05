package oo.lista2.exercicio2;

import java.util.Scanner;

public class Lista2Exercicio2 {
	private static Scanner scan;
	public static void main(String[] args) {
		scan = new Scanner(System.in);
		boolean funciona = true;
		do {
			int opcao = imprimeOpcoes();
			switch(opcao) {
			case 1:
				executa();
				break;
			case 2:
				funciona = false;
				break;
			}
		}while(funciona);
		System.out.println("Programa finalizado!");
	}
	
	private static void executa() {
		int num1, num2;
		System.out.println("Digite o primeiro numero : ");
		num1 = scan.nextInt();
		System.out.println("Digite o segundo numero : ");
		num2 = scan.nextInt();
		
		System.out.println("Soma  = "+(num1+num2));
		System.out.println("Media = "+((num1*1.0+num2)/2));
		System.out.println("Ordem crescente = "+((num1 > num2) ? num2+" "+num1 : num1+" "+num2));

	}
	
	private static int imprimeOpcoes() {
		System.out.println("\n1 - Executar\n2 - Sair\n");
		int opcao = scan.nextInt();
		return opcao;
	}
}
