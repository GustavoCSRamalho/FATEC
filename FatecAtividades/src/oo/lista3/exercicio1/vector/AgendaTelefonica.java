package oo.lista3.exercicio1.vector;

import java.util.Scanner;
import java.util.Vector;

public class AgendaTelefonica {
	private Vector<Pessoa> pessoas;
	private Scanner scanner;
	
	public AgendaTelefonica() {
		pessoas = new Vector<Pessoa>();
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
				pessoas.addElement(nova);
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

	public Vector<Pessoa> getPessoas() {
		return pessoas;
	}

	public void setPessoas(Vector<Pessoa> pessoas) {
		this.pessoas = pessoas;
	}

	
	
}
