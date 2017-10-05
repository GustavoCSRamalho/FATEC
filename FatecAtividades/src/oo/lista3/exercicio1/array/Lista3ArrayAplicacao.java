package oo.lista3.exercicio1.array;

import java.util.Scanner;

public class Lista3ArrayAplicacao {
	private static Scanner scanner;
	public static void main(String[] args) {
		scanner = new Scanner(System.in);
		Lista3ArrayAgendaTelefonica agenda = new Lista3ArrayAgendaTelefonica();
		int sair = 0; 
		int opcao = 0;
		while(sair == 0) {
			switch(opcao) {
			case 0:
				agenda.imprimirOpcoes();
				opcao = scanner.nextInt();
				break;
			case 1:
				agenda.imprimirPessoas();
				opcao = 0;
				break;
			case 2:
				agenda.cadastrarPessoa();
				opcao = 0;
				break;
			case 3:
				agenda.removerPessoa();
				opcao = 0;
				break;
			case 4:
				sair = 1;
				System.out.println("\nAté mais!\n");
				break;
			default:
				agenda.imprimirOpcoes();
				opcao = scanner.nextInt();
				break;
			}
		}
	}
}
