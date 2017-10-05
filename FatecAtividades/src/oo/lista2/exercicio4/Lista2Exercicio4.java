package oo.lista2.exercicio4;

import java.util.Scanner;

public class Lista2Exercicio4 {
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
	
	private static int imprimeOpcoes() {
		System.out.println("\n1 - Executa\n2 - Sair\n");
		int opcao = scan.nextInt();
		return opcao;
	}
	private static void executa() {
		int num1, num2;
		System.out.println("Digite o primeiro numero : ");
		num1 = scan.nextInt();
		System.out.println("Digite o segundo numero : ");
		num2 = scan.nextInt();
		
		if(num2 % num1 == 0) {
			System.out.println("É multiplo!");
		}else {
			System.out.println("Não é multiplo!");
		}
	}
}
