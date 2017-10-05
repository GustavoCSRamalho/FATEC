package oo.lista2.exercicio3;

import java.util.Scanner;

public class Lista2Exercicio3 {
	private static Scanner scan;
	public static void main(String[] args) {
		boolean funciona = true;
		scan = new Scanner(System.in);
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
		int opcoes = scan.nextInt();
		return opcoes;
	}
	
	private static void executa() {
		int[] lista = new int[5];
		int maior , menor, count = 1; 
		
		for(int i = 0; i < 5; i++) {
			System.out.printf("Digite o %d numero : ",i+1);
			lista[i] = scan.nextInt();
		}
		maior = lista[0];
		menor = lista[0];
		for(int i = 1; i < 5; i++) {
			if(lista[i] > maior) {
				maior = lista[i];
			}
			if(lista[i] < menor) {
				menor = lista[i];
			}
			count++;
		}
		System.out.println("Maior numero = "+maior);
		System.out.println("Menor numero = "+menor);
	}
}
