package oo.lista4.engine;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import oo.lista4.modelos.Lista4Aluno;
import oo.lista4.modelos.Lista4Contato;
import oo.lista4.modelos.Lista4Pessoa;
import oo.lista4.modelos.Lista4Professor;

public class Lista4Agenda {
	private List<Lista4Aluno> alunos;
	private List<Lista4Professor> professores;
	private static Scanner scan;
	
	public Lista4Agenda() {
		this.alunos = new ArrayList<Lista4Aluno>();
		this.professores = new ArrayList<Lista4Professor>();
		this.scan = new Scanner(System.in);
	}
	
	
	public int listarOpcoes() {
		System.out.println("\n1 - Adicionar contato.\n2 - Editar contato.\n"+
				"3 - Remover contato.\n4 - Listar todos.\n5 - Sair.\n");
		System.out.println("Digite a opcao desejada: ");
		int opcao = scan.nextInt();
		if(opcao >= 1 && opcao <= 5) {
			return opcao;
		}else {
			System.out.println("Digite uma opcao valida: ");
			this.listarOpcoes();
			return 0;
		}
	}
	public Lista4Professor novoProfessor() {
		Lista4Professor professor = new Lista4Professor();
		System.out.println("Digite o nome: ");
		professor.setNome(scan.next());
		System.out.println("Digite o telefone: ");
		professor.setTelefone(scan.next());
		System.out.println("Digite o email: ");
		professor.setEmail(scan.next());
		System.out.println("Digite o numero de registro: ");
		professor.setNumeroRegistro(scan.next());
		System.out.println("Digite a quantidade hora aula: ");
		professor.setQuantidadeHoraAula(scan.next());
		return professor;

	}
	
	public Lista4Aluno novoAluno() {
		Lista4Aluno aluno = new Lista4Aluno();
		
		System.out.println("Digite o nome: ");
		aluno.setNome(scan.next());
		System.out.println("Digite o telefone: ");
		aluno.setTelefone(scan.next());
		System.out.println("Digite o email: ");
		aluno.setEmail(scan.next());
		System.out.println("Digite o numero de matricula: ");
		aluno.setNumeroMatricula(scan.next());
		
		return aluno;
	}
	
	public Lista4Pessoa addPessoa() {
		Lista4Pessoa pessoa = null;
		System.out.println("Digite 1 para adicionar o aluno e 2 para o professor: ");
		int opcao = scan.nextInt();
		if(opcao == 1) {
			Lista4Aluno aluno = novoAluno();
			pessoa = aluno;
		
		}else {
			Lista4Professor professor = novoProfessor();
			pessoa = professor;
		}
		
		return pessoa;
	}
	
	public void inserirContato() {
		Lista4Pessoa pessoa = addPessoa();
		if(pessoa instanceof Lista4Aluno) {
			alunos.add((Lista4Aluno)pessoa);
			System.out.println("Aluno adicionado!");
		}else {
			professores.add((Lista4Professor)pessoa);
			System.out.println("Professor adicionado!");
		}
	}
	
	public Lista4Pessoa modificaPessoa(Lista4Pessoa pessoa) {
		String opcao = "";
		System.out.println("Deseja alterar o nome: (y/n)");
		opcao = scan.next();
		if(opcao.equals("y")) {
			System.out.println("Digite o novo nome: ");
			pessoa.setNome(scan.next());
		}
		System.out.println("Deseja alterar o telefone: (y/n)");
		opcao = scan.next();
		if(opcao.equals("y")) {
			System.out.println("Digite o novo telefone: ");
			pessoa.setTelefone(scan.next());
		}
		System.out.println("Deseja alterar o email: (y/n)");
		opcao = scan.next();
		if(opcao.equals("y")) {
			System.out.println("Digite o novo email: ");
			pessoa.setEmail(scan.next());
		}
		return pessoa;
	}
	
	public void editarPessoa() {
		System.out.println("Digite o nome da pessoa: ");
		String nome = scan.next();
		String opcao = "";
		boolean achou = false;
		for(Lista4Aluno aluno : alunos) {
			if(aluno.getNome().equals(nome)) {
				Lista4Aluno alunoModificado = (Lista4Aluno)modificaPessoa(aluno);
				System.out.println("Deseja alterar o numero de matricula: (y/n)");
				opcao = scan.next();
				if(opcao.equals("y")) {
					System.out.println("Digite o novo nome: ");
					aluno.setNumeroMatricula(scan.next());
				}
				aluno = alunoModificado;
			}
		}
		for(Lista4Professor professor: professores) {
			if(professor.getNome().equals(nome)) {
				Lista4Professor professorModificado = (Lista4Professor)modificaPessoa(professor);
				System.out.println("Deseja alterar o numero de matricula: (y/n)");
				opcao = scan.next();
				if(opcao.equals("y")) {
					System.out.println("Digite o novo numero de registro: ");
					professor.setNumeroRegistro(scan.next());
				}
				System.out.println("Deseja alterar o numero de horas aula: (y/n)");
				opcao = scan.next();
				if(opcao.equals("y")) {
					System.out.println("Digite o novo numero de horas aula: ");
					professor.setQuantidadeHoraAula(scan.next());
				}
				professor= professorModificado;
			}
		}
	}
	
	public void removerPessoa() {
		System.out.println("Digite o nome da pessoa a ser removido: ");
		String nome = scan.next();
		Lista4Pessoa pessoaRemovida = null;
		boolean removido = false;
		for(Lista4Aluno aluno:alunos) {
			if(aluno.getNome().equals(nome) && !removido) {
				pessoaRemovida = aluno;
				removido = true;
			}
		}
		for(Lista4Professor professor: professores) {
			if(professor.getNome().equals(nome) && !removido) {
				pessoaRemovida = professor;
				removido = true;
			}
		}
		if(!removido) {
			System.out.println("Contato não existe!");
		}else {
			if(pessoaRemovida instanceof Lista4Aluno ) {
				alunos.remove(pessoaRemovida);
			}else {
				professores.remove(pessoaRemovida);
			}
			System.out.println("Contato excluido!");
		}
	}
	
	public void listarTodos() {
		Lista4Contato contato;
		System.out.println("\nLista de contatos de alunos: ");
		for(Lista4Aluno aluno: alunos) {
			contato = aluno;
			System.out.println(contato.dadosFormatados());
		}
		System.out.println("\nLista de contatos de professores: ");
		for(Lista4Professor professor: professores) {
			contato = professor;
			System.out.println(contato.dadosFormatados());
			
		}
	}

	public List<Lista4Aluno> getAlunos() {
		return alunos;
	}

	public void setAlunos(List<Lista4Aluno> alunos) {
		this.alunos = alunos;
	}

	public List<Lista4Professor> getProfessores() {
		return professores;
	}

	public void setProfessores(List<Lista4Professor> professores) {
		this.professores = professores;
	}
	
}
