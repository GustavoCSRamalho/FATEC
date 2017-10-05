package oo.lista7.aplicacao;

import java.io.IOException;

import oo.lista7.acesso.Lista7Acesso;
public class Lista7CadastraUsuario {
	public static void main(String[] args) throws ClassNotFoundException, IOException {
		while(true) {
			Lista7Acesso acesso = new Lista7Acesso();
			acesso.criaArquivo();
			
			acesso.adicionaUsuario();
			acesso.ler();
			System.out.println("----");
		}
		
	}
}
