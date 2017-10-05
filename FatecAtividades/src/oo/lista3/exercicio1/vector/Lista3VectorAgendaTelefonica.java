package oo.lista3.exercicio1.vector;

import java.util.Scanner;
import java.util.Vector;

public class Lista3VectorAgendaTelefonica {
	private Vector<Lista3VectorPessoa> pessoas;
	private Scanner scanner;
	
	public Lista3VectorAgendaTelefonica() {
		pessoas = new Vector<Lista3VectorPessoa>();
		scanner = new Scanner(System.in);
	}
	
	public void cadastrarPessoa() {
		
				System.out.println("\nInsira um nome para a pessoa ");
				String nome = scanner.next();
				System.out.println("\nInsira um telefone para a pessoa ");
				String telefone = scanner.next();
				System.out.println("\nInsira um email para a pessoa ");
				String email = scanner.next();
				Lista3VectorPessoa nova = new Lista3VectorPessoa(nome, telefone, email);
				pessoas.addElement(nova);
				System.out.println("\nNovo contato adicionado\n");
	}
	
	public void removerPessoa() {
		System.out.println("\nDigite o nome do contato ");
		String nomeContato = scanner.next();
		for(Lista3VectorPessoa pessoa : pessoas) {
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
		for(Lista3VectorPessoa pessoa : pessoas) {
			if(pessoa != null) {
				System.out.println("\nNome "+pessoa.getNome()+"\nTelefone "
						+pessoa.getTelefone()+"\nEmail "+pessoa.getEmail());
			}
		}
	}

	public Vector<Lista3VectorPessoa> getPessoas() {
		return pessoas;
	}

	public void setPessoas(Vector<Lista3VectorPessoa> pessoas) {
		this.pessoas = pessoas;
	}

	
	
}
