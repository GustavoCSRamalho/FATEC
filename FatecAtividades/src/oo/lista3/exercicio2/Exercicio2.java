package oo.lista3.exercicio2;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

final class Exercicio2 {
	private static Scanner scan;
	private static Map<String,Double> dicionario;
	private static  double total;
	public static void main(String[] args) {
		scan = new Scanner(System.in);
		dicionario = new HashMap<String,Double>();
		dicionario.put("P1",1.0);
		dicionario.put("P2", 2.98);
		dicionario.put("P3", 9.98);
		dicionario.put("P4", 4.49);
		dicionario.put("P5", 6.87);
		total = 0;
		int opcao;
		
		boolean funciona = true;
		
		do {
			opcao = imprimeOpcoes();
			switch(opcao) {
			case 1:
				Exercicio2.addPar();
				break;
			case 2:
				Exercicio2.imprimirTotal();
				break;
			case 3:
				Exercicio2.limparTotal();
				break;
			case 4:
				funciona = false;
			}
		}while(funciona);
		
		System.out.println("Programa finalizado!");
	}
	
	private static int imprimeOpcoes() {
		int opcao;
		System.out.println("\n1 - Adicionar par.\n2 - Total vendido.\n3 - Fazer outra operacao.\n4 - Sair.\n");
		opcao = scan.nextInt();
		return opcao;
	}
	private static void addPar() {
		String codigo;
		int quantidade;
		System.out.println("Digite o código do par: ");
		codigo = scan.next();
		System.out.println("Digite a quantidade: ");
		quantidade = scan.nextInt();
		if(dicionario.containsKey(codigo)) {
			total += quantidade * dicionario.get(codigo).doubleValue();
		}else {
			System.out.println("\nCódigo invalido!\n");
		}
		
	}
	private static void imprimirTotal() {
		System.out.printf("\nO valor total da venda foi de = %.2f",total);
	}
	private static void limparTotal() {
		total = 0;
		System.out.println("\nPronto para fazer outra operação!\n");
	}
	
	
}
