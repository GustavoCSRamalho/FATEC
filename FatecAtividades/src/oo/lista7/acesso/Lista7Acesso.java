package oo.lista7.acesso;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


import oo.lista7.entradadados.Lista7Dados;
import oo.lista7.models.Lista7Usuario;


public class Lista7Acesso {
	private List<Lista7Usuario> listaUsuario;
	private Scanner scan;
	private List<Lista7Usuario> atualizaListaUsuario;
	private String endereco;
	private Lista7Dados dados;
	public Lista7Acesso() {
		scan = new Scanner(System.in);
		dados = new Lista7Dados();
		listaUsuario = new ArrayList<Lista7Usuario>();
		atualizaListaUsuario = new ArrayList<Lista7Usuario>();
		
	}
	
	public final void adicionaUsuario() throws ClassNotFoundException, IOException {
		Lista7Usuario user = dados.checaUsuario();
		listaUsuario.add(user);
		salvaUsuario();
		System.out.println("\nUsuario adiciona!\n");
	}
	
	private final void salvaUsuario() throws IOException, ClassNotFoundException {
		FileInputStream ler = new FileInputStream("/home/gustavo/Documents/fatec/OrientacaoObjeto/"+
				"Exercicios/exercicio7/usuarios.txt");
		ObjectInputStream lerObjeto = new ObjectInputStream(ler);
		List<Lista7Usuario> atualizalistaDeUsuarios = (List<Lista7Usuario>) lerObjeto.readObject();
		if (atualizalistaDeUsuarios.size() != 0) {
			for (Lista7Usuario user : atualizalistaDeUsuarios) {
				atualizaListaUsuario.add(user);
			}
		}
		listaUsuario.addAll(atualizaListaUsuario);

		FileOutputStream escrever = new FileOutputStream("/home/gustavo/Documents/fatec/OrientacaoObjeto/"+
				"Exercicios/exercicio7/usuarios.txt");
		ObjectOutputStream escreverObjeto = new ObjectOutputStream(escrever);
		escreverObjeto.writeObject(listaUsuario);
		System.out.println("\nUsuario adicionado!\n");
		escreverObjeto.close();
		escrever.close();
	}
	
	public final void ler() throws IOException, ClassNotFoundException {
		FileInputStream ler = new FileInputStream("/home/gustavo/Documents/fatec/OrientacaoObjeto/"+
				"Exercicios/exercicio7/usuarios.txt");
		ObjectInputStream lerObjeto = new ObjectInputStream(ler);
		List<Lista7Usuario> listaDeUsuarios = (List<Lista7Usuario>) lerObjeto.readObject();
		for(Lista7Usuario usuario: listaDeUsuarios) {
			System.out.println("User: "+usuario.getUsuario()+" Senha: "+usuario.getSenha());
		}
	}
	
	public final void criaArquivo() throws IOException {
		listaUsuario = new ArrayList<Lista7Usuario>();		
		try(FileInputStream ler = new FileInputStream("/home/gustavo/Documents/fatec/OrientacaoObjeto/"+
				"Exercicios/exercicio7/usuarios.txt");) {
			System.out.println("O arquivo ja existe então não é preciso criar outro!");
		}catch(Exception e) {
			FileOutputStream escrever = new FileOutputStream("/home/gustavo/Documents/fatec/OrientacaoObjeto/"+
					"Exercicios/exercicio7/usuarios.txt");
			ObjectOutputStream escreverObjeto = new ObjectOutputStream(escrever);
			escreverObjeto.writeObject(listaUsuario);
			System.out.println("Arquivo criado!");
			escrever.close();
		}
	}
	
	public final boolean validaUsuario() throws IOException, ClassNotFoundException {
		Lista7Usuario user = dados.checaUsuario();
		System.out.println("User: "+user.getUsuario()+"\nSenha: "+user.getSenha());
		FileInputStream ler = new FileInputStream("/home/gustavo/Documents/fatec/OrientacaoObjeto/"+
				"Exercicios/exercicio7/usuarios.txt");
		ObjectInputStream lerObjeto = new ObjectInputStream(ler);
		List<Lista7Usuario> listaDeUsuarios = (List<Lista7Usuario>) lerObjeto.readObject();
		boolean achou = false;
		if(listaDeUsuarios.size() != 0) {
			for(Lista7Usuario usuario: listaDeUsuarios) {
				System.out.println("BS: user: "+usuario.getUsuario()+"\nsenha: "+usuario.getSenha());
				if(usuario.getUsuario().equalsIgnoreCase(user.getUsuario()) && 
						usuario.getSenha().equalsIgnoreCase(user.getSenha()) && !achou) {
					achou = true;
					return true;
				}
				
			}
		if(!achou) {
			System.out.println("\nUsuario não cadastrado!\n");
			return false;
		}
		}
		lerObjeto.close();
		ler.close();
		System.out.println("\nNenhum usuario cadastrado!\n");
		return false;
	}
}
