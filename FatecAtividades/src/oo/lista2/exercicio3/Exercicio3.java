package oo.lista2.exercicio3;

import java.util.Scanner;

public class Exercicio3 {
	public static void main(String[] args) {
		int[] lista = new int[5];
		int maior , menor, count = 1; 
		Scanner scan = new Scanner(System.in);
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
