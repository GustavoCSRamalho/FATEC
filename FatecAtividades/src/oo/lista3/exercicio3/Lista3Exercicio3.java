package oo.lista3.exercicio3;

import java.util.Scanner;

final class Lista3Exercicio3 {
	private static double totalCobrado;
	private static Scanner scan;
	public static void main(String[] args) {
		int opcao;
		scan = new Scanner(System.in);
		boolean funciona = true;
		do {
			opcao = imprimirOpcoes();
			switch(opcao) {
			case 1:
				addCobranca();
				break;
			case 2:
				funciona = false;
				break;
			}
		}while(funciona);
		System.out.println("\nO programa foi finalizado!\n");
	}
	
	private static int imprimirOpcoes() {
		System.out.println("\n1 - Adicionar hora estacionada.\n"+
				"2 - Sair.\n");
		int opcao = scan.nextInt();
		return opcao;
	}
	
	private static void addCobranca() {
		System.out.println("Digite as horas que o veiculo ficou estacionado: ");
		totalCobrado = 0;
		int horasEstacionadas = scan.nextInt();
		int horas;
		if(horasEstacionadas <= 3) {
			totalCobrado = 2;
		}else {
			totalCobrado += 2;
			horas = horasEstacionadas - 3;
			totalCobrado += horas * 0.50;
		}
		System.out.printf("\nO total cobrado foi de = %.2f\n",totalCobrado);
	}
	
	private static void imprimeTotalCobrado() {
		System.out.printf("\nO total cobrado foi deu  = %.2f\n",totalCobrado);
	}
}
