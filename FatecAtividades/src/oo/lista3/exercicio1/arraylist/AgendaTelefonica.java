package oo.lista3.exercicio1.arraylist;

import java.util.ArrayList;
import java.util.Scanner;

public class AgendaTelefonica {
	private ArrayList<Pessoa> pessoas;
	private Scanner scanner;
	
	public AgendaTelefonica() {
		pessoas = new ArrayList<Pessoa>();
		scanner = new Scanner(System.in);
	}
	
	public void cadastrarPessoa() {
		
				System.out.println("\nInsira um nome para a pessoa ");
				String nome = scanner.next();
				System.out.println("\nInsira um telefone para a pessoa ");
				String telefone = scanner.next();
				System.out.println("\nInsira um email para a pessoa ");
				String email = scanner.next();
				Pessoa nova = new Pessoa(nome, telefone, email);
				pessoas.add(nova);
				System.out.println("\nNovo contato adicionado\n");
	}
	
	public void removerPessoa() {
		System.out.println("\nDigite o nome do contato ");
		String nomeContato = scanner.next();
		for(Pessoa pessoa : pessoas) {
			if(pessoa.getNome().equals(nomeContato)) {
				pessoas.remove(pessoa);
				System.out.println("\nContato removido!\n");
				break;
			}
		}
	}
	
	public void imprimirOpcoes() {
		System.out.println("\nEscolha uma das opcoes: \n");
		System.out.println("1 - Listar contatos.\n");
		System.out.println("2 - Incluir contatos.\n");
		System.out.println("3 - Remover contato.\n");
		System.out.println("4 - Sair\n");
	}
	
	public void imprimirPessoas() {
		for(Pessoa pessoa : pessoas) {
			if(pessoa != null) {
				System.out.println("\nNome "+pessoa.getNome()+"\nTelefone "
						+pessoa.getTelefone()+"\nEmail "+pessoa.getEmail());
			}
		}
	}

	public ArrayList<Pessoa> getPessoas() {
		return pessoas;
	}

	public void setPessoas(ArrayList<Pessoa> pessoas) {
		this.pessoas = pessoas;
	}
	
}
