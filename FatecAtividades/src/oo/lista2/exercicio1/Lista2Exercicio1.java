package oo.lista2.exercicio1;

import java.util.Scanner;

public class Lista2Exercicio1 {
	private static Scanner scan;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		scan = new Scanner(System.in);
		boolean funciona = true;
		do {
			int opcoes = imprimeOpcoes();
			switch(opcoes) {
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
	
	private static int imprimeOpcoes() {
		System.out.println("\n1 - Executa\n2 - Sair\n");
		int opcoes = scan.nextInt();
		return opcoes;
	}
	
	private static void executa() {
		int num1, num2;
		System.out.println("Digite o primeiro numero : ");
		num1 = scan.nextInt();
		System.out.println("Digite o segundo numero : ");
		num2 = scan.nextInt();
		
		System.out.println("Soma  = "+(num1+num2));
		System.out.println("Subtracao = "+(num1 - num2));
		System.out.println("Divisao = "+(num1*1.0/num2*1.0));
		System.out.println("Produto = "+(num1 * num2));
	}

}
