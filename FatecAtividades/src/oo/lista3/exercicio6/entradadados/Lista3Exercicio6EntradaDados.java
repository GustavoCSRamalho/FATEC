package oo.lista3.exercicio6.entradadados;

import java.util.Scanner;

import oo.lista3.exercicio6.models.Lista3Exercicio6Cliente;

public class Lista3Exercicio6EntradaDados {
	public static  Scanner scan;
	private Lista3Exercicio6Cliente cliente;
	
	public Lista3Exercicio6EntradaDados() {
		scan = new Scanner(System.in);
		cliente = null;
	}
	
	public Lista3Exercicio6Cliente edicaoCliente(Lista3Exercicio6Cliente cliente) {
		String opcao = "";
		System.out.println("Deseja alterar o telefone: (y/n)");
		opcao = scan.next();
		if(opcao.equalsIgnoreCase("y")) {
			System.out.println("Digite o novo telefone: ");
			cliente.setTelefone(scan.next());
		}
		System.out.println("Deseja alterar o endereco:  (y/n)");
		opcao = scan.next();
		if(opcao.trim().equalsIgnoreCase("y")) {
			System.out.println("Digite o novo endereco: ");
			cliente.setEndereco(scan.next()+scan.nextLine());
		}
		return cliente;
	}
	
	public Lista3Exercicio6Cliente adicionaCliente() {
		cliente = new Lista3Exercicio6Cliente();
		System.out.println("\nAdicionando um cliente: \n");
		System.out.println("Digite o nome: ");
		cliente.setNome(scan.next());
		System.out.println("Digite o email: ");
		cliente.setEmail(scan.next());
		System.out.println("Digite o telefone: ");
		cliente.setTelefone(scan.next());
		System.out.println("Digite o endereco: ");
		cliente.setEndereco(scan.next()+scan.nextLine());
		System.out.println("Adicione os valores dos meses: ");
		for(int i = 0; i < 12; i++) {
			System.out.printf("Valor %d mes: ",i+1)	;
			cliente.getGastoMeses().add(scan.nextDouble());
		}
		
		return cliente;
	}
}
