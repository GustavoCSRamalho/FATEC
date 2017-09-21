package oo.lista2.exercicio6;

import java.util.Scanner;

final class Exercicio6 {
	private static Scanner scan ;
	public static void main(String[] args) {
		scan = new Scanner(System.in);
		Vendedor vendedor = new Vendedor();
		boolean funciona = true;
		String conf = "";
		int opcao;
		while(funciona) {
			opcao = Exercicio6.imprimirOpcoes();
			switch(opcao) {
			case 1:
				vendedor.addProduto();
				break;
			
			case 2:
				vendedor.imprimiRendimento();
				break;
			case 3:
				funciona = false;
				System.out.println("Programa finalizado!");
			}
		}
	}
	
	private static int imprimirOpcoes() {
		System.out.println("1 - Adicionar produto.\n2 - Calcular rendimento.\n3 - Sair.\n");
		return scan.nextInt();
	}
}
