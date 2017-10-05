package oo.lista3.exercicio1.vector;

import java.util.Scanner;

public class Lista3VectorAplicacao {
	private static Scanner scanner;
	public static void main(String[] args) {
		scanner = new Scanner(System.in);
		Lista3VectorAgendaTelefonica agenda = new Lista3VectorAgendaTelefonica();
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
