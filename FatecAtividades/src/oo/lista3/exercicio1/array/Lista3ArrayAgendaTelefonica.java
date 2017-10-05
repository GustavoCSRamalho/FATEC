package oo.lista3.exercicio1.array;

import java.util.Scanner;

public class Lista3ArrayAgendaTelefonica {
	private Lista3ArrayPessoa[] pessoas;
	private Scanner scanner;
	
	public Lista3ArrayAgendaTelefonica() {
		pessoas = new Lista3ArrayPessoa[5];
		scanner = new Scanner(System.in);
	}
	
	public void cadastrarPessoa() {
		for(int i = 0 ;i < pessoas.length;i++) {
			if(pessoas[i] == null) {
				System.out.println("\nInsira um nome para a pessoa ");
				String nome = scanner.next();
				System.out.println("\nInsira um telefone para a pessoa ");
				String telefone = scanner.next();
				System.out.println("\nInsira um email para a pessoa ");
				String email = scanner.next();
				Lista3ArrayPessoa nova = new Lista3ArrayPessoa(nome, telefone, email);
				pessoas[i] = nova;
				System.out.println("\nNovo contato adicionado\n");
				break;
			}
		}
	}
	public void removerPessoa() {
		System.out.println("\nDigite o nome do contato ");
		String nomeContato = scanner.next();
		boolean encontrou = false;
		int pos = 0;
		for(int i = 0 ;i < pessoas.length;i++) {
			if(pessoas[i] != null) {
				if(pessoas[i].getNome().equals(nomeContato)) {
					pos = i;
					System.out.println("\nContato deletado\n");
					encontrou = true;
					break;
				}
			}
		}
		if(!encontrou) {
			System.out.println("\nContato nao existe!\n");
		}else {
			pessoas[pos] = null;
		}
	}
	public void imprimirOpcoes() {
		System.out.println("\nEscolha uma das opcoes: \n");
		System.out.println("1 - Listar contatos.\n");
		System.out.println("2 - Incluir contato.\n");
		System.out.println("3 - Remover contato.\n");
		System.out.println("4 - Sair\n");
	}
	
	public void imprimirPessoas() {
		for(Lista3ArrayPessoa pessoa : pessoas) {
			if(pessoa != null) {
				System.out.println("\nNome "+pessoa.getNome()+"\nTelefone "
						+pessoa.getTelefone()+"\nEmail "+pessoa.getEmail());
			}
		}
	}

	public Lista3ArrayPessoa[] getPessoas() {
		return pessoas;
	}

	public void setPessoas(Lista3ArrayPessoa[] pessoas) {
		this.pessoas = pessoas;
	}
	
}
