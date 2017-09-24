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

import oo.lista5.modelos.Aluno;
import oo.lista5.modelos.Contato;
import oo.lista5.modelos.Pessoa;
import oo.lista5.modelos.Professor;

public class Agenda {
	private List<Aluno> alunos;
	private List<Professor> professores;
	private List<Pessoa> pessoas;
	private static Scanner scan;
	
	public Agenda() {
		this.alunos = new ArrayList<Aluno>();
		this.professores = new ArrayList<Professor>();
//		this.pessoas = new ArrayList<Pessoa>();
		this.scan = new Scanner(System.in);
	}
	
	public void recuperaDados() throws IOException, ClassNotFoundException {
		FileInputStream ler = new FileInputStream("/home/gustavo/Documents/fatec/OrientacaoObjeto/"+
				"Exercicios/exercicio5/agenda.txt");
		ObjectInputStream lerObjeto = new ObjectInputStream(ler);
		List<Pessoa> listaPessoas = (List<Pessoa>) lerObjeto.readObject();
		if(!listaPessoas.isEmpty()) {
			for(Pessoa pessoa: listaPessoas) {
				if(pessoa instanceof Aluno) {
					alunos.add((Aluno) pessoa);
				}else {
					professores.add((Professor) pessoa);
				}
				
			}
		}
		System.out.println("Dados recuperados!");
	}
	
	public final void criaArquivo() throws IOException {
		pessoas = new ArrayList<Pessoa>();
		try(FileInputStream ler = new FileInputStream("/home/gustavo/Documents/fatec/OrientacaoObjeto/"+
				"Exercicios/exercicio5/agenda.txt");) {
			System.out.println("O arquivo ja existe então não é preciso criar outro!");
		}catch(Exception e) {
			FileOutputStream escrever = new FileOutputStream("/home/gustavo/Documents/fatec/OrientacaoObjeto/"+
					"Exercicios/exercicio5/agenda.txt");
			ObjectOutputStream escreverObjeto = new ObjectOutputStream(escrever);
			escreverObjeto.writeObject(pessoas);
			System.out.println("Arquivo criado!");
			escrever.close();
		}
	}
	
//	public void lerAgenda() throws IOException, ClassNotFoundException {
//		FileInputStream ler = new FileInputStream("/home/gustavo/Documents/fatec/OrientacaoObjeto/"+
//				"Exercicios/exercicio5/agenda.txt");
//		ObjectInputStream lerObjeto = new ObjectInputStream(ler);
//		List<Pessoa> listaPessoas = (List<Pessoa>)lerObjeto.readObject();
//		Contato contato;
//		boolean profImprime = true, alunoImprime = true;
//		for(Pessoa pessoa: listaPessoas) {
//			if(pessoa instanceof Aluno) {
//				if(alunoImprime)	System.out.println("\nLista de contatos de alunos: ");	alunoImprime = false;
//				
//			}else {
//				if(profImprime)	System.out.println("\nLista de contatos de professores: ");	profImprime = false;
//			}
//			contato = pessoa;
//			System.out.println(contato.dadosFormatados());
//		}
//		lerObjeto.close();
//		ler.close();
//		
//	}
	public void salvarAgenda() throws IOException {
		FileOutputStream escrever = new FileOutputStream("/home/gustavo/Documents/fatec/OrientacaoObjeto/"+
				"Exercicios/exercicio5/agenda.txt");
		ObjectOutputStream escreverObjeto = new ObjectOutputStream(escrever);
		pessoas = new ArrayList<Pessoa>();
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
	public Professor novoProfessor() {
		Professor professor = new Professor();
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
	
	public Aluno novoAluno() {
		Aluno aluno = new Aluno();
		
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
	
	public Pessoa addPessoa() {
		Pessoa pessoa = null;
		System.out.println("Digite 1 para adicionar o aluno e 2 para o professor: ");
		int opcao = scan.nextInt();
		if(opcao == 1) {
			Aluno aluno = novoAluno();
			pessoa = aluno;
		
		}else {
			Professor professor = novoProfessor();
			pessoa = professor;
		}
		
		return pessoa;
	}
	
	public void inserirContato() {
		Pessoa pessoa = addPessoa();
		if(pessoa instanceof Aluno) {
			alunos.add((Aluno)pessoa);
			System.out.println("Aluno adicionado!");
		}else {
			professores.add((Professor)pessoa);
			System.out.println("Professor adicionado!");
		}
	}
	
	public Pessoa modificaPessoa(Pessoa pessoa) {
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
		for(Aluno aluno : alunos) {
			if(aluno.getNome().equals(nome)) {
				Aluno alunoModificado = (Aluno)modificaPessoa(aluno);
				System.out.println("Deseja alterar o numero de matricula: (y/n)");
				opcao = scan.next();
				if(opcao.equals("y")) {
					System.out.println("Digite o novo nome: ");
					aluno.setNumeroMatricula(scan.next());
				}
				aluno = alunoModificado;
			}
		}
		for(Professor professor: professores) {
			if(professor.getNome().equals(nome)) {
				Professor professorModificado = (Professor)modificaPessoa(professor);
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
		Pessoa pessoaRemovida = null;
		boolean removido = false;
		for(Aluno aluno:alunos) {
			if(aluno.getNome().equals(nome) && !removido) {
				pessoaRemovida = aluno;
				removido = true;
			}
		}
		for(Professor professor: professores) {
			if(professor.getNome().equals(nome) && !removido) {
				pessoaRemovida = professor;
				removido = true;
			}
		}
		if(!removido) {
			System.out.println("Contato não existe!");
		}else {
			if(pessoaRemovida instanceof Aluno ) {
				alunos.remove(pessoaRemovida);
			}else {
				professores.remove(pessoaRemovida);
			}
			System.out.println("Contato excluido!");
		}
	}
	
	public void listarTodos() {
		Contato contato;
		System.out.println("\nLista de contatos de alunos: ");
		for(Aluno aluno: alunos) {
			contato = aluno;
			System.out.println(contato.dadosFormatados());
		}
		System.out.println("\nLista de contatos de professores: ");
		for(Professor professor: professores) {
			contato = professor;
			System.out.println(contato.dadosFormatados());
			
		}
	}

	public List<Aluno> getAlunos() {
		return alunos;
	}

	public void setAlunos(List<Aluno> alunos) {
		this.alunos = alunos;
	}

	public List<Professor> getProfessores() {
		return professores;
	}

	public void setProfessores(List<Professor> professores) {
		this.professores = professores;
	}
	
}
