package oo.lista5.engine;



import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import oo.lista5.modelos.Lista5Aluno;
import oo.lista5.modelos.Lista5Contato;
import oo.lista5.modelos.Lista5Pessoa;
import oo.lista5.modelos.Lista5Professor;

public class Lista5Agenda {
	private List<Lista5Aluno> alunos;
	private List<Lista5Professor> professores;
	private List<Lista5Pessoa> pessoas;
	private static Scanner scan;
	
	public Lista5Agenda() {
		this.alunos = new ArrayList<Lista5Aluno>();
		this.professores = new ArrayList<Lista5Professor>();
//		this.pessoas = new ArrayList<Pessoa>();
		this.scan = new Scanner(System.in);
	}
	
	public void recuperaDados() throws IOException, ClassNotFoundException {
		FileInputStream ler = new FileInputStream("/home/gustavo/Documents/fatec/OrientacaoObjeto/"+
				"Exercicios/exercicio5/agenda.txt");
		ObjectInputStream lerObjeto = new ObjectInputStream(ler);
		List<Lista5Pessoa> listaPessoas = (List<Lista5Pessoa>) lerObjeto.readObject();
		if(!listaPessoas.isEmpty()) {
			for(Lista5Pessoa pessoa: listaPessoas) {
				if(pessoa instanceof Lista5Aluno) {
					alunos.add((Lista5Aluno) pessoa);
				}else {
					professores.add((Lista5Professor) pessoa);
				}
				
			}
		}
		System.out.println("Dados recuperados!");
	}
	
	public final void criaArquivo() throws IOException {
		pessoas = new ArrayList<Lista5Pessoa>();
		try(FileInputStream ler = new FileInputStream("/home/gustavo/Documents/fatec/OrientacaoObjeto/"+
				"Exercicios/exercicio5/agenda.txt");) {
		}catch(Exception e) {
			FileOutputStream escrever = new FileOutputStream("/home/gustavo/Documents/fatec/OrientacaoObjeto/"+
					"Exercicios/exercicio5/agenda.txt");
			ObjectOutputStream escreverObjeto = new ObjectOutputStream(escrever);
			escreverObjeto.writeObject(pessoas);
			escrever.close();
		}
	}
	
	public void salvarAgenda() throws IOException {
		FileOutputStream escrever = new FileOutputStream("/home/gustavo/Documents/fatec/OrientacaoObjeto/"+
				"Exercicios/exercicio5/agenda.txt");
		ObjectOutputStream escreverObjeto = new ObjectOutputStream(escrever);
		pessoas = new ArrayList<Lista5Pessoa>();
		pessoas.addAll(alunos);
		pessoas.addAll(professores);
		escreverObjeto.writeObject(pessoas);
		System.out.println("Adicionado no arquivo as pessoas!");
		escreverObjeto.close();
		escrever.close();
	}
	
	
	public int listarOpcoes() {
		System.out.println("\n1 - Adicionar contato.\n2 - Editar contato.\n"+
				"3 - Remover contato.\n4 - Listar todos.\n5 - Salvar agenda.\n"
				+ "6 - Recuperar agenda.\n7 - Sair.\n");
		System.out.println("Digite a opcao desejada: ");
		int opcao = scan.nextInt();
		if(opcao >= 1 && opcao <= 7) {
			return opcao;
		}else {
			System.out.println("Digite uma opcao valida: ");
			this.listarOpcoes();
			return 0;
		}
	}
	public Lista5Professor novoProfessor() {
		Lista5Professor professor = new Lista5Professor();
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
	
	public Lista5Aluno novoAluno() {
		Lista5Aluno aluno = new Lista5Aluno();
		
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
	
	public Lista5Pessoa addPessoa() {
		Lista5Pessoa pessoa = null;
		System.out.println("Digite 1 para adicionar o aluno e 2 para o professor: ");
		int opcao = scan.nextInt();
		if(opcao == 1) {
			Lista5Aluno aluno = novoAluno();
			pessoa = aluno;
		
		}else {
			Lista5Professor professor = novoProfessor();
			pessoa = professor;
		}
		
		return pessoa;
	}
	
	public void inserirContato() {
		Lista5Pessoa pessoa = addPessoa();
		if(pessoa instanceof Lista5Aluno) {
			alunos.add((Lista5Aluno)pessoa);
			System.out.println("Aluno adicionado!");
		}else {
			professores.add((Lista5Professor)pessoa);
			System.out.println("Professor adicionado!");
		}
	}
	
	public Lista5Pessoa modificaPessoa(Lista5Pessoa pessoa) {
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
		for(Lista5Aluno aluno : alunos) {
			if(aluno.getNome().equals(nome)) {
				Lista5Aluno alunoModificado = (Lista5Aluno)modificaPessoa(aluno);
				System.out.println("Deseja alterar o numero de matricula: (y/n)");
				opcao = scan.next();
				if(opcao.equals("y")) {
					System.out.println("Digite o novo nome: ");
					aluno.setNumeroMatricula(scan.next());
				}
				aluno = alunoModificado;
			}
		}
		for(Lista5Professor professor: professores) {
			if(professor.getNome().equals(nome)) {
				Lista5Professor professorModificado = (Lista5Professor)modificaPessoa(professor);
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
		Lista5Pessoa pessoaRemovida = null;
		boolean removido = false;
		for(Lista5Aluno aluno:alunos) {
			if(aluno.getNome().equals(nome) && !removido) {
				pessoaRemovida = aluno;
				removido = true;
			}
		}
		for(Lista5Professor professor: professores) {
			if(professor.getNome().equals(nome) && !removido) {
				pessoaRemovida = professor;
				removido = true;
			}
		}
		if(!removido) {
			System.out.println("Contato não existe!");
		}else {
			if(pessoaRemovida instanceof Lista5Aluno ) {
				alunos.remove(pessoaRemovida);
			}else {
				professores.remove(pessoaRemovida);
			}
			System.out.println("Contato excluido!");
		}
	}
	
	public void listarTodos() {
		Lista5Contato contato;
		System.out.println("\nLista de contatos de alunos: ");
		for(Lista5Aluno aluno: alunos) {
			contato = aluno;
			System.out.println(contato.dadosFormatados());
		}
		System.out.println("\nLista de contatos de professores: ");
		for(Lista5Professor professor: professores) {
			contato = professor;
			System.out.println(contato.dadosFormatados());
			
		}
	}

	public List<Lista5Aluno> getAlunos() {
		return alunos;
	}

	public void setAlunos(List<Lista5Aluno> alunos) {
		this.alunos = alunos;
	}

	public List<Lista5Professor> getProfessores() {
		return professores;
	}

	public void setProfessores(List<Lista5Professor> professores) {
		this.professores = professores;
	}
	
}
