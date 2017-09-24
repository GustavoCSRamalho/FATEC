package oo.lista7.aplicacao;

import java.io.IOException;

import oo.lista7.acesso.Acesso;
public class CadastraUsuario {
	public static void main(String[] args) throws ClassNotFoundException, IOException {
		while(true) {
			Acesso acesso = new Acesso();
			acesso.criaArquivo();
			
			acesso.adicionaUsuario();
			acesso.ler();
			System.out.println("----");
		}
		
	}
}
